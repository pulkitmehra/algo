package com.concurrency;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ReactiveServer implements Runnable {

    private final Selector _selector;
    private final ServerSocketChannel _serverSocketChannel;
    private static final int WORKER_POOL_SIZE = 10;
    private static ExecutorService _workerPool;

    ReactiveServer(int port) throws IOException {
        _selector = Selector.open();
        _serverSocketChannel = ServerSocketChannel.open();
        _serverSocketChannel.socket().bind(new InetSocketAddress(port));
        _serverSocketChannel.configureBlocking(false);

        // Register _serverSocketChannel with _selector listening on OP_ACCEPT events.
        // Callback: Acceptor, selected when a new connection incomes.
        SelectionKey selectionKey = _serverSocketChannel.register(_selector, SelectionKey.OP_ACCEPT);
        selectionKey.attach(new Acceptor());
    }

    public void run() {
        try {
            // Event Loop
            while (true) {
                _selector.select();
                Iterator it = _selector.selectedKeys().iterator();

                while (it.hasNext()) {
                    SelectionKey sk = (SelectionKey) it.next();
                    it.remove();
                    Runnable r = (Runnable) sk.attachment(); // handler or acceptor callback/runnable
                    if (r != null) {
                        r.run();
                    }
                }
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static ExecutorService getWorkerPool() {
        return _workerPool;
    }

    // Acceptor: if connection is established, assign a handler to it.
    private class Acceptor implements Runnable {
        public void run() {
            try {
                SocketChannel socketChannel = _serverSocketChannel.accept();
                if (socketChannel != null) {
                    new Handler(_selector, socketChannel);
                }
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        _workerPool = Executors.newFixedThreadPool(WORKER_POOL_SIZE);

        try {
            new Thread(new ReactiveServer(9090)).start(); // a single thread blocking on selector for events
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    static class Handler implements Runnable {
        private final SocketChannel _socketChannel;
        private final SelectionKey _selectionKey;

        private static final int READ_BUF_SIZE = 1024;
        private static final int WRiTE_BUF_SIZE = 1024;
        private ByteBuffer _readBuf = ByteBuffer.allocate(READ_BUF_SIZE);
        private ByteBuffer _writeBuf = ByteBuffer.allocate(WRiTE_BUF_SIZE);

        public Handler(Selector selector, SocketChannel socketChannel) throws IOException {
            _socketChannel = socketChannel;
            _socketChannel.configureBlocking(false);

            // Register _socketChannel with _selector listening on OP_READ events.
            // Callback: Handler, selected when the connection is established and ready for READ
            _selectionKey = _socketChannel.register(selector, SelectionKey.OP_READ);
            _selectionKey.attach(this);
            selector.wakeup(); // let blocking select() return
        }

        public void run() {
            try {
                if (_selectionKey.isReadable()) {
                    read();
                }
                else if (_selectionKey.isWritable()) {
                    write();
                }
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        // Process data by echoing input to output
        synchronized void process() {
            _readBuf.flip();
            byte[] bytes = new byte[_readBuf.remaining()];
            _readBuf.get(bytes, 0, bytes.length);
            System.out.print("process(): " + new String(bytes, Charset.forName("ISO-8859-1")));

            _writeBuf = ByteBuffer.wrap(bytes);

            // Set the key's interest to WRITE operation
            _selectionKey.interestOps(SelectionKey.OP_WRITE);
            _selectionKey.selector().wakeup();
        }

        synchronized void read() throws IOException {
            try {
                int numBytes = _socketChannel.read(_readBuf);
                System.out.println("read(): #bytes read into '_readBuf' buffer = " + numBytes);

                if (numBytes == -1) {
                    _selectionKey.cancel();
                    _socketChannel.close();
                    System.out.println("read(): client connection might have been dropped!");
                }
                else {
                    ReactiveServer.getWorkerPool().execute(new Runnable() {
                        public void run() {
                            process();
                        }
                    });
                }
            }
            catch (IOException ex) {
                ex.printStackTrace();
                return;
            }
        }

        void write() throws IOException {
            int numBytes = 0;

            try {
                numBytes = _socketChannel.write(_writeBuf);
                System.out.println("write(): #bytes read from '_writeBuf' buffer = " + numBytes);

                if (numBytes > 0) {
                    _readBuf.clear();
                    _writeBuf.clear();

                    // Set the key's interest-set back to READ operation
                    _selectionKey.interestOps(SelectionKey.OP_READ);
                    _selectionKey.selector().wakeup();
                }
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

package com.algo.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Assert;
import org.junit.Test;

public class SocketProgTest {

	private static class EchoMultiServer {
		private ServerSocket serverSocket;

		public void start(int port) throws IOException {
			serverSocket = new ServerSocket(port);
			while (true)
				new EchoClientHandler(serverSocket.accept()).start();
		}

		public void stop() throws IOException {
			serverSocket.close();
		}

		private static class EchoClientHandler extends Thread {
			private Socket clientSocket;
			private PrintWriter out;
			private BufferedReader in;

			public EchoClientHandler(Socket socket) {
				this.clientSocket = socket;
			}

			public void run() {
				try {
					out = new PrintWriter(clientSocket.getOutputStream(), true);

					in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

					String inputLine;
					while ((inputLine = in.readLine()) != null) {
						if (".".equals(inputLine)) {
							out.println("bye");
							break;
						}
						out.println(inputLine);
					}

					in.close();
					out.close();
					clientSocket.close();

				} catch (

				IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		@Test
		public void givenGreetingClient_whenServerRespondsWhenStarted_thenCorrect() throws Exception {
			GreetClient client = new GreetClient();
			client.startConnection("127.0.0.1", 6666);
			String response = client.sendMessage("hello server");
			Assert.assertEquals("hello client", response);
		}

		public class GreetClient {
			private Socket clientSocket;
			private PrintWriter out;
			private BufferedReader in;

			public void startConnection(String ip, int port) throws Exception {
				clientSocket = new Socket(ip, port);
				out = new PrintWriter(clientSocket.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			}

			public String sendMessage(String msg) throws Exception {
				out.println(msg);
				String resp = in.readLine();
				return resp;
			}

			public void stopConnection() throws Exception {
				in.close();
				out.close();
				clientSocket.close();
			}
		}

		public class GreetServer {
			private ServerSocket serverSocket;
			private Socket clientSocket;
			private PrintWriter out;
			private BufferedReader in;

			public void start(int port) throws Exception {
				serverSocket = new ServerSocket(port);
				clientSocket = serverSocket.accept();
				out = new PrintWriter(clientSocket.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				String greeting = in.readLine();
				if ("hello server".equals(greeting)) {
					out.println("hello client");
				} else {
					out.println("unrecognised greeting");
				}
			}

			public void stop() throws Exception {
				in.close();
				out.close();
				clientSocket.close();
				serverSocket.close();
			}

		}
	}
}

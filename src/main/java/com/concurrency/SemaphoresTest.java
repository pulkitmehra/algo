package com.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Semaphore;

import org.junit.Test;

public class SemaphoresTest {

	@Test
	public void doInSequence() {

		BinarySemaphore bs = new BinarySemaphore();
		CompletableFuture.runAsync(() -> {
			System.out.println("I am preparing goodies");
			sleep(4000);
			System.out.println("sending..");
			bs.tell();
		});

		CompletableFuture.runAsync(() -> {
			bs.ack();
			System.out.println("Got it!!");

		});
		sleep(10000);
	}

	/*
	 * Opposite of semaphores. It only give access until n threads arrives.
	 */
	static class Barriers {
	}
	
	/*
	 * multiple thread should meet at a particular execution point and then go further.
	 */
	static class RendezvousPoint{
		
	}

	public class BoundedSemaphore {
		private int signals = 0;
		private int bound = 0;

		public BoundedSemaphore(int upperBound) {
			this.bound = upperBound;
		}

		public synchronized void take() throws InterruptedException {
			while (this.signals == bound)
				wait();
			this.signals++;
			this.notify();
		}

		public synchronized void release() throws InterruptedException {
			while (this.signals == 0)
				wait();
			this.signals--;
		}
	}

	public class BinarySemaphore {
		boolean signal = false;

		public synchronized void tell() {
			signal = true;
			notifyAll();
		}

		public synchronized void ack() {
			while (!signal) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			signal = false;
		}
	}

	@Test
	public void connectionPool() throws InterruptedException {
		Pool p = new Pool();
		Object item = p.getItem();
		System.out.println("1");
		p.getItem();
		System.out.println("2");
		CompletableFuture.runAsync(() -> {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			p.putItem(item);
		});
		System.out.println("3");
		p.getItem();
		System.out.println("done");

	}

	public static class Conn {

	}

	public static class Pool {

		private int MAX_AVAILABLE = 2;
		private final Semaphore available = new Semaphore(MAX_AVAILABLE, true);
		protected Conn[] items = new Conn[MAX_AVAILABLE];
		protected boolean[] used = new boolean[MAX_AVAILABLE];

		{
			for (int i = 0; i < MAX_AVAILABLE; i++) {
				items[i] = new Conn();
			}
		}

		public Object getItem() throws InterruptedException {
			available.acquire();
			return getNextAvailableItem();
		}

		public void putItem(Object x) {
			if (markAsUnused(x))
				available.release();
		}

		protected synchronized Object getNextAvailableItem() {
			for (int i = 0; i < MAX_AVAILABLE; ++i) {
				if (!used[i]) {
					used[i] = true;
					return items[i];
				}
			}
			return null; // not reached
		}

		protected synchronized boolean markAsUnused(Object item) {
			for (int i = 0; i < MAX_AVAILABLE; ++i) {
				if (item == items[i]) {
					if (used[i]) {
						used[i] = false;
						return true;
					} else
						return false;
				}
			}
			return false;
		}
	}

	private void sleep(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

class TestSync implements Runnable {
	private int balance;

	public void run() {
		for (int i = 0; i < 50; i++) {
			increment();
			System.out.println("Balance is " + balance);
		}
	}

	private synchronized void increment() {
		int i = balance;
		balance = i + 1;
	}
}

class TestSyncTest {
	public static void main(String[] args) {
		TestSync job = new TestSync();
		Thread one = new Thread(job);
		Thread two = new Thread(job);
		one.start();
		two.start();
	}
}
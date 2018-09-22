class MyRunnable implements Runnable {
	public void run() {
		go();
	}

	void go() {
		doMore();
	}

	void doMore(){
		System.out.println("Top o' the stack");
	}
}

class ThreadTestDrive {
	public static void main(String[] args) {
		MyRunnable job = new MyRunnable();
		Thread thread = new Thread(job);
		thread.start();
		try {
			Thread.sleep(200);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("Back in main");
	}
}
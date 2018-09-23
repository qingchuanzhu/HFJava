class BankAccount{
	private int balance = 100;

	public int getBalance() {
		return balance;
	}

	public void withdraw(int amount) {
		balance -= amount;
	}
}

class RyanAndMonicaJob implements Runnable {
	private BankAccount account = new BankAccount();

	RyanAndMonicaJob() {

	}

	RyanAndMonicaJob(BankAccount bankaAcct) {
		account = bankaAcct;
	}

	public void run(){
		for (int i = 0; i < 25 ; i++) {
			makeWithDraw(4);
			if (account.getBalance() < 0) {
				System.out.println("Overdrawn!");		
			}	
		}
	}

	private synchronized void makeWithDraw(int amount) {
		String threadName = Thread.currentThread().getName();
		if (account.getBalance() >= amount) {
			// System.out.println(threadName + " is about to withdraw");
			try{
				// System.out.println(threadName + " is going to sleep");
				Thread.sleep(500);
			} catch(Exception ex){
				ex.printStackTrace();
			}
			// System.out.println(threadName + " woke up");
			account.withdraw(amount);
			System.out.println(threadName + " completes the withdrawal of " + amount);
		} else {
			System.out.println("Not enough for " + threadName);
		}
	}
}

class RaceConditionTest {

	private void runRaceCondition1() {
		// same job object, the synchronized method will prevent race conditon
		RyanAndMonicaJob job = new RyanAndMonicaJob();
		Thread one = new Thread(job);
		Thread two = new Thread(job);
		one.setName("Ryan");
		two.setName("Monica");
		one.start();
		two.start();
	}

	private void runRaceCondition2() {
		// same as 1, but now we have two different job objects, so the synchronized method can't prevent 
		// race condtion on account
		BankAccount account = new BankAccount();
		RyanAndMonicaJob job1 = new RyanAndMonicaJob(account);
		RyanAndMonicaJob job2 = new RyanAndMonicaJob(account);
		Thread one = new Thread(job1);
		Thread two = new Thread(job2);
		one.setName("Ryan");
		two.setName("Monica");
		one.start();
		two.start();
	}

	public static void main(String[] args) {
		RaceConditionTest test = new RaceConditionTest();
		// test.runRaceCondition1();
		test.runRaceCondition2();
	}
}
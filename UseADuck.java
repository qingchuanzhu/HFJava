class Duck{
	private int size;
	private static int duckCount;

	Duck(){
		System.out.println("Quack");
		size = 27;
		System.out.println("Duck size " + size);
		duckCount++;
	}

	Duck(int duckSize){
		System.out.println("Quack");
		size = duckSize;
		System.out.println("Duck size " + size);
		duckCount++;
	}

	static int getCount(){
		return duckCount;
	}
}

class Duck2{
	// private constructor
	private static Duck2 duck = new Duck2();
	private final String creator = "Sam";
	int x = 12;

	private Duck2(){
		System.out.println("Duck2 Quack");
	}
	
	static Duck2 makeDuck2(){
		return duck;
	}

	void go(final int x){
		System.out.println(x);
	}

	static void go2(final int x){
		System.out.println(x);	
	}
}

public class UseADuck {
	public static void main(String[] args) {
		Duck d = new Duck(42);
		Duck d2 = new Duck();
		System.out.println("Duck count is " + Duck.getCount());

		Duck2 d3 = Duck2.makeDuck2();
		Duck2.go2(7);
		d3.go(7);
	}
}
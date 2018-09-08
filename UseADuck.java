class Duck{
	int size;

	Duck(){
		System.out.println("Quack");
		size = 27;
		System.out.println("Duck size " + size);
	}

	Duck(int duckSize){
		System.out.println("Quack");
		size = duckSize;
		System.out.println("Duck size " + size);
	}
}

public class UseADuck {
	public static void main(String[] args) {
		Duck d = new Duck(42);
		Duck d2 = new Duck();
	}
}
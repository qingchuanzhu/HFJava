class TestBox {
	int i;
	Integer j;

	public static void main(String[] args) {
		TestBox box = new TestBox();	
		box.go();
	}

	void go(){
		i = j;
		System.out.println(i);
		System.out.println(j);
	}
}
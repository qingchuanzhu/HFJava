class MyAnimalList {
	private Animal[] animals = new Animal[5];
	private int nextIndex = 0;

	void add(Animal a) {
		if (nextIndex < animals.length) {
			animals[nextIndex] = a;
			System.out.println("Animal added at " + nextIndex);
			nextIndex++;
		}
	}
}

class AnimalTestDrive {
	public static void main(String[] args) {
		MyAnimalList list = new MyAnimalList();
		Dog a = new Dog();
		Cat c = new Cat();
		list.add(a);
		list.add(c);

		if (a.equals(c)) {
			System.out.println("Test equal: True");
		} else {
			System.out.println("Test equal: False");
		}

		System.out.println("Class type of c " + c.getClass());
		System.out.println("Hashcode of c " + c.hashCode());
		System.out.println("Description of c " + c.toString());
	}
}
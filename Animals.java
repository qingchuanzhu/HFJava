interface Pet {
	String name = "Puppy";

	void beFriendly();
	void play();
}

abstract class Animal {
	String picture;
	String food;
	int hungerLevel;
	private String name;

	abstract void makeNoise();
	abstract void eat();
	abstract void sleep();
	abstract void roam();

	Animal() {

	}

	Animal(String aName) {
		name = aName;
	}

	String getName(){
		return name;
	}

	void setName(String aName){
		name = aName;
	}
}

abstract class Canine extends Animal {
	void roam() {}
}

abstract class Feline extends Animal {
	void roam() {}
}

class Lion extends Feline {
	void makeNoise(){}
	void eat() {}
	void sleep() {}
}

class Cat extends Feline {
	void makeNoise(){}
	void eat() {}
	void sleep() {}
}

class Tiger extends Feline {
	void makeNoise(){}
	void eat() {}
	void sleep() {}
}

class Hippo extends Animal {

	Hippo (){

	}

	Hippo (String aName) {
		super(aName);
	}

	void roam() {}
	void makeNoise(){}
	void eat() {}
	void sleep() {}
}

class Wolf extends Canine {
	void makeNoise(){}
	void eat() {}
	void sleep() {}
}

class Dog extends Canine {
	void makeNoise(){}
	void eat() {}
	void sleep() {}
}
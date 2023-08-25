package co.yedam.abstracts;

public class MainExe {
	public static void main(String[] args) {
//		Animal animal = new Animal(""); 추상클래스는 인스턴스 못만듦
		Animal animal = new Dog("멍멍이");
		animal.sound();
		
		animal = new Cat("야옹이");
		animal.sound();
	}

}

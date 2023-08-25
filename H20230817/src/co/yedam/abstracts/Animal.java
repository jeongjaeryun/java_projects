package co.yedam.abstracts;

public abstract class Animal {
	private String name;
	
	public Animal(String name) {
		this.name = name;
	}
	
	//게터 세터
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//추상메소드 abstract - 구현부분{}이 없는 메소드 sound();가 정의부분
	//sound라는 메소드는 반드시 자식클래스에서 기능을 구현함
	public abstract void sound();
	
	
}

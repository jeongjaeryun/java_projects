package co.yedam.inheritance;

public class CellPhone /*extends Object*/ { 
	private String model;
	private String color;
	
	CellPhone(){ //기본생성자
		
	}
	public void turnOn() {
		System.out.println("전원을 켭니다.");
	}
	
	public void turnOff() {
		System.out.println("전원을 끕니다.");
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() { //부모클래스가 가지고있는 메소드를 자식클래스가 재정의 하겠다
//		return super.toString();
		return color + ", "+ model;
	}
}

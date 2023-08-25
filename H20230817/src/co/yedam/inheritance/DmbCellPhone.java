package co.yedam.inheritance;

public class DmbCellPhone extends CellPhone {
	//CellPhone을 부모클래스로 정하고 상속받음 
	//상속받을땐 extends 부모클래스명
	
	private int channel; //자기자신만의 속성도 가질수 있음
	
	public void changeChannel(int channel) {
		this.channel=channel;
	}
	//자신만의 기능, 속성 구현 가능
	public void turnOnDmb() {
		System.out.println("DMB 폰을 켭니다.");
	}
	
	//재정의 (overriding)
	@Override
	public void turnOn() { // 오버라이딩 : 부모클래스가 가지고있는 메소드를 자식클래스가 재정의 하겠다
//		super.turnOn(); //super 부모를 가리킴
		System.out.println(getModel()+"의 전원을 켭니다.");
	}
	
}

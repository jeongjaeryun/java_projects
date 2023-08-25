package co.yedam.inheritance;

public class MainExe {

	public static void main(String[] args) {
		CellPhone cell = new CellPhone();
		cell.setModel("SM1100");
		cell.setColor("black");
		cell.turnOn();
		cell.turnOff();
		
		
		DmbCellPhone dmb = new DmbCellPhone(); 
		//부모클래스의 기능들 그대로 호출해서 사용가능
		dmb.setModel("DMB1100");
		dmb.setColor("white");
		dmb.turnOn();
		dmb.turnOff();
		dmb.turnOnDmb();
	
		CellPhone cell2 = new DmbCellPhone(); // promotion 내부형변환
		//자식(DmbCellPhone)의 인스턴스 값 받을수 있음
		cell2.turnOn();
//		cell2.turnOnDmb(); 이건 불가. 자식클래스의 인스턴스를 받지만 부모클래스에 담긴 기능까지만 사용가능
		
		if(cell2 instanceof DmbCellPhone) {
			DmbCellPhone dmb2 = (DmbCellPhone) cell2;//casting 강제형변환
			dmb2.turnOnDmb(); // 자식클래스에 정의된 기능 사용 가능
		}//if문의 끝
		
		if(cell instanceof DmbCellPhone) {
			
			DmbCellPhone dmb3 = (DmbCellPhone) cell; //부모클래스의 타입 cell
			dmb3.turnOnDmb(); //작동안됨 cell이 DmbCellPhone의 인스턴스가 아님!
			
		}//if문의 끝
		
		CellPhone[] phones = new CellPhone[5]; //부모클래스의 배열이니 자식클래스도 담김
		//CellPhone이라는 인스턴스를 담기위한 phones 배열 생성
		
		phones[0] = cell; //부모클래스도 담겨지고
		phones[1] = dmb;  //자식클래스도 담겨짐
		
		phones[0].turnOn(); //CellPhone의 인스턴스
		phones[1].turnOn(); //DmbCellPhone의 인스턴스
		//똑같은 실행방식인데 결과값이 다른 것을 다형성이라고 함
		
	}//main의 끝

}

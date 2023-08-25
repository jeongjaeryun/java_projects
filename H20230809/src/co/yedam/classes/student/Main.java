package co.yedam.classes.student;

public class Main {
	public static void main(String[] args) {
//		Calculator cal = new Calculator(); //인스턴스 생성 이렇게 실체가 만들어져야 쓸수 있음
//		double result = cal.sum(20, 40);
//		System.out.println(result);
		
		double result = Calculator.multi(10, 20); //인스턴스 생성 안하고 바로 클래스를씀 멀티는 static이라 사용할수 있음
		System.out.println(result);
		
	}
	public void start() {
		Main main = new Main();
		main.main(null);
	}
}

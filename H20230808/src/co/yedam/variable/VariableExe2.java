package co.yedam.variable;

public class VariableExe2 {
   public static void main(String[] args) {
	int num1 = 10;
	String str = "홍길동";
	str = "김길동";
	
	//홍길동, 20이라는 값을 담고싶을땐? 여러개의 타입의 값을 담고싶을땐 클래스 선언해서 담으면 됨
	Person hong = new Person(); //Person이라는 클래스에 있는 값만 담을수 있음
	hong.name = "홍길동";
	hong.age = 20;
	hong.weight = 67.8;
	
	hong = new Person(); // 다시 선언해서 위에 값이 사라지고 다 초기화 됨
	
	System.out.println("이름은 "+ hong.name //
			+", 나이는 "+ hong.age//
			+ ", 몸무게는 " + hong.weight);
	
	VariableExe3 exe3 = new VariableExe3();
	exe3.showInfo();
	exe3.helloMsg();
 }
}

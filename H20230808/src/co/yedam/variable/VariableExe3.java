package co.yedam.variable;

public class VariableExe3 {
	
	int num = 100; 
	
	public void showInfo() {
		int num = 100 + this.num; //클래스에 소속된 필드는 this붙임
		System.out.println("num: "+ num);
		int num1 = 200; // 로컬변수는 선언된 실행블럭 안에서만 유효한 값을 가진다
	}
	
	public void printNum() {
//		System.out.println("num: "+num1);
	}
	
	public void helloMsg() {
		int num = 200+ this.num;
		System.out.println("num: "+ num);
	}
	
}

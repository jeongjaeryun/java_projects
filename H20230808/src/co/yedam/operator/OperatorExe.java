package co.yedam.operator;

public class OperatorExe {

	public static void main(String[] args) {
		
		int x,y;
		y = x = 2; //2를 x에 저장 그 x를 y에 저장
		
		int result = x++ + 10; // 후위형 연산후 1증가
		System.out.println(result);
		System.out.println("x: "+x);
		
		result = ++y + 10; // 전위형 연산전 1증가
		System.out.println(result);
		System.out.println("y: "+y);
		
		String str = "";
		
		// 삼항 연산자 
		if (x >= 10) {
			str = "x는 10이상";
		}else {
			str = "x는 10미만";
		}
		
		str = ( x > 10 ) ? "x는 10이상" : "x는 10미만";
		System.out.println(str);
		
		
		
		
	}

}

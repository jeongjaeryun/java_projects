package co.yedam.exceptions;

// 예외: 프로그램이 정상적으로 종료시점 될때까지 진행.

public class NullPointExe {
 public static void main(String[] args) {
	String msg = null;
	msg = "123";
	
	try {
		System.out.println(msg.toString()); // try 에러발생부분
		int val = Integer.parseInt(msg);
		System.out.println("결과는 "+ val);
	} catch(NullPointerException e) {       // catch null포인트 예외가 발생하면 얘가 처리. 예외처리 정상실행되면 이부분이 실행되지 않고 예외가 발생하면 catch구문 실행
		System.out.println("msg 값이 null을 참조합니다.");
		System.out.println("예외가 발생했습니다.");
	} catch (NumberFormatException e1) {  //number 포맷 예외 발생하면 얘가 처리
		System.out.println("msg 값을 숫자로 변환할 수 없습니다.");
	} finally {
		System.out.println("예외의 발생과는 상관 없이 실행할 코드 작성");
	}
	
	System.out.println("end of prog.");
 }
}

package co.yedam.variable;

import java.util.Scanner;

/*
 * Scanner 클래스 활용
 */
public class VariableExe5 {
 public static void main(String[] args) {
	Scanner scan = new Scanner(System.in); // 스캐너 (키보드 입력)
	
	String numStr = "123"; //문자열에 담긴 숫자값만 parseInt가능 "123a"는 불가
	int num = Integer.parseInt(numStr); //int에 parseint 를 쓰면 "123"을 숫자 123으로 변환
	System.out.println(num);
	
	int sum = 0;
	
	while(true) {
	System.out.println("정수값을 입력: 종료하려면 quit>>>");
	String result = scan.nextLine(); //입력값을 문자열로 반환
	System.out.printf("입력값은 %s입니다. \n", result);
	
	  if(result.equals("quit")){ //.equals 문자비교할때
		break; //반복문을 종료하겠다
	  }
	//입력값이 100보다 크거나 0보다 작으면 합계 안하고 
	//범위 안의 값만 합하도록
	  int val = Integer.parseInt(result);
	   if(val > 100 || val < 0) {// 조건을 만족 못하면 다시 처리
		continue;
	    }
	 sum = sum + val; //값을 누적
//	sum = sum + Integer.parseInt(result);
	}
	System.out.println("입력값의 합계는 " + sum);
	System.out.println("end of prog.");
  }
}

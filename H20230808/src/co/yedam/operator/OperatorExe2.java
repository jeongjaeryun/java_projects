package co.yedam.operator;

import java.util.Scanner;

/*
 * 은행 app
 */
//컨트롤 쉬프트 o 임포트 단축키

public class OperatorExe2 {
  public static void main(String[] args) {
	
	Scanner scn = new Scanner(System.in); //임포트 안하고싶으면 이렇게 적기 
	int balance = 0; //10만원 이상 불가, -금액 불가 잔고
	boolean run = true;
	int sum = 0;
	
	while(run) {
		System.out.println("1.예금 2.출금 3.잔고확인 4.종료");
		System.out.println("선택>> ");
	
		int menu = Integer.parseInt(scn.nextLine());
		if(menu==1) {
			System.out.println("입금액 입력>>");
				int plus = Integer.parseInt(scn.nextLine());
				sum = balance + plus;
			if(sum > 100000 || plus < 0) {
				System.out.println("입금이 불가합니다");
			}else {
				balance += plus;
				System.out.println(plus+"원이 입금 되었습니다.");
			}
		}else if(menu==2) {
			System.out.println("출금액 입력>> ");
			int minus= Integer.parseInt(scn.nextLine());
			sum = balance - minus;
			if(sum < 0 || minus <0) {
				System.out.println("출금이 불가합니다.");
			}else {
				balance -= minus;
				System.out.println(minus+"원이 출금되었습니다");
			}
		}else if(menu==3) {
			System.out.println("현재 잔액은 "+balance+"원 입니다.");
		}else if(menu==4) {
			System.out.println("종료되었습니다.");
			break;
		}
	}
  } //main의 끝
}
package co.yedam.interfaces;

import java.util.Scanner;

public class MainExe {
	
	public static void main(String[] args) {
		Dao dao = new OracleDao(); //MysqlDao()로 구현하거나 OracleDao()로 구현하거나
		//Dao 인터페이스 변수에다가 다른 구현객체 쓸수있는게 장점
		String str;
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		int menu = -1;
		while(run) {
			System.out.println("1.추가 2.조회 3.수정 4.삭제 5.종료");
			System.out.println("선택>> ");
			menu = scn.nextInt(); // 숫자 입력 후 엔터 값까지 받게하려고 밑에 넥스트라인 만듦 
			scn.nextLine();
			
			switch(menu) {
			case 1:
				dao.insert();
				break;
			case 2:
				dao.select();
				break;
			case 3:
				dao.update();
				break;
			case 4:
				dao.delete();
				break;
			case 5:
				System.out.println("종료합니다.");
				run = false;
				break;
			default: System.out.println("잘못된 오류입니다.");
			}
		}

	}//main의 끝

}

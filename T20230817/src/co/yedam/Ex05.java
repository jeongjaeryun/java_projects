package co.yedam;

import java.util.Scanner;

public class Ex05 {
	Friend[]friends = new Friend[10];
	Scanner scn = new Scanner(System.in);
	
	public void start() {
		boolean run = true;
		
		while(run) {
			
			System.out.println("1.등록 2.목록 3.전화번호수정 4.삭제 5.종료");
			System.out.println("선택>> ");
			
			int menu = scn.nextInt(); // 숫자 입력 후 엔터 값까지 받게하려고 밑에 넥스트라인 만듦 
			scn.nextLine();
			
			switch(menu) {
			case 1:
				register();
				break;
			case 2:
				list();
				break;
			case 3:
				modify();
				break;
			case 4:
				remove();
				break;
			case 5:
				System.out.println("종료합니다.");
				run = false;
				break;
			default: System.out.println("잘못된 오류입니다.");
			}
		}
	}//start의 끝
	private void register() {
		System.out.println("친구이름 등록 >>");
		String name = scn.nextLine();
		System.out.println("전화번호 등록 >> ");
		String phone = scn.nextLine();
		System.out.println("생년월일 등록 >> ");
		String birth = scn.nextLine();
		System.out.println("키를 등록 >> ");
		double tall = Double.parseDouble(scn.nextLine());
		Friend frd = new Friend(name, phone, birth, tall);
		for(int i = 0; i<friends.length; i++) {
			if(friends[i]==null) {
				friends[i]=frd;
				break;
			}
		}
	}//register()의 끝
	
	private void list() {
		for(Friend frd : friends) {
			if(frd != null) {
				System.out.println(frd.toString());
			}
		}
	}//list의 끝
	private void modify() {
		System.out.println("이름 입력 >> ");
		String name = scn.nextLine();
		System.out.println("수정할 연락처 입력 >> ");
		String phone = scn.nextLine();
		for(int i=0; i < friends.length; i++) {
			if(friends[i]!= null && friends[i].getName().equals(name)) {
				friends[i].setPhone(phone);
				System.out.println("수정되었습니다");
				break;
			}
		}

	}//modify()의 끝
	
	private void remove() {
		System.out.println("삭제할 이름을 입력 >>");
		String name = scn.nextLine();
		for(int i = 0; i < friends.length; i++) {
			if(friends[i]!=null && friends[i].getName().equals(name)) {
				friends[i]=null;
				System.out.println("삭제되었습니다.");
				break;
			}
		}
	}//remove()의 끝
	
	public static void main(String[] args) {
		Ex05 app = new Ex05();
		app.start();
	}//main의 끝
	
}//Ex05의 끝

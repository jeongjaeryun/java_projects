package co.yedam.friend;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FriendApp {
	//배열>컬렉션>파일>DB
	Friend[]friends = new Friend[10];
	Scanner scn = new Scanner(System.in);
	
	//컨트롤
	public void start() {
		boolean run = true;
		int menu = -1;
		while(run) {
			System.out.println("1.추가 2.조회 3.수정 4.삭제 5.종료");
			System.out.println("선택>> ");
			try {
			menu = scn.nextInt();// 숫자 입력 후 엔터 값까지 받게하려고 밑에 넥스트라인() 만듦
			}catch(InputMismatchException e) {
				System.out.println("메뉴를 다시 선택하세요.");
				scn.nextLine();//엔터키 처리해주려면 꼭 넣어야함
				continue; //밑에 실행안하고 다시 위로 올라가도록
			} finally {
				scn.nextLine();
			}

			switch(menu) {
			case 1:
				addFriend();
				break;
			case 2:
				search();
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
	}
	//읽어 들인 값을 문자열 반환해주는 스캐너 매소드
	private String printString(String msg) {
		System.out.println(msg+">> ");
		return scn.nextLine();
	}
	//등록
	private void addFriend() {
		int subMenu=-1; 
		while(true) {
		System.out.println("1.학교친구 2.회사친구 3.그외 친구");
		System.out.println("선택>> ");

		try {
		subMenu = scn.nextInt(); 
		scn.nextLine();
		break;
		}catch(InputMismatchException e) {
			System.out.println("1, 2, 3 중에 선택하세요");
			continue;
			
		}finally {
		scn.nextLine();
		 }
		}//while 끝
		Friend friend = null;
		String name = printString("이름입력");
		String phone = printString("연락처입력");
		if(subMenu == 1) { //학교친구
			String univ = printString("학교입력");
			String major = printString("전공입력");

			friend = new UnivFriend(name, phone, univ, major);
			
		}else if(subMenu == 2) {//회사친구
			String comp = printString("회사입력");
			String dept = printString("부서입력");

			friend = new ComFriend(name, phone, comp, dept);
			
		}else {//그외친구
			friend = new Friend(name, phone);
		}
		
		for(int i=0; i<friends.length; i++) {
			if(friends[i] == null) {
				friends[i] = friend;
				break;
			}
		}

	}//addFriend()의 끝
	
	//조회: 이름을 입력하면 이름에 해당되는 것만 조회, 이름 안치고 엔터를 치면 전체 조회
	private void search() {
		System.out.println("조회할 이름 입력>> ");
		String name = scn.nextLine();
			System.out.println("없는이름입니다. 다시입력하세요");
			
		for(int i=0; i<friends.length; i++) {
			if(friends[i] != null && friends[i].getName().equals(name)) {
			  System.out.println(friends[i].showInfo());
			  break;
			}else if(friends[i] != null && name.equals("")){
				System.out.println(friends[i].showInfo());
			}
		}
	}
	//수정 : 이름을 기준으로 연락처 수정
	private void modify() {
		System.out.println("연락처 수정");
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
	}
	//삭제 : 이름을 넣고 삭제
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

	}
}

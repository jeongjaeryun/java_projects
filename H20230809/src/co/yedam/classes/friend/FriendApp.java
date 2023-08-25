package co.yedam.classes.friend;

import java.text.ParseException;
import java.util.Scanner;

// 접근지시자 (access modifier)
public class FriendApp {
	private Scanner scn = new Scanner(System.in);
	private Friend[] friends = new Friend[10];
	String name = "";
	int count = 0;

	public FriendApp() { //기본생성자

	}

	private void addFriend() {
		System.out.println("이름 연락처 생년월일");
		String[] data = scn.nextLine().split(" ");
// 		19950303
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//		Date birth = null;
//		final int num = 0;//var,char,
//		num = 1; 요거 파이널 붙이면 값변경 불가
		Friend friend = new Friend(data[0], data[1], data[2]);
		// 입력받는 값 저장

		for (int i = 0; i < friends.length; i++) {
			if (friends[i] == null) {
				friends[i] = friend;
				break;
			}
		}
	}// addFriend

	private void list() { // 리턴타입없이 출력만
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null) {
				System.out.println(friends[i].toString());
			}
		}
	}// list

	private void findFriend() {

		System.out.println("이름을 입력하세요");
		name = scn.nextLine();

		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null // 두조건이 참이어야 블럭을 실행
					&& friends[i].getName().equals(name)) {
				System.out.println(friends[i].toString());
				count++;
				break;
			}
		}
	}

	private void editFriend() {
		
		System.out.println("연락처를 입력하세요");
		String phone = "";
		count = 0;
		phone = scn.nextLine(); // 연락처 속성 생성
		for (int i = 0; i <= friends.length; i++) {
			if (friends[i] != null) { // 중복된 이름이 없다
				if (friends[i].getName().equals(name)) {
					friends[i].setPhone(phone); // 입력받은 값을 배열에 저장
					System.out.println("정상처리 되었습니다.");
					count++;
					break; // for반복에 대한 브레이크
				}
			}
		}
		if (count < 1) {
			System.out.println("없는 정보입니다.");
		}
	}

	private void delFriend() {
		System.out.println("삭제할 이름을 등록하세요");
		name = scn.nextLine();
		for (int i = 0; i <= friends.length; i++) {
			if (friends[i] != null && friends[i].getName().equals(name)) {
				friends[i] = null; // 삭제.
				break; // 빠져나옴
			}
		}
	}

	public void start() { //모든곳에서 접근하게 하려면 public

		FriendApp app = new FriendApp(); // 등록 목록 종료 기능만들어넣을거임
		Scanner scn = app.scn;
		boolean run = true;

		while (run) {
			System.out.println("1.등록 2.목록 3.조회(이름) 4.수정 5.삭제 9.종료");
			System.out.println("선택>> ");
			// 조회 findFriend/ 수정 editFriend(연락처삭제)/ 삭제 delFriend(이름기준삭제)
			int menu = Integer.parseInt(scn.nextLine()); // 앱에 가지고 있는 값들 가져와서 쓸수있음 scn, friends

			switch (menu) {
			case Menu.ADD:
				app.addFriend();
				break;
			case Menu.LIST:
				app.list();
				break;
			case Menu.SEARCH:
				app.findFriend();
				break;
			case Menu.EDIT:
				app.editFriend();
				break;
			case Menu.DEL:
				app.delFriend();
				break;
			case Menu.EXIT :
				System.out.println("종료합니다");
				run = false;
			}// switch의 끝

		} // while의 끝
	}// start 메소드의 끝
}// class의 끝

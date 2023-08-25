package co.yedam.friend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FriendApp {
	// 등록, 수정, 삭제, 목록

	// 필드
	Map<String, String> userList = new HashMap<>();
	List<Friend> friends = new ArrayList<Friend>();
	Scanner scn = new Scanner(System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");

	// 생성자
	public FriendApp() {
		userList.put("user1", "1234"); // 사용자와 비밀번호
		userList.put("user2", "5678");
		userList.put("user3", "9087");
	}

	private boolean userCheck() { // id, pw가 맞으면 start가 실행되도록
		// 여기에 반복문
		boolean userCheck = true;
		System.out.println("id>> ");
		String id = scn.nextLine();
		System.out.println("pw>> ");
		String pw = scn.nextLine();

		if (userList.containsKey(id)) { // id 체크 id 해당하는 값이 있으면
			if (userList.get(id).equals(pw)) { // pw체크
				return true;
			}
		}
		return false;
	}

	public void start() {
		boolean run = true;

		while (true) {
			if (userCheck()) {
				break;// boolean타입 반환 true가 되면 while 실행
			}
			System.out.println("로그인에 실패하였습니다.");
		}

		while (run) {

			System.out.println("1.추가 2.수정 3.삭제 4.목록 5.종료");
			System.out.println("선택 >> ");

			int menu = scn.nextInt(); // 숫자 입력 후 엔터 값까지 받게하려고 밑에 넥스트라인 만듦
			scn.nextLine();

			switch (menu) {
			case 1:
				add();
				break;
			case 2:
				edit();
				break;
			case 3:
				del();
				break;
			case 4:
				list();
				break;
			case 5:
				System.out.println("종료합니다.");
				run = false;
				break;
			default:
				System.out.println("잘못된 오류입니다.");

			}
		}//while의 끝

	}// start의 끝

	private void add() {
//		String name = printString("이름")
//		String name = printString("번호")
//	    String name = printString("생년월일")
		System.out.println("친구이름 등록 >>");
		String name = scn.nextLine();
		System.out.println("전화번호 등록 >> ");
		String phone = scn.nextLine();
		System.out.println("생년월일(970707) 등록 >> ");

		Date today = new Date();
		String birth = scn.nextLine();
		Date today1 = null;
		try {
			today1 = sdf.parse(birth);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		Friend frd = new Friend(name, phone, today1);
		friends.add(new Friend(name, phone, today1));

	}// add의 끝

	private void edit() {
//		String name = printString("이름");
//		String phone = printString("연락처");

		System.out.println("이름을 입력하세요 >> ");
		String name = scn.nextLine();
		System.out.println("수정할 연락처를 입력하세요 >> ");
		String phone = scn.nextLine();
		for (int i = 0; i < friends.size(); i++) {
			if (friends.get(i).getName().equals(name)) {
				friends.get(i).setPhone(phone);
				break;
			}
		}
	}// edit의 끝

	private void del() {
		System.out.println("삭제할 이름을 입력 >>");
		String name = scn.nextLine();
		for (int i = 0; i < friends.size(); i++) {
			if (friends.get(i).getName().equals(name)) {
				friends.remove(i);
				break;
			}
		}
	}// del의 끝

	private void list() {
//		for(int i=0; i<friends.size(); i++) { 
//			   System.out.println("이름 : "+ friends.get(i).getName()+" 번호 : "+friends.get(i).getPhone()+" 생일 : "+friends.get(i).getBirth()); 
//			   break;
//		   }
		for (Friend fnd : friends) {
			System.out.println(fnd);
		}
	}// list의 끝
	
}

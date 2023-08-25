package co.yedam.stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import co.yedam.friend.Friend;

public class FriendApp {
	Scanner scn = new Scanner(System.in);
	List<Friend> friends = new ArrayList<>();

	public FriendApp() {
		loadFile();
	}

	// 등록 출력 종료
	public void start() {
		boolean run = true;
		while (run) {
			System.out.println("1.등록 2.목록 3.종료");
			System.out.println("선택>> ");
			int menu = scn.nextInt(); // 1 넣고 엔터침 엔터값이 남아있어서 처리해줘야함
			scn.nextLine(); // 엔터키 소진
			if (menu == 1) {
				add();
			} else if (menu == 2) {
				list();
				
			} else if (menu == 3) {
				System.out.println("종료합니다.");
				saveFile();
				run = false;
			}
		}
	}// end of start

	SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");

	private void add() { // 등록
		String name = printString("이름 입력");
		String phone = printString("연락처 입력");
		String birth = printString("생일 입력(95-06-03)");
		try {
			Friend fnd = new Friend(name, phone, sdf.parse(birth));
			friends.add(fnd);

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	private void list() { // 목록 출력
		for (Friend fnd : friends) {
			System.out.println(fnd);
		}
	}

	private void saveFile() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// friends 컬랙션에 있는 값 -> 텍스트 형식으로 저장
		File file = new File("C:/Temp/friendList.txt");
		try {
			FileWriter fw = new FileWriter(file); //캐릭터기반의 출력스트림
			for (Friend fnd : friends) {
				String line = fnd.getName() //
						+ " " + fnd.getPhone() //
						+ " " + sdf.format(fnd.getBirth());
				fw.write(line + "\n");
			}
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}// saveFile 끝

	private void loadFile() {
		File file = new File("C:/Temp/friendList.txt"); //File이란 객체는 파일에 대한 정보를 가지고있는 클래스
		Scanner scn2 = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			scn2 = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} // trycatch 끝

		while (true) {
			String line = null;
			try {
				line = scn2.nextLine();
			} catch (NoSuchElementException e) {
				break;
			}

			String[] data = line.split(" "); // 홍길동 010-1111-1111 1995-05-05 공란기준으로 배열 만듦
//			try {
//				System.out.println(data[0]+data[1]+sdf.parse(data[2]));
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			try {
				Friend newFriend = new Friend(data[0], data[1], sdf.parse(data[2])); // friends에 값 넣기 ,문자열타입을 데이트타입으로 만들어줌
				friends.add(newFriend);
			} catch (ParseException e) {
				e.printStackTrace();
			}

		} // while끝

	}// loadFile끝

	private String printString(String msg) {
		System.out.println(msg + " >> ");
		return scn.nextLine();
	}
}// FriendApp의 끝

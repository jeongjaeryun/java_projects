package co.yedam.friend;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ScanExe {
	public static void main(String[] args) {
		File file = new File("src/co/yedam/friend/friends.txt");
		Scanner scn = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			scn = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

//		while(scn.hasNext()) { //더이상 읽어올 값이 있는지 없는지 체크하는거
//			String line = scn.next();// 공란을 기준으로 읽어옴(띄어쓰기기준)
//			System.out.println(line);
//		}

		List<Friend> friends = new ArrayList<>();
		while (true) {
			String line = null;
			try {
				line = scn.nextLine();
			} catch (NoSuchElementException e) {
				break;
			}

			String[] data = line.split(" "); // 홍길동 010-1111-1111 1995-05-05 공란기준으로 배열 만듦
			try {
				Friend newFriend = new Friend(data[0], data[1], sdf.parse(data[2])); //friends에 값 넣기
				friends.add(newFriend);
			} catch (ParseException e) {
				e.printStackTrace();
			}

		} // while끝

		// 반복문 출력
		for (Friend fnd : friends) {
			System.out.println(fnd.toString());
		} // for 끝

		System.out.println("=====end of line=====");

	}// main 끝
}// 클래스끝

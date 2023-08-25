package co.yedam.board.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import co.yedam.board.vo.User;



public class UserServiceImpl implements UserService {
	
//user.txt 에서 정보를 읽고 User정보를 List컬랙션에 저장.
	//User클래스 생성

	
	List<User> userList =new ArrayList<>(); //userList에 정보를 담아놓고 여기 값을 밑에checkLogin에서 가져오게
	public UserServiceImpl() {
		loadFile();
	}
	@Override
	public User checkLogin(User user) {
		for(int i =0; i<userList.size(); i++) {
			if(userList.get(i).getUserId().equals(user.getUserId())) {
				if(userList.get(i).getUserPw().equals(user.getUserPw())){
					return userList.get(i);
				}
			}
		}
		return null; //없으면 false 리턴
	}
	
	void loadFile() {
		File file = new File("C:/Temp/users.txt"); //File이란 객체는 파일에 대한 정보를 가지고있는 클래스
		Scanner scn2 = null;
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
//			
			try {
				User newUser = new User(data[0], data[1],(data[2])); // friends에 값 넣기 ,문자열타입을 데이트타입으로 만들어줌
				userList.add(newUser);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} // while끝
	}
}

package co.yedam.board.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.board.vo.User;

public class UserServiceImpl implements UserService {
// users.txt 에서 정보를 읽고 
	// User정보를 List컬랙션에 저장.
// User 클래스 생성.
	List<User> userList = new ArrayList<>();

	public UserServiceImpl() {
		loadFile();
	}

	@Override
	public User checkLogin(User user) {
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getUserId().equals(user.getUserId())) {
				if (userList.get(i).getUserPw().equals(user.getUserPw())) {
					return userList.get(i);
				}
			}
		}
		return null;
	}

	void loadFile() {// 파일을 불러와서 읽고 저장
		try {
			FileReader fr = new FileReader("c:/temp/users.txt");
			BufferedReader br = new BufferedReader(fr);
			while (true) {
				String str = br.readLine();
				if (str == null) {
					break;
				}
				String[] data = str.split(" ");
				userList.add(new User(data[0], data[1], data[2]));
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initPassword(User user) { //패스워드 초기화
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getUserId().equals(user.getUserId())) {
				userList.get(i).setUserPw(user.getUserPw());
				break;
			}
		}
	}
	public void save() {
		FileWriter fw;
		try {
			fw = new FileWriter("c:/temp/users.txt");//쓰기위한 스트림//파일을 만듦!!!
//			BufferedWriter bw = new BufferedWriter(fw);
			
			for(int i = 0; i<userList.size(); i++) {
//				System.out.println(userList.get(i));
				String info = userList.get(i).getUserId()+" "+userList.get(i).getUserPw()+" "+userList.get(i).getUserNm();
//				System.out.println(info);
				fw.write(info+"\n"); //파일에 info를 써줌
			}
//			bw.flush();bw.close();
			fw.flush();fw.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}

}

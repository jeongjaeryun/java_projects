package co.yedam.friend;

import java.util.Scanner;

public class FriendExe {
	public static void main(String[] args) {
		//name, phone
		//배열 선언5 인스턴스 3명
		// name = 홍길동
		String name = "홍길동";
		String phone = "010-1727-2222";
	 Friend[] friends = new Friend[5];
//	 friends[0]= new Friend("홍길동", "010-1111-2222");
//	 friends[1]= new Friend("김길동", "010-2222-3333");
//	 friends[2]= new Friend("이길동", "010-3333-4444");
	 
	 for(int i =0; i<friends.length; i++) {
		 if(friends[i] == null) {
			 friends[i]= new Friend("홍길동", "010-1111-2222");
			 break;
		 }
		 System.out.println(friends[i].showInfo());
	 }
	 
	 
	 
	 for(int i =0; i<friends.length; i++) {
		 if(friends[i] != null && friends[i].getName().equals(name)) {
//			 System.out.println(friends[i].showInfo());
			 friends[i].setPhone(phone);
		 }
	 }
	}
}

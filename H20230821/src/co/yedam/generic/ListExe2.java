package co.yedam.generic;

import java.util.ArrayList;
import java.util.List;

public class ListExe2 {
	public static void main(String[] args) {
		List<Member>list = new ArrayList<>(); //멤버의 인스턴스를 담을수 있는 컬렉션 생성
		list.add(new Member(1001,"Hong")); // 값 담는 방법 1. add를 사용해서 값을 담아줌
		Member member = new Member(1002, "Hwang");//2. 따로 변수를 선언해서 이렇게 담아줌
		list.add(member); // 2. 따로 변수를 선언해서 이렇게 담아줌
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getMemberId()==1001) {
//				list.get(i).setMemberName("홍"); 값 수정
				list.remove(i); //값 삭제
				
			}
		}
		
		for (Member mem : list) {
			System.out.printf("이름은 %s\n", mem.getMemberName());
		}
		
	}
}

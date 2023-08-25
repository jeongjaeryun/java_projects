package co.yedam.api;

import java.util.HashSet;
import java.util.Set;

public class SetExe {
	public static void main(String[] args) {
		//ArrayList 배열특징을 갖고있는 클래스 HashSet 집합의 특징 갖고있는 클래스, 중복된 값은 저장 불가
		
		Set<String>set = new HashSet<>();
		set.add("Hong"); //값 담을때 add씀
		set.add("Hwang");
		set.add("Kim");
		set.add("Hong"); // 중복하는값 찍어내지 않음
		
		for(String str : set) {
			System.out.println(str);
		}
		
		Set<Member>memberSet = new HashSet<>();
		memberSet.add(new Member(101,"Hong"));
		memberSet.add(new Member(102,"Hwang"));
		memberSet.add(new Member(103,"Kim"));
		memberSet.add(new Member(101,"Hong")); //중복값이 아니라고 찍히나봄,,,
		for(Member str : memberSet) {
			System.out.println(str);
		}

		
	}
}

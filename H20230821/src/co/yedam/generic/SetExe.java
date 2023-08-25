package co.yedam.generic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SetExe {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("홍길동"); //값 저장 추가
		set.add("김길동");
		set.add("박길동");	
		set.add("홍길동"); //동일한 값 걸러내서 위에 "홍길동"은 안찍힘 중복값 허용안함!
//		set.remove("홍길동"); 값 삭제
		
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) { //끄집어낼 요소가 있으면 계속 반복하겠다 hasNext()- 가져올객체가 있으면 true 없으면 false 반환
			String val = iter.next(); // 값 출력
			System.out.println(val);
		}
		
		List<Integer>list = new ArrayList<>();
		list.add(10);
		list.add(11);
		list.add(12);
		list.add(11); //List는 중복값 허용
		
		Set<Integer>iset = new HashSet<>();
		for(Integer no : list) {
			iset.add(no); //list 값을 no에 저장 -> no는 Set 컬렉션이라 중복값 11은 제거하고 저장
		}
		
		for(Integer no : iset) {
			System.out.println(no);  // list의 중복값 11 제거해줘서 한번 찍힘
		}
		
	}

}

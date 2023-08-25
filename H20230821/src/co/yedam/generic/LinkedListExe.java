package co.yedam.generic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExe {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>(); // 뒤에 new에 타입 안적어주면 앞에 저절로 String 타입 땡겨옴
		long start = System.currentTimeMillis();
		for(int i=0; i<100000; i++) {
			list.add(0,"" + i); //0을 쓰면 젤 첫번째에 값을 계속 추가하는것! 0을 안쓰면 맨뒤에서부터 값이 추가됨
		}
		long end = System.currentTimeMillis();
		System.out.println("ArrayList: "+(end-start)+"ms");
		
		
		
		list = new LinkedList<>(); //List 인터페이스 구현하는 대표적인 클래스 Linked, Array
		start = System.currentTimeMillis();
		for(int i=0; i<100000; i++) {
			list.add(0,"" + i);
		}
		end = System.currentTimeMillis();
		System.out.println("LinkedList: "+(end-start)+"ms"); //LinkedList가 ArrayList보다 시간 두배정도 더 걸림
		
		//중간위치 수정할땐 LinkedList
		//끝에서 부터 수정할땐 ArrayList 쓰는게 빠름
		//우리는 ArrayList 쓰기로,,,
		
	}
}

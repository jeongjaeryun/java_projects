package co.yedam.generic;

import java.util.ArrayList;
import java.util.List;

public class ListExe {
   public static void main(String[] args) {
	   List<String> list = new ArrayList<String>(); //List 는 인터페이스. new로 객체 못만듦
	   list.add("Hello");   //add()메소드로 값을 추가함
	   list.add(new String("World"));
	   list.add("Good");
	   
	   String result = list.get(0); //컬렉션 인덱스0의 값을 가져옴 여기선 Hello  컬렉션.get(인덱스번호); 배열 가져올땐 ary[0]이었음
	   System.out.println(result);
	   
	   for(int i=0; i<list.size(); i++) { // 배열에서 배열.length썼듯이 컬렉션에선 컬렉션.size();
		   System.out.println(list.get(i)); //list가 가지고 있는 값 출력

	   }
	   
	   list.set(1, "result"); //(인덱스 1의 값을 "result"로 변경)
	   System.out.println("===값 수정후===");
	   list.remove(1);//인덱스 1에 있는 값을 삭제하겠다
	   list.clear();//값 전체 삭제
	   
	   for(String str : list) { //list가 가지고 있는 값만큼 확장하겠다
		   System.out.println(str);
	   }
	   
  }
}

package co.yedam.variable;

import java.io.IOException;

public class VariableExe4 {
	public static void main(String[] args) {
		// 이름은 홍길동이고, 나이는 20살입니다.
		String name = "홍길동"; 
		int age = 20;   //name이라는 변수와 age라는 변수 선언
		double weight = 67.8;
		
		System.out.println("이름은 "+ name + ", 나이는 "+ age +"살 입니다.");
		System.out.printf("이름은 %s, \n나이는 %d살, \n몸무게는 %.2f 입니다.\n",name,age,weight); //%s에 들어갈 값은 name에 저장된 문자열, %d에 들어갈 값은 age에 저장된 값
		//%.nf 소수점 n자리만큼 표시하겠다
		
		try {
			System.out.println("값을 입력>>>"); //a 누르고 Enter침 
			while(true) {
			int result = System.in.read();//사용자가 입력한 값을 숫자값으로 보여주는 메소드
			if(result == 113) { //q: 113 q를 누르면 break 조건문빠져나오게
				break;
			  }else if(result==10 || result == 13){
				 //ENTER(cr:13, lf: 10)
			  }else {
				  System.out.println("키코드: " + result);				  
//			      System.out.println("값을 입력>>>");

			  }
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end of prog.");
		
	}//end of main
} //end of class.

package co.yedam.loop;

public class WhileExe {

	public static void main(String[] args) {
		
		
		boolean run = true;
		while(run) {
			int tmp = (int)(Math.random()*100);
			if(tmp > 90) {
				break;  //tmp가 90보다 큰 경우 종료하겠습니다
				//run = false; break해주거나 run 값을 false로 해줘서 반복 종료
			}
			System.out.println(tmp);
		}//while문의 끝
		System.out.println("end");
		
		int i = 1;
		while(i<=10) {
			System.out.println(i);
			i++;
		}//while문의 끝
		
		int sum = 0;
		i=1;
		while(i<=100) {
			sum += i;
			i++;
		}//while문의 끝
		
		System.out.println("1~"+(i-1)+"합: "+sum);
		
		//do while문
		System.out.println("--------------------------------");
		while(true) {
			int num = (int)(Math.random()*6)+1;
			System.out.println(num);
			if(num==6) {
				break;
			}
		}
		System.out.println("프로그램 종료");
		
	  Outter: for(char upper='A'; upper<='Z'; upper++) {
		  for(char lower='a'; lower<='z'; lower++) {
			  System.out.println(upper+"-"+lower);
			  if(lower=='g') {
				  break Outter;
			  }
		  }
	  }
	  System.out.println("프로그램 실행 종료");
	  
////	  for(int i=1; i<=10; i++) {
//		  if(i%2 != 0) {
//			  continue;
//		  }
//	  }
	}//main의 끝

}

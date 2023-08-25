package co.yedam.loop;

public class ForExe {

	public static void main(String[] args) {
		int sum = 0;
		sum = sum + 1;
		sum = sum + 2;
		sum = sum + 3;
		sum = sum + 4;
		sum = sum + 5; //sum에 5를 더한값까지 누적시키겠다
		
		sum = 0;
		for(int i=1; i<=5; i++) {
			sum = sum + i;
		}
		System.out.println(sum);
		
		System.out.println("---------------------------------");

		System.out.println("1부터 10까지 출력");
		for(int i=1; i<=10; i++) {
			System.out.println(i);
		}
		sum = 0;
		for(int i = 1; i <= 100; i++) {
			sum = sum + i;
			//sum += i;
		}System.out.println("1~100의 합: "+sum);
		
		//float타입 카운터 변수
		for(float x=0.1f; x<=1.0f; x+=0.1f) {
			System.out.println(x);  //0.1은 플로트 타입이라 정확하게 표현불가 9번만 실행됨
		}
		
		//중첩for문 구구단만들기
		for(int m=2; m<=9; m++) {
			System.out.println("***"+m+"단 ***");
			for(int n=1; n<=9; n++) {
				System.out.println(m+"x"+n+"="+(m*n));
			}
		}
		
		System.out.println("----------별찍기1-----------");
		//별찍기
		for(int i=1; i<=4; i++) {
			System.out.println();
			for(int j=1; j<i+1; j++ ) {
				System.out.print("*");
			}
		}System.out.println();
		

		System.out.println("----------별찍기2-----------");
		
		for(int i=1;i<=4;i++) {
			System.out.println();
			for(int a=4; a>i; a--) {
				System.out.print(" ");
			}for(int j=1; j<i+1; j++) {
				System.out.print("*");
			}
		}System.out.println();
		
		System.out.println("-----------------");
		for(int i =1; i<=4; i++) {
			for(int j = 1; j<=4; j++) {
				if(i+j<5) {
					System.out.print(" ");
				}else {
					System.out.println("*");
				}
				System.out.println();
			}
		}
		System.out.println("end");
		
	}//main의 끝

}

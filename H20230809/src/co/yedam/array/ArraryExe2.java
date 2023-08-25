package co.yedam.array;

public class ArraryExe2 {

	public static void main(String[] args) {
		
		
		int num1, num2, num3;
		num1 = 56;
		num2 = 72;
		num3 = 67;
		
		// 큰값:
		int max = 0;
		if(num1>num2) {
			if(num1>num3) {
				max = num1;
			}else {
				max = num3;
			}
		}else {
			if(num2>num3) {
				max = num2;
			}else {
				max = num3;
			}
		}
		System.out.println("if문으로 max값 구하기"+max);
		
		//배열로 큰값구하기
		max=0;
		int[]intAry = {num1, num2, num3};		
		for(int i = 0; i<intAry.length; i++) {
			if(max < intAry[i]) {
				max = intAry[i];
			}
		}
		System.out.println("배열로 max값 구하기: "+max);
		
		
		
		//정수를 담을 배열 공간 5개 생성
		int[]Ary = new int[5]; //배열 길이 : 5
		//1~100사이의 임의의 값을 가져와서 배열의 첫번째 위치에 담기
//		Ary[0]=(int)(Math.random()*100)+1;
		
		//반복문으로 배열의 값 넣기
		int sum = 0;
		double avg = 0;
		for(int i=0; i<=Ary.length-1; i++) {
			Ary[i]=(int)(Math.random()*100)+1;
			sum += Ary[i];
//			System.out.println(sum);
		}
		    avg = sum / Ary.length; 
		System.out.println(sum);
		System.out.println(avg);
		//5개의 합, 평균
		
		
	}//main의 끝

}


package co.yedam.array;

public class ArraryExe1 {

	public static void main(String[] args) {
		//배열 선언
		int[] intAry = null;
		intAry = new int[10]; //정수담을 공간 10개 생성
		intAry = new int[] {12,25,67,23}; //공간이 4개인 배열 생성	
		
		int[]intAry2 = {55, 47, 90}; // 이 배열이 가지고 있는 주소값 반환
		
		System.out.println(intAry[0]);
		intAry[0] = 22; // intAry 배열 첫번째 값으로 22 넣음
//		intAry = 50; 데이터 유형이 달라서 안됨 왼쪽 오른쪽 데이터타입 같아야함
		intAry = intAry2; //둘다 정수를 담은 배열이라서 Ary2의 주소값을 Ary에 할당 가능
		
		int sum = 0;
		sum += intAry[0];
		sum += intAry[1];
		sum += intAry[2];
		sum += intAry[3];
		
		//위에거를 반복문으로 만든게 밑에거
		
		for(int i=0; i<4; i++) {
			sum += intAry[i]; // 0 1 2 3
		}
		
		
		
	}//main의 끝

}

package co.yedam.array;

public class FuncExe {
	public static void main(String[] args) { //void 반환되는 값이 없음
//		printStar(); //프린트스타 메소드를 실행해라, 별 한번 찍힘
//	    printStar(3); //별 세번찍힘
		printString(5, "♡"); // str타입 하트가 5번 찍힘
		int n3 = sum(5,7);
		System.out.println(n3);
		int[]intAry = {5,7,9,2,6};
		int n4 = sum(intAry);
		System.out.println(n4);
		
	   Friend f = getFriend("홍길동", "010-4567-2345", Gender.MEN); //겟프렌드 메소드가 반환해주는 데이터타입이 프랜드 타입
	   f.showInfo();
	}
	
	public static void printStar() {
		System.out.println("*");
	}
	
	public static void printStar(int times) { //()안에 들어가는 값 매개변수
		for(int i=0; i<times; i++)
		System.out.println("*");
	}
	
	public static void printString(int times, String str) { //()안에 들어가는 값 매개변수
		for(int i=0; i<times; i++)
		System.out.println(str);
	}
	
	public static int sum(int n1, int n2) { 
		int result = n1 + n2;    
		return result;     //int타입 result에 저장된 값을 반환해주겠다
	}
	
	public static int sum(int[] arry) { 
		int sum = 0;
		for(int i=0;i<arry.length;i++) {
			sum += arry[i];
		}
		return sum;     //sum에 저장된 값을 반환해주겠다
	}
	
	public static Friend getFriend(String name, String phone, Gender gender) {
		Friend f = new Friend();
		f.name = name; //이름 name에 넣고 
		f.phone = phone; //연락처 phone에 넣고
		f.gender = gender; //성별 gender에 넣고
		return f;
	}
	
}

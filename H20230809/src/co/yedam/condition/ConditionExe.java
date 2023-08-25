package co.yedam.condition;

public class ConditionExe {

	public static void main(String[] args) {
		
		int num = 97;
		char chr = 65; //65 66 67 68
		byte b1 = 2;
		byte b2 = 2;
		int result = b1 +b2;   //작은 타입에서 큰타입으로 갈땐 자동형변환이 됨
		
		//"abc".equals("asd") 문자열 비교할땐 .equals
		System.out.println(chr == 'A');
		
		char grade1 = (char)((Math.random()*4+65)); //*(최대값-최소값+1)+최소값 ,,큰타입에서 작은타입으로 변환할때 강제형변환 붙여줘야함
		System.out.println(grade1);
		
		System.out.println("어떤 혜택을 원하세요?");
		
		switch(grade1) {
		case 'A' : 
			System.out.println("VVIP 혜택을 받으실 수 있습니다.");
			break;
		case 'B' : 
			System.out.println("VIP 혜택을 받으실 수 있습니다.");
			break;
		case 'C' : 
			System.out.println("우수 회원 혜택을 받으실 수 있습니다.");
			break;
		case 'D' : 
			System.out.println("일반 회원 혜택을 받으실 수 있습니다.");
			break;
		default:
			System.out.println("혜택이 없습니다.");
		}
		System.out.println("감사합니다.");
		
		
		
		
		
		
		
		//임의의 수 1이 나오면 가위, 2 바위, 3보
		int score = (int)(Math.random()*3)+1;
		if(score==1) {
			System.out.println(score+"는 가위입니다");
		}else if(score==2){
			System.out.println(score+"는 바위입니다");

		}else {
			System.out.println(score+"는 보입니다");
		}
		String grade = ""; 
		switch(score) {
		case 1:
			grade = "가위";
		case 2:
			grade = "바위";
		case 3:
			grade = "보";
	    }
	System.out.printf("%d는 %s입니다.", score, grade);
	
	}

}

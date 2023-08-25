package co.yedam.condition;

public class IfExe {

	public static void main(String[] args) {
		int score = 85; 
		score = (int)(Math.random()*100)+1; //0~49까지의 수가 랜덤으로 나옴 50까지 나오려면 뒤에 1더하기
		String grade = ""; // 변수선언하고 초기화 해줘야함
		
		if(score > 90) {
			grade = "A";
		}else if(score > 80) {
			grade = "B";
		}else if(score > 70) {
			grade = "C";
		}else if(score > 60) {
			grade = "D";
		}else {
			grade = "F";
		} // 하나의 if문에 else if, else가 들어가 있는것
		
		int score1 = score / 10; // 95/10 => 9.5이지만 정수타입이니 9만 나옴
		switch(score1) {  //case문은 조건에 맞아도 밑에 조건 다 돌기때문에 break 걸어주기
		case 10:
			grade = "A";
			break;
		case 9:
			grade = "A";
			break;
		case 8:
			grade = "B";
			break;
		case 7:
			grade = "C";
			break;
		case 6:
			grade = "D";
			break;
		default:
			grade = "F";
		}
		System.out.printf("점수 %d는 %s입니다.", score, grade);
	}

}

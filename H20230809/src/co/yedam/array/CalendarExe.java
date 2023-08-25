package co.yedam.array;

public class CalendarExe {
	public static void main(String[] args) {
	  int month = 3;
	  System.out.println("-------------"+month+"월-------------");
	  String[] days = {"SUN","MON","TUE","WED","THR","FRI","SAT"};
	  for(int i=0; i < days.length; i++) {
		  System.out.printf("%4s",days[i]);
	  }
	  System.out.println();
	  //달력, 31일까지
	  int space = getFirstDay(month); // 달력 첫주 공백
	  for(int i=0; i < space; i++) {
		  System.out.printf("%4s"," ");
		  }
	  
	  for(int i=1; i<=getLastDate(month); i++) { //1~31일 7일씩 떨어지게
		  System.out.printf("%4d",i);
		  if((i+space) % 7 == 0) {
			  System.out.println();
		  }
	  }

	}//main의 끝
	
	public static int getFirstDay(int month) {
		int day = 0;
		int totalDays = 0;
		for (int i = 1; i <= month -1; i++) { //1월은 공백날이 0이라 반복문 안돎
			totalDays += getLastDate(i);
		}
		day = (day+totalDays) % 7;
		return day;
	}
//	public static int getFirstDay(int month) { //월의 첫날의 시작요일위치
//		int day = 0;
//		switch(month) {
//		case 1: //1월
//			day = 0;
//			break;
//		case 2: //2월
//			day = 3;
//			break;
//		case 3: //3월
//			day = 3;
//			break;
//		case 4: //4월
//			day = 6;
//			break;
//		case 5: //5월
//			day = 1;
//			break;
//		case 6: //6월
//			day = 4;
//			break;
//		case 7: //7월
//			day = 6;
//			break;
//		case 8: //8월
//			day = 2;
//			break;
//		case 9: //9월
//			day = 5;
//			break;
//		case 10: //10월
//			day = 0;
//			break;	
//		case 11: //11월
//			day = 3;
//			break;
//		case 12: //9월
//			day = 5;
//			break;
//		}
//		return day;
//	}
	
	public static int getLastDate(int month) { //월의 마지막날
		//1월 : 31 2월: 28 3월 :31... 1 3 5 7 8 10 12
		int lastDate = 31;
		switch(month) {
		case 4:
		case 6:
		case 9:
		case 11:
			lastDate=30;   //달이 4,6,9,11 이면 라스트데이트에 30을 담겠다
			break;
		case 2:
			lastDate=28;
		}
		return lastDate;
	}
}

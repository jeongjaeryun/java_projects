package co.yedam.classes.friend;

import java.util.Calendar;

public class CalendarApp {
	public void showCalendar(int year, int month) {
	
	System.out.println("           "+year+"년 "+month+"월 ");
		
	Calendar cal = Calendar.getInstance(); // getinstance 인스턴스(객체)만드는 거 인스턴스가 있어야 계산처리함
	cal.set(year, month -1, 1);
	int first = cal.get(Calendar.DAY_OF_WEEK);
	int last = cal.getActualMaximum(Calendar.DATE);
	
//		cal.set(2023, 1, 3);
//		System.out.println(Calendar.DAY_OF_WEEK);//호출되는 시점의 연도월시간
//		System.out.println(cal.get(Calendar.YEAR)); //MONTH, DATE
//		System.out.println(cal.get(Calendar.DAY_OF_WEEK)); //cal의 기능중에 get이라는 메소드 첫째날 조회
//		System.out.println(cal.getActualMaximum(Calendar.DATE)); //달의 마지막날 조회
	 
	
	
	String[] days = {"SUN","MON","TUE","WED","THR","FRI","SAT"};
	  for(int i=0; i < days.length; i++) {
		  System.out.printf("%4s",days[i]);
	  }
	  System.out.println();
	  //달력, 31일까지
	  int space = first; // 달력 첫주 공백
	  for(int i=0; i < space-1; i++) {
		  System.out.printf("%4s"," ");
		  }
	  
	  for(int i=1; i<=last; i++) { //1~31일 7일씩 떨어지게
		  System.out.printf("%4d",i);
		  if((i+space-1) % 7 == 0) {
			  System.out.println();
		  }
	  }
	
		
	}
}

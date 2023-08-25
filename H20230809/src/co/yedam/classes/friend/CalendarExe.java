package co.yedam.classes.friend;

import java.util.Calendar;

public class CalendarExe {
	public static void main(String[] args) {
//		Calendar cal = Calendar.getInstance(); // getinstance 인스턴스(객체)만드는 거
		
//		cal.set(2023, 1, 3);
//		System.out.println(Calendar.DAY_OF_WEEK);//호출되는 시점의 연도월시간
//		System.out.println(cal.get(Calendar.YEAR)); //MONTH, DATE
//		System.out.println(cal.get(Calendar.DAY_OF_WEEK)); //cal의 기능중에 get이라는 메소드 첫째날 조회
//		System.out.println(cal.getActualMaximum(Calendar.DATE)); //달의 마지막날 조회
		
		CalendarApp app = new CalendarApp();
		app.showCalendar(2002, 6);
		
		
	}

}

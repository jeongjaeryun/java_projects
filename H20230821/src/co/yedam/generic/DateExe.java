package co.yedam.generic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExe {
	public static void main(String[] args) {
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //연원일 시분초로 출력하고싶다면 
		System.out.println(today.toString()); //이건 미국식으로 출력 요일 월 일 시간 연도
		System.out.println(sdf.format(today)); //연월일로 찍기 Date를 String타입으로 보여줌
		
		String strTime = "2023-09-01 13:22:33";
		try {
			Date newdate = sdf.parse(strTime);//parse는 String -> Date로 바꿔줌
			System.out.println(newdate.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		
		
	}

}

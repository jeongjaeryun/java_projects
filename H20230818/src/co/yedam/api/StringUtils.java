package co.yedam.api;

public class StringUtils {
	static String checkGender(String ssn) {
		//주민번호 구분해서 남자, 여자, 오류케이스 판별
		
		
		String ssn1 = "9802252068507";
		char birth = ssn1.charAt(6);
		if(birth == ' ' || birth == '-') {
			birth =ssn1.charAt(7);
		}
		String result = "";
		int year = ssn1.charAt(0);
		if(year >= 0 && birth == '3') {
			System.out.println("남자입니다");
		}
			switch(birth) {
			case '1':
			case '3':
				result = "남자입니다.";
				System.out.println(result);
				break;
			case '2':
			case '4':
				result = "여자입니다.";
				System.out.println(result);
				break;
			default: 
				result = "오류입니다.";
				System.out.println(result);
		 }//switch
		
			return result;
			
		
		
	}
	
	static String getFileName(String filePath) {
		//전체경로에서 파일명만 추출
		String file = "C:/Dev/temp/포메.jpg";
		String firstNum = file.substring(12);
		System.out.println(firstNum);
		
		return null;
	}
	
}

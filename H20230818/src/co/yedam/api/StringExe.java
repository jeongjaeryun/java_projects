package co.yedam.api;

import java.io.UnsupportedEncodingException;

public class StringExe {
	public static void main(String[] args) {
		
		
		byte[]bytes = {104, 101, 108, 108, 111}; //byte 배열 생성 {hello}
		String str=null;
		try {
			str = new String(bytes, 0, 3, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} //범위 설정해서 찍을수도 있음 0번쨰부터 3번째까지
		System.out.println(str);

	}

}

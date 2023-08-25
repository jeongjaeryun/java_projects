package co.yedam.stream;

import java.io.FileInputStream;
import java.io.IOException;

public class FileinputStreamExe {
	public static void main(String[] args) {
		FileInputStream fis;
		try {
			fis = new FileInputStream("C:/Temp/out.data");
			while (true) {
				int val = fis.read(); // 1바이트를 읽고 읽은 바이트 수 리턴
				if (val == -1) {
					break;
				}
				System.out.println(val);
			}

			fis.close(); // 꼭넣어줘야함 아님 계속 실행
		} catch (IOException e) {
			e.printStackTrace();
		} // 파일을 읽어들임

	}

}

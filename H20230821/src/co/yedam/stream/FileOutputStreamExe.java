package co.yedam.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamExe {
	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("C:/Temp/out.data"); // out.data 파일 만들어짐 폴더는 못만들어서 C드라이브에 Temp
																				// 폴더 만들어주기
			fos.write(100); // byte타입으로 저장
			fos.write(200);
			fos.write(256); // 248 16 32 64 128 256 0~255바이트까지 담음
			fos.flush(); // 버퍼의 캐시값을 비움
			fos.close(); // 사용한 리소스 환원. 사용종료


		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("end.");
	}// main의 끝
}

package co.yedam.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		try {
			FileInputStream fis = new FileInputStream("C:/Temp/img.jpg");
			FileOutputStream fos = new FileOutputStream("C:/temp/copy.jpg");
			byte[] buf = new byte[100];
			
			while (true) {
				int val = fis.read(buf); // read() 1바이트씩 읽음
				if (val == -1) {// 더이상 읽어들일 값이 없으면 -1값을 반환함 
					break;
				}
				fos.write(buf); // write()1바이트 쓰기
			}
			fis.close();
			fos.flush();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();

		System.out.println("end - "+(end - start)+"ms");

	}

}

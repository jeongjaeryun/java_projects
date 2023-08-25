package co.yedam.stream;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExe {
	public static void main(String[] args) {
		try {
			File file = new File("src/co/yedam/stream/FileCopy.java");
			FileReader fr = new FileReader(file);
			char[] buf = new char[100]; // buf 100바이트씩 읽겠습니다
			while (true) {
				int val = fr.read(buf); //배열이면 읽어들인 크기가 들어감 배열아니면 읽어들인 문자
				if (val == -1) {
					break;
				}
				for (int i = 0; i < val; i++) {
					System.out.print(buf[i]);
				}
			}
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

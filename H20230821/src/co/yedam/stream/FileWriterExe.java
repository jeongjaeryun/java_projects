package co.yedam.stream;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterExe {
	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("C:/Temp/names.txt"); // names.txt 파일 만듦 출력스트림
			Scanner scn = new Scanner(System.in);

			System.out.println("start");
			while (true) {
				String line = scn.nextLine();
				if (line.equals("quit")) { // quit를 넣으면 종료할게
					break;
				}
				fw.write(line + "\n");
			}
			fw.flush();
			fw.close();
			scn.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end");
	}

}

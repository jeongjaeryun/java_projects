package co.yedam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BoardApp {
	Scanner scn = new Scanner(System.in);
	List<Board> boards = new ArrayList<Board>();
	Board service = new Board();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	private String printString(String msg) { // 스캐너
		System.out.print(msg + ">> ");
		return scn.nextLine();
	}

	public BoardApp() { // 시작시 초기자료
		init();
	}

	public void start() {

		boolean run = true;
		while (run) {
			System.out.println("1.추가 2.수정 3.상세조회 4.삭제 5.목록 9.종료");
			System.out.print("선택>> ");

			int menu = scn.nextInt();
			scn.nextLine();

			switch (menu) {
			case 1: // 등록.
				register();
				break;

			case 2: // 수정
				modify();
				break;

			case 3: // 조회
				search();
				break;

			case 4: // 삭제
				remove();
				break;

			case 5: // 목록
				list();
				break;

			case 9: // 종료, 저장
				System.out.println("종료합니다.");
				save();
				run = false;
			}
		}
		System.out.println("end of prog.");
	}// start 끝

	void register() { // 등록
		String brNo = printString("글번호입력");
		String title = printString("제목입력");
		String content = printString("내용입력");
		String writer = printString("작성자입력");
		Date today = new Date();
		Board board = new Board(Integer.parseInt(brNo), title, content, writer, today);
		board.setWrDate(today);

		boards.add(new Board(Integer.parseInt(brNo), title, content, writer, today));

	}// register 끝

	void modify() { // 수정
		String brdNo = printString("번호 입력");
		String content = printString("내용 입력");
		for (int i = 0; i < boards.size(); i++) {
			if (boards.get(i).getBrdNo() == Integer.parseInt(brdNo)) {
				boards.get(i).setContent(content);
				break;
			}
		}
	}// modify 끝

	void search() { // 조회
		String brdNo = printString("번호입력");
		for (int i = 0; i < boards.size(); i++) {
			if (boards.get(i).getBrdNo() == (Integer.parseInt(brdNo))) {
				System.out.println(boards.get(i).toString());
				break;
			}
		}
	}// search끝

	void remove() { // 삭제
		String brdNo = printString("번호입력");
		for (int i = 0; i < boards.size(); i++) {
			if (boards.get(i).getBrdNo() == (Integer.parseInt(brdNo))) {
				boards.remove(i);
				break;
			}
		}
	}// remove끝

	void list() { //목록

		for (Board bord : boards) {
			System.out.println("글번호 : " + bord.getBrdNo() + " 글제목: " + bord.getTitle() + "\n작성자: " + bord.getWriter() //
					+ " 작성일자: " + sdf.format(bord.wrDate));
		}
	}// list 끝

	public void init() {
		try {
			FileInputStream fis = new FileInputStream("C:/Temp/boardList.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);

			// 값을 읽어들임 반환되는 타입이 객체 타입. boardList에 담을거임
			boards = (List<Board>) ois.readObject(); // 객체로 변형시키겠다

			ois.close();
			fis.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}// init 끝

	public void save() { // 파일저장기능구현

		try {
			FileOutputStream fos = new FileOutputStream("C:/Temp/boardList.dat"); // 출력스트림
			ObjectOutputStream oos = new ObjectOutputStream(fos);// 보조스트림
			oos.writeObject(boards); // 직렬화 거쳐서 객체를 바이트타입으로 변경함
			oos.flush();
			oos.close();
			fos.flush();
			fos.close();

			System.out.println("게시글 저장완료");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}// save 끝

}// BoardApp끝

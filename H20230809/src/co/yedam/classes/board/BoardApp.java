package co.yedam.classes.board;

import java.util.Scanner;

public class BoardApp {
  //기능구현
	Scanner scn = new Scanner(System.in);//스캐너 scn 생성
	private Board[] boards = new Board[100]; //배열생성
	public BoardApp() {}//기본생성자
//	Board brd = new Board();
	
	//글등록
	void addBoard() {
		System.out.println("글 등록 기능");
		System.out.println("글 번호 입력 >> ");
		int bNo = Integer.parseInt(scn.nextLine());
		System.out.println("글 제목 입력 >> ");
		String title = scn.nextLine();
		System.out.println("글 내용 입력 >> ");
		String content = scn.nextLine();
		System.out.println("작성자 >> ");
		String user = scn.nextLine();
		Board brd = new Board(bNo, user, title, content);
		// 배열 등록
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] == null) {
				boards[i] = brd;
				break;
			}
		}
	} // addBoard()의 끝
	
	void list() {
			System.out.println("글번호  제목  작성자");
			for (Board brd : boards) {
				if (brd != null) {
//					System.out.println(brd.toString());
					System.out.println(brd.getBoardNo()+"  "+brd.getTitle()+"  "+brd.getUser());
				}
			}
		}// list()의 끝
	void detailList() {
		System.out.println("상세보기");
		System.out.println("글 번호 입력 >> ");
		int bNo = Integer.parseInt(scn.nextLine());
//		for(int i=0; i<boards.length; i++) {
//			if(boards[i] != null && boards[i].getBoardNo()==(bNo)) {
//				System.out.println(boards[i].toString());
//			}
//		}	
		
		for (Board brd : boards) {
			if(brd != null && brd.getBoardNo() ==(bNo)) {
				System.out.println(brd.toString());
				break;
			}
		}
	}//detailList()의 끝
	void edit() {
		System.out.println("글 수정");
		System.out.println("글 번호 입력 >> ");
		int bNo = Integer.parseInt(scn.nextLine());
		System.out.println("수정할 글 제목 입력 >> ");
		String title = scn.nextLine();
		System.out.println("수정할 글 내용 입력 >> ");
		String content = scn.nextLine();
		
		for(int i=0; i<=boards.length; i++) {
			if(boards!=null && boards[i].getBoardNo()==(bNo)) {
				boards[i].setTitle(title);
				boards[i].setContent(content);
				System.out.println("수정 되었습니다.");
				break;

			}
		}
//		for(Board brd : boards) {
//			if(brd != null && brd.getBoardNo()==(bNo)) {
//				brd.setTitle(title);
//				brd.setContent(content);
//				System.out.println("수정 되었습니다.");
//
//			}
//		}
	}//edit()의 끝
	void delBoard() {
		System.out.println("글 삭제");
		System.out.println("삭제할 글 번호 >> ");
		int bNo = Integer.parseInt(scn.nextLine());
		for (int i = 0; i <= boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNo()==(bNo)) {
				boards[i] = null; // 삭제.
				System.out.println("삭제되었습니다.");
				break; // 빠져나옴
			}
		}
	}//delBoard의 끝
	
	public void start() {
		boolean run = true;
		BoardApp bapp = new BoardApp();
		Scanner scn = bapp.scn;
		
		while (run) {
			System.out.println("1.등록 2.목록 3.상세보기 4.수정 5.삭제 6.종료");
			System.out.println("선택>> ");
			
			int menu = Integer.parseInt(scn.nextLine()); 

			switch (menu) {
			case 1:
				bapp.addBoard();
				break;
			case 2:
				bapp.list();
				break;
			case 3:
				bapp.detailList();
				break;
			case 4:
				bapp.edit();
				break;
			case 5:
				bapp.delBoard();
				break;
			case 6 :
				System.out.println("종료합니다");
				run = false;
			}// switch의 끝

		} // while의 끝
		
	}//start의 끝
	
}//BoardApp의 끝
	
	


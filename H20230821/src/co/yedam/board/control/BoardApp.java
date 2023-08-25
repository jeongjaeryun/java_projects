package co.yedam.board.control;

import java.util.List;
import java.util.Scanner;

import co.yedam.board.service.BoardService;
import co.yedam.board.service.BoardServiceJdbc;
import co.yedam.board.service.ReplyService;
import co.yedam.board.service.ReplyServiceImpl;
import co.yedam.board.service.UserService;
import co.yedam.board.service.UserServiceJdbc;
import co.yedam.board.vo.Board;
import co.yedam.board.vo.Reply;
import co.yedam.board.vo.User;

public class BoardApp { // 메인기능담당

	Scanner scn = new Scanner(System.in);
	BoardService service = new BoardServiceJdbc(); // 보드서비스는 인터페이스
//	BoardService service = new BoardServiceImpl(); // 보드서비스는 인터페이스
	UserService uservice = new UserServiceJdbc();// 오라클을 활용해 처리하겠다
	ReplyService rpservice = new ReplyServiceImpl();
	String id = null;

	public void start() {

		// 사용자체크 아이디 패스워드 맞으면 진행 틀리면 계속 로그인하라고 알려줌

		boolean run = true;
		while (true) {
			id = printString("id");
			String pw = printString("pass");
			User user = new User();
			user.setUserId(id);
			user.setUserPw(pw);

			user = uservice.checkLogin(user); // 이러면 반환해주는게 user클래스

			if (user != null) {
				System.out.println(user.getUserName() + ", 환영합니다.");
				break;
			}
			System.out.println("로그인에 실패했습니다.");
		}
		while (run) {

			System.out.println("1.글등록 2.목록 3.수정 4.삭제 5.상세조회 9.종료");
			System.out.println("선택>> ");

			int menu = scn.nextInt();// 들어오는숫자값처리
			scn.nextLine();// 엔터처리

			switch (menu) {
			case 1:// 등록
				register();
				break;

			case 2: // 목록
				boardList();
				break;

			case 3:// 수정
				modify();
				break;

			case 4: // 삭제
				remove();

				break;

			case 5: // 상세조회
				search();
				break;

			case 9:
				System.out.println("종료합니다");
				service.save();
				rpservice.save();// 종료되는 시점에 파일 저장.
				run = false;
				break;
			}

		}
		System.out.println("end of prog.");
	}// end of start

	private String printString(String msg) {
		System.out.println(msg + " >> ");
		return scn.nextLine();// 입력값 반환해줌
	}

	void register() {// 등록
		String title = printString("제목 입력");
		String content = printString("내용 입력");
		String writer = id;
		Board board = new Board(title, content, writer);
		// 보드서비스구현하는 클래스에 매개값으로 던져넣을것

		if (service.add(board)) {// 등록기능 이렇게 호출하면 등록되도록
			System.out.println("등록 완료!");
		} else {
			System.out.println("등록 실패!");
		}
	}

	void boardList() {// 목록
		int page = 1;
		while (true) {
			System.out.println("<글번호>   <제목>   <작성자>");
			System.out.println("===========================");
			List<Board> list = service.list(page);
			for (Board b : list) {
				System.out.println(b.listInfo());
			}
			// 4건 > 1page, 9건 > 2page, 19건 > 4page
			System.out.println("===========================");

			int totalCnt = service.getTotal(); // 토탈건수
			int lastPage = (int) Math.ceil(totalCnt / 5.0); // 올림 계산한 마지막 페이지
			for (int i = 1; i <= lastPage; i++) {
				if (i == page) {
					System.out.printf("[%2d]", i);
				} else
					System.out.printf("%3d", i);
			}
			System.out.println();// 줄바꿈
			System.out.println("조회페이지 입력하세요(exit: 9)>> ");
			page = scn.nextInt();
			if (page == 9) {
				break;
			}
		}
	}

	void modify() {// 수정
		String brdNo = printString("번호 입력");
		if (!service.getResponseUser(Integer.parseInt(brdNo)).equals(id)) {
			System.out.println("권한없음!");
			return; // 실행을 중지하겠습니다
		}
		String content = printString("내용 입력");
		Board brd = new Board();
		brd.setBrdNo(Integer.parseInt(brdNo)); // 문자열값을 int타입으로 변경
		brd.setBrdContent(content);
		if (service.modify(brd)) {
			System.out.println("수정 완료!");
		} else {
			System.out.println("수정 실패!");
		}
	}

	void remove() {// 삭제
		String brdNo = printString("삭제할 글번호 입력");
		if (!service.getResponseUser(Integer.parseInt(brdNo)).equals(id)) {
			System.out.println("권한없음!");
			return; // 실행을 중지하겠습니다
		}
		if (service.remove(Integer.parseInt(brdNo))) {
			System.out.println("삭제 완료!");
		} else {
			System.out.println("삭제 실패!");
		}
	}

	void search() {// 상세조회
		String brdNo = printString("조회할 글번호 입력");
		Board result = service.search(Integer.parseInt(brdNo));

		if (result == null) {
			System.out.println("해당 글 번호가 없습니다");
		} else {
			System.out.println(result.showInfo());
			showRp(brdNo);
			reply(brdNo);// 댓글입력등록
			
//			ReplyApp rapp = new ReplyApp(Integer.parseInt(brdNo));
//		    rapp.start();//댓글의 컨트롤 역할
		}

	}

	// 댓글추가 목록 삭제
	void reply(String brdNo) {
		int brdNo2 = Integer.parseInt(brdNo);
		String rewrite = printString("댓글입력 : a 나가기 : b");
		if (rewrite.equals("a")) {
			// 댓글입력 받기
			String rpContent = printString("댓글작성 ");
			System.out.println("작성자: " + id);
			// 댓글정보 Reply 객체에 저장
			Reply reply = new Reply(brdNo2, rpContent, id);

			if (rpservice.add(reply)) {
				System.out.println("댓글 등록 완료!");
			} else {
				System.out.println("댓글을 등록 실패.");
			}
		}
	}

	void showRp(String brdNo) {

		List<Reply> rlist = rpservice.list();
//		System.out.println(rlist.size());
		for (Reply r : rlist) {
			if (r.getBrdNo() == Integer.parseInt(brdNo)) {
				System.out.print(" ㄴ");
				System.out.println(r.toString());
			}
		}
	}
	
	class ReplyApp{
		//필드
		private ReplyService rpservice =new ReplyServiceImpl();
		private int brdNo;
		//생성자
		public ReplyApp(int brdNo) {
			this.brdNo = brdNo;
		}
	
	}//ReplyApp 끝
	
	
}

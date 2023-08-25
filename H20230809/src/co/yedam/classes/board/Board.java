package co.yedam.classes.board;

public class Board {
//글번호 제목공간 작성자공간 글내용 4개의 정보를 담을수 있는 클래스 선언
	
	int boardNo;
	String user;
	String title;
	String content;
	
	public Board() { //기본생성자
		
	}
	
	public Board(int boardNo, String user, String title,String content) {
		this.boardNo = boardNo;
		this.user = user;
		this.title = title;
		this.content = content;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}



	@Override
	public String toString() {
		return "글번호 : " + boardNo +"   작성자 : " + user + "\n제목 : " + title +"\n내용 : " + content +"\n";
	}
	
	



	
}//Board의 끝

 

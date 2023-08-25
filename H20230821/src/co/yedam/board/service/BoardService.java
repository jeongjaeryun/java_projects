package co.yedam.board.service;
//규칙을 만들기위해서 인터페이스 사용

import java.util.List;

import co.yedam.board.vo.Board;

//파일에 저장, DB저장
public interface BoardService {
	//등록(추가)
	public boolean add(Board board);
	
	//목록
	public List<Board> list(int page);
	public int getTotal(); //토탈건수의 페이지
	
	//수정 : 글내용 수정
	public boolean modify(Board board);
	
	//삭제
	public boolean remove(int brdNo);
	
	//상세조회
	public Board search(int brdNo); //글번호에 대한 전체정보
	
	//종료할때 구현
	public void save(); //세이브메소드
	
	//글번호 - 작성자 반환
	public String getResponseUser(int brdNo);
	
}

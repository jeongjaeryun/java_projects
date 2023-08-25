package co.yedam.board.service;

import java.util.List;

import co.yedam.board.vo.Reply;

public interface ReplyService {
	//등록
	public boolean add(Reply reply);
	
	//목록
	public List<Reply> list();
	public int getTotal(); //토탈건수의 페이지
	//삭제
	public boolean remove(int rpNo);
	//저장
	public void save();
}

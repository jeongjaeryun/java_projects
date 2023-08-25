package co.yedam.board.service;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.yedam.board.vo.Board;

public class BoardServiceImpl implements BoardService { // 데이터불러오고 저장할거임

	List<Board> boardList = new ArrayList<>(); // 추가하면 boardList에 저장할거임

	public BoardServiceImpl() { // 생성자가 호출될때 init 생성자도 같이 실행
		init();
	}

	private void init() {
		try {
			FileInputStream fis = new FileInputStream("C:/Temp/board.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);

			// 값을 읽어들임 반환되는 타입이 객체 타입. boardList에 담을거임
			boardList = (List<Board>) ois.readObject(); // 객체로 변형시키겠다

			ois.close();
			fis.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private int getMaxNo() {
		int brdNo = 0;
		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).getBrdNo() > brdNo) {
				brdNo = boardList.get(i).getBrdNo();
			}
		}
		return brdNo + 1;
	}

	private Date getDate() {
		Date today = new Date();
		return today;
	}

	@Override
	public boolean add(Board board) { // 현재시점추가
		board.setBrdNo(getMaxNo());
		board.setWriteDate(getDate());
		return boardList.add(board); // boardApp에서 사용자가 입력한 값 매개값으로 받아 boardList에 저장
	}

	// 페이지찍기
	@Override
	public List<Board> list(int page) {
		int start = (page - 1) * 5; // 인덱스는 0부터니까
		int end = page * 5;
		List<Board> pageList = new ArrayList<>(); // 5개씩 잘라 보여주려고 새로 선언
		for (int i = 0; i < boardList.size(); i++) {
			if (i >= start && i < end) {
				pageList.add(boardList.get(i));
			}
		}
		return pageList;
	}

	@Override
	public boolean modify(Board board) { // 수정시점
		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).getBrdNo() == board.getBrdNo()) {
				board.setUpdateDate(getDate());
				boardList.get(i).setBrdContent(board.getBrdContent()); // 매개값으로 넘어온 board.brdcontent로 바꿈
				return true; // 한건씩 정상적으로 바뀌어지면 true 반환(boolean타입이라)
			}
		}
		return false; // 수정이 안되었단 의미로 false반환
	}

	@Override
	public boolean remove(int brdNo) {
		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).getBrdNo() == brdNo) {
				boardList.remove(i); // 글번호가 있음 삭제
				return true; // 한건씩 정상적으로 바뀌어지면 true 반환(boolean타입이라)
			}
		}
		return false; // 삭제할게 없음 false반환
	}

	@Override
	public Board search(int brdNo) {
		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).getBrdNo() == brdNo) {
				return boardList.get(i); // 값이 같은게 있음 반환 , Board타입
				// 한건씩 정상적으로 바뀌어지면 true 반환(boolean타입이라)
			}
		}
		return null;
	}

	@Override
	public void save() { // 파일저장기능구현
		try {
			FileOutputStream fos = new FileOutputStream("C:/Temp/board.dat"); // 출력스트림
			ObjectOutputStream oos = new ObjectOutputStream(fos);// 보조스트림
			oos.writeObject(boardList); // 직렬화 거쳐서 객체를 바이트타입으로 변경함
			oos.flush();
			oos.close();
			fos.flush();
			fos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getTotal() { // 토탈건수
		return boardList.size();
	}

	@Override
	public String getResponseUser(int brdNo) {
		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).getBrdNo() == brdNo) {
				return boardList.get(i).getBrdWriter(); // 넘버값이 같은게 있음 작성자 항목 반환
			}
		}
		return null;
	}
}

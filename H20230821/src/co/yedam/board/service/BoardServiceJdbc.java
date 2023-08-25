package co.yedam.board.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.board.common.Dao;
import co.yedam.board.vo.Board;

public class BoardServiceJdbc implements BoardService {

	// Connection 객체. db연결위한 객체
	// PreparedStatement 객체. Statement- sql 구문활용해서 처리하겠다 쿼리 실행객체
	// ResultSet 객체. 조회할 정보들을 잠시 담아놓는 객체
	// String 쿼리.

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String query;

	void disconn() {
		try {
			if (rs != null) {// rs을 사용했다면
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 실행했는데 반응이 없으면 오라클 commit; 해줘야함 그래야 연동됨!!
	@Override
	public boolean add(Board board) {
		query = "insert into board (brd_no, brd_title, brd_content, brd_writter)"
				+ "values((select nvl(max(brd_no),0)+1 from board),?,?,?)"; // ?-> 파라메터 변수 4개의 값을받아오겠다 nvl 0 널일경우 0으로바꿈
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query); // 값을채워줌
			psmt.setString(1, board.getBrdTitle()); // 첫번째 파라메터? 값채워줌
			psmt.setString(2, board.getBrdContent()); // 두번째 ? 값채워주기
			psmt.setString(3, board.getBrdWriter()); // 세번째 ? 값채우주기
			int r = psmt.executeUpdate();// insert, update, delete 할때 사용하는 쿼리실행 메서드
			if (r == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}

	@Override
	public List<Board> list(int page) {
		List<Board> list = new ArrayList<Board>();

		conn = Dao.conn();
		query = "select *  "//
				+ "from (select rownum rn, a.* "//
				+ "      from (select * from board "//
				+ "            order by brd_no) a "//
				+ "      where rownum <= (? * 5 )) b "//
				+ "where b.rn > (?-1) * 5"; // sql 전체데이터를 가져오겠다
		try {
			psmt = conn.prepareStatement(query);
			psmt.setInt(1, page); // executeQuery하기전에 값 담아줘야함 ? 첫번째에 이값담겠다
			psmt.setInt(2, page);

			rs = psmt.executeQuery(); // 쿼리를 실행하겠습니다 잠시 board의 8건을 rs에 담아둠
			while (rs.next()) {
				// rs -> list로 변환해줘야함
				Board board = new Board();
				board.setBrdNo(rs.getInt("brd_no"));
				board.setBrdTitle(rs.getString("brd_title"));
				board.setBrdWriter(rs.getString("brd_writter"));

				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}

	@Override
	public int getTotal() { // 건수에 맞는 페이징처리
		int totalPage = 0;
		query = "select count(*) as cnt from board";
		conn = Dao.conn();

		try {
			psmt = conn.prepareStatement(query);
			rs = psmt.executeQuery(); // select
			if (rs.next()) {
				totalPage = rs.getInt("cnt");
				return totalPage;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return totalPage;
	}

	@Override
	public boolean modify(Board board) {
//		query = "update board set brd_content='" + board.getBrdContent() + "' where brd_no = " + board.getBrdNo();
//		System.out.println(query);
		query = "update board set brd_content= ? where brd_no = ?"; // ?-> 파라메터 변수가된다는의미
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query); // 값을채워줌
			psmt.setString(1, board.getBrdContent()); // 첫번째 파라메타 물음표엔 보드콘텐츠넣어준다
			psmt.setInt(2, board.getBrdNo()); // 두번째 파라메타 물음표엔 보드넘버
			int r = psmt.executeUpdate();// insert, update, delete 할때 사용하는 메서드
			if (r == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}

	@Override
	public boolean remove(int brdNo) { // brd_no가 키임 입력되는 넘버가 삭제됨
		query = "delete from board where brd_no = " + brdNo;
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query); // query를 실행하겠다
			int r = psmt.executeUpdate(); // insert, update, delete 할때 사용하는 메서드
			if (r == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}

	@Override
	public Board search(int brdNo) {
		query = "select * from board where brd_no = " + brdNo; // 한건 조회
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			rs = psmt.executeQuery(); // select
			if (rs.next()) {
				Board board = new Board();
				board.setBrdNo(rs.getInt("brd_no"));
				board.setBrdTitle(rs.getString("brd_title"));
				board.setBrdWriter(rs.getString("brd_writter"));
				board.setBrdContent(rs.getString("brd_content"));
				board.setWriteDate(rs.getDate("write_date"));

				return board;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}

		return null;
	}

	@Override
	public void save() {

	}

	@Override
	public String getResponseUser(int brdNo) {
		query = "select brd_writter from board where brd_no = ?";
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			psmt.setInt(1, brdNo);
			rs = psmt.executeQuery(); // select
			if (rs.next()) {
				return rs.getString("brd_writter");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return null;
	}

}

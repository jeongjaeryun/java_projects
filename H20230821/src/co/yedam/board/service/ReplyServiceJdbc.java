package co.yedam.board.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import co.yedam.board.common.Dao;
import co.yedam.board.vo.Reply;

public class ReplyServiceJdbc implements ReplyService {

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String query;

	void disconn() {
		try {
			if (rs != null) {
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

	@Override
	public boolean add(Reply reply) {
		query= "insert into reply(rp_no, brd_no,rp_content,rp_writer)"
				+"values((select nvl(max(rep_no),0)+1 from reply),?,?,?";
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Reply> list() {
		return null;
	}

	@Override
	public int getTotal() {
		return 0;
	}

	@Override
	public boolean remove(int rpNo) {
		return false;
	}

	@Override
	public void save() {
		
	}

}

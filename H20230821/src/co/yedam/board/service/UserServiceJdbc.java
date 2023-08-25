package co.yedam.board.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.yedam.board.common.Dao;
import co.yedam.board.vo.User;

public class UserServiceJdbc implements UserService {
	Connection conn; //데이터베이스연결 객체
	PreparedStatement psmt; //쿼리처리 결과받아오는객체
	ResultSet rs; //처리된결과 받아놓기위한 객체 조회할경우 필요
	String query; // 담아놓을 문자열필요
	
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

	@Override
	public User checkLogin(User user) {
		query = " select * from users " + " where user_id = ? " + " and user_pw = ?";
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			psmt.setString(1, user.getUserId());
			psmt.setString(2, user.getUserPw());
			rs = psmt.executeQuery(); // 실행한 쿼리문의 결과를 rs에 담겠다

			if (rs.next()) { // rs에 담긴게 있으면 next()메서드가 true 반환
				User nuser = new User();
				nuser.setUserId(rs.getString("user_id"));
				nuser.setUserName(rs.getString("user_nm"));
				nuser.setUserPw(rs.getString("user_pw"));
				return nuser;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return null; //한건 조회해서 없으면 null반환
	}

}

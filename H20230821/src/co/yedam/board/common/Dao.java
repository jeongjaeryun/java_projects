package co.yedam.board.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dao {
	static Connection conn;

	public static Connection conn() {//패키지가 달라져서 public붙임 다른 패키지에서도 쓸수있게 

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "proj", "proj");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;

	}
}

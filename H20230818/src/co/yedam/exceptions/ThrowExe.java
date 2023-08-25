package co.yedam.exceptions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ThrowExe {

	public static void main(String[] args) {
		try {
			dbSearch();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static void dbSearch() throws Exception { //Exception 적어주면 모든 예외에 대해 처리하겠다 아님 세세하게 예외 적어줘야함
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from employees");
		while(rs.next()) {//데이터를 하나 가져오겠다
			System.out.println("사원번호 : " + rs.getInt("employee_id") //
			+ " 이름 : "+rs.getString("first_name"));
		}
	}
}

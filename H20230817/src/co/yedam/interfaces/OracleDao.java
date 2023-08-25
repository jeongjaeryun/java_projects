package co.yedam.interfaces;
 
public class OracleDao implements Dao { //Dao라는 인터페이스를 구현하는 클래스로 만듦
	public void add() {
		
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		System.out.println("Oracle 입력기능");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("Oracle 수정기능");

	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("Oracle 삭제기능");

	}

	@Override
	public void select() {
		// TODO Auto-generated method stub
		System.out.println("Oracle 조회기능");

	}
}

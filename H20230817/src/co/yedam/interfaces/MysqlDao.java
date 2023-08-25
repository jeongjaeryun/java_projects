package co.yedam.interfaces;

public class MysqlDao implements Dao { //Dao라는 인터페이스를 받음

	
	//인터페이스 선언 인터페이스가 가진 기능 구현하기위해 반드시 선언
	@Override
	public void insert() {
		System.out.println("Mysql 입력기능");
	}     

	@Override
	public void update() {
		System.out.println("Mysql 수정기능");
	}

	@Override
	public void delete() {
		System.out.println("Mysql 삭제기능");
	}

	@Override
	public void select() {
		System.out.println("Mysql 조회기능");
	}

}

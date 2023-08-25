package co.yedam.interfaces;

public interface Dao {
	// 규칙선언
	static final double pi = 3.14; // 상수, 상수는 값 못바꿈 한가지 값만 가짐
	
	/*abstract*/ void insert(); //여기선 abstract 안써도 추상클래스임
	void update();
	void delete();
	void select();
}

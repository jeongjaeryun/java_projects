package co.yedam.generic;

//T: type parameter
//<T>:제네릭 타입이 실행되는 시점에 타입을 정하겠다.

public class Box<T> {
//	Object obj; // Object타입 Object가 젤 상위클래스 어떤 클래스든 담을 수 있다
	T obj; //BoX가 실행되는 시점에 타입을 정하겠다는게 generic . 여기선 T
	
	T get() {
		return obj;
	}
	
	void set(T obj) {
		this.obj = obj; // 필드값 채워주기 위한 set메서드
	}
}

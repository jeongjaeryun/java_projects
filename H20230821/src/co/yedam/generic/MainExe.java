package co.yedam.generic;

public class MainExe {
	public static void main(String[] args) {
		Box<String> box = new Box<String>(); //Box가 사용되는 시점에 타입 정해줌 <String>
		box.set("Hello");
		String result = box.get(); //캐스팅(형변환)해줘야함 generic 
		
		Box<Integer>ibox = new Box<Integer>();
		ibox.set(10); // 10 (int)타입이 아니고 Integer로 랩퍼?맵퍼?가 바꿔줌
		Integer iresult = ibox.get();
	}

}

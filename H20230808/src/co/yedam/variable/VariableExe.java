package co.yedam.variable;

public class VariableExe {
    public static void main(String[] args) {
		// 변수 선언
    	// 정수형 변수의 유형: byte(1바이트), short(2바이트), int(4바이트), long(8바이트)
    	//byte: -128 ~ 127
    	//short: -32768 ~ 32767
    	//int : -2147483648 ~ 2147483647
    	
    	int num1 =3; // 초기화
    	int num2 =2147483647;
    	
//    	num1 = 10; 
//    	num2 = 20; 
    	int result = num1 + num2;  //넘1 정수 넘2 정수, 계산 값도 정수 타입이 일치해야함
    	System.out.println("result: "+ result);
    	
    	byte b1 = 10;
    	byte b2 = 20;
    	int b3 = b1 + b2; //Type mismatch: cannot convert from int to byte int를 byte로 선언할수없다 byte여도 더하기 연산은 int가 됨
    	
    	
    	int i1 = 100;
    	byte b4 = 10;
    	b3 = i1 + b4; //내부적으로 작은데이터값을 큰데이터값으로 바꿔줌 byte를 int로 자동형변환해서 연산.b3 = i1 + (int)b4
    	
    	// 실수타입
    	// float, double
    	double dbl1 = 10.23223;
    	double dbl2 = 20;
    	double dbl3 = dbl1 + dbl2;
    	
    	float f1 = 10.1f;  //float타입의 실수값이라는 뜻으로 뒤에 f붙여줘야함 아님 double로 처리됨
    	float f2 = 10.001f;
    	float f3 = f1 + f2;
    	System.out.println("f3: "+f3); // 정확한 값이 아닌 근사치의 값으로 나옴
    	
	}
}

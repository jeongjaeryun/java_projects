package co.yedam.api;

public class SystemExe {
	public static void main(String[] args) {
		long start = System.currentTimeMillis(); //작업이 시작되기전 시간
		start = System.nanoTime(); //더 세분화된 시간 나노타임
		for(int i=0; i<1000000;i++) {
			System.out.println(i);
		}
		long end = System.nanoTime(); 
//		System.currentTimeMillis(); //작업이 끝난 시간
		
		System.out.println((end-start)+" ns"); //작업하는 동안 걸린 시간
	}

}

package co.yedam.thread;

import java.awt.Toolkit;

public class BeePrintExe {
	public static void main(String[] args) {
		// 쓰레드생성
		// 1. Runnable 인터페이스를 구현하는 객체를 Thread(생성자 매개값).
		// 2. Thread를 상속하는 클래스를 작성.
		Thread beep;
		beep = new Thread(new BeepTask());
		beep = new WorkThread();
		// 1-1.Runnable 인터페이스를 구현하는 익명객체 생성
		// Functional Interface.(구현할 메소드 한개만 존재
		beep = new Thread(() -> {// 람다표현식 // 인터페이스구현코드시작
			Toolkit tookit = Toolkit.getDefaultToolkit();
			for (int i = 0; i < 5; i++) {
				tookit.beep(); //비프음 발생
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		});// run이라는 추상메소드를 구현하는 기능 //인터페이스구현코드끝
		beep.start();

		for (int i = 0; i < 5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500); //0.5초간 일시정지
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}

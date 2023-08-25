package co.yedam.thread;

import java.awt.Toolkit;

public class WorkThread extends Thread {
	@Override
	public void run() {
		Toolkit tookit = Toolkit.getDefaultToolkit();

		for (int i = 0; i < 5; i++) {
			tookit.beep();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		super.run();
	}
}

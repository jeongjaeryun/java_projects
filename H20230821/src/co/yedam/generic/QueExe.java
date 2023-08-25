package co.yedam.generic;

import java.util.LinkedList;
import java.util.Queue;
//Queue 구조 : First In First Out 먼저들어간걸 먼저 꺼낸다
public class QueExe {
	public static void main(String[] args) {
		Queue<String> que = new LinkedList<>();
		que.offer("One"); // offer()값추가
		que.offer("Two");
		que.offer("Three");
		
		while(!que.isEmpty()) {
			String val = que.poll(); // poll() 큐에서 값꺼내기
			System.out.println(val);
		}
	}

}

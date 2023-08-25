package co.yedam.generic;

import java.util.Stack;

// Stack : LastInFirstOut 마지막 들어간게 첫번째로 나오는 구조
public class StackExe {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		stack.push("One"); // 값추가
		stack.push("Two");
		stack.push("Three");

		while (!stack.isEmpty()) { 
			String val = stack.pop(); // 마지막거부터 값 빼내기
			System.out.println(val);
		}

	}
}
package co.yedam.array;

import java.util.Scanner;

public class TodoApp {
	public static void main(String[] args) {
		// 등록/완료/조회(날짜)/미완료
		// 등록: 1번 할일 0812 미완료(false)
		// 완료: 1 2 4 를 치면 1,2,4번의 상태를 바꿔주면 됨 boolean을 트루로 바꿔줌
		// 조회(날짜): 0812
		// 미완료 목록 출력 미완료 출력 기준은 순번을 기준으로.
//		sortSample();

		Scanner scn = new Scanner(System.in);
		Todo[] todos = new Todo[50]; // 투두 객체를 담을수 있는 배열 생성
		boolean run = true;
		int idx = 0;
		String num = "";
//						String[]data = null;

		while (run) {
			System.out.println("------------------------------------------------------");
			System.out.println("1.등록 | 2.완료 | 3.조회(날짜) | 4.미완료 | 5.종료");
			System.out.println("------------------------------------------------------");
			System.out.print("선택> ");

			int menu = Integer.parseInt(scn.nextLine());
			if (menu == 1) {
				System.out.println("등록 >> ");

				String[] data = scn.nextLine().split(" ");
				Todo todo = new Todo();

				todo.no = Integer.parseInt(data[0]);
				todo.todo = data[1];
				todo.dueDate = data[2];
				todo.done = false;

				todos[idx] = todo;
				idx++; // 계속 0번 방에 저장할순 없으니 idx를 증가시켜줌

			} else if (menu == 2) {// 완료: 1 2 4 를 치면 1,2,4번의 상태를 바꿔주면 됨 boolean을 트루로 바꿔줌
				System.out.print("번호를 입력하세요 >> ");
				String[] data = scn.nextLine().split(" ");
				for (int j = 0; j < data.length; j++) {
					for (int i = 0; i < todos.length; i++) {
						if (todos[i] != null && todos[i].no == Integer.parseInt(data[j])) {
							todos[i].done = true;
						}
					}
				}

			} else if (menu == 3) {// 조회(날짜): 0812
						 System.out.print("조회 >> ");
						 num = scn.nextLine();
//						 boolean ok = false;
//						 for(int i=0; i<todos.length;i++) {
//							 if(todos[i] != null && todos[i].dueDate.equals(num)) {
//								 System.out.printf("%d, %s, %s \n",todos[i].no,todos[i].todo,todos[i].dueDate);
//								 ok=true;
//							 }
//						 }
//						 if(ok = false) {
//							 System.out.println("등록된 번호가 아닙니다");
//						 }
				int ntnull = 0;
				for(int i = 0; i <todos.length; i++) { // 다 돌아서 낫널인 값을 저장해야 하니 여기는 -1 안함
					if(todos[i]!= null) {
						ntnull++;
					}
				}
				for (int j = 0; j < ntnull-1; j++) {
					for (int i = 0; i < ntnull-1; i++) {
						Todo tmp = new Todo();
						if (todos[i].no < todos[i + 1].no) {
							tmp = todos[i];
							todos[i] = todos[i + 1];
							todos[i + 1] = tmp;
						}
					}
					// 출력
					for (Todo td : todos) {
						if(td!=null && td.done == false) {
						System.out.println("해당날짜의 미완료 목록"+ td);
						}
					}
					
				}//for문끝

			} else if (menu == 4) {// 미완료목록 출력
				for (int i = 0; i < todos.length; i++) {
					if (todos[i] != null && todos[i].done == false) {
						System.out.printf("%d %s %s %s", todos[i].no, todos[i].todo, todos[i].dueDate,
								todos[i].done == false ? "미완료" : "완료");
						System.out.println();
					}
				}
			} else if (menu == 5) {
				System.out.println("프로그램 종료");
				run = false;
			}

		} // while끝

	}// main의 끝

	public static void sortSample() { // 정렬하는 방식
		int[] intAry = { 45, 23, 90, 77, 12 };
		int len = intAry.length - 1;
		for (int j = 0; j <= len; j++) {
			for (int i = 0; i < len; i++) {
				if (intAry[i] > intAry[i + 1]) {
					int tmp = intAry[i];
					intAry[i] = intAry[i + 1];
					intAry[i + 1] = tmp;
				}
			}
		}
		for (int num : intAry)
			System.out.println(num);
	}
}

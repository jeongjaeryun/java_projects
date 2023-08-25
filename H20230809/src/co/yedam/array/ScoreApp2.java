package co.yedam.array;

import java.util.Scanner;

class Member {
	String name;
	int score;
}

public class ScoreApp2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String[]data = s.nextLine().split(" ");
		System.out.println(data[0]);
		System.out.println(data[1]);
		System.out.println("-----------------");
		for (String elem : data) {
			System.out.println(elem);
		}
	}

}

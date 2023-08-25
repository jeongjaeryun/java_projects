package co.yedam;

import java.util.Scanner;

public class Ex01 {
 public static void main(String[] args) {
	

	Scanner scn = new Scanner(System.in);
	System.out.println("num1을 입력하세요 >> ");
	int num1 = Integer.parseInt(scn.nextLine());
	System.out.println("num2를 입력하세요 >> ");
	int num2 = Integer.parseInt(scn.nextLine());
	
	if(num1> num2) {
		System.out.println( "둘중 큰수는>>"+ num1);
	}else if(num2>num1) {
		System.out.println("둘중 큰수는>>" + num2);
	}
	
}
}

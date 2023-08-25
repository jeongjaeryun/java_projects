package co.yedam;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		
	
	Scanner scn = new Scanner(System.in);
	
	System.out.println("num1을 입력하세요 >> ");
	int num1 = Integer.parseInt(scn.nextLine());
	System.out.println("num2를 입력하세요 >> ");
	int num2 = Integer.parseInt(scn.nextLine());
	int sum2=0;
	int sum3=0;
	for(int i=num1; i<=num2; i++ ) {
	 if(i%2==0) {
		 sum2 += i;
	 }else if(i%3==0) {
		 sum3 += i;
	 } 
	}
	System.out.println(sum2+sum3);
	
	}	
}

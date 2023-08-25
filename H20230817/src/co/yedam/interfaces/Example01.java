package co.yedam.interfaces;

public class Example01 {
	public static void main(String[] args) {
		int[][] intAry = new int[5][5]; //intAry[0]에 정수값 들어있습니다
		
//		System.out.println(intAry[4][4]);//index 값 최대 4니까
		
		int no = 1;
		for(int r=0; r<5; r++) {
			for(int c=0; c<5; c++) {
				intAry[r][c]=no;
				no++;
				System.out.printf("%3d", intAry[r][c]);
			}
			System.out.println();
		}
		System.out.println("--------------------------");

		no = 1;
		for(int r=0; r<5; r++) {
			for(int c=0; c<5; c++) {
				intAry[r][c]=no;
				no++;
				System.out.printf("%3d", intAry[c][r]);
			}
			System.out.println();
		}
		
		System.out.println("--------------------------");

		no = 1;
		for(int r=0; r<5; r++) {
			for(int c=4; c>=0; c--) {
				intAry[r][c]=no;
				no++;
				System.out.printf("%3d", intAry[c][r]);
			}
			System.out.println();
		}
		
 }
}

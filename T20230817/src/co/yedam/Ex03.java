package co.yedam;

public class Ex03 {

	public static void main(String[] args) {
		int[]Ary = new int[5];
		
		for(int i=0; i<Ary.length; i++) {
			Ary[i] = (int)(Math.random()*10)+1;
		}
		int max = Ary[0];
		int min = Ary[0];
		for(int i = 0; i<=Ary.length-1; i++) {
			
			if(max < Ary[i]) {
				max =Ary[i];
			}
			
			if(min > Ary[i]) {
				min = Ary[i];
			}
		}
		System.out.println("최대값은>> "+max+" 최소값은>> "+min);
		
	}

}

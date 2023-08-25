package co.yedam.array;


public class ArraryExe3 {

	public static void main(String[] args) {
		
		
		Student[]students = new Student[3];
		
		Student s1 = new Student();
		s1.name = "홍길동";
		s1.score = 85;
		
		Student s2 = new Student();
		s1.name = "김길동";
		s1.score = 80;
		
		Student s3 = new Student();
		s1.name = "최길동";
		s1.score = 90;
		
		students[0]=s1;
		students[1]=s2;
		students[2]=s3;
		String name = "";
		int max = 0;
//		students[0].name + students[0].score;
		for(int i = 0; i<students.length; i++) {
			if(max < students[i].score) {
				max = students[i].score;
				name=students[i].name;
			}
		}System.out.printf("최고점은 %d, 이름은 %s",max,name);
		System.out.println();
		
		
		
		
		
		
		String[]names = {"홍길동","김길동","박길동","최길동"}; //학생이름
		int[]scores = {85, 88, 92, 75}; // 학생점수
		
		// 점수가 max값에 해당하는 학생의 이름 String name에 담기
		//index 값 같은 학생
		
		name = "";
		max=0;	
		for(int i = 0; i<scores.length-1; i++) {
			if(max < scores[i]) {
				max = scores[i];
				name=names[i];
			}
		}
		System.out.printf("최고점은 %d, 이름은 %s",max,name);
		
		
	}//main의 끝

}


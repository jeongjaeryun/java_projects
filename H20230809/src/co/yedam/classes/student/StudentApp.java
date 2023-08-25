package co.yedam.classes.student;

public class StudentApp {
	public static void main(String[] args) {
		Student[] students = new Student[10]; //길이가 10인 students 배열 생성
		
		Student s1 = new Student();
		s1.setStdNo(100);
		s1.setStdName("홍길동");
		s1.setScore(70);
		students[0] = s1; //배열에 s1값 담기
		
		students[1] = new Student(101,"김길동",80); //이렇게 한번에 넣을수도 있음
		students[2] = new Student(102,"최길동",85);
		students[3] = new Student(103,"박길동",90);
		
		String searchName = "김길동";
		
		for(int i=0; i<students.length; i++) {
			if(students[i]!=null&&students[i].getStdName().equals(searchName)) {
				System.out.println("학번 "+students[i].getStdNo() +" 점수 "+ students[i].getScore());
			}
		}
		
	}

}

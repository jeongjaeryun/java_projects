package co.yedam.classes.student;

public class StudentExe {
	public static void main(String[] args) {
		//s1은 주소값
		
		Student s1 = new Student(); //Student.java에 있는 생성자 Student()임
//		s1.stdNo = 100; private 설정해둬서 이렇게 못씀
//		s1.stdName = "Hong";
//		s1.score = 80;
//		s1.stdInfo();
		s1.setStdNo(100);
		s1.setStdName("Hong");
		s1.setScore(-80);
		s1.stdInfo();
		
		System.out.println(s1.getStdName());
		
		Student s2 = new Student(101, "Hwang", 90); //ctrl 누르고 Student 누르면 생성자 쪽으로 감
		s2.stdInfo();
		
	}
}

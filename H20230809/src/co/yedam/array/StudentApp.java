package co.yedam.array;


import java.util.Scanner;

public class StudentApp {
public static void main(String[] args) {
	

	
		Student[] students = new Student[10];		
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		int idx = 0;
	    int score = 0;
		String name ="";
		
		Student s1 = new Student();
		s1.name = "홍길동";
		s1.score = 85;
		s1.height = 178.9;
		s1.gender = Gender.MEN;
		Student s2 = new Student();
		s2.name = "김길동";
		s2.score = 80;
		s2.height = 169.9;
		Student s3 = new Student();
		s1.name = "최길동";
		s1.score = 90;
		s1.gender = Gender.WOMEN;
//		
		students[0]=s1;
		students[1]=s2;
		students[2]=s3;
		

		
		//1.등록 2.조회 3.목록
		while(run) {
			System.out.println("1.등록 2.조회 3.목록 4.최장신 5.종료");
			System.out.println("선택>> ");
			
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
			case 1: // 이름, 점수, 키 : 입력 idx이용해서 0번째 위치에 
//				Student s1 = new Student(); //값을 집어넣기 위해 빈공간을 많듦
				System.out.println("이름을 입력하세요");
				s1.name = scn.nextLine();
				System.out.println("점수를 입력하세요");
				s1.score = Integer.parseInt(scn.nextLine());// 문자열을 숫자로 바꿔줌"123"->123 "178.9"->double타입으로 바꿔주기 => 178.9
//				Double.parseDouble(null => "178.9" 를 178.9로 바꿔줌);
				System.out.println("키를 입력하세요");
				s1.height = Double.parseDouble(scn.nextLine());
				students[idx]=s1;
				idx++;
				break;
			case 2: // 이름, 점수 : 이름을 입력하면 점수를 출력 idx+1 등록된 학생이 없으면 없는 학생입니다
				System.out.println("이름");
				name = scn.nextLine();
				String notnm = "";
				for(int i=0; i<students.length; i++) {
					if(students[i]!=null //두조건이 참이어야 블럭을 실행
							&& students[i].name.equals(name)) {
						System.out.printf("%s의 점수: %d\n",students[i].name, students[i].score);									
					} else if(students[i] == null || !students[i].name.equals(name)) {
						notnm = null;
						}
					}
				if(notnm==null) {
					System.out.println("등록된 학생이 아닙니다.");
				}
				break;
			case 3: // 이름, 점수 출력
				for(int i=0; i<students.length; i++) {
					if(students[i]!=null && students[i].gender == Gender.MEN) {
						System.out.printf("이름: %s, 점수: %d\n",students[i].name, students[i].score);						
					}
				}
				break;
			case 4: //가장 큰 키를 찾아서 이름 출력
				System.out.println("키");
				double max = 0;
				String names = "";
				for(int i = 0; i<students.length; i++) {
					if(students[i]!=null && max < students[i].height) {
						max = students[i].height;
						names = students[i].name;
					}
				}System.out.printf("최장신은 %s입니다.\n",names);
				break;
			case 5:// 종료 boolean을 false로 바꿔주면 끝남
				System.out.println("종료합니다");
				run=false;
			}//switch문 끝
			
			
		}//while문 끝
		System.out.println("end");
		
		
		
	}//main의 끝

}


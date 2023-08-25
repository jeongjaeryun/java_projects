package co.yedam.classes.student;

public class Student {
    //필드
	//정리하고싶은 속성들
	private int stdNo; //학생번호  int는 초기값 0으로 만들어짐 
	private String stdName; //학생이름 String은 초기값 null로 만들어짐
	private int score; //점수
	//private 외부에서 값 수정 못하게 함 메소드를 사용해서 값을 넣을수 있음
	
	//생성자 : 필드의 값 초기화하는 용도로 쓰임
	//생성자는 클래스이름과 똑같은 메소드 생성
	Student(){
		//기본생성자
	}
	
	Student(int stdNo){  //매개값이 있는 생성자 
		this.stdNo = stdNo; //매개변수와 필드에 있는 값을 구분하기 위해 this. 붙여줌(매개변수랑 필드값 같을때)
	}
	
	Student(int stdNo, String stdName, int score){ //()안을 매개변수라함
		this.stdNo = stdNo; //이 가지고 있는 필드중에 stdNo를 불러오려면 this
		this.stdName = stdName;
		this.score = score;
	}
	
	//메소드 관례상 get, set붙여서 이름 지음
	void stdInfo() {
		System.out.println("학번:"+stdNo+", 학생이름: "+stdName+", 점수: "+score);
	}
	
	void setStdNo(int stdNo) {
		this.stdNo = stdNo;
	}
	void setStdName(String stdName) { // setStdName는 매개변수에 값을 채워주는 역할
		this.stdName = stdName;
	}
	
	void setScore(int score) {
		if(score < 0) {
			this.score=0;
		}else {
			this.score = score;
		}
	}
	//getter  - 마우스 오른쪽-> 소스 -> 제너레이트 게터 앤 세터즈 ->올게터 -> 완료

	public int getStdNo() {
		return stdNo;
	}

	public String getStdName() {
		return stdName;
	}

	public int getScore() {
		return score;
	}
	
	
}

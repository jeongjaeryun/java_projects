package co.yedam.array;

public class Friend {
	String name;
	String phone;
	Gender gender;
	
	// 메소드
	void showInfo(){      //값을 반환하고 싶은 타입을 앞에 적어줌 여기선 String 값을 반환안하고 싶으면 void
		System.out.printf("이름은 %s, 번호는 %s, 성별은 %s\n",
				name, phone, gender == Gender.MEN ? "남" : "여");
	}
	
	void briefInfo() {
		System.out.printf("이름: %s, 번호: %s \n",
				name, phone);	
	}
	
}

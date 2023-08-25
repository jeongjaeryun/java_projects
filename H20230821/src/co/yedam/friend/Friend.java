package co.yedam.friend;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Friend {
	private String name; //필드생성
	private String phone;
	private Date birth;
	
	public Friend(String name, String phone, Date birth) { //생성자
		super();
		this.name = name;
		this.phone = phone;
		this.birth = birth; // 1998-08-05 이렇게 넣으려면 심플데이트포맷의 parse라는 메소드를 써야함 sdf.parse("1998-08-05"); 
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//한국식으로 출력하기위해 여기에 설정해줌
		return "이름: " + name + " 연락처: " + phone + " 생일: " + sdf.format(birth);
	}
	
	
	
}

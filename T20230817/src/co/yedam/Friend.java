package co.yedam;

public class Friend {
  String name;
  String phone;
  String birth;
  double tall;
  
	  public Friend() {
		  
	  }

	  public Friend(String name, String phone, String birth, double tall) {
		  this.name=name;
		  this.phone=phone;
		  this.birth=birth;
		  this.tall=tall;
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
	
	public String getBirth() {
		return birth;
	}
	
	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	public double getTall() {
		return tall;
	}
	
	public void setTall(double tall) {
		this.tall = tall;
	}

	@Override
	public String toString() {
		return "이름: " + name + " 전화번호: " + phone + " 생년월일: " + birth + " 키: " + tall;
	}
  
}

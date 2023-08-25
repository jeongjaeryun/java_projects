package co.yedam.friend;

public class UnivFriend extends Friend {
	//Friend가 부모클래스
	private String univ;  //학교이름
	private String major; //전공
	
	public UnivFriend(String name, String phone, String univ, String major) {
		super(name, phone);//부모클래스 기본생성자, super가 부모클래스 뜻함
		this.univ = univ;
		this.major = major;
	}

	public String getUniv() {
		return univ;
	}

	public void setUniv(String univ) {
		this.univ = univ;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	@Override
	public String showInfo() { //부모클래스가 가진 쇼인포 반환
		return super.showInfo()+", 학교 이름은 " + univ + ", 전공은 "+ major;
	}
}

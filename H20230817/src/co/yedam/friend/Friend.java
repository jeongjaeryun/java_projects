package co.yedam.friend;

public class Friend {
//친구연락처 정보
//학교친구 -- 이름, 연락처, 학교이름, 전공정보
//회사친구 -- 이름, 연락처, 회사이름, 부서
//그 외 친구 -- 이름, 연락처
	
//Friend - 이름, 연락처
//UniveFriend - 학교, 전공
//CompFriend - 회사, 부서
//FriendApp - 배열 선언 정보담기 추가 조회 수정 삭제 CRUD
//MAINExe - main 클래스 실행
	
	private String name;
	private String phone;
	
	public Friend(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
	
	//getter setter로 정의 
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
	
	public String showInfo() { //정보출력할 메소드 생성
		return "이름은 " + name + " 연락처는 "+ phone;
	}
	
	
}//Friend 클래스의 끝

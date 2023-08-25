package co.yedam.api;
class Member{
	private int memberId;
	private String memberName;
	
	public Member(int memberId, String memberName) { //생성자
		super();
		this.memberId = memberId;
		this.memberName = memberName;
	}
	
	@Override
	public String toString() {
//				return super.toString();
				return "Member [memberId=" + memberId + ", memberName=" + memberName + "]";
	}

	@Override
	public int hashCode() {
		return memberId;
	}
	
	@Override
	public boolean equals(Object obj) { //실제 주소값은 다르지만 논리적으로 두객체가 동등하다면 true, 아님 false
//		return super.equals(obj);
		Member target = (Member)obj;
		if(this.memberId == target.memberId && this.memberName.equals(target.memberName)) {
			return true; // 논리적 동일
		}else {
			return false;
		}
	
}
}
public class EqualsExe {

	public static void main(String[] args) {
		String str1 = new String("Hong"); // str1에는 주소값이 들어있음
		String str2 = new String("Hong");
		
		Member mem1 = new Member(101,"Hong");
		Member mem2 = new Member(101,"Hwang");
		
		System.out.println(str1 == str2); // 주소값을 비교
		System.out.println(str1.equals(str2)); // 문자값을 비교
		System.out.println(mem1.equals(mem2)); // 문자값을 비교

	}

}

package co.yedam.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class User {
	private String id; //필드
	private String pw;
	
	public User(String id, String pw) { //생성자
		super();
		this.id = id;
		this.pw = pw;
	}
	//논리동등객체
	@Override
	public int hashCode() {
		return this.id.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		User target = (User)obj;
		
		return this.id.equals(target.id) && this.pw.equals(target.pw); //id와 pw가 같으면 논리적 객체로 보겠습니다
	}
	
	
}

public class MapExe {
	public static void main(String[] args) {
		//Map: 키 & 값을 쌍으로 저장
		Map<String, Integer> map = new HashMap<>();
		map.put("홍길동", 80);  // Map은 값추가 put
		map.put("김길동", 85);
		map.put("이길동", 90);
		
		Integer val = map.get("홍길동"); //value 가져올때 쓰는 get 홍길동에 대한 integer 값 80을 출력해줌
		System.out.println(val);
		
		List<User> users = new ArrayList<>();
		users.add(new User("user1","1234"));
		
		Map<String, String> userMap = new HashMap<>();
		userMap.put("user2", "1111");
		userMap.put("user3", "2222");
		userMap.put("user4", "3333");
		
		if(userMap.containsKey("user2")) { //containsKey: 해당하는 값이 있는지 체크하는 메소드
			System.out.println(userMap.get("user2")); //해당하는 값 가져옴
		} 
		
		// key 반환. 
		Set<String> keyset = userMap.keySet(); //Set<String>을 반환하는 key값을 다 가져오는 메소드
		for(String key : keyset) { //전체목록가져오기
			String value = userMap.get(key);
			System.out.printf("key: %s, val: %s \n", key, value);
		}
		
		//map 해당하는 이름을 가져오고 싶다
		Map<User, String> umap = new HashMap<>();
		umap.put(new User("user1", "1111"), "홍길동"); //객체는 반환되는 주소가 항상 다름
		umap.put(new User("user2", "2222"), "김길동");
		umap.put(new User("user3", "1111"), "이길동");

		String name = umap.get(new User("user1", "1111"));
		System.out.println("name : "+ name);
	}

}

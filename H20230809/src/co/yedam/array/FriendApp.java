package co.yedam.array;

import java.util.Scanner;

public class FriendApp {
	static Friend[]friends = new Friend[10];
	static Scanner scn = new Scanner(System.in);
	static String name;
	static String phone;
	static Gender gender;
	// boolean checkFriend(String name) {}
	public static boolean checkFriend(String name) { //메소드 이름 체크프렌드
		 for(int i=0; i<friends.length; i++) {
			 if(friends[i]!=null && friends[i].name.equals(name)) {//배열의 값이 널이 아니고 그 배열이 가지고 있는 위치의 네임이 네임값으로 들어오는것과 똑같은 것이 있다면
				 return true; //true값을 반환함
			 }
		 }
		 return false;
	 }
	public static void init() {
		for(int i = 0; i<5; i++) {
			Friend f = new Friend();
			f.name = "test"+i;
			f.phone = "010-3245-9999"+i;
			f.gender = i % 2 == 0? Gender.MEN:Gender.WOMEN;
			
			friends[i]=f;
		}
		
	}
	
	public static void printMenu() {
		System.out.println("1.추가 2.수정 3.삭제 4.조회 5.목록 6.종료");
		System.out.println("선택>> ");
	}
	
	public static void add() {
		System.out.println("이름을 입력하세요");
		name = scn.nextLine();
		System.out.println("연락처를 입력하세요");
		phone = scn.nextLine();
		System.out.println("성별을 입력하세요(1:남자, 2:여자)");
		gender=null;
		int choice = Integer.parseInt(scn.nextLine());
		if(choice==1) {
			gender = Gender.MEN;
		}else {
			gender = Gender.WOMEN;
		}
		Friend fnd = new Friend();
		fnd.name=name;
		fnd.phone=phone;
		fnd.gender=gender;
		
		for(int i=0; i<=friends.length;i++) {
			if(friends[i] == null) {
				friends[i] = fnd;
				break;
			}
		}
		System.out.println("정상적으로 등록되었습니다.");
			}
	public static void edit() {
		System.out.println("이름을 입력하세요");  
	    name = scn.nextLine(); //이름 속성 생성
	    if(!checkFriend(name)) {
	    	System.out.println("찾는 이름이 없습니다");
	    	return; //case2 끝내겠다.
	    }
		System.out.println("연락처를 입력하세요");
	    phone = scn.nextLine(); //연락처 속성 생성
		for(int i=0; i<=friends.length;i++) {
			if(friends[i] != null) { //중복된 이름이 없다
				if(friends[i].name.equals(name)) {
					friends[i].phone = phone; //입력받은 값을 배열에 저장
					break; //for반복에 대한 브레이크
				}
			}
		}
		//메소드의 중지
	}
	 public static void del() {
		 System.out.println("이름을 입력하세요");
		    name = scn.nextLine();
		    if(!checkFriend(name)) {
		    	System.out.println("찾는 이름이 없습니다");
		    	return; //case3 끝내겠다.
		    }
		    
		    for(int i=0; i<=friends.length;i++) {
				if(friends[i] != null && friends[i].name.equals(name)) {
						friends[i]=null; //삭제.
						break; //빠져나옴
					}
				}
	 }
	 
	 public static void search() {
			System.out.println("이름을 입력하세요");
			name = scn.nextLine();
			 if(!checkFriend(name)) {
			    	System.out.println("찾는 이름이 없습니다");
			    	return; //case2 끝내겠다.
			    }
			int count =0;
			for(int i=0; i<friends.length; i++) {
				if(friends[i]!=null //두조건이 참이어야 블럭을 실행
						&& friends[i].name.equals(name)) {
					friends[i].showInfo();
					count++;
				    break;
				}
			}
	 }
	public static void list() {
		for(int i=0; i<friends.length; i++) {
			if(friends[i]!=null) {
				friends[i].briefInfo();					
			}
		}
	}
	
public static void main(String[] args) {
	//추가, 수정, 삭제, 조회, 목록
	boolean run = true;
	
	//초기값
	for(int i = 0; i<5; i++) {
		Friend f = new Friend();
		f.name = "test"+i;
		f.phone = "010-3245-9999"+i;
		f.gender = i % 2 == 0? Gender.MEN:Gender.WOMEN;
		
		friends[i]=f;
	}
	
	
	while(run) {
		printMenu();		
		int menu = Integer.parseInt(scn.nextLine());
		
		switch(menu) {
		case 1: // 더이상 추가할수없습니다 추가하기
			add();
			break;
		case 2:
			edit();
			break; //switch에 대한 브레이크
		case 3:
		    del();
		    break; //switch에 대한 브레이크
		case 4: // 조회. 이름,연락처,성별보여줌
		   search();
			break;
		case 5: // 목록  이름, 연락처
			list();
			break;			
		case 6: // 종료
			System.out.println("종료합니다.");
			run=false;
		default:
			System.out.println("메뉴를 다시 선택하세요.");
		}//switch의 끝
	}//while의 끝
 } //main의 끝
}
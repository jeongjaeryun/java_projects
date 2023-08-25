package co.yedam.lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //게터,세터,투스트링
@AllArgsConstructor // 필드 값 채워주는 생성자
@NoArgsConstructor  // 기본생성자
public class Student {
	private int stdNo;
	private String stdName;
	private int score;
}

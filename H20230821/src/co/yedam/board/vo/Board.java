package co.yedam.board.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

//데이터 한건한건 처리해주는 클래스
public class Board implements Serializable { //직렬화 역직렬화 표시하는거 
	private int brdNo; // 오라클에선 brd_no
	private String brdTitle;    //제목
	private String brdContent;  //글내용
	private String brdWriter;   //작성자
	private Date writeDate;     //작성일자
	private Date updateDate;    //수정일자
	
	public Board() { //기본생성자
		
	}
	
	//constructor 생성자
	public Board(String brdTitle, String brdContent, String brdWriter) {
		super();
		this.brdTitle = brdTitle;
		this.brdContent = brdContent;
		this.brdWriter = brdWriter;
	}

	public int getBrdNo() {
		return brdNo;
	}

	public void setBrdNo(int brdNo) {
		this.brdNo = brdNo;
	}

	public String getBrdTitle() {
		return brdTitle;
	}

	public void setBrdTitle(String brdTitle) {
		this.brdTitle = brdTitle;
	}

	public String getBrdContent() {
		return brdContent;
	}

	public void setBrdContent(String brdContent) {
		this.brdContent = brdContent;
	}

	public String getBrdWriter() {
		return brdWriter;
	}

	public void setBrdWriter(String brdWriter) {
		this.brdWriter = brdWriter;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "Board [brdNo=" + brdNo + ", brdTitle=" + brdTitle + ", brdContent=" + brdContent + ", brdWriter="
				+ brdWriter + ", writeDate=" + writeDate + ", updateDate=" + updateDate + "]";
	}
	
	
	public String listInfo() { //목록보기
		return "글번호: "+brdNo+ " 글제목: "+brdTitle+ " 작성자: "+brdWriter;
	}
	
	public String showInfo() { //상세보기
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		return "글번호: "+brdNo+ " 글제목: "+brdTitle+ " 작성자: "+brdWriter//
				+"\n글내용: "+ brdContent + "\n작성일자 : "+sdf.format(writeDate);
	}
	
	
	
	
}

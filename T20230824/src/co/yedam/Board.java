package co.yedam;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Board implements Serializable {
	int brdNo;
	String title;
	String content;
	String writer;
	Date wrDate;
	
	public Board() {
		
	}

	public Board(int brdNo, String title, String content, String writer, Date wrDate) {
		
		super();
		this.brdNo = brdNo;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.wrDate = wrDate;
	}

	public int getBrdNo() {
		return brdNo;
	}

	public void setBrdNo(int brdNo) {
		this.brdNo = brdNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getWrDate() {
		return wrDate;
	}

	public void setWrDate(Date wrDate) {
		this.wrDate = wrDate;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return "글번호 : " + brdNo + " 제목: " + title + "\n글내용 : " + content + "\n작성자: " + writer
				+ " 작성일: " + sdf.format(wrDate);
	}
	
	
	
	
}

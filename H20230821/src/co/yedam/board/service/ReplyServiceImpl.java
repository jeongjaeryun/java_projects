package co.yedam.board.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import co.yedam.board.vo.Reply;

public class ReplyServiceImpl implements ReplyService {
	
	List<Reply>replyList = new ArrayList<>();
	
	public ReplyServiceImpl() {
		init();
	}
	

	private void init() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("C:/Temp/reply.dat");
			ObjectInputStream ois =new ObjectInputStream(fis);
			
			replyList =(List<Reply>) ois.readObject();
			
			ois.close();
			fis.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private int getMaxNo() {
		int rpNo = 0;
		for (int i = 0; i < replyList.size(); i++) {
			if (replyList.get(i).getRpNo() > rpNo) {
				rpNo = replyList.get(i).getRpNo();
			}
		}
		return rpNo + 1;
	}

	@Override
	public boolean add(Reply reply) {
		reply.setRpNo(getMaxNo());
		return replyList.add(reply);
	}

	@Override
	public List<Reply> list() {
//		int start = (page -1)*5;
//		int end = page*5;
//		List<Reply> pageList = new ArrayList<>();
//		for(int i =0; i<replyList.size(); i++) {
//			if(i >= start && i <end) {
//				pageList.add(replyList.get(i));
//			}
//		}
		return replyList;
	}

	@Override
	public int getTotal() {
		return replyList.size();
	}


	@Override
	public boolean remove(int rpNo) {
		for(int i = 0; i<replyList.size(); i++) {
			if(replyList.get(i).getRpNo() == rpNo) {
				replyList.remove(i);
				return true;
			}
		}
		return false;
	}


	@Override
	public void save() {
		try {
			FileOutputStream fos = new FileOutputStream("C:/Temp/reply.dat"); // 출력스트림
			ObjectOutputStream oos = new ObjectOutputStream(fos);// 보조스트림
			oos.writeObject(replyList); // 직렬화 거쳐서 객체를 바이트타입으로 변경함
			oos.flush();
			oos.close();
			fos.flush();
			fos.close();

			System.out.println("댓글저장완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

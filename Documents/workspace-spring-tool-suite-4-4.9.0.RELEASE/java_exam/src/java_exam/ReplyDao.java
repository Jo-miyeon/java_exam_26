package java_exam;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ReplyDao {
	private ArrayList<Reply> replies;
	private int no=1;
	public ReplyDao() {
		replies = new ArrayList<>();
	}
	public static String getCurrentDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time = new Date();
		String time1 = format.format(time);

		return time1;
	}
	public void insertReply(Reply r) {
		r.setId(no);
		no++;
		r.setRegDate(getCurrentDate());
		replies.add(r);
	}
	public ArrayList<Reply> getReplies() {
		return replies;
	}
	public ArrayList<Reply> getRepliesByParentId(int parentId) {
		ArrayList<Reply> searchedReplies = new ArrayList<>();
		for(int i=0; i<replies.size();i++) {
			Reply reply = replies.get(i);
			if(reply.getParentId()==parentId) {
				searchedReplies.add(reply);
			}
		}
		return replies; //parentId를 넘길테니 그 parentId에 맞는 댓글만 가져와줘..
	}
}

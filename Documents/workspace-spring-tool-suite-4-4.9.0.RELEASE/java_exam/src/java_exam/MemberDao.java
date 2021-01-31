package java_exam;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MemberDao {
	private ArrayList<Member> members;
	private int no=1;
	public MemberDao() {
		members = new ArrayList<>();
	}
	public void insertMember(Member m) {
		m.setId(no);
		no++;
		members.add(m);
	}
	public static String getCurrentDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time = new Date();
		String time1 = format.format(time);

		return time1;
	}
	public Member getMemberByLoginIdandLoginPw(String id,String pw) { //member를 가져와야한다.
		for(int i=0;i<members.size();i++) {
			Member m = members.get(i);
			if(m.getLoginId().equals(id) && m.getLoginPw().equals(pw)) {
				System.out.println(m.getNickname()+"님 환영합니다!");
				return m;
			}
		}
		return null;
	}
}

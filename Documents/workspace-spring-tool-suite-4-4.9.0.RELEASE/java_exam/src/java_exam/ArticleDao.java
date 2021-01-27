package java_exam;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ArticleDao {
	//Data Access Object
	private static ArrayList<Article> articles; // 매서드안에서는 static을 선언할수없다
	private int no=4;
	
	public ArticleDao() { //ArticleDao가 만들어질때 무조건 실행되어야하니까 생성자를 활용 
		//ArticleDao를 만드는 순간 생성자가 세팅돼서나옴 
		articles = new ArrayList<>();
		Article a1 = new Article(1,"제목1","내용1","익명1",getCurrentDate());
		Article a2 = new Article(1,"제목2","내용2","익명2",getCurrentDate());
		Article a3 = new Article(1,"제목3","내용3","익명3",getCurrentDate());
		articles.add(a1);
		articles.add(a2);
		articles.add(a3);
	}

	public static String getCurrentDate() {
		SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
		Date time = new Date();
		String time1 = format.format(time);
		
		return time1;
	}

	public static Article getArticleById(int targetId) { // targetId를 받아서 targetId가 있는지 찾아범
		for (int i = 0; i < articles.size(); i++) {
			if (articles.get(i).getId() == targetId) {
				return articles.get(i);
			}
		}
		return null;
	}
	public void removeArticle(Article a) {
		articles.remove(a);
	}
	public ArrayList<Article> getArticles() {
		
		return articles;
	}
	public void insertArticle(Article a) {
		a.setId(no);
		no++;
		a.setRegDate(getCurrentDate());
		articles.add(a);
	}
}

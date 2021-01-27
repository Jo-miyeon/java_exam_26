package java_exam;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class java_exam {
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArticleDao dao = new ArticleDao();

		while (true) {
			System.out.print("명령어입력 : ");
			String str = sc.nextLine();
			if (str.equals("exit")) {
				break;
			} else if (str.equals("add")) {
				Article a = new Article();
				
				System.out.println("게시물 제목을 입력해주세요 :");
				String title = sc.nextLine();
				a.setTitle(title);
				System.out.println("게시물 내용을 입력해주세요 :");
				String body = sc.nextLine();
				a.setBody(body);
				dao.insertArticle(a);
				System.out.println("게시물이 등록되었습니다.");
			} else if (str.equals("list")) {
				ArrayList<Article> articles = dao.getArticles();  //new할 필요없이 dao한테 달라고하면 됨.
				for (int i = 0; i < articles.size(); i++) {
					System.out.println("게시물 번호:" + articles.get(i).getId());
					System.out.println("제목 :" + articles.get(i).getTitle());
					System.out.println("======================");
				}
			} else if (str.equals("update")) {
				System.out.println("수정할 게시물의 번호를 선택해주세요 :");
				int targetId = Integer.parseInt(sc.nextLine());
				Article target = dao.getArticleById(targetId);
				if (target == null) {
					System.out.println("존재하지 않는 게시물입니다.");
				} else {
					System.out.println("수정할 게시물의 제목을 입력해주세요 :");
					String newTitle = sc.nextLine();
					System.out.println("수정할 게시물의 내용을 입력해주세요 :");
					String newBody = sc.nextLine();
					target.setTitle(newTitle);
					target.setBody(newBody);
					System.out.println("게시물이 수정되었습니다.");
				}

			} else if (str.equals("delete")) {
				ArrayList<Article> articles = dao.getArticles();
				System.out.println("삭제할 게시물의 번호를 선택해주세요 :");
				int targetId = Integer.parseInt(sc.nextLine());
				Article target = dao.getArticleById(targetId);

				if (target == null) { // for문에 내가찾는 게시물 번호가 없을 경우 밑으로 내려온다.
					System.out.println("게시물이 존재하지않습니다.");
				} else {
					dao.removeArticle(target);
					System.out.println(targetId + "번 게시물이 삭제되었습니다.");
				}
			} else if (str.equals("read")) {
				System.out.println("상세보기할 게시물번호를 선택해주세요:");
				int targetId = Integer.parseInt(sc.nextLine());
				Article target = dao.getArticleById(targetId);
				if (target == null) {
					System.out.println("게시물이 존재하지않습니다.");
				} else {
					target.setHit(target.getHit()+1);
					System.out.println("======" + target.getId() + "번 게시물======");
					System.out.println("게시물 번호:" + target.getId());
					System.out.println("제목 :" + target.getTitle());
					System.out.println("내용 :" + target.getBody());
					System.out.println("조회수 :" + target.getHit());
					System.out.println("등록날짜 :" + target.getRegDate());
					System.out.println("======================");
				}
			}
		}
	}
}

package java_exam;

import java.util.ArrayList;
import java.util.Scanner;

public class java_exam {

	public static void main(String[] args) {
		ArrayList<Article> articles = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int no = 1;

		while (true) {

			System.out.print("명령어입력 : ");
			String str = sc.nextLine();
			if (str.equals("exit")) {
				break;
			} else if (str.equals("add")) {
				Article a = new Article();
				a.setId(no);
				no++;
				System.out.println("게시물 제목을 입력해주세요 :");
				String title = sc.nextLine();
				a.setTitle(title);
				System.out.println("게시물 내용을 입력해주세요 :");
				String body = sc.nextLine();
				a.setBody(body);
				System.out.println("게시물이 등록되었습니다.");
			} else if (str.equals("list")) {
				for (int i = 0; i < articles.size(); i++) {
					System.out.println("게시물 번호:" + articles.get(i).getId());
					System.out.println("제목 :" + articles.get(i).getTitle());
					System.out.println("내용 :" + articles.get(i).getBody());
					System.out.println("======================");
				}
			} else if (str.equals("update")) {
				System.out.println("수정할 게시물의 번호를 선택해주세요 :");
				int targetId = Integer.parseInt(sc.nextLine());
				
				for (int i = 0; i < articles.size(); i++) {
					if (articles.get(i).getId() == targetId) {
						System.out.println("수정할 게시물의 제목을 입력해주세요 :");
						String newTitle = sc.nextLine();
						System.out.println("수정할 게시물의 내용을 입력해주세요 :");
						String newBody = sc.nextLine();
						
						Article newArticle = new Article();
						newArticle.setId(articles.get(i).getId());
						newArticle.setTitle(newTitle);
						newArticle.setBody(newBody);
						
						articles.set(i, newArticle);
						System.out.println("게시물이 수정되었습니다.");
					}
				}
			}else if(str.equals("delete")) {
				System.out.println("삭제할 게시물의 번호를 선택해주세요 :");
				int targetId = Integer.parseInt(sc.nextLine());
				int existFlag =2;
				for(int i=0;i<articles.size();i++) {
					if(articles.get(i).getId()==targetId) {
						existFlag=1; //for문에 내가 찾는 게시물번호가 있을경우 1로 바껴서 밑에 if문 타지않는다.
						articles.remove(i);
					}
				}
				if(existFlag==2) { //for문에 내가찾는 게시물 번호가 없을 경우 밑으로 내려온다.
					System.out.println("게시물이 존재하지않습니다.");
				}else {
					System.out.println(targetId+"번 게시물이 삭제되었습니다.");	
				}
			}
		}
	}
}

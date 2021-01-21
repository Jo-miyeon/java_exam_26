package java_exam;

import java.util.ArrayList;
import java.util.Scanner;

public class java_exam {

	public static void main(String[] args) {
		ArrayList<String> titles = new ArrayList<>();
		ArrayList<String> bodies = new ArrayList<>();
		ArrayList<Integer> ids = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int no = 1;

		while (true) {

			System.out.print("명령어입력 : ");
			String str = sc.nextLine();
			if (str.equals("exit")) {
				break;
			} else if (str.equals("add")) {
				ids.add(no);
				no++;
				System.out.println("게시물 제목을 입력해주세요 :");
				String title = sc.nextLine();
				titles.add(title);
				System.out.println("게시물 내용을 입력해주세요 :");
				String body = sc.nextLine();
				bodies.add(body);
				System.out.println("게시물이 등록되었습니다.");
			} else if (str.equals("list")) {
				for (int i = 0; i < titles.size(); i++) {
					System.out.println("게시물 번호:" + ids.get(i));
					System.out.println("제목 :" + titles.get(i));
					System.out.println("내용 :" + bodies.get(i));
					System.out.println("======================");
				}
			} else if (str.equals("update")) {
				System.out.println("수정할 게시물의 번호를 선택해주세요 :");
				int targetId = Integer.parseInt(sc.nextLine());
				
				for (int i = 0; i < ids.size(); i++) {
					if (ids.get(i) == targetId) {
						System.out.println("수정할 게시물의 제목을 입력해주세요 :");
						String newTitle = sc.nextLine();
						System.out.println("수정할 게시물의 내용을 입력해주세요 :");
						String newBody = sc.nextLine();
						titles.set(i, newTitle);
						bodies.set(i, newBody);
						System.out.println("게시물이 수정되었습니다.");
					}
				}
			}else if(str.equals("delete")) {
				System.out.println("삭제할 게시물의 번호를 선택해주세요 :");
				int targetId = Integer.parseInt(sc.nextLine());
				for(int i=0;i<ids.size();i++) {
					if(ids.get(i)==targetId) {
						titles.remove(i);
						bodies.remove(i);
					}
				}
				System.out.println("게시물이 삭제되었습니다.");
			}
		}
	}

}

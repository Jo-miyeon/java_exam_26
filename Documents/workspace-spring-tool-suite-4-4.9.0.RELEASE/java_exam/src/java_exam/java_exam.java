package java_exam;

import java.util.ArrayList;
import java.util.Scanner;

public class java_exam {
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArticleDao dao = new ArticleDao();
		ReplyDao rdao = new ReplyDao();
		MemberDao mdao = new MemberDao();

		Member loginedMember = null;
		
		while (true) {
			if(loginedMember == null) {
				System.out.print("명령어입력 : ");
			}else {
				System.out.println("명령어 입력["+loginedMember.getNickname()+"] :");
			}
			
			String str = sc.nextLine();
			if (str.equals("exit")) {
				break;
			}else if(str.equals("sign up")) {
				Member m = new Member();
				System.out.println("==== 회원 가입을 진행합니다. ====");
				System.out.println("아이디를 입력해주세요:");
				String signupId = sc.nextLine();
				m.setLoginId(signupId);
				System.out.println("비밀번호를 입력해주세요:");
				String signupPw = sc.nextLine();
				m.setLoginPw(signupPw);
				System.out.println("닉네임을 입력해주세요:");
				String signupNn = sc.nextLine();
				m.setNickname(signupNn);
				mdao.insertMember(m);
				System.out.println("==== 회원가입이 완료되었습니다. ====");
			}else if(str.equals("sign in")) {
				Member m = new Member();
				System.out.println("아이디:");
				String signinId = sc.nextLine();
				System.out.println("비밀번호:");
				String signinPw = sc.nextLine();
				Member member = mdao.getMemberByLoginIdandLoginPw(signinId,signinPw);
				if(member==null) {
					System.out.println("비밀번호를 틀렸거나 잘못된 회원정보입니다.");
				}else {
					loginedMember = member;
					System.out.println(loginedMember.getNickname()+"님 안녕하세요!");
				}
			}
			else if (str.equals("add")) {
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
				printArticles(articles);
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
					System.out.println("====================");
					while(true) {
						System.out.println("상세보기 기능을 선택해주세요(1. 댓글 등록, 2. 좋아요, 3. 수정, 4. 삭제, 5. 목록으로) :");
						int readFunc = Integer.parseInt(sc.nextLine());
						if(readFunc==1) {
							Reply r = new Reply();
							System.out.println("댓글 내용을 입력해주세요 : ");
							String body = sc.nextLine();
							r.setBody(body);
							r.setNickname("익명");
							r.setParentId(target.getId());
							rdao.insertReply(r);
							System.out.println("댓글이 등록되었습니다.");
							System.out.println("======" + target.getId() + "번 게시물======");
							System.out.println("게시물 번호:" + target.getId());
							System.out.println("제목 :" + target.getTitle());
							System.out.println("내용 :" + target.getBody());
							System.out.println("조회수 :" + target.getHit());
							System.out.println("등록날짜 :" + target.getRegDate());
							System.out.println("==========댓글==========");
							ArrayList<Reply> replies = rdao.getRepliesByParentId(target.getId());
							printReplies(replies);
						}else if(readFunc==2) {
							
						}else if(readFunc==3) {
							
						}else if(readFunc==4) {
							
						}else if(readFunc==5) {
							break;
						}
					}
					
				}
			}else if (str.equals("search")) {
				System.out.println("검색 항목을 선택해주세요 :1. 제목, 2. 내용, 3. 제목 + 내용, 4. 작성자 ");
				int keywordNum = Integer.parseInt(sc.nextLine());
				System.out.println("검색 키워드를 입력해주세요 : ");
				String searchKeyWord = sc.nextLine();
				ArrayList<Article> articles;
				articles = dao.getSearchedArticleByFlag(keywordNum, searchKeyWord);
				printArticles(articles);
			}
		}
	}
	private static void getMemberByLoginIdandLoginPw(String signinId, String signinPw) {
		// TODO Auto-generated method stub
		
	}
	private static void printArticles(ArrayList<Article> articleList) {
		for(int i=0;i<articleList.size();i++) {
			System.out.println("게시물 번호:" + articleList.get(i).getId());
			System.out.println("제목 :" + articleList.get(i).getTitle());
			System.out.println("======================");
		}
	}
	private static void printReplies(ArrayList<Reply> replyList) {
		for(int i=0;i<replyList.size();i++) {
			//System.out.println("번호:" + replyList.get(i).getId());
			System.out.println("내용 :" + replyList.get(i).getBody());
			System.out.println("작성자 :" + replyList.get(i).getNickname());
			System.out.println("작성일 :" + replyList.get(i).getRegDate());
			System.out.println("======================");
		}
	}
}

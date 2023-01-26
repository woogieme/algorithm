package project4.p2040;

import java.util.Date;

public class Article {
	int articleId; //pk
	String title;
	String content;
	int viewCnt;
	Date regDate;
	int userSeq; //fk
	
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Article(int articleId, String title, String content, int userSeq, int viewCnt, Date regDate) {
		super();
		this.articleId = articleId;
		this.title = title;
		this.content = content;
		this.userSeq = userSeq;
		this.viewCnt = viewCnt;
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", title=" + title + ", content=" + content + ", userSeq=" + userSeq
				+ ", viewCnt=" + viewCnt + ", regDate=" + regDate + "]";
	}
	
}

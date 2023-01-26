package project4.p2040;

import java.util.Date;

public class Comment {
	int commentId;
	int articleId;
	int userSeq;
	String content;
	Date regDate;
	
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(int commentId, int articleId, int userSeq, String content, Date regDate) {
		super();
		this.commentId = commentId;
		this.articleId = articleId;
		this.userSeq = userSeq;
		this.content = content;
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", articleId=" + articleId + ", userSeq=" + userSeq + ", content="
				+ content + ", regDate=" + regDate + "]";
	}
	
	

}

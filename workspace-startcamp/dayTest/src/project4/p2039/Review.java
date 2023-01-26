package project4.p2039;

public class Review {
	int reviewId;
	int resId;
	String writer;
	String content;
	
	public Review() {}

	public Review(int reviewId, int resId, String writer, String content) {
		super();
		this.reviewId = reviewId;
		this.resId = resId;
		this.writer = writer;
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", resId=" + resId + ", writer=" + writer + ", content=" + content
				+ "]";
	}
	
	
}

package vo;

public class Recomment {
	private int recommentNo;
	private String recommentContent;
	private int boardNo;
	private String memberId;
	private String createdate;
	
	
	public int getRecommentNo() {
		return recommentNo;
	}
	public void setRecommentNo(int recommentNo) {
		this.recommentNo = recommentNo;
	}

	public String getRecommentContent() {
		return recommentContent;
	}
	public void setRecommentContent(String recommentContent) {
		this.recommentContent = recommentContent;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
		
}

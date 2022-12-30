package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.Board;

public class BoardDao {
	// 검색 추가
	public ArrayList<Board> selectBoardListByPage(Connection conn, int beginRow, int endRow, String serachtitle, String type) throws Exception {
		ArrayList<Board> list = new ArrayList<Board>();
		String sql = "SELECT board_no boardNo, board_title boardTitle, board_view, member_id, createdate FROM (SELECT rownum rnum, board_view, board_no, board_title, member_id, createdate FROM (SELECT board_no, board_view, member_id, board_title, createdate FROM board WHERE "+type+" LIKE ? ORDER BY TO_NUMBER(board_no) DESC)) WHERE rnum BETWEEN ? AND ?"; // WHERE rnum >=? AND rnum <=?;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, "%"+serachtitle+"%");
		stmt.setInt(2, beginRow);
		stmt.setInt(3, endRow);
		
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Board b = new Board();
			b.setBoardNo(rs.getInt("boardNo"));
			b.setBoardTitle(rs.getString("boardTitle"));
			b.setCreatedate(rs.getString("createdate"));
			b.setBoardView(rs.getInt("board_view"));
			b.setMemberId(rs.getString("member_id"));
			list.add(b);
		}
		rs.close();
		stmt.close();
		return list;
	}
	//조회수 
	public int insertBoardView(Connection conn, int boardNo, int view) throws Exception{
		int result= 0;
		String sql ="UPDATE BOARD SET board_view = ?  WHERE board_no= ?";
		PreparedStatement stmt= conn.prepareStatement(sql);
		stmt.setInt(1, view+1);
		stmt.setInt(2, boardNo);
		result= stmt.executeUpdate();
		
		stmt.close();
		
		return result;
	}
	
	
	public int insertBoard(Connection conn, Board b) throws Exception {
		int result= 0;
		String sql="INSERT INTO board ( BOARD_NO, BOARD_TITLE, BOARD_CONTENT, MEMBER_ID, UPDATEDATE, CREATEDATE ) values ( board_seq.nextval, ?, ?, ?, sysdate, sysdate )";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, b.getBoardTitle());
		stmt.setString(2, b.getBoardContent());
		stmt.setString(3, b.getMemberId());
		result=stmt.executeUpdate();
		stmt.close();
		
		return result;
	}
	public Board boardOneValues(Connection conn, int boardNo) throws Exception {
		Board board=  new Board();
		String sql ="SELECT * FROM board WHERE board_no= ?";
		PreparedStatement stmt= conn.prepareStatement(sql);
		stmt.setInt(1, boardNo);
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			board.setBoardView(rs.getInt("board_view"));
			board.setBoardNo(rs.getInt("board_no"));
			board.setBoardTitle(rs.getString("board_title"));
			board.setBoardContent(rs.getString("board_content"));
			board.setMemberId(rs.getString("member_id"));
			board.setUpdatedate(rs.getString("updatedate"));
		}
		rs.close();
		stmt.close();
		return board;
	}
	public int updateBoardMatchId(Connection conn, Board b) throws Exception {
		int result= 0;
		
		String sql = "UPDATE BOARD SET board_title= ?, board_content= ?, updatedate= sysdate WHERE board_no=?";
		PreparedStatement stmt= conn.prepareStatement(sql);
		stmt.setString(1, b.getBoardTitle());
		stmt.setString(2, b.getBoardContent());
		stmt.setInt(3, b.getBoardNo());
		result= stmt.executeUpdate();
		
		stmt.close();
		
		return result;
	}
	public int deleteBoard(Connection conn, int boardNo) throws Exception {
		int result =0;
		
		String sql= "DELETE FROM BOARD WHERE board_no= ?";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setInt(1, boardNo);
		
		result= stmt.executeUpdate();
		
		stmt.close();
		
		return result;
	}
	public int deleteBoardByMember(Connection conn, String memberId) throws Exception {
		int result =0;
		
		String sql= "DELETE FROM BOARD WHERE member_id= ?";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setString(1, memberId);
		
		result= stmt.executeUpdate();
		
		stmt.close();
		
		return result;
	}
	public int countBoard(Connection conn, int rowPerPage, String serachtitle, String type) throws Exception{
		
		int count=0;
		String sql = "SELECT COUNT(*) FROM board WHERE "+type+" LIKE ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, "%"+serachtitle+"%");
		
		ResultSet rs= stmt.executeQuery();
		if(rs.next()) {
			count=rs.getInt("count(*)");
		}
		int lastPage= count/rowPerPage;
		if(count%rowPerPage!=0) {
			lastPage+=1;
		}
		
		return lastPage;
		
	}
	public ArrayList<Board> selectBoardByMember(Connection conn, String memberId) throws Exception{
		ArrayList<Board> list = new ArrayList<Board>();
		String sql ="SELECT * FROM BOARD WHERE member_id= ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, memberId);
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Board b = new Board();
			b.setBoardNo(rs.getInt("board_no"));
			b.setBoardTitle(rs.getString("board_title"));
			b.setUpdatedate(rs.getString("updatedate"));
			
			list.add(b);
			
		}
		rs.close();
		stmt.close();
		return list;
	}
}

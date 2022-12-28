package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.Board;

public class BoardDao {
	// 검색 추가
	public ArrayList<Board> selectBoardListByPage(Connection conn, int beginRow, int endRow) throws Exception {
		ArrayList<Board> list = new ArrayList<Board>();
		String sql = "SELECT board_no boardNo, board_title boardTilte, createdate"
				+ " FROM (SELECT rownum rnum, board_no, board_title, createdate"
				+ "			FROM (SELECT board_no, board_title, createdate"
				+ "					FROM board ORDER BY board_no DESC))"
				+ " WHERE rnum BETWEEN ? AND ?"; // WHERE rnum >=? AND rnum <=?;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, beginRow);
		stmt.setInt(2, endRow);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Board b = new Board();
			b.setBoardNo(rs.getInt("boardNo"));
			b.setBoardTitle(rs.getString("boardTitle"));
			b.setCreatedate(rs.getString("createdate"));
			list.add(b);
		}
		rs.close();
		stmt.close();
		return list;
	}
	
	public int insertBoard(Connection conn, Board board) throws Exception {
		int result= 0;
		String sql="INSERT INTO BOARD( board_no, board_title, board_content, member_id, updatedate, createdate "
				+ ") values( board_seq.nextval, ?, ?, ?, sysdate, sysdate );";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, board.getBoardTitle());
		stmt.setString(2, board.getBoardContent());
		stmt.setString(3, board.getMemberId());
		
		result=stmt.executeUpdate();
		stmt.close();
		
		return result;
	}
	public Board boardOneVlaues(Connection conn, int boardNo) throws Exception {
		Board board=  new Board();
		String sql ="SELECT * FROM board WHERE board_no= ?";
		PreparedStatement stmt= conn.prepareStatement(sql);
		stmt.setInt(1, boardNo);
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
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
		
		String sql = "UPDATE BOARD SET board_title= ?, board_content= ?, updatedate= systdate ";
		PreparedStatement stmt= conn.prepareStatement(sql);
		stmt.setString(1, b.getBoardTitle());
		stmt.setString(2, b.getBoardContent());
		
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

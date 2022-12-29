package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.Recomment;



public class RecommentDao {
	//ArrayList<recomment> list board one 에 띄우기
	public ArrayList<Recomment> recommentListByBoardNo(Connection conn, int boardNo) throws Exception{
		ArrayList<Recomment> list = new ArrayList<Recomment>();
		String sql = "SELECT * FROM recomment WHERE board_no=?";
		PreparedStatement stmt= conn.prepareStatement(sql);
		stmt.setInt(1, boardNo);
		
		ResultSet rs= stmt.executeQuery();
		
		while(rs.next()) {
			Recomment r = new Recomment();
			r.setMemberId(rs.getString("member_id"));
			r.setRecommentNo(rs.getInt("recomment_no"));
			r.setRecommentContent(rs.getString("recomment_content"));
			r.setCreatedate(rs.getString("createdate"));
			list.add(r);
		}
		rs.close();
		stmt.close();

		return list;
	}
	
	//int return recomment insert
	public int recommentInsert(Connection conn, Recomment re) throws Exception {
		int result= 0;
		String sql= "INSERT INTO recomment(recomment_no, recomment_content, board_no, member_id, createdate) values"
				+ " (recomment_seq.nextval, ?, ?, ?, sysdate)";
		PreparedStatement stmt= conn.prepareStatement(sql);
		stmt.setString(1, re.getRecommentContent());
		stmt.setInt(2, re.getBoardNo());
		stmt.setString(3, re.getMemberId());
		
		result=stmt.executeUpdate();
		
		stmt.close();
		return result;
	}
	
	//int return recomment update
	public int recommentUpdate(Connection conn, Recomment re) throws Exception{
		int result=0;
		String sql = "UPDATE RECOMMENT SET recomment_content= ?, createdate=sysdate WHERE recomment_no = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, re.getRecommentContent());
		stmt.setInt(2, re.getRecommentNo());
		
		result= stmt.executeUpdate();
		return result;
	}
	
	
	//int retrun recomment delete
	public int recommentDelete(Connection conn, int recommentNo) throws Exception{
		int result= 0;
		String sql = "DELETE FROM recomment WHERE recomment_no=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, recommentNo);
		
		result= stmt.executeUpdate();
		
		return result;
		
	}
	//int return recomment delete// by board
	public int recommentDeleteByBoard(Connection conn, int boardNo) throws Exception{
		String sql= "DELETE FROM recomment WHERE board_no=?";
		PreparedStatement stmt= conn.prepareStatement(sql);
		stmt.setInt(1, boardNo);
		
		int result= stmt.executeUpdate();
		
		return result;
	}
}

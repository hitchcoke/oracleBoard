package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.Member;

public class MemberDao {
	public int selectMemberIdCk(Connection conn, String memberId) throws Exception{
		int result=0;
		
		String sql = "SELECT member_id FROM member WHERE member_id = ?";
		PreparedStatement stmt= conn.prepareStatement(sql);
		ResultSet rs= stmt.executeQuery();
		
		if(rs.next()) {
			result=1;
		}
		rs.close();
		stmt.close();
		
		return result;
	}
	
	public int insertMember(Connection conn, Member m)throws Exception {
		int result=0;
		
		String sql= "INSERT INTO member("
				+ "member_id,"
				+ "member_pw,"
				+ "member_name,"
				+ "updatedate,"
				+ "createdate) values (?, ?, ?, sysdate, sysdate)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, m.getMemberId());
		stmt.setString(2, m.getMemberPw());
		stmt.setString(3, m.getMemberName());
		
		result = stmt.executeUpdate();
		
		return result;
	}
	public Member loginAction(Connection conn ,Member paramMember) throws Exception{
		Member m= new Member();
		
		String sql = "SELECT * FROM member WHERE member_id = ? AND member_pw= ?";
		PreparedStatement stmt= conn.prepareStatement(sql);
		stmt.setString(1, paramMember.getMemberId());
		stmt.setString(2, paramMember.getMemberPw());
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			m.setMemberId(rs.getString("member_id"));
			m.setMemberName(rs.getString("member_name"));
			m.setCreatedate(rs.getString("createdate"));
			m.setUpdatedate(rs.getString("updatedate"));
		}else {
			m=null;
		}
		rs.close(); 
		stmt.close();
		return m;
	}
	public int updateMember(Connection conn, String memberId, String memberName) throws Exception{
		int result=0;
		String sql="UPDATE member SET member_name= ?, updatedate= sysdate WHERE member_id=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, memberName);
		stmt.setString(2, memberId);
		result= stmt.executeUpdate();
		
		stmt.close();
		
		
		return result;
	}
	public int deleteMember(Member m, Connection conn) throws Exception {
		int result = 0;
		
		String sql = "DELETE FROM member WHERE member_id = ? AND member_pw= ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, m.getMemberId());
		stmt.setString(2, m.getMemberPw());
		result=stmt.executeUpdate();
		
		
		return result;
	}
}

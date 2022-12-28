package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.MemberDao;
import util.DBUtil;
import vo.Member;

public class MemberService {
	private MemberDao memberDao;
	
	public int memberidck(String memberId) {
		int result=0;
		Connection conn=null;
		
		try {
			conn= DBUtil.getConnection();
			memberDao=new MemberDao();
			
			result=memberDao.selectMemberIdCk(conn, memberId);
			
			conn.commit();
		}catch(Exception e) {
			try {
				conn.rollback();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	public int insertMember(Member m) {
		int result=0;
		Connection conn=null;
		
		try {
			conn= DBUtil.getConnection();
			memberDao=new MemberDao();
			
			result=memberDao.insertMember(conn, m);
			
			conn.commit();
		}catch(Exception e) {
			try {
				conn.rollback();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public Member loginAction(Member paramMember) {
		Member m = new Member();
		Connection conn=null;
		
		try {
			conn= DBUtil.getConnection();
			memberDao=new MemberDao();
			
			m=memberDao.loginAction(conn, paramMember);
			
			conn.commit();
		}catch(Exception e) {
			try {
				conn.rollback();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return m;
		
	}
	public int updateMember(String memberId, String memberName) {
		int result=0;
		Connection conn=null;
		
		try {
			conn= DBUtil.getConnection();
			memberDao=new MemberDao();
			
			result=memberDao.updateMember(conn, memberId, memberName);
			
			conn.commit();
		}catch(Exception e) {
			try {
				conn.rollback();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	public int deleteMember(Member m) {
		int result=0;
		Connection conn=null;
		
		try {
			conn= DBUtil.getConnection();
			memberDao=new MemberDao();
			
			result=memberDao.deleteMember(m, conn);
			
			conn.commit();
		}catch(Exception e) {
			try {
				conn.rollback();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
}

package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.RecommentDao;
import util.DBUtil;
import vo.Recomment;

public class RecommentService {
	private RecommentDao reDao;
	
	public ArrayList<Recomment> getRecommentbyBoard(int boardNo){
		ArrayList<Recomment> list = null;
		Connection conn=null;
		try {
			conn= DBUtil.getConnection();
			reDao=new RecommentDao();
			list=reDao.recommentListByBoardNo(conn, boardNo);
			conn.commit(); // DBUtil.class에서 conn.setAutoCommit(false);
		} catch (Exception e) {
			try {
				conn.rollback(); // DBUtil.class에서 conn.setAutoCommit(false);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public int insertRecomment(Recomment re) {
		int result=0;
		Connection conn=null;
		try {
			conn= DBUtil.getConnection();
			reDao=new RecommentDao();
			result=reDao.recommentInsert(conn, re);
			conn.commit(); // DBUtil.class에서 conn.setAutoCommit(false);
		} catch (Exception e) {
			try {
				conn.rollback(); // DBUtil.class에서 conn.setAutoCommit(false);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	
	}
	public int updateRecomment(Recomment re) {
		int result= 0;
		Connection conn=null;
		try {
			conn= DBUtil.getConnection();
			reDao=new RecommentDao();
			result= reDao.recommentUpdate(conn, re);
			conn.commit(); // DBUtil.class에서 conn.setAutoCommit(false);
		} catch (Exception e) {
			try {
				conn.rollback(); // DBUtil.class에서 conn.setAutoCommit(false);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	
	}
	public int deleteRecomment(int recommentNo) {
		int result=0;
		Connection conn=null;
		try {
			conn= DBUtil.getConnection();
			reDao=new RecommentDao();
			result= reDao.recommentDelete(conn, recommentNo);
			conn.commit(); // DBUtil.class에서 conn.setAutoCommit(false);
			
		} catch (Exception e) {
			try {
				conn.rollback(); // DBUtil.class에서 conn.setAutoCommit(false);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	
	}
	public int deleteRecommentbyBoard(int boardNo) {
		int result=0;
		Connection conn=null;
		try {
			conn= DBUtil.getConnection();
			reDao=new RecommentDao();
			result= reDao.recommentDeleteByBoard(conn, boardNo);
			conn.commit(); // DBUtil.class에서 conn.setAutoCommit(false);
			
		} catch (Exception e) {
			try {
				conn.rollback(); // DBUtil.class에서 conn.setAutoCommit(false);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}	
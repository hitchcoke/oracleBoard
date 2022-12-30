package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.BoardDao;
import util.DBUtil;
import vo.Board;

public class BoardService {
	private BoardDao boardDao;

	
	public ArrayList<Board> getBoardListByPage(int currentPage, int rowPerPage, String serachtitle, String type) {
		/*
		 	1) connection 생성 <- DBUtil.class
		 	2) beginRow, endRow 생성 <- currentPage,rowPerPage를 가공
		 */
		ArrayList<Board> list = null;
		Connection conn = null;
	
		try {
			conn = DBUtil.getConnection();
			int beginRow = (currentPage-1)*rowPerPage+1;
			int endRow = beginRow + rowPerPage - 1;
			boardDao = new BoardDao();
			list = boardDao.selectBoardListByPage(conn, beginRow, endRow, serachtitle, type);
		
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
	
	public int updateView(int boardNo, int view) {
		int result = 0;
		Connection conn= null;
		
		try {
			conn=DBUtil.getConnection();
			boardDao=new BoardDao();
			result=boardDao.insertBoardView(conn, boardNo, view);
			conn.commit();
			
		}catch(Exception e) {
			try {
				conn.rollback();
				
			}catch(Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public int countBoard(int rowPerPage, String serachtitle, String type) {
		int lastPage=0;
		Connection conn= null;
		
		try {
			conn=DBUtil.getConnection();
			boardDao= new BoardDao();
			lastPage=boardDao.countBoard(conn, rowPerPage, serachtitle, type);
			conn.commit();
			
		}catch(Exception e) {
			try {
				conn.rollback();
				
			}catch(Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return lastPage;
	}
	
	public int insertBoard(Board board) {
		
		int result=0;
		Connection conn= null;
		
		try {
			
			conn=DBUtil.getConnection();
			boardDao= new BoardDao();
			result= boardDao.insertBoard(conn, board);
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
	public Board boardOne(int boardNo) {
		Board b = new Board();
		Connection conn= null;
		
		try {
			conn=DBUtil.getConnection();
			boardDao=new BoardDao();
			b= boardDao.boardOneValues(conn, boardNo);
			
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
		
		return b;
	}
	
	public int updateBoard(Board b) {
		int result = 0;
		Connection conn = null;
		try {
			conn=DBUtil.getConnection();
			boardDao=new BoardDao();
			result=boardDao.updateBoardMatchId(conn, b);
			
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
	public int deleteBoard(int boardNo) {
		int result=0;
		Connection conn= null;
		try {
			conn = DBUtil.getConnection();
			boardDao= new BoardDao();
			result= boardDao.deleteBoard(conn, boardNo);
			
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
	public int deleteMemberBoardToo(String memberId) {
		int result = 0;
		Connection conn = null;
		try {
			conn=DBUtil.getConnection();
			boardDao= new BoardDao();
			result = boardDao.deleteBoardByMember(conn, memberId);
			
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
	public ArrayList<Board> selectBoardByMember(String memberId){
		ArrayList<Board> list = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
		
			boardDao = new BoardDao();
			list =boardDao.selectBoardByMember(conn, memberId);
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
}

package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;
import service.RecommentService;

/**
 * Servlet implementation class RemoveBoardController
 */
@WebServlet("/RemoveBoardController")
public class RemoveBoardController extends HttpServlet {
	private BoardService boardService;
	private RecommentService reDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//redirect boardList
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		this.boardService= new BoardService();
		this.reDao= new RecommentService();
		
		reDao.deleteRecommentbyBoard(boardNo);
		int result= boardService.deleteBoard(boardNo);
		
		response.sendRedirect(request.getContextPath()+"/BoardListController?result="+result);
		
		
	}


}

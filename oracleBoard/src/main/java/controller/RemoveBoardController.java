package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;

/**
 * Servlet implementation class RemoveBoardController
 */
@WebServlet("/RemoveBoardController")
public class RemoveBoardController extends HttpServlet {
	private BoardService boardService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//redirect boardList
		int boardNo = Integer.parseInt("boardNo");
		this.boardService= new BoardService();
		int result= boardService.deleteBoard(boardNo);
		
		response.sendRedirect(request.getContextPath()+"/BoardListController?result="+result);
		
		
	}


}

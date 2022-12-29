package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.BoardService;
import vo.Board;
import vo.Member;

/**
 * Servlet implementation class ModifiyBoardController
 */
@WebServlet("/ModifiyBoardController")
public class ModifiyBoardController extends HttpServlet {
	private BoardService boardService;
	//form
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		if(loginMember == null) {
			response.sendRedirect(request.getContextPath()+"/LoginController");
			return;
		}
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		this.boardService=new BoardService();
		Board board = boardService.boardOne(boardNo);
		
		request.setAttribute("b", board);
		
		request.getRequestDispatcher("/WEB-INF/view/board/updateBoard.jsp").forward(request, response);
	}

	//action
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String boardTitle=request.getParameter("boardTitle");
		String boardContent=request.getParameter("boardContent");
		Board b = new Board();
		b.setBoardNo(boardNo);
		b.setBoardContent(boardContent);
		b.setBoardTitle(boardTitle);
		
		this.boardService= new BoardService();
		
		int result= boardService.updateBoard(b);
		
		
		response.sendRedirect(request.getContextPath()+"/BoardListController?result="+result);
		
	}

}

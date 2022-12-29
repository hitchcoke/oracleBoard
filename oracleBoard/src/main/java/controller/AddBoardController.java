package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class AddBoardController
 */
@WebServlet("/AddBoardController")
public class AddBoardController extends HttpServlet {
	private BoardService boardService;
	//글쓰기폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		if(loginMember == null) {
			response.sendRedirect(request.getContextPath()+"/LoginController");
			return;
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/board/insertBoard.jsp");
		rd.forward(request, response);
	}
	//글쓰기action
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		if(loginMember == null) {
			response.sendRedirect(request.getContextPath()+"/LoginController");
			return;
		}
		
		
		this.boardService= new BoardService();
		String boardtitle= request.getParameter("boardTitle");
		String boardcontent= request.getParameter("boardContent");
		
		Board b = new Board();
		b.setBoardContent(boardcontent);
		b.setBoardTitle(boardtitle);
		b.setMemberId(loginMember.getMemberId());	
		System.out.print(b.getBoardTitle());
		System.out.print(b.getBoardContent());
		System.out.println(b.getMemberId());
		
		int result = boardService.insertBoard(b);
		
		response.sendRedirect(request.getContextPath()+"/BoardListController?result="+result);
	}

}

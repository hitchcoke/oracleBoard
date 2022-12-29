package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.BoardService;
import service.RecommentService;
import vo.Board;
import vo.Member;
import vo.Recomment;

/**
 * Servlet implementation class BoardOneController
 */
@WebServlet("/BoardOneController")
public class BoardOneController extends HttpServlet {
	private BoardService boardService;
	private RecommentService reDao;
	//board 상세보기
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//수정 삭제
		//1 글수정(로그인멤버==글쓴멤버)
		//2 글삭제(로그인멤버==글쓴멤버)
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		if(loginMember == null) {
			response.sendRedirect(request.getContextPath()+"/LoginController");
			return;
		}
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		this.reDao = new RecommentService();
		ArrayList<Recomment> list = reDao.getRecommentbyBoard(boardNo);
		
		this.boardService = new BoardService();
		Board b = boardService.boardOne(boardNo);
		
		int result = 0;
		
		if(loginMember.getMemberId().equals(b.getMemberId())) {
			result= 1;
		}
		request.setAttribute("board", b);
		request.setAttribute("result", result);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/view/board/boardOne.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
}

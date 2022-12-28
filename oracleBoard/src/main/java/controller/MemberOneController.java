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
import vo.Board;
import vo.Member;

/**
 * Servlet implementation class GetMemberController
 */
@WebServlet("/MemberOneController")
public class MemberOneController extends HttpServlet {
	private BoardService boardService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		if(loginMember == null) {
			response.sendRedirect(request.getContextPath()+"/LoginController");
			return;
		}
		this.boardService =new BoardService();
		ArrayList<Board> list = boardService.selectBoardByMember(loginMember.getMemberId());
		request.setAttribute("boardList", list);
		
		/*
		 * view
		 * 메뉴구성
		 * */
		request.getRequestDispatcher("/WEB-INF/view/member/memberOne.jsp").forward(request, response);
	}


}

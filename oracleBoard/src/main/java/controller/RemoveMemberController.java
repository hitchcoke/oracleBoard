package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.BoardService;
import service.MemberService;
import vo.Member;

/**
 * Servlet implementation class RemoveMemberController
 */
@WebServlet("/RemoveMemberController")
public class RemoveMemberController extends HttpServlet {
	private BoardService boardService;
	private MemberService memberService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		if(loginMember == null) {
			response.sendRedirect(request.getContextPath()+"/LoginController");
			return;
		}
		
		if(request.getParameter("msg")!=null) {
			String msg= "아이디비밀번호를 확인하세요";
			request.setAttribute("mg", msg);
		}
		request.getRequestDispatcher("/WEB-INF/view/member/deleteMember.jsp").forward(request, response);
		//view
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//redierct -> get방식/ member/logout
		String memberId= request.getParameter("memberId");
		String memberPw= request.getParameter("memberPw");
		
		Member m = new Member();
		m.setMemberId(memberId);
		m.setMemberPw(memberPw);
		this.boardService= new BoardService();
		this.memberService= new MemberService();
		int result= memberService.deleteMember(m);
		
		if(result == 1) {
			memberService.deleteMember(m);
			boardService.deleteMemberBoardToo(m.getMemberId());
			response.sendRedirect(request.getContextPath()+"/LogoutController");
			
		}else {
			int msg= 1;
			response.sendRedirect(request.getContextPath()+"/RemoveMemberController?msg="+msg);
		}
		
		
	}

}

package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberService;
import vo.Member;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private MemberService memberService;
       
   //로그인 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		if(loginMember != null) {
			response.sendRedirect(request.getContextPath()+"/HomeController");
			return;
		}
		request.getRequestDispatcher("/WEB-INF/view/member/login.jsp").forward(request, response);
	}

	//로그인 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String memberId= request.getParameter("memberId");
		String memberPw= request.getParameter("memberPw");
		Member m = new Member();
		
		m.setMemberId(memberId);
		m.setMemberPw(memberPw);
		this.memberService= new MemberService();
		
		Member resultm = memberService.loginAction(m);
		if(resultm != null) {
			request.getSession().setAttribute("loginMember", resultm);
			response.sendRedirect(request.getContextPath()+"/HomeController");
		}else {
			response.sendRedirect(request.getContextPath()+"/LoginController");
		}
		
		
	}

}

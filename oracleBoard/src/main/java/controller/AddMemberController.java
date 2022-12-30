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
import service.MemberService;
import vo.Board;
import vo.Member;

/**
 * Servlet implementation class AddMemberController
 */
@WebServlet("/AddMemberController")
public class AddMemberController extends HttpServlet {
	private MemberService memberService;
	//회원가입 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		if(loginMember != null) {
			response.sendRedirect(request.getContextPath()+"/HomeController");
			return;
		}
		int msg=0;
		if(request.getParameter("msg")!=null) {
			msg= Integer.parseInt(request.getParameter("msg"));
		}
		request.setAttribute("msg", msg);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/member/insertMember.jsp");
		rd.forward(request, response);
	}

	//회원가입 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		if(loginMember != null) {
			response.sendRedirect(request.getContextPath()+"/HomeController");
			return;
		}
		String memberId =request.getParameter("memberId");
		String memberPw =request.getParameter("memberPw");
		String memberName=request.getParameter("memberName");
		
		this.memberService= new MemberService();
		Member m = new Member();
		
		m.setMemberId(memberId);
		m.setMemberName(memberName);
		m.setMemberPw(memberPw);
		
		int result= memberService.memberidck(memberId);
		
		if(result==0) {
			int row = memberService.insertMember(m);
			System.out.println(result);
			System.out.println("row"+row);
			response.sendRedirect(request.getContextPath()+"/LoginController");
			
		}else {
			int msg= 1;
			response.sendRedirect(request.getContextPath()+"/AddMemberController?msg="+msg);
		}
		
		
		
		
	}

}

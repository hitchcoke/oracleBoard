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
 * Servlet implementation class ModifyMemberController
 */
@WebServlet("/ModifyMemberController")
public class ModifyMemberController extends HttpServlet {
	private MemberService memberService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		if(loginMember == null) {
			response.sendRedirect(request.getContextPath()+"/LoginController");
			return;
		}
		request.getRequestDispatcher("/WEB-INF/view/member/updateMember.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//redirect MemberOne 
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		String memberName= request.getParameter("memberName");
		this.memberService = new MemberService();
		loginMember.setMemberName(memberName);
		
		memberService.updateMember(loginMember.getMemberId(), memberName);
		
		request.getSession().setAttribute("loginMember", loginMember);
		response.sendRedirect(request.getContextPath()+"/MemberOneController");
		
	}

}

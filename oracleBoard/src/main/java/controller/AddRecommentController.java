package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.RecommentService;
import vo.Member;
import vo.Recomment;

/**
 * Servlet implementation class AddRecommentController
 */
@WebServlet("/AddRecommentController")
public class AddRecommentController extends HttpServlet {
	private RecommentService reDao;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		if(loginMember == null) {
			response.sendRedirect(request.getContextPath()+"/LoginController");
			return;
		}
		String recommentContent= request.getParameter("recommentContent");
		int boardNo=Integer.parseInt(request.getParameter("boardNo"));
		
		this.reDao= new RecommentService();
		Recomment re= new Recomment();
		re.setBoardNo(boardNo);
		re.setMemberId(loginMember.getMemberId());
		re.setRecommentContent(recommentContent);
		
		int result= reDao.insertRecomment(re);
		
		if(result==0) {
			
			response.sendRedirect(request.getContextPath()+"/BoardOneController?boardNo="+boardNo+"&result="+result);
			return;
		}
		response.sendRedirect(request.getContextPath()+"/BoardOneController?boardNo="+boardNo);
	}

}

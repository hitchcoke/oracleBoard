package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.RecommentService;

/**
 * Servlet implementation class RemoveRecommentController
 */
@WebServlet("/RemoveRecommentController")
public class RemoveRecommentController extends HttpServlet {
	private RecommentService reDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int recommentNo = Integer.parseInt(request.getParameter("recommentNo"));
		this.reDao= new RecommentService();
		int boardNo=Integer.parseInt(request.getParameter("boardNo"));
		int result= reDao.deleteRecomment(recommentNo);
		
		response.sendRedirect(request.getContextPath()+"/BoardOneController?result="+result+"&boardNo="+boardNo);
	}


}

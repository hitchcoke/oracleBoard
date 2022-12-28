package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardOneController
 */
@WebServlet("/BoardOneController")
public class BoardOneController extends HttpServlet {
	//board 상세보기
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//수정 삭제
		//1 글수정(로그인멤버==글쓴멤버)
		//2 글삭제(로그인멤버==글쓴멤버)
	}

	
}

package edu.kh.project.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/logout")
public class LogoutController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// a태그로 요청했기 때문에 doGet메서드 오버라이딩
		
		// HttpSession을 얻어와 
		HttpSession session = req.getSession();
	
		// Session을 무효화하고
		session.invalidate();
		
		// 메인 페이지를 재요청(redirect)
		resp.sendRedirect("/");
	}
	

}

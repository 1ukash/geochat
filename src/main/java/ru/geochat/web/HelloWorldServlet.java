package ru.geochat.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HelloWorldServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		String header1 = req.getHeader("Content-Type");
		req.getRequestDispatcher("/hello.jsp").forward(req, resp);
//		resp.getOutputStream().write("<h1>hello</h1>".getBytes());
	}
	
}
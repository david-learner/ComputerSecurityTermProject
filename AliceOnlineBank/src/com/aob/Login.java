package com.aob;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		String memberFile = "E:\\Dev\\jeeWorkspace\\AliceOnlineBank\\WebContent\\database\\member.txt";
		System.out.println("doPost-Login");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		int i = 0;
		boolean loginOk = false; //로그인이 성공하면 값을 true로.
		String temp = null; //id, pwd 체크할 수 있게 ArrayList에서 id, pwd를 뽑아서 임시로 저장할 변수
		List<String> members = new ArrayList<>();
		for(String line : Files.readAllLines(Paths.get(memberFile))) {
			for(String part : line.split("\\t+")) {
				members.add(part);
				//System.out.println(members.get(i));
			}
		}
		
		
		
		for(i=1;i<members.size();i=i+5)
		{
			temp = members.get(i);
			if(id.equals(temp))
			{	
				System.out.println("login Success - id matched");
				temp = members.get(i+1);
				if(pwd.equals(temp))
				{
					//로그인 성공
					System.out.println("login Success - pwd matched");
					System.out.println("Login OK");
					loginOk = true;
					break;
				}else {
					//로그인 실패
					System.out.println("login fail - pwd not matched");
					//response.sendRedirect("Main.jsp");
					//return; 
					//return;을 써주지 않으면 response.sendRedirect에서 오류가 난다.
					//참고 - http://didiroro.tistory.com/6
				}
			}else {
				//로그인 실패
				System.out.println("login fail - id not matched");
			}
		}
		
		if(loginOk)
		{
			HttpSession session = request.getSession();
			session.setAttribute("id", id); //session에 "id"란 이름에 id를 담는다.
			response.sendRedirect("Menu.jsp");
			System.out.println("login complete");
		}
		
	}

}

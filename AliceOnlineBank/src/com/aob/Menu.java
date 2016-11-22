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
 * Servlet implementation class Menu
 */
@WebServlet("/Menu")
public class Menu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Menu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		//String check = request.getParameter("submitType");
		String check = "deposit";

		System.out.println("doPost");
		System.out.println(check);
		String balance = null;
		
		if(check.equals("deposit")) //submitType이 deposit이면 money에 deposit 금액 담기.
		{
			String money = request.getParameter("deposit");
			System.out.println(money);
			balance = doDeposit(request, response, money);
			request.setAttribute("balance", balance);
			request.getRequestDispatcher("Menu.jsp").forward(request, response);
		}else {
			String money = request.getParameter("withdrawal");
			balance = doWithdrawal(request, response, money);
			request.setAttribute("balance", balance);
			request.getRequestDispatcher("Menu.jsp").forward(request, response);
		}
		
		
		
		
	}
	
	protected String doDeposit(HttpServletRequest request, HttpServletResponse response, String money) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String memberFile = "E:\\Dev\\jeeWorkspace\\AliceOnlineBank\\WebContent\\database\\member.txt";

		List<String> members = new ArrayList<>();
		for(String line : Files.readAllLines(Paths.get(memberFile))) {
			for(String part : line.split("\\t+")) {
				members.add(part);
			}
		}
		
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");	//session의 "id"를 불러와서 id에 담는다. 
		String balance = null;
		int sum = 0;
		
		for(int i=1;i<members.size();i=i+5)
		{
			if(members.get(i).equals(id)){
				balance = members.get(i+3);
				System.out.println(balance);
				sum = Integer.parseInt(balance) + Integer.parseInt(money);
				members.set(i+3, Integer.toString(sum));
				System.out.println("saveOK");
				break;
			}
		}
		
		return Integer.toString(sum);
	}
	
	protected String doWithdrawal(HttpServletRequest request, HttpServletResponse response, String money) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String memberFile = "E:\\Dev\\jeeWorkspace\\AliceOnlineBank\\WebContent\\database\\member.txt";

		List<String> members = new ArrayList<>();
		for(String line : Files.readAllLines(Paths.get(memberFile))) {
			for(String part : line.split("\\t+")) {
				members.add(part);
			}
		}
		
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");	//session의 "id"를 불러와서 id에 담는다. 
		String balance = null;
		int sum = 0;
		
		for(int i=1;i<members.size();i=i+5)
		{
			if(members.get(i).equals(id)){
				balance = members.get(i+3);
				if(Integer.parseInt(balance)<Integer.parseInt(money)){
					System.out.println("money over balance"); break;
				}
				sum = Integer.parseInt(balance) - Integer.parseInt(money);
				members.set(i+3, Integer.toString(sum));
				break;
			}
		}
		
		return Integer.toString(sum);
	}

}

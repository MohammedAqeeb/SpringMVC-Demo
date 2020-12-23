package com.mitra.mvc;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

/**
 * Servlet implementation class ControlServlet
 */
public class ControlServlet extends HttpServlet {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlServlet() {
        super();
        System.out.println("In CS()");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In CS() of doGet()");
		process(request,response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In CS() of Process()");
		
		String uri=request.getRequestURI();
		
		System.out.println("uri"+uri);
		
		RequestDispatcher rd=null;
		
		ModelControl mc=new ModelControl();
			//Open Register
		if(uri.contains("/OpenRegister.do"))
		{
			rd= request.getRequestDispatcher("Register.jsp");
			rd.forward(request, response);
		}
			
				//Open Login
		if(uri.contains("/OpenLogin.do"))
		{
			rd= request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
		
			//LOGIN 
		if(uri.contains("/login.do"))
		{
			System.out.println("In CS--->Process()--Login.do");
			LoginBean bean=(LoginBean)request.getAttribute("log");
			System.out.println("bean="+bean);
			
			String result=mc.authenticate(bean);
			if(result.equals(Constants.SUCCESS))
			{
				HttpSession session=request.getSession(true);
				session.setAttribute("user", bean.getEmail());
				rd=request.getRequestDispatcher("menu.jsp");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("errorMSG", result);
				rd=request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			}
			
		}
		
		if(uri.contains("register.do"))
		{
			System.out.println("in process()-> within regbean");
		  
			RegBean bean=(RegBean)request.getAttribute("reg");
			System.out.println("Bean()="+bean);
			
			
			String result=mc.Register(bean);
			
			if(result.equals("SUCCESS"))
			{
				rd=request.getRequestDispatcher("Regdone.jsp");
				rd.forward(request, response);
				request.setAttribute("messg", "USER REGISTERED SUCCESSFULLY");
				
			}
			else
			{
				request.setAttribute("errormsg", result);
				rd=request.getRequestDispatcher("Register.jsp");
				rd.forward(request, response);
				
			}
			
		}
		
	}
			
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In CS() of doPost()");
		process(request,response);
	}

}

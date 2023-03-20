package com.ssafy.basic;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycle
 */
@WebServlet("/life")
public class LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LifeCycle() {
        super();
        System.out.println("Constructor call!!!!!!!!!!!");
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Service call!!!!!!!!!!!");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("Destroy call!!!!!!!!!!!");
	}


	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		System.out.println("init call!!!!!!!!!!!");
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

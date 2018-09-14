package com.ibm.timetable;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Result
 */
@WebServlet("/Result")
public class Result extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Result() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String text=request.getParameter("text");
		//response.getWriter().append(text);
		HttpSession session=request.getSession();
		session.setAttribute("subject",text);
		HttpSession httpSession = request.getSession(false); 
		String week = null;
		String trainer = null;
		String subject = null;
		if(httpSession != null){
		    week = (String) httpSession.getAttribute("week");
		    trainer = (String) httpSession.getAttribute("text");
		    subject = (String) httpSession.getAttribute("subject");
		}
		String[] string=week.split(",");
		//response.getWriter().append(string[0]+" "+string[1]+" "+trainer+" "+subject);
		Double time1 = Double.parseDouble(string[0]);
		//response.getWriter().append("Time"+time);
		Crud c=new Crud();
		try {
			c.Update(trainer,subject,time1,string[1]);
		    List<TimeTable> time = c.fetchtime();
		    request.setAttribute("time", time);
			request.getRequestDispatcher("WEB-INF/view/table.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

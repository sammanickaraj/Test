

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Submit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String fname;
	String lname;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		fname = request.getParameter("firstname");
		lname = request.getParameter("lastname");
		System.out.println(fname);
		System.out.println(lname);
		
	}

}

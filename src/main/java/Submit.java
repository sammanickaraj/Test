import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class Submit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String fname;
	public static String lname;
	public static String Age;
	public static int newAge;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fname = request.getParameter("firstname");
		lname = request.getParameter("lastname");
		Age = request.getParameter("Age");
		newAge = Integer.parseInt(Age);
		System.out.println(fname);
		System.out.println(lname);
		System.out.println(newAge);
		try {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("<html><body>");
			out.println("<h3>Registration complete with below details</h3><br>"+
						"First Name is: "+fname+"<br>"+
						"Last Name is: "+lname+"<br>"+
						"Age is: "+newAge+"<br>");
			out.println("<p>Click the link to go back to Registration page</p><a href=\"http://localhost:8080/NewApp\">Registration Page</a><br>");
//			out.println("<br/>Added "+fname+" to database");
//			out.println("</body></html>");
			updateTable(out);
			out.println("</body></html>");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void updateTable(PrintWriter obj) throws Exception{
		try {
			Connection con = getConnection();
			PreparedStatement create = con.prepareStatement("INSERT INTO Persons (FirstName,LastName,Age) "+"VALUES('"+fname+"', '"+lname+"', '"+newAge+"');");
			create.executeUpdate();
                        obj.println("<br/>Added "+fname+" to database");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("Function Complete");
		}
	}
	
	public static Connection getConnection() throws Exception {
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/testdb";
			String dbName = "root";
			String dbPass = "Superman@9";
			Class.forName(driver);		
			Connection conn = DriverManager.getConnection(url, dbName, dbPass);
			System.out.println("Connected");
			return conn;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}

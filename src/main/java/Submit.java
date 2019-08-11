import java.io.IOException;
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
			updateTable();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void updateTable() throws Exception{
		try {
			Connection con = getConnection();
			PreparedStatement create = con.prepareStatement("INSERT INTO Persons (FirstName,LastName,Age) "+"VALUES('"+fname+"', '"+lname+"', '"+newAge+"');");
			create.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("Function Complete");
		}
	}
	
	public static Connection getConnection() throws Exception {
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://192.168.0.105:3306/testdb";
			String dbName = "root";
			String dbPass = "root";
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

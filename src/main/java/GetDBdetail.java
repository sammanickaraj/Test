

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class GetDBdetail extends HttpServlet {
	PrintWriter out = null;
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		out=response.getWriter();

		try {
			
			Connection con = getConnection();
			String query = "SELECT * FROM Persons";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			String str = "<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"<head>\r\n" + 
					"<style>\r\n" + 
					"table {\r\n" + 
					"  font-family: arial, sans-serif;\r\n" + 
					"  border-collapse: collapse;\r\n" + 
					"  width: 100%;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"td, th {\r\n" + 
					"  border: 1px solid #dddddd;\r\n" + 
					"  text-align: left;\r\n" + 
					"  padding: 8px;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"tr:nth-child(even) {\r\n" + 
					"  background-color: #dddddd;\r\n" + 
					"}\r\n" + 
					"</style>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"\r\n" + 
					"<h2>User List from Database</h2>\r\n" + 
					"\r\n" + 
					"<table>\r\n" + 
					"  <tr>\r\n" + 
					"    <th>ID</th>\r\n" + 
					"    <th>FirstName</th>\r\n" + 
					"    <th>LastName</th>\r\n" +
					"	 <th>Age</th>\r\n" +
					"  </tr>";
			while (rs.next())
		      {
		        int id = rs.getInt("id");
		        String firstName = rs.getString("FirstName");
		        String lastName = rs.getString("LastName");
		        String Age = rs.getString("Age");
		        str +="<tr><td>"+id+"</td><td>"+firstName+"</td><td>"+lastName+"</td><td>"+Age+"</td></tr>";
		        }
			
			
			str += "</table>\r\n" + 
					"\r\n" + 
					"</body>\r\n" + 
					"</html>";
			out.println(str);
			st.close();
			
			
			
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
				String dbPass = "";
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

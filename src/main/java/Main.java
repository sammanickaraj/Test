import java.sql.DriverManager;
import java.sql.Connection;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		getConnection();
		
	}
		public static Connection getConnection() throws Exception {
			try {
				String driver = "com.mysql.jdbc.Driver";
				String url = "jdbc:mysql://localhost:3306/testdb";
				String dbName = "root";
				String dbPass = "";
				Class.forName(driver);
				
				Connection conn = DriverManager.getConnection(url,dbName,dbPass);
				System.out.println("Connected");
				return conn;
			} catch (Exception e) {
				System.out.println(e);
			}
			return null;
		}

	}


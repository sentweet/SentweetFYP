package abc;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTextField;
public class dbclass {
	private static String url = "jdbc:mysql://localhost:3306/";
	private static String driverName = "com.mysql.jdbc.Driver";
	private static String username = "root";
	private static String password = "";
	private static Connection con;
	private static String dbName = "sentweet";
	public String s;
	public static Connection getConnection() {
		url += dbName;
		try {
			Class.forName(driverName);
			try {
				con = DriverManager.getConnection(url, username, password);
			} catch (SQLException ex) {
				System.out.println("Failed to create the database connection.");
			}
		} catch (ClassNotFoundException ex) {
			System.out.println("Driver not found.");
		}
		return con;
	}
	public ResultSet select(String query) {
		ResultSet rs = null;
		System.out.println("good db starts");
		try {
			con = getConnection();
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			System.out.println("done db");
		} catch (Exception e) {
		}
		return rs;
	}
	
	public void insert(String s) {
		con = getConnection();
		System.out.println("db started");
		PreparedStatement preparedStmt;
		try {
			preparedStmt = con.prepareStatement(s);
			preparedStmt.execute();
			System.out.println("inserted");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		System.out.println("done");
	}
	public void abc(String a,String b, Long c, String d) throws SQLException
	{
		con = getConnection();
		PreparedStatement pstmt = con.prepareStatement(
				"INSERT INTO `dataset`(`name`, `location`, `tweetid`, `text`) values (?,?,?,?)"	);

				pstmt.setString(1, a); // set parameter 1 (FIRST_NAME)
				pstmt.setString(2, b); // set parameter 2 (ID)
				pstmt.setLong(3, c); // set parameter 1 (FIRST_NAME)
				pstmt.setString(4, d);
				int rows = pstmt.executeUpdate(); 
		
		
		
	}
	public void delete(String text) {
		con = getConnection();
		System.out.println("db started");
		PreparedStatement preparedStmt;
		try {
			preparedStmt = con.prepareStatement(s);
			preparedStmt.execute();
			System.out.println("inserted");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		System.out.println("done");// TODO Auto-generated method stub
	}
}
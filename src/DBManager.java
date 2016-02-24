import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	private String driverName;
	private String url;
	private String dbName;
	private String username;
	private String password;
	/*
	  	DBManager test = new DBManager("com.mysql.jdbc.DriverManager"
									,"jdbc:mysql://127.0.0.1:3306/"
									,"db_hpq","root","fuckmedikotopassword");
	*/
	
	public DBManager(String driverName,String url,String dbName
						,String username,String password) {
		this.driverName = driverName; //com.mysql.jdbc.DriverManager
		this.url = url; //jdbc.mysql://127.0.0.1:3306/
		this.dbName = dbName; //db_hpq
		this.username = username; //root
		this.password = password;
	}

	public Connection getConnection() {
		try {
			return DriverManager.getConnection(url + dbName,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public String getDriverName() {
		return driverName;
	}

	public String getUrl() {
		return url;
	}

	public String getDbName() {
		return dbName;
	}

	public String getUsername() {
		return username;
	}
}

package DB;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	public static String driver;
	public static String dburl;
	public static String dbuser;
	public static String password;
	public static ConnectionFactory factory = null;
	public ConnectionFactory(){
		this.getproperties();
	}
	public void getproperties(){
		Properties prop = new Properties();
		//??????????
		InputStream is = Thread.currentThread().getContextClassLoader()
		.getResourceAsStream("db.properties");
		try {
			prop.load(is);
			this.driver = prop.getProperty("driver");
			this.dburl = prop.getProperty("dburl");
			this.dbuser = prop.getProperty("dbuser");
			this.password = prop.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		Connection conn = null;
		new ConnectionFactory();
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(dburl,dbuser,password);
			//System.out.println("数据库连接成功！");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}

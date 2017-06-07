package sql;
import java.beans.PropertyVetoException;
import java.beans.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Time;

import java.sql.Connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class ConnectionPool {
	private static ComboPooledDataSource cpd = null;
//	 String className = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//	 String url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=NewCentury";
//	  String user = "sa";
//	  String password = "IBMSsmarthome";
	 String className ="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/wia-pa";
	 String user="root";
	 String password="123456";		
	
   private ConnectionPool(){
	   cpd = new ComboPooledDataSource();
	   cpd.setUser(user);
	   cpd.setPassword(password);
	   cpd.setJdbcUrl(url);
	   try {
		cpd.setDriverClass(className);
	} catch (PropertyVetoException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   //设置连接池
	cpd.setInitialPoolSize(20);
	cpd.setMaxPoolSize(10);
	cpd.setMinPoolSize(5);
   }
   
   private static ConnectionPool instance = null;
   public synchronized static ConnectionPool getInstance(){
	   if(instance == null){
		    instance = new ConnectionPool();
	   }
	return instance;
   }
  
  
   
   public Connection getConnection() throws SQLException{
	 
	return cpd.getConnection();
   }
	public static void main(String[] args) throws Exception{
		long begin = System.currentTimeMillis();//系统初始化之后的时间，为当前系统时间转换为毫秒
		System.out.println("当前时间："+begin+"毫秒");
		for (int i = 0; i < 100; i++){//通过数据库连接池，请求100次数据库连接
 		Connection conn = ConnectionPool.getInstance().getConnection();
 		conn.close();
		}
		long end = System.currentTimeMillis();//连接请求结束时间，转换为毫秒
		System.out.println("结束时间："+end+"毫秒");
		//结束时间减去开始时间，为请求响应时间
		System.out.println("通过数据库连接池，100次连接请求耗时："+(end - begin)+"毫秒");}}
	








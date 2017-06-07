package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBUtil {

	
public Connection getConnection(){
		
		//设置连接的数据库‘用户名和密码
		 String url="jdbc:mysql://localhost:3306/cn_sk";
		 String username="root";
		 String password="123456";		
		try {
			Class.forName("com.mysql.jdbc.Driver");		//打开驱动	??	可否用此打开一个类
			return  DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();	
			} catch (SQLException e) {
			e.printStackTrace();
		}	
		return null;
	}
	
	//关闭数据库*******************************************************************************************
	public void closeConnection(Connection conn){		
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//更新数据库表中内容*********************************************************************************
	public void update(String table,String device,String data) { // 更新表()中的哪一个传感器的值和当时间
		DBUtil util = new DBUtil();
		Connection conn = util.getConnection();

		String sql = "update "+table+" set " + device + "=" + data;
		
		try {
			conn.setAutoCommit(false); // 自动提交关闭
			Statement stmt = conn.createStatement();

			stmt.executeUpdate(sql); // 执行SQL语句
			
			conn.commit(); // 提交
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback(); // 回滚到之间的状态
			} catch (SQLException e1) {

				e1.printStackTrace();
			} finally {
				util.closeConnection(conn);
			}
		}

	}

	//实时存储数据库表ub中内容*********************************************************************************	
	
/*	
	public boolean insert_ub(String table, String device){
		DBUtil util = new DBUtil();
		Connection conn = util.getConnection();
		ResultSet rs = null;
		boolean ss = false;
		//String queryrs2 = null;
		try {	
			String sql = "insert into vote_vote(uid, ip, votedate) values ('" + uid + "','" + ip + "','" + new java.sql.Date(System.currentTimeMillis()) + "')";;		
			//String sql="select*from StuTbl where id=4;"
			Statement stmt =conn.createStatement();
			rs=stmt.executeQuery(sql);		//将查找到的结果放入结果集中
			//rs.next();
			boolean flag = false;
			String sql = "insert into vote_vote(uid, ip, votedate) values ('" + uid + "','" + ip + "','" + new java.sql.Date(System.currentTimeMillis()) + "')";
			try {
				controlDB.executeUpdate(sql);
				flag = true;
			} catch (Exception e) {
				e.printStackTrace();
			}

			return flag;
			
			rs.close();			
			conn.close();
			util.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return queryrs;
	}
	*/




public String query(String table, String device){
	DBUtil util = new DBUtil();
	Connection conn = util.getConnection();
	ResultSet rs = null;
	String queryrs = null;
	//String queryrs2 = null;
	try {	
		String sql="select "+device+" from "+table+";";		
		//String sql="select*from StuTbl where id=4;"
		Statement stmt =conn.createStatement();
		rs=stmt.executeQuery(sql);		//将查找到的结果放入结果集中
		//rs.next();
		while(rs.next()){		//	查找指定设备那一列最新的值和日期
			 queryrs=rs.getString(device);
			 //queryrs2=rs.getString(timer);
			 //qd.setQuerydate(rs.getString(device));
			 //qd.setQuerytime(rs.getString(timer));
			}
		
		//System.err.println(qd.getQuerydate());
		//System.err.println(queryrs);
		rs.close();			
		conn.close();
		util.closeConnection(conn);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return queryrs;
}
}
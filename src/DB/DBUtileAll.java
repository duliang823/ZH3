package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DBUtileAll {
	public static void main(String[] args) {
		DBUtileAll DBall=new DBUtileAll();
		ArrayList<String[]> list = new ArrayList<String[]>();
		list=DBall.qurey();
		String[] i=list.get(0);			//得到list中list[0]及temperature[]数组；
		for(String j:i){				//遍历temperature[]数组
			System.out.println(j);
		}

		
	}
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
	//向数据库表中增加传感器数据*********************************************************************************
	public boolean insert(String temp,String humidity,String infrared,String smoke) { // 更新表()中的哪一个传感器的值和当时间
		
		DBUtil util = new DBUtil();
		Connection conn = util.getConnection();
		ResultSet rs = null;
		
		 int maxId=0;
		  String sql1="select max(id) as maxId from sensor";
		try {
			conn.setAutoCommit(false); // 自动提交关闭
			Statement stmt = conn.createStatement();
			
		  rs=stmt.executeQuery(sql1);
		 
		  if(rs.next()){
			maxId=rs.getInt("maxId");
		  }
		  Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String da = sdf.format(date);
		/////   String sql = "insert into sensor(id,time,temp,humidity,infrared,smoke)values('"
		////		+(++maxId)+"',to_date('"+da+"','yyyy-mm-dd hh24:mi:ss'),'"+temp+"',,'"+humidity+"'," +
		///				"'"+infrared+"','"+smoke+"')";
		//String sql = "insert into sensor values('"+ now() +"'=" + data+","+timer+"=now() where id="+id+";");
		String sql = "insert into sensor(id,time,temp,humidity,infrared,smoke)values(?,?,?,?,?,?)";
		   PreparedStatement ps=conn.prepareStatement(sql);
		   
           ps.setInt(1, maxId);
           ps.setString(2, da);
           ps.setString(3, temp);
           ps.setString(4, humidity);
           ps.setString(5, infrared);
           ps.setString(6, smoke);
           
           int result=ps.executeUpdate();
           //ps.executeUpdate();无法判断是否已经插入
           if(result>0)
               return true;
         
		   
		   
		   
		   
//			stmt.executeUpdate(sql); // 执行SQL语句
//			
//			conn.commit(); // 提交
//			conn.close();
///			return true;
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
		return false;

	}
	
	

	//向数据库表中添加内容*********************************************************************************
	public void update(String item,int id,String data) { // 更新表()中的哪一个传感器的值和当时间
		DBUtil util = new DBUtil();
		Connection conn = util.getConnection();

		String sql = "update en_tabal set " + item + "=" + data+" where id="+id+";";
		
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
	
/*	
	//向数据库表中添加内容*********************************************************************************
	public void update(String device,String timer,int id,String data) { // 更新表()中的哪一个传感器的值和当时间
		DBUtil util = new DBUtil();
		Connection conn = util.getConnection();

		String sql = "update wia_pa set " + device + "=" + data+","+timer+"=now() where id="+id+";";
		
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
	
	*/
	public String query(String device,int id){
		DBUtil util = new DBUtil();
		Connection conn = util.getConnection();
		ResultSet rs = null;
		String queryrs = null;
		//String queryrs2 = null;
		try {	
			String sql="select "+device+" from wia_pa where id ="+id+";";		
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
	@SuppressWarnings("null")
	public ArrayList<String[]> qurey(){
		DBUtil util = new DBUtil();
		Connection conn = util.getConnection();
		ResultSet rs = null;
		ArrayList<String[]> list = new ArrayList<String[]>();

		try {	
			String sql="select*from en_tabal;";		
			Statement stmt =conn.createStatement();
			rs=stmt.executeQuery(sql);		//将查找到的结果放入结果集中	
			
			String i[] = new String[9];
			String v[] = new String[9];
			String w[] = new String[9];
			String kwh[] = new String[9];
			String tag[] = new String[9];
			
			
			int j=0;
			while(rs.next()){	
				/*******将查询到的值分别出入对应的数组  9类数据**********/
				i[j]=rs.getString("i");
				v[j]=rs.getString("v");
				w[j]=rs.getString("w");
				kwh[j]=rs.getString("kwh");
				tag[j]=rs.getString("tag");
								
				j++;
				}
			/*******将数组存入集合中**********/
			list.add(i);
			list.add(v);
			list.add(w);
			list.add(kwh);
			list.add(tag);
			
			rs.close();	
			conn.close();
			util.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
}

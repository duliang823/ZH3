package modelImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Query;
import sql.ConnectionPool;



public class QueryImpl   {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static   ArrayList<Query>  queryAll(String sql) {
		
		Connection conn = null;
		try {
			conn = ConnectionPool.getInstance().getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Query> retList = new ArrayList();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				Query model = new Query(rs.getInt("id"), rs.getString("name"), rs.getString("value"), rs.getString("time"));
			retList.add(model);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return retList;
	}
	public static void main(String[] args) {
//		String str = "select * from 中控室 ";
		String room = "中控室";
		String time1 = "2015-05-28 11:31:59";
		String time2 = "2015-05-30 11:31:59";
		String value = "37.55";
		String name = "烟雾4";
		String sqlString = "select * from 中控室  where name='"+name+"' and time > '"+time1+"'and time <'"+time2+"'";
		System.out.println(sqlString);
		/*
		System.out.println(sqlString);
		ArrayList<Query> list = QueryImpl.queryAll(sqlString);
		System.out.println(list.size());
		for(int i=0; i<list.size(); i++ ){
		Query model = (Query)list.get(i);
		System.out.println("ID号："+model.getId());
		System.out.println("名字："+model.getName());
		System.out.println("时间："+model.getTime());
		System.out.println("数据："+model.getValue());
		}*/
		
//		String sql = "insert into "+room+"(name,value,time) value('"+name+"','"+value+"','"+time1+"')";
		String sql = "delete from "+room+" where time1>'"+50+"'and time2<'"+10004+"'";
		
				System.out.println(sql);
				Connection conn = null;
				Statement stmt = null;
				try {
				 conn = ConnectionPool.getInstance().getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				 stmt = conn.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
//				for (int i = 0; i < 1; i++) {
					stmt.executeUpdate(sql);
					System.out.println("执行删除成功");
//				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("执行插入成功!!!!");
	}
}

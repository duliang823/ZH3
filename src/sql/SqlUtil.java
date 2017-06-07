package sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.org.apache.bcel.internal.generic.Select;
import com.sun.swing.internal.plaf.metal.resources.metal;

public class SqlUtil {
	
	
	/**
	 * 删除给定日期区间的数据
	 * @param room
	 * @param time1
	 * @param time2
	 */
	public void delete(String room,String name,String time1,String time2) {
		Connection conn = null;
		Statement stmt = null;
		String deleteSql = "delete from "+room+" where name='"+name+"' and time>'"+time1+"'and time<'"+time2+"'";
		System.out.println(deleteSql);
		try {
			conn = ConnectionPool.getInstance().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(deleteSql);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		finally {
			try {
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}}}
	public static void main(String[] args) {
		String room = "中控室";
		SqlUtil su = new SqlUtil();
		String time1 = "2015-05-29";
		String time2 = "2015-06-01";
		String name = "烟雾2";
		su.delete(room, name ,time1, time2);
	}
}

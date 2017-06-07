package com.ub.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;



import com.ub.beans.Sensor;
import com.ub.beans.Ub;
import com.ub.beans.Ub1;
import com.ub.beans.Ub2;
import com.ub.beans.Ub3;
import com.ub.dao.UbDao;

import DB.ConnectionFactory;
import DB.ControlDB;
import DB.DBUtil;
public class UbDaoImpl implements UbDao{
	
	ControlDB controlDB = null;

	public UbDaoImpl() {
		controlDB = new ControlDB();
	}
	
public boolean insertUb(Ub ub) {
		

		boolean flag = false;
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs=null;
		try {
			con = ConnectionFactory.getConnection();
			stmt = con.createStatement();
		  int maxId=0;
		  String sql1="select max(id) as maxId from ub";
		
		  rs=stmt.executeQuery(sql1);
		  if(rs.next()){
			maxId=rs.getInt("maxId");
		  }
		  Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String da = sdf.format(date);
//		   String sql = "insert into ub(id,time,temp,humidity,infrared,smoke"
//				+"period,location,device,DI,status) values('"
//				+(++maxId)+"',to_date('"+da+"','yyyy-mm-dd hh24:mi:ss'),'"+ub.getTemp()+"',,'"+ub.getTemp()+"'," +
//						"'"+ub.getHumidity()+"','"+ub.getInfrared()+"','"+ub.getSmoke()+"','"+ub.getPeriod()
//				+"',,'"+ub.getDevice()+"',,'"+ub.getDI()+"','"+ub.getStatus()+"')";
			
		  
			 Calendar c = Calendar.getInstance();
			  c.setTime(sdf.parse(da));
			  int dayForWeek = 0;
			  if(c.get(Calendar.DAY_OF_WEEK) == 1){
			   dayForWeek = 7;
			  }else{
			   dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
			  }
			  //
			  System.out.println(dayForWeek);
		   
			
			
			String sql="insert into ub(id,time,day,temp,humidity,infrared,smoke,period,location,device,DI,status) values" +
					"('"+(++maxId)+"','"+da+"','"+dayForWeek+"','"+ub.getTemp()+"','"+ub.getHumidity()+"','"+ub.getInfrared()+"','"+ub.getSmoke()+"','"+ub.getPeriod()+"','"+ub.getLocation()+"','"+ub.getDevice()+"','"+ub.getDI()+"','"+ub.getStatus()+"')";
		
			controlDB.executeUpdate(sql);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return flag;
		
	}
	
	public boolean insert(Ub ub) {
		
		  DBUtil db=new DBUtil();
			Connection conn=null;
			Statement stat=null;
			ResultSet rs=null;
			try{
				conn=db.getConnection();
				stat=conn.createStatement();
				
				int maxId=0;
				String sql1="select max(id) as maxId from ub";
				rs=stat.executeQuery(sql1);
				if(rs.next()){
					maxId=rs.getInt("maxId");
				}

	   Date date = new Date();
	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   String da = sdf.format(date);
	   String sql = "insert into ub(id,time,temp,humidity,infrared,smoke"
				+"period,location,device,DI,status) values('"
				+(++maxId)+"',to_date('"+da+"','yyyy-mm-dd hh24:mi:ss'),'"+ub.getTemp()+"',,'"+ub.getTemp()+"'," +
				"'"+ub.getHumidity()+"','"+ub.getInfrared()+"','"+ub.getSmoke()+"','"+ub.getPeriod()
				+"',,'"+ub.getDevice()+"',,'"+ub.getDI()+"','"+ub.getStatus()+"')";
				sql=new String(sql.getBytes("ISO8859-1"),"UTF-8");
				stat.addBatch(sql);

				stat.executeBatch();
				return true;
			}catch(SQLException e){
				e.getMessage();
			    return false;
			}catch(Exception e){
				e.getStackTrace();
				return false;
			}finally{
				try {
					if(rs!=null){
						rs.close();
					}
					if(stat!=null){
						stat.close();
					}
					if(conn!=null){
						conn.close();
					}
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
	}

	
	public boolean insertUb1(Ub1 ub1) {
		
		  DBUtil db=new DBUtil();
			Connection conn=null;
			Statement stat=null;
			ResultSet rs=null;
			try{
				conn=db.getConnection();
				stat=conn.createStatement();
				
				int maxId=0;
				String sql1="select max(id) as maxId from ub1";
				rs=stat.executeQuery(sql1);
				if(rs.next()){
					maxId=rs.getInt("maxId");
				}

	   Date date = new Date();
	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   String da = sdf.format(date);
	   String sql = "insert into ub1(id,time,temp,humidity,infrared,smoke"
				+"period,d_status,a_status,f_status,c_status,tv_status) values('"
				+(++maxId)+"',to_date('"+da+"','yyyy-mm-dd hh24:mi:ss'),'"+ub1.getTemp()+"',,'"+ub1.getTemp()+"'," +
				"'"+ub1.getHumidity()+"','"+ub1.getInfrared()+"','"+ub1.getSmoke()+"','"+ub1.getPeriod()
				+"',,'"+ub1.getD_status()+"','"+ub1.getA_status()+"','"+ub1.getF_status()+"','"+ub1.getC_status()+"'," +
						"'"+ub1.getTv_status()+"')";
				sql=new String(sql.getBytes("ISO8859-1"),"UTF-8");
				stat.addBatch(sql);

				stat.executeBatch();
				return true;
			}catch(SQLException e){
				e.getMessage();
			    return false;
			}catch(Exception e){
				e.getStackTrace();
				return false;
			}finally{
				try {
					if(rs!=null){
						rs.close();
					}
					if(stat!=null){
						stat.close();
					}
					if(conn!=null){
						conn.close();
					}
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
	
	}


	public boolean insertUb2(Ub2 ub2) {
	
		  DBUtil db=new DBUtil();
			Connection conn=null;
			Statement stat=null;
			ResultSet rs=null;
			try{
				conn=db.getConnection();
				stat=conn.createStatement();
				
				int maxId=0;
				String sql1="select max(id) as maxId from ub2";
				rs=stat.executeQuery(sql1);
				if(rs.next()){
					maxId=rs.getInt("maxId");
				}

	   Date date = new Date();
	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   String da = sdf.format(date);
	   String sql = "insert into ub2(id,time,temp,humidity,infrared,smoke"
				+"period,d_location,d_status, d_ID,  a_location, a_status, a_ID," +
				" f_location, f_status, f_ID,  c_location, c_status, c_ID ,tv_location," +
				" tv_status, tv_ID) values('"+(++maxId)+"',to_date('"+da+"','yyyy-mm-dd hh24:mi:ss')," +
				"'"+ub2.getTemp()+"','"+ub2.getTemp()+"',"+"'"+ub2.getHumidity()+"'," +
				"'"+ub2.getInfrared()+"','"+ub2.getSmoke()+"','"+ub2.getPeriod()
				+"','"+ub2.getD_location()+"','"+ub2.getD_status()+"','"+ub2.getD_status()+"'," +
				"','"+ub2.getA_location()+"','"+ub2.getA_status()+"','"+ub2.getA_status()+"'," +
				"','"+ub2.getF_location()+"','"+ub2.getF_status()+"','"+ub2.getF_status()+"'," +
				"','"+ub2.getC_location()+"','"+ub2.getC_status()+"','"+ub2.getC_status()+"'," +
				"','"+ub2.getTv_location()+"','"+ub2.getTv_status()+"','"+ub2.getTv_status()+"')";
				sql=new String(sql.getBytes("ISO8859-1"),"UTF-8");
				stat.addBatch(sql);

				stat.executeBatch();
				return true;
			}catch(SQLException e){
				e.getMessage();
			    return false;
			}catch(Exception e){
				e.getStackTrace();
				return false;
			}finally{
				try {
					if(rs!=null){
						rs.close();
					}
					if(stat!=null){
						stat.close();
					}
					if(conn!=null){
						conn.close();
					}
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
	}
//	public static void main(String[] args){
//		Sensor sensor1=new Sensor();
//		Ub ub=new Ub();
//		ub.setTemp(sensor1.getTemp());
//		ub.setHumidity(sensor1.getHumidity());
//		ub.setInfrared(sensor1.getInfrared());
//		ub.setSmoke(sensor1.getSmoke());
//		ub.setPeriod("winter");
//		ub.setLocation("living_room");
//		ub.setDevice("light");
//		ub.setDI("1");
//		ub.setStatus("ON");
//		
//		UbDao u=new UbDaoImpl();
//		
//		if (u.insertUb(ub)) {
//			System.out.println("开灯记录成功");
//		} else {
//			System.out.println("开灯记录失败");
//		}
//	}

	
public boolean insertUb3(Ub3 ub3) {
		
boolean flag = false;
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs=null;
		try {
			con = ConnectionFactory.getConnection();
			stmt = con.createStatement();
		  int maxId=0;
		  String sql1="select max(id) as maxId from ub3";
		
		  rs=stmt.executeQuery(sql1);
		  if(rs.next()){
			maxId=rs.getInt("maxId");
		  }
		  Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String da = sdf.format(date);

		  
			 Calendar c = Calendar.getInstance();
			  c.setTime(sdf.parse(da));
			  int dayForWeek = 0;
			  if(c.get(Calendar.DAY_OF_WEEK) == 1){
			   dayForWeek = 7;
			  }else{
			   dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
			  }
			  //
			  System.out.println(dayForWeek);
		   
			
			
			String sql="insert into ub3(id,time,day,period,location,device,DI,status) values" +
					"('"+(++maxId)+"','"+da+"','"+dayForWeek+"','"+ub3.getPeriod()+"','"+ub3.getLocation()+"','"+ub3.getDevice()+"','"+ub3.getDI()+"','"+ub3.getStatus()+"')";
		
			controlDB.executeUpdate(sql);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return flag;
	}


public boolean insertSensor(Sensor s) {
	
	boolean flag = false;
			
			Connection con = null;
			Statement stmt = null;
			ResultSet rs=null;
			try {
				con = ConnectionFactory.getConnection();
				stmt = con.createStatement();
			  int maxId=0;
			  String sql1="select max(id) as maxId from sensor";
			
			  rs=stmt.executeQuery(sql1);
			  if(rs.next()){
				maxId=rs.getInt("maxId");
			  }
			  Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String da = sdf.format(date);

			  
				 Calendar c = Calendar.getInstance();
				  c.setTime(sdf.parse(da));
				  int dayForWeek = 0;
				  if(c.get(Calendar.DAY_OF_WEEK) == 1){
				   dayForWeek = 7;
				  }else{
				   dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
				  }
				  //
				  System.out.println(dayForWeek);
			   
				  	
				
				String sql="insert into sensor(id,time,temp,humidity,infrared,smoke)values" +
						"('"+(++maxId)+"','"+da+"','"+s.getTemp()+"','"+s.getHumidity()+"','"+s.getInfrared()+"','"+s.getSmoke()+"')";
			
				controlDB.executeUpdate(sql);
				flag = true;
			} catch (Exception e) {
				e.printStackTrace();
			}		
			return flag;
		}



}

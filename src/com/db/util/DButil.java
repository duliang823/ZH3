package com.db.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;


import com.ub.beans.Sensor;
import com.ub.beans.Ub;
import com.ub.beans.Ub1;
import com.ub.beans.Ub2;
import com.ub.dao.UbDao;


public class DButil {
	
	public Connection getconnection(){
		//连接数据库账号密码***********************************************************************
		String url="jdbc:mysql://localhost:3306/cn_sk";
		String username="root";
		String password="123456";
		try {
			//打开驱动*************************************************************************
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("mysql connected");
			return DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//关闭数据库*******************************************************************************
	public void closeConnection(Connection conn){
		if(conn!=null){
			try {
				conn.close();
				System.out.println("mysql connection closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//向ub表中添加内容****************************************************************************
	public void insertUb(Ub ub){
		DButil util=new DButil();
		Connection conn=util.getconnection();
		ResultSet rs=null;
		
		try {
			Statement stmt=conn.createStatement();
			int maxId=0;
			String sql1="select max(id) as maxId from ub";
			rs=stmt.executeQuery(sql1);
			if(rs.next()){
				maxId=rs.getInt("maxId");
			}
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String da = sdf.format(date);
			String sql="insert into ub(id,time,temp,humidity,infrared,smoke,period,location,device,DI,status) values" +
			"('"+(++maxId)+"','"+da+"','"+ub.getTemp()+"','"+ub.getHumidity()+"','"+ub.getInfrared()+"','"+ub.getSmoke()+"','"+ub.getPeriod()+"','"+ub.getLocation()+"','"+ub.getDevice()+"','"+ub.getDI()+"','"+ub.getStatus()+"')";
			System.out.println(sql);
			stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	public static void main(String[] args){
		Sensor sensor1=new Sensor();
		Ub ub=new Ub();
		ub.setTemp(sensor1.getTemp());
		ub.setHumidity(sensor1.getHumidity());
		ub.setInfrared(sensor1.getInfrared());
		ub.setSmoke(sensor1.getSmoke());
		ub.setPeriod("winter");
		ub.setLocation("living_room");
		ub.setDevice("light");
		ub.setDI("1");
		ub.setStatus("ON");
		
		DButil util =new DButil();
		util.insertUb(ub);
	}

}

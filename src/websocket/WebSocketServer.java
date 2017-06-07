package websocket;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.db.util.DButil;
import com.ub.beans.Sensor;
import com.ub.beans.Ub;
import com.ub.beans.Ub3;
import com.ub.dao.UbDao;
import com.ub.dao.impl.UbDaoImpl;

import UDPServer.anylsys;
import UDPServer.udpServer;

//import java
//该注解用来指定一个URI，客户端可以通过这个URI来连接到WebSocket。类似Servlet的注解mapping
@ServerEndpoint(value="/websocketS")
public class WebSocketServer {
 
  @OnMessage
  public void onMessage(String message, Session session)
    throws IOException, InterruptedException {
   
    // Print the client message for testing purposes
    System.out.println("Received: " + message);
    
    // Send the first message to the client
    udpServer udp=new udpServer();
   // anylsys anylsys = new anylsys();
    
	if(message.equals("openlight")) {
		byte[] data={0x66,(byte) 0xad,0x0a,0x31,0x01,0x11,0x31,(byte) 0xa0,0x00,(byte) 0xa1};
		udp.SendUDP(data,2);
		System.out.println("开灯");
		//Sensor anylsys.sensor=new Sensor();
		
		//anylsys anylsys = new anylsys();
		Ub ub=new Ub();
		//anylsys.sensor.getTemp();
		
		ub.setTemp(anylsys.sensor.getTemp());
		ub.setHumidity(anylsys.sensor.getHumidity());
		ub.setInfrared(anylsys.sensor.getInfrared());
		ub.setSmoke(anylsys.sensor.getSmoke());
		ub.setPeriod("winter");
		ub.setLocation("living_room");
		ub.setDevice("light");
		ub.setDI("1");
		ub.setStatus("ON");
		System.out.println(ub.getDevice());
		UbDao u=new UbDaoImpl();
		if (u.insertUb(ub)) {
			System.out.println("开客厅灯记录成功");
		} else {
			System.out.println("开客厅灯记录失败");
		}	
		
		Ub3 ub3=new Ub3();
		ub3.setPeriod("winter");
		ub3.setLocation("living_room");
		ub3.setDevice("light");
		ub3.setDI("1");
		ub3.setStatus("ON");
		System.out.println(ub.getDevice());
		UbDao u1=new UbDaoImpl();
		if (u1.insertUb3(ub3)) {
			System.out.println("开客厅灯记录成功");
		} else {
			System.out.println("开客厅灯记录失败");
		}	
	}
	if(message.equals("closelight")) {
		System.out.println("关灯");
		byte[] data={0x66,(byte) 0xad,0x0a,0x31,0x01,0x11,0x31,(byte) 0xa0,0x00,(byte) 0xa2};
		udp.SendUDP(data,2);
		
		//anylsys anylsys = new anylsys();
		
		Ub ub=new Ub();
		ub.setTemp(anylsys.sensor.getTemp());
		ub.setHumidity(anylsys.sensor.getHumidity());
		ub.setInfrared(anylsys.sensor.getInfrared());
		ub.setSmoke(anylsys.sensor.getSmoke());
		ub.setPeriod("winter");
		ub.setLocation("living_room");
		ub.setDevice("light");
		ub.setDI("1");
		ub.setStatus("OFF");
		System.out.println(ub.getDevice());
		UbDao u=new UbDaoImpl();
		if (u.insertUb(ub)) {
			System.out.println("关灯灯记录成功");
		} else {
			System.out.println("关灯记录失败");
		}		
		
		
		Ub3 ub3=new Ub3();
		ub3.setPeriod("winter");
		ub3.setLocation("living_room");
		ub3.setDevice("light");
		ub3.setDI("1");
		ub3.setStatus("OFF");
		System.out.println(ub.getDevice());
		UbDao u1=new UbDaoImpl();
		if (u1.insertUb3(ub3)) {
			//System.out.println("关客厅灯记录成功");
		} else {
			//System.out.println("开客厅灯记录失败");
		}			
		
		
		
		
		
	}
	if(message.equals("openfan")) {
		System.out.println("开风扇");
		byte[] data={0x58,0x58,0x58,0x43,0x49,0x44,0x2e,0x01,0x53,0x30,0x30,0x30,0x31,0x30,0x31,0x30,0x31,0x30,0x33,0x30,0x30,0x30,0x30,0x30,0x30,0x30,0x30,0x30,0x3f,0x02};
		udp.SendUDP(data,2);
		
		//anylsys anylsys = new anylsys();
		Ub ub=new Ub();
		ub.setTemp(anylsys.sensor.getTemp());
		ub.setHumidity(anylsys.sensor.getHumidity());
		ub.setInfrared(anylsys.sensor.getInfrared());
		ub.setSmoke(anylsys.sensor.getSmoke());
		ub.setPeriod("winter");
		ub.setLocation("living_room");
		ub.setDevice("fan");
		ub.setDI("2");
		ub.setStatus("ON");
		System.out.println(ub.getDevice());
		UbDao u=new UbDaoImpl();
		if (u.insertUb(ub)) {
			System.out.println("开风扇记录成功");
		} else {
			System.out.println("开风扇记录失败");
		}	
		
		Ub3 ub3=new Ub3();
		ub3.setPeriod("winter");
		ub3.setLocation("living_room");
		ub3.setDevice("fan");
		ub3.setDI("2");
		ub3.setStatus("ON");
		System.out.println(ub.getDevice());
		UbDao u1=new UbDaoImpl();
		if (u1.insertUb3(ub3)) {
			//System.out.println("关客厅灯记录成功");
		} else {
			//System.out.println("开客厅灯记录失败");
		}				
		
		
	}
	if(message.equals("closefan")) {
		System.out.println("关风扇");
		byte[] data={0x58,0x58,0x58,0x43,0x49,0x44,0x2e,0x01,0x53,0x30,0x30,0x30,0x31,0x30,0x31,0x30,0x31,0x30,0x33,0x30,0x30,0x30,0x30,0x30,0x30,0x30,0x30,0x30,0x3f,0x01};
		udp.SendUDP(data,2);
		
		//Sensor anylsys.sensor=new Sensor();
		Ub ub=new Ub();
		ub.setTemp(anylsys.sensor.getTemp());
		ub.setHumidity(anylsys.sensor.getHumidity());
		ub.setInfrared(anylsys.sensor.getInfrared());
		ub.setSmoke(anylsys.sensor.getSmoke());
		ub.setPeriod("winter");
		ub.setLocation("living_room");
		ub.setDevice("fan");
		ub.setDI("2");
		ub.setStatus("OFF");
		System.out.println(ub.getDevice());
		UbDao u=new UbDaoImpl();
		if (u.insertUb(ub)) {
			System.out.println("关风扇记录成功");
		} else {
			System.out.println("关风扇记录失败");
		}	
		
		
		
		
		Ub3 ub3=new Ub3();
		ub3.setPeriod("winter");
		ub3.setLocation("living_room");
		ub3.setDevice("fan");
		ub3.setDI("2");
		ub3.setStatus("OFF");
		System.out.println(ub.getDevice());
		UbDao u1=new UbDaoImpl();
		if (u1.insertUb3(ub3)) {
			//System.out.println("关客厅灯记录成功");
		} else {
			//System.out.println("开客厅灯记录失败");
		}
		
		
	}
	if(message.equals("openair")) {
		System.out.println("开空调");
		byte[] data={0x66,(byte) 0xad,0x0d,0x31,0x01,0x11,0x31,(byte) 0xc0,(byte) 0xff,0x55,0x02,0x2e,0x33};
		udp.SendUDP(data,2);
		
	//	Sensor anylsys.sensor=new Sensor();
		Ub ub=new Ub();
		ub.setTemp(anylsys.sensor.getTemp());
		ub.setHumidity(anylsys.sensor.getHumidity());
		ub.setInfrared(anylsys.sensor.getInfrared());
		ub.setSmoke(anylsys.sensor.getSmoke());
		ub.setPeriod("winter");
		ub.setLocation("living_room");
		ub.setDevice("air_conditioner");
		ub.setDI("3");
		ub.setStatus("ON");
		System.out.println(ub.getDevice());
		UbDao u=new UbDaoImpl();
		if (u.insertUb(ub)) {
			System.out.println("开空调记录成功");
		} else {
			System.out.println("开空调记录失败");
		}	
		
		
		
		
		Ub3 ub3=new Ub3();
		ub3.setPeriod("winter");
		ub3.setLocation("living_room");
		ub3.setDevice("air_conditioner");
		ub3.setDI("3");
		ub3.setStatus("ON");
		System.out.println(ub.getDevice());
		UbDao u1=new UbDaoImpl();
		if (u1.insertUb3(ub3)) {
			//System.out.println("关客厅灯记录成功");
		} else {
			//System.out.println("开客厅灯记录失败");
		}	
		
	}
	if(message.equals("closeair")) {
		System.out.println("关空调");
		byte[] data={0x66,(byte) 0xad,0x0d,0x31,0x01,0x11,0x31,(byte) 0xc0,(byte) 0xff,0x55,0x02,0x2d,0x33};
		udp.SendUDP(data,2);
		
	///	Sensor anylsys.sensor=new Sensor();
		Ub ub=new Ub();
		ub.setTemp(anylsys.sensor.getTemp());
		ub.setHumidity(anylsys.sensor.getHumidity());
		ub.setInfrared(anylsys.sensor.getInfrared());
		ub.setSmoke(anylsys.sensor.getSmoke());
		ub.setPeriod("winter");
		ub.setLocation("living_room");
		ub.setDevice("air_conditioner");
		ub.setDI("3");
		ub.setStatus("OFF");
		System.out.println(ub.getDevice());
		UbDao u=new UbDaoImpl();
		if (u.insertUb(ub)) {
			System.out.println("关空调记录成功");
		} else {
			System.out.println("关空调记录失败");
		}	
		
		
		Ub3 ub3=new Ub3();
		ub3.setPeriod("winter");
		ub3.setLocation("living_room");
		ub3.setDevice("air_conditioner");
		ub3.setDI("3");
		ub3.setStatus("OFF");
		System.out.println(ub.getDevice());
		UbDao u1=new UbDaoImpl();
		if (u1.insertUb3(ub3)) {
			//System.out.println("关客厅灯记录成功");
		} else {
			//System.out.println("开客厅灯记录失败");
		}	
	}
	if(message.equals("opencurtain")) {
		System.out.println("开窗帘");
		byte[] data={0x58, 0x58, 0x58 ,0x43, 0x49, 0x44, 0x2e, 0x01, 0x53, 0x30, 0x30, 0x30, 0x31, 0x30, 0x31, 0x30, 0x31, 0x30, 0x33, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x3d, 0x01};
		udp.SendUDP(data,2);
		
	//	Sensor anylsys.sensor=new Sensor();
		Ub ub=new Ub();
		ub.setTemp(anylsys.sensor.getTemp());
		ub.setHumidity(anylsys.sensor.getHumidity());
		ub.setInfrared(anylsys.sensor.getInfrared());
		ub.setSmoke(anylsys.sensor.getSmoke());
		ub.setPeriod("winter");
		ub.setLocation("study");
		ub.setDevice("curtain");
		ub.setDI("4");
		ub.setStatus("ON");
		System.out.println(ub.getDevice());
		UbDao u=new UbDaoImpl();
		if (u.insertUb(ub)) {
			System.out.println("开窗帘记录成功");
		} else {
			System.out.println("开窗帘记录失败");
		}	
		
		Ub3 ub3=new Ub3();
		ub3.setPeriod("winter");
		ub3.setLocation("study");
		ub3.setDevice("curtain");
		ub3.setDI("4");
		ub3.setStatus("ON");
		System.out.println(ub.getDevice());
		UbDao u1=new UbDaoImpl();
		if (u1.insertUb3(ub3)) {
			//System.out.println("关客厅灯记录成功");
		} else {
			//System.out.println("开客厅灯记录失败");
		}	
		
		
		
	}
	if(message.equals("stopcurtain")) {
		System.out.println("停窗帘");
		byte[] data={0x58, 0x58, 0x58 ,0x43, 0x49, 0x44, 0x2e, 0x01, 0x53, 0x30, 0x30, 0x30, 0x31, 0x30, 0x31, 0x30, 0x31, 0x30, 0x33, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x3d, 0x02};
		udp.SendUDP(data,2);
		

	}
	
	if(message.equals("closecurtain")) {
		System.out.println("关窗帘");
		byte[] data={0x58, 0x58, 0x58 ,0x43, 0x49, 0x44, 0x2e, 0x01, 0x53, 0x30, 0x30, 0x30, 0x31, 0x30, 0x31, 0x30, 0x31, 0x30, 0x33, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x3d, 0x00};
		udp.SendUDP(data,2);
		
		//Sensor anylsys.sensor=new Sensor();
		Ub ub=new Ub();
		ub.setTemp(anylsys.sensor.getTemp());
		ub.setHumidity(anylsys.sensor.getHumidity());
		ub.setInfrared(anylsys.sensor.getInfrared());
		ub.setSmoke(anylsys.sensor.getSmoke());
		ub.setPeriod("winter");
		ub.setLocation("study");
		ub.setDevice("curtain");
		ub.setDI("4");
		ub.setStatus("OFF");
		System.out.println(ub.getDevice());
		UbDao u=new UbDaoImpl();
		if (u.insertUb(ub)) {
			System.out.println("关窗帘记录成功");
		} else {
			System.out.println("关窗帘记录失败");
		}	
		
		
		Ub3 ub3=new Ub3();
		ub3.setPeriod("winter");
		ub3.setLocation("study");
		ub3.setDevice("curtain");
		ub3.setDI("4");
		ub3.setStatus("OFF");
		System.out.println(ub.getDevice());
		UbDao u1=new UbDaoImpl();
		if (u1.insertUb3(ub3)) {
			//System.out.println("关客厅灯记录成功");
		} else {
			//System.out.println("开客厅灯记录失败");
		}		
		
		
		
	}
	/**********能耗计控制部分**********************/
	if(message.equals("en_tv_open")) {
		System.out.println("开电视能耗计");
		byte[] data={0x68,(byte) 0xcc,0x31,0x01,0x01,0x01,0x01,0x16};
		udp.SendUDP(data,1);
		/*Thread.sleep(300);			//延时20ms下发采集指令
		byte[] data_caiji={0x68,(byte) 0xcc,0x31,0x02,0x01,0x01,0x01,0x16};
		udp.SendUDP(data_caiji,1);
		System.out.println("发送了查询命令");*/
		
		/**
		 * 开启电视
		 */
		//		Sensor anylsys.sensor=new Sensor();
				Ub ub=new Ub();
				ub.setTemp(anylsys.sensor.getTemp());
				ub.setHumidity(anylsys.sensor.getHumidity());
				ub.setInfrared(anylsys.sensor.getInfrared());
				ub.setSmoke(anylsys.sensor.getSmoke());
				ub.setPeriod("winter");
				ub.setLocation("living_room");
				ub.setDevice("TV");
				ub.setDI("5");
				ub.setStatus("ON");
				System.out.println(ub.getDevice());
				UbDao u=new UbDaoImpl();
				if (u.insertUb(ub)) {
					System.out.println("开客厅电视灯记录成功");
				} else {
					System.out.println("开客厅电视记录失败");
				}	
		
				Ub3 ub3=new Ub3();
				ub3.setPeriod("winter");
				ub3.setLocation("living_room");
				ub3.setDevice("TV");
				ub3.setDI("5");
				ub3.setStatus("ON");
				System.out.println(ub.getDevice());
				UbDao u1=new UbDaoImpl();
				if (u1.insertUb3(ub3)) {
					//System.out.println("关客厅灯记录成功");
				} else {
					//System.out.println("开客厅灯记录失败");
				}	
									
	}
	if(message.equals("en_tv_close")) {
		System.out.println("关电视能耗计");
		byte[] data={0x68,(byte) 0xcc,0x31,0x00,0x01,0x01,0x01,0x16};
		udp.SendUDP(data,1);
		/*Thread.sleep(300);			//延时20ms下发采集指令
		byte[] data_caiji={0x68,(byte) 0xcc,0x31,0x02,0x01,0x01,0x01,0x16};
		udp.SendUDP(data_caiji,1);*/
		
		
		/**
		 * 关闭客厅电视
		 */
			///	Sensor anylsys.sensor=new Sensor();
				Ub ub=new Ub();
				ub.setTemp(anylsys.sensor.getTemp());
				ub.setHumidity(anylsys.sensor.getHumidity());
				ub.setInfrared(anylsys.sensor.getInfrared());
				ub.setSmoke(anylsys.sensor.getSmoke());
				ub.setPeriod("winter");
				ub.setLocation("living_room");
				ub.setDevice("TV");
				ub.setDI("5");
				ub.setStatus("OFF");
				System.out.println(ub.getDevice());
				UbDao u=new UbDaoImpl();
				if (u.insertUb(ub)) {
					System.out.println("开客厅电视记录成功");
				} else {
					System.out.println("关客厅电视记录失败");
				}		
		
				
				Ub3 ub3=new Ub3();
				ub3.setPeriod("winter");
				ub3.setLocation("living_room");
				ub3.setDevice("TV");
				ub3.setDI("5");
				ub3.setStatus("OFF");
				System.out.println(ub.getDevice());
				UbDao u1=new UbDaoImpl();
				if (u1.insertUb3(ub3)) {
					//System.out.println("关客厅灯记录成功");
				} else {
					//System.out.println("开客厅灯记录失败");
				}			
				
				
		
	}
	
	if(message.equals("en_fan_open")) {
		System.out.println("开风扇能耗计————轻音乐");
		byte[] data={0x68,(byte) 0xcc,0x32,0x01,0x01,0x01,0x01,0x16};
		udp.SendUDP(data,1);
		/*Thread.sleep(300);			//延时20ms下发采集指令
		byte[] data_caiji={0x68,(byte) 0xcc,0x32,0x02,0x01,0x01,0x01,0x16};
		udp.SendUDP(data_caiji,1);
		System.out.println("发送了查询命令");*/
		
		/**
		 * 打开音乐
		 */
			///	Sensor anylsys.sensor=new Sensor();
				Ub ub=new Ub();
				ub.setTemp(anylsys.sensor.getTemp());
				ub.setHumidity(anylsys.sensor.getHumidity());
				ub.setInfrared(anylsys.sensor.getInfrared());
				ub.setSmoke(anylsys.sensor.getSmoke());
				ub.setPeriod("winter");
				ub.setLocation("living_room");
				ub.setDevice("soft_music");
				ub.setDI("6");
				ub.setStatus("ON");
				System.out.println(ub.getDevice());
				UbDao u=new UbDaoImpl();
				if (u.insertUb(ub)) {
					System.out.println("开客厅轻音乐记录成功");
				} else {
					System.out.println("开客厅轻音乐记录失败");
				}	
		
				
				Ub3 ub3=new Ub3();
				ub3.setPeriod("winter");
				ub3.setLocation("living_room");
				ub3.setDevice("soft_music");
				ub3.setDI("6");
				ub3.setStatus("ON");
				System.out.println(ub.getDevice());
				UbDao u1=new UbDaoImpl();
				if (u1.insertUb3(ub3)) {
					//System.out.println("关客厅灯记录成功");
				} else {
					//System.out.println("开客厅灯记录失败");
				}		
				
				
		
	}
	if(message.equals("en_fan_close")) {
		System.out.println("关风扇能耗计————轻音乐");
		byte[] data={0x68,(byte) 0xcc,0x32,0x00,0x01,0x01,0x01,0x16};
		udp.SendUDP(data,1);
		/*Thread.sleep(300);			//延时20ms下发采集指令
		byte[] data_caiji={0x68,(byte) 0xcc,0x32,0x02,0x01,0x01,0x01,0x16};
		udp.SendUDP(data_caiji,1);*/
		
		/**
		 * 关闭音乐
		 */
		
	//	Sensor anylsys.sensor=new Sensor();
		Ub ub=new Ub();
		ub.setTemp(anylsys.sensor.getTemp());
		ub.setHumidity(anylsys.sensor.getHumidity());
		ub.setInfrared(anylsys.sensor.getInfrared());
		ub.setSmoke(anylsys.sensor.getSmoke());
		ub.setPeriod("winter");
		ub.setLocation("living_room");
		ub.setDevice("soft_music");
		ub.setDI("6");
		ub.setStatus("OFF");
		System.out.println(ub.getDevice());
		UbDao u=new UbDaoImpl();
		if (u.insertUb(ub)) {
			System.out.println("关闭客厅轻音乐记录成功");
		} else {
			System.out.println("关闭客厅轻音乐记录失败");
		}	
		
		
		Ub3 ub3=new Ub3();
		ub3.setPeriod("winter");
		ub3.setLocation("living_room");
		ub3.setDevice("soft_music");
		ub3.setDI("6");
		ub3.setStatus("OFF");
		System.out.println(ub.getDevice());
		UbDao u1=new UbDaoImpl();
		if (u1.insertUb3(ub3)) {
			//System.out.println("关客厅灯记录成功");
		} else {
			//System.out.println("开客厅灯记录失败");
		}
		
	}
	if(message.equals("en_light_open")) {
		System.out.println("开灯光能耗计");
		byte[] data={0x68,(byte) 0xcc,0x33,0x01,0x01,0x01,0x01,0x16};
		udp.SendUDP(data,1);
		/*Thread.sleep(300);			//延时20ms下发采集指令
		byte[] data_caiji={0x68,(byte) 0xcc,0x33,0x02,0x01,0x01,0x01,0x16};
		udp.SendUDP(data_caiji,1);*/
		
		/**
		 * 开卧室灯
		 */
		//		Sensor anylsys.sensor=new Sensor();
				Ub ub=new Ub();
				ub.setTemp(anylsys.sensor.getTemp());
				ub.setHumidity(anylsys.sensor.getHumidity());
				ub.setInfrared(anylsys.sensor.getInfrared());
				ub.setSmoke(anylsys.sensor.getSmoke());
				ub.setPeriod("winter");
				ub.setLocation("bedroom");
				ub.setDevice("light");
				ub.setDI("7");
				ub.setStatus("ON");
				System.out.println(ub.getDevice());
				UbDao u=new UbDaoImpl();
				if (u.insertUb(ub)) {
					System.out.println("开卧室灯记录成功");
				} else {
					System.out.println("开卧室灯记录失败");
				}	
		
				
				Ub3 ub3=new Ub3();
				ub3.setPeriod("winter");
				ub3.setLocation("bedroom");
				ub3.setDevice("light");
				ub3.setDI("7");
				ub3.setStatus("ON");
				System.out.println(ub.getDevice());
				UbDao u1=new UbDaoImpl();
				if (u1.insertUb3(ub3)) {
					//System.out.println("关客厅灯记录成功");
				} else {
					//System.out.println("开客厅灯记录失败");
				}
		
	}
	if(message.equals("en_light_close")) {
		System.out.println("关灯光能耗计");
		byte[] data={0x68,(byte) 0xcc,0x33,0x00,0x01,0x01,0x01,0x16};
		udp.SendUDP(data,1);
		/*Thread.sleep(300);			//延时20ms下发采集指令
		byte[] data_caiji={0x68,(byte) 0xcc,0x33,0x02,0x01,0x01,0x01,0x16};
		udp.SendUDP(data_caiji,1);*/
		
		/**
		 * 开卧室灯
		 */
			//	Sensor anylsys.sensor=new Sensor();
				Ub ub=new Ub();
				ub.setTemp(anylsys.sensor.getTemp());
				ub.setHumidity(anylsys.sensor.getHumidity());
				ub.setInfrared(anylsys.sensor.getInfrared());
				ub.setSmoke(anylsys.sensor.getSmoke());
				ub.setPeriod("winter");
				ub.setLocation("bedroom");
				ub.setDevice("light");
				ub.setDI("7");
				ub.setStatus("OFF");
				System.out.println(ub.getDevice());
				UbDao u=new UbDaoImpl();
				if (u.insertUb(ub)) {
					System.out.println("关卧室灯记录成功");
				} else {
					System.out.println("关卧室灯记录失败");
				}	
		
				
				Ub3 ub3=new Ub3();
				ub3.setPeriod("winter");
				ub3.setLocation("bedroom");
				ub3.setDevice("light");
				ub3.setDI("7");
				ub3.setStatus("OFF");
				System.out.println(ub.getDevice());
				UbDao u1=new UbDaoImpl();
				if (u1.insertUb3(ub3)) {
					//System.out.println("关客厅灯记录成功");
				} else {
					//System.out.println("开客厅灯记录失败");
				}		
				
	}
	if(message.equals("en_hotwater_open")) {
		System.out.println("开热水壶能耗计");
		byte[] data={0x68,(byte) 0xcc,0x34,0x01,0x01,0x01,0x01,0x16};
		udp.SendUDP(data,1);
		/*Thread.sleep(300);			//延时20ms下发采集指令
		byte[] data_caiji={0x68,(byte) 0xcc,0x34,0x02,0x01,0x01,0x01,0x16};
		udp.SendUDP(data_caiji,1);*/
		
	//	Sensor anylsys.sensor=new Sensor();
		Ub ub=new Ub();
		ub.setTemp(anylsys.sensor.getTemp());
		ub.setHumidity(anylsys.sensor.getHumidity());
		ub.setInfrared(anylsys.sensor.getInfrared());
		ub.setSmoke(anylsys.sensor.getSmoke());
		ub.setPeriod("winter");
		ub.setLocation("Washroom");
		ub.setDevice("heater");
		ub.setDI("8");
		ub.setStatus("ON");
		System.out.println(ub.getDevice());
		UbDao u=new UbDaoImpl();
		if (u.insertUb(ub)) {
			System.out.println("开热水器记录成功");
		} else {
			System.out.println("开热水器记录失败");
		}	
		
		
		Ub3 ub3=new Ub3();
		ub3.setPeriod("winter");
		ub3.setLocation("Washroom");
		ub3.setDevice("heater");
		ub3.setDI("8");
		ub3.setStatus("ON");
		System.out.println(ub.getDevice());
		UbDao u1=new UbDaoImpl();
		if (u1.insertUb3(ub3)) {
			//System.out.println("关客厅灯记录成功");
		} else {
			//System.out.println("开客厅灯记录失败");
		}		
		
		
		
	}
	if(message.equals("en_hotwater_close")) {
		System.out.println("关热水壶能耗计");
		byte[] data={0x68,(byte) 0xcc,0x34,0x00,0x01,0x01,0x01,0x16};
		udp.SendUDP(data,1);
		/*Thread.sleep(300);			//延时20ms下发采集指令
		byte[] data_caiji={0x68,(byte) 0xcc,0x34,0x02,0x01,0x01,0x01,0x16};
		udp.SendUDP(data_caiji,1);*/
		
	//	Sensor anylsys.sensor=new Sensor();
		Ub ub=new Ub();
		ub.setTemp(anylsys.sensor.getTemp());
		ub.setHumidity(anylsys.sensor.getHumidity());
		ub.setInfrared(anylsys.sensor.getInfrared());
		ub.setSmoke(anylsys.sensor.getSmoke());
		ub.setPeriod("winter");
		ub.setLocation("Washroom");
		ub.setDevice("heater");
		ub.setDI("8");
		ub.setStatus("OFF");
		System.out.println(ub.getDevice());
		UbDao u=new UbDaoImpl();
		if (u.insertUb(ub)) {
			System.out.println("关热水器记录成功");
		} else {
			System.out.println("关热水器记录失败");
		}	
		
		
		
		Ub3 ub3=new Ub3();
		ub3.setPeriod("winter");
		ub3.setLocation("Washroom");
		ub3.setDevice("heater");
		ub3.setDI("8");
		ub3.setStatus("OFF");
		System.out.println(ub.getDevice());
		UbDao u1=new UbDaoImpl();
		if (u1.insertUb3(ub3)) {
			//System.out.println("关客厅灯记录成功");
		} else {
			//System.out.println("开客厅灯记录失败");
		}	
		
	}
	if(message.equals("en_dianfanbao_open")) {
		System.out.println("开电饭煲能耗计");
		byte[] data={0x68,(byte) 0xcc,0x35,0x01,0x01,0x01,0x01,0x16};
		udp.SendUDP(data,1);
		/*Thread.sleep(300);			//延时20ms下发采集指令
		byte[] data_caiji={0x68,(byte) 0xcc,0x35,0x02,0x01,0x01,0x01,0x16};
		udp.SendUDP(data_caiji,1);*/
		
	//	Sensor anylsys.sensor=new Sensor();
		Ub ub=new Ub();
		ub.setTemp(anylsys.sensor.getTemp());
		ub.setHumidity(anylsys.sensor.getHumidity());
		ub.setInfrared(anylsys.sensor.getInfrared());
		ub.setSmoke(anylsys.sensor.getSmoke());
		ub.setPeriod("winter");
		ub.setLocation("kitchen");
		ub.setDevice("electric_cookers");
		ub.setDI("9");
		ub.setStatus("ON");
		System.out.println(ub.getDevice());
		UbDao u=new UbDaoImpl();
		if (u.insertUb(ub)) {
			System.out.println("开电饭煲记录成功");
		} else {
			System.out.println("开电饭煲记录失败");
		}	
	
		
		Ub3 ub3=new Ub3();
		ub3.setPeriod("winter");
		ub3.setLocation("kitchen");
		ub3.setDevice("electric_cookers");
		ub3.setDI("9");
		ub3.setStatus("ON");
		System.out.println(ub.getDevice());
		UbDao u1=new UbDaoImpl();
		if (u1.insertUb3(ub3)) {
			//System.out.println("关客厅灯记录成功");
		} else {
			//System.out.println("开客厅灯记录失败");
		}			
		
	}
	if(message.equals("en_dianfanbao_close")) {
		System.out.println("关电饭煲能耗计");
		byte[] data={0x68,(byte) 0xcc,0x35,0x00,0x01,0x01,0x01,0x16};
		udp.SendUDP(data,1);
		/*Thread.sleep(300);			//延时20ms下发采集指令
		byte[] data_caiji={0x68,(byte) 0xcc,0x35,0x02,0x01,0x01,0x01,0x16};
		udp.SendUDP(data_caiji,1);*/
		
	//	Sensor anylsys.sensor=new Sensor();
		Ub ub=new Ub();
		ub.setTemp(anylsys.sensor.getTemp());
		ub.setHumidity(anylsys.sensor.getHumidity());
		ub.setInfrared(anylsys.sensor.getInfrared());
		ub.setSmoke(anylsys.sensor.getSmoke());
		ub.setPeriod("winter");
		ub.setLocation("kitchen");
		ub.setDevice("electric_cookers");
		ub.setDI("9");
		ub.setStatus("OFF");
		System.out.println(ub.getDevice());
		UbDao u=new UbDaoImpl();
		if (u.insertUb(ub)) {
			System.out.println("关电饭煲记录成功");
		} else {
			System.out.println("关电饭煲记录失败");
		}	
		
		
		Ub3 ub3=new Ub3();
		ub3.setPeriod("winter");
		ub3.setLocation("kitchen");
		ub3.setDevice("electric_cookers");
		ub3.setDI("9");
		ub3.setStatus("OFF");
		System.out.println(ub.getDevice());
		UbDao u1=new UbDaoImpl();
		if (u1.insertUb3(ub3)) {
			//System.out.println("关客厅灯记录成功");
		} else {
			//System.out.println("开客厅灯记录失败");
		}			
		
	}
	if(message.equals("dianbiao")) {
		System.out.println("查询电表xx");
		byte[] d = {0x68,0x57,0x77,0x55,0x00,0x00,0x00,0x68,0x11,0x04,0x33,0x33,0x34,0x33,(byte) 0xd5,0x16};
		byte[] c = {0x68,(byte) 0x83,(byte) 0x85,0x42,0x00,0x00,0x00,0x68,0x11,0x04,0x33,0x33,0x34,0x33,(byte) 0xfc,0x16};
		udp.SendUDP(d,3);
		Thread.sleep(1000);
		//udp.SendUDP(c,3);
		
	}
	
  }
   
  @OnOpen
  public void onOpen() {
    System.out.println("Client connected");
  }
 
  @OnClose
  public void onClose() {
    System.out.println("Connection closed");
  }
}

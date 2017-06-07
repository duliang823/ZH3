package UDPServer;

import com.ub.beans.Sensor;

import DB.DBUtileAll;

public class anylsys {
	
	public static Sensor sensor=new Sensor();

	public void anys(byte[] B){
		DBUtileAll db = new DBUtileAll();
		int[] b= new int[37];
		for (int i = 0; i < b.length; i++) {
			b[i]=B[i];
			if(b[i]<0){				//对负数进行处理
				b[i]=B[i]+256;		//BYTE的范围是-127到128，对应两位的十六进制数，十位是8和8以后的都是负数
			}
			
		}
		/*
		if(b[0]==104&&b[1]==87){
			////System.out.println("收到电表数据");
			//System.out.println("b[18]:"+b[18]+"b[19]:"+b[19]+"b[20]:"+b[20]+"b[21]:"+b[21]);
			if(b[1]==87){        //87==0X57
				System.out.println("收到电表NO.1数据");
				String x1=change(b[14]);
				String x2=change(b[15]);
				String x3=change(b[16]);
				String x4=change(b[17]);
				String str=x4+x3+x2+"."+x1;
				db.update("i", 8, str);
				System.out.println(str);
				////System.out.println("电表数据为："+x4+""+x3+x2+"."+x1+"Kw/h");
			}
			if(b[1]==131){        //131==0X83
				System.out.println("收到电表NO.2数据");
				String x1=change(b[14]);
				String x2=change(b[15]);
				String x3=change(b[16]);
				String x4=change(b[17]);
				String str=x4+x3+x2+"."+x1;
				db.update("i", 9, str);
				////System.out.println(str);
				////System.out.println("电表数据为："+x4+""+x3+x2+"."+x1+"Kw/h");
			}
						
		}
	*/	
	
	if(b[0]==104){
			////System.out.println("收到电表数据");
			//System.out.println("b[18]:"+b[18]+"b[19]:"+b[19]+"b[20]:"+b[20]+"b[21]:"+b[21]);
		if(b[1]==170){
			
			if(b[2]==87&&b[3]==6){        //红外判别
								
			  //  String str=change(b[11]);
			//	System.out.println(str);
				String device="infrared";
				String status=String.valueOf(b[11]);
				sensor.setInfrared(status);
				if(b[11]>0){
					System.out.println("收到红外数据----客厅有人");
				}
			}
			
		}
		
  if(b[1]==221){
	  	  	 	
	  if(b[2]==01){ 
		  System.out.println("收到客厅温湿度数据");
		  int tempg=b[8];
		  int temopd=b[9];
		  int humg=b[10];
		  int humd=b[11];
		  
		  String temp=tempg+"."+temopd;
		  String hum=humg+"."+humd;
		  sensor.setTemp(temp);
		  sensor.setHumidity(hum);
		//  System.out.println("客厅温度值："+temp);
		//  System.out.println("客厅湿度值："+hum);
		  
	}
	  if(b[2]==02||b[2]==03||b[2]==07){ 
		  System.out.println("收到客厅烟雾数据");
		  int smogg=b[10];
		  int smogd=b[11];
		  
		  String smog=smogg+"."+smogg;
		  sensor.setHumidity(smog);
		  System.out.println("客厅烟雾值："+smog);
		  
	}
	  	    
	  
			if(b[2]==87){        //87==0X57
				System.out.println("收到电表NO.1数据");
				String x1=change(b[14]);
				String x2=change(b[15]);
				String x3=change(b[16]);
				String x4=change(b[17]);
				String str=x4+x3+x2+"."+x1;
				db.update("i", 8, str);
				System.out.println(str);
				////System.out.println("电表数据为："+x4+""+x3+x2+"."+x1+"Kw/h");
			}
			
			if(b[2]==37){
				////System.out.println("能耗计");
				/*String str="";
				for(int k=0;k<B.length;k++){
					str = str+"-"+Integer.toHexString(B[k]);
				}*/
				
				switch (b[3]) {
				case 49:				//能耗计0x31  电视
					
					////System.err.println("收到电视能耗计数据");
					toData(B, 1);
					break;
				case 50:                   //能耗计0x32 风扇
					////System.err.println("收到风扇能耗计数据");
					toData(B, 2);
					break;
				case 51:				//能耗计0x33 灯光
						
					////System.err.println("收到灯光能耗计数据");
					toData(B, 3);	
					break;
				case 52:				//能耗计0x34 热水壶
						
					/////System.err.println("收到热水壶能耗计数据");
					toData(B, 4);	
					break;
				case 53:			//能耗计0x34 电饭煲
							
					/////System.err.println("收到电饭煲能耗计数据");
					toData(B, 5);
					break;

				default:
					break;
				}
			}
									
        }		
			
			if(b[1]==131){        //131==0X83
				////System.out.println("收到电表NO.2数据");
				String x1=change(b[14]);
				String x2=change(b[15]);
				String x3=change(b[16]);
				String x4=change(b[17]);
				String str=x4+x3+x2+"."+x1;
				db.update("i", 9, str);
				////System.out.println(str);
				////System.out.println("电表数据为："+x4+""+x3+x2+"."+x1+"Kw/h");
			}
						
		}		
			
		
		

	}
	
	public static String change(int i){
		if(i<51||i>=211){
			System.out.println("有小于0X33或0xD2的数据");
			return "00";    //处理小于0X33时的异常数据
		}
		//String str = ""+Integer.toHexString((i-51));
		String str =Integer.toHexString((i-51));
		str = str.replaceAll("[a-zA-Z]","0" );				//去除字符串中的字母
		int i4=Integer.parseInt(str.trim().trim());
		if(i4>=0&&i4<=9){
			str="0"+i4;
		}
		//System.out.println(str);
		return str;
	}
	
	
	public static void toData(byte[] B,int i){
		DBUtileAll db = new DBUtileAll();
		int[] b= new int[37];
		for (int j = 0; j < b.length; j++) {
			b[j]=B[j];
			if(b[j]<0){				//对负数进行处理
				b[j]=B[j]+256;		//BYTE的范围是-127到128，对应两位的十六进制数，十位是8和8以后的都是负数
			}
		}
		/**累计电量**/
		String w1 = change(b[14]);
		String w2 = change(b[15]);
		String w3 = change(b[16]);
		String w4 = change(b[17]);
		String dianliang = w4+w3+w2+"."+w1;
		db.update("kwh", i, dianliang);
		/////System.out.println("累计电量为："+dianliang);
		/**工作电压****/
		String v1 = change(b[18]);
		String v2 = change(b[19]);
		String v =v2+""+v1;
		StringBuilder sbv=new StringBuilder(v);   
		sbv.insert(3,".");                         //在字符串指定位置插入元素
		db.update("v", i, sbv.toString());
		////System.out.println("电压为："+sbv);
		/**工作电流****/
		String i1 = change(b[20]);
		String i2 = change(b[21]);
		String i3 = change(b[22]);
		String I = ""+i3+i2+i1;
		StringBuilder sbi = new StringBuilder(I);
		sbi.insert(3, ".");
		db.update("i", i, sbi.toString());
		////System.out.println("电流为："+sbi);
		/**负载功率***/
		String g1 = change(b[23]);
		String g2 = change(b[24]);
		String g3 = change(b[25]);
		String g = ""+g3+g2+g1;
		StringBuilder sbg=new StringBuilder(g);   
		sbg.insert(5,".");                         //在字符串指定位置插入元素
		db.update("w", i, sbg.toString());
		/////System.out.println("功率为："+sbg);
		/**状态***/
		String t = change(b[34]);
		db.update("tag", i, t);
		/////System.out.println("能耗计状态为："+t);
		
	}
}

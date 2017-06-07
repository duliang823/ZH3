<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>智能家居</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">	   
	<link rel="stylesheet" type="text/css" href="css/main.css">
	
	
	
  </head>
  
  <body>
  <div id="main">
 	 <div id="title_sub">
     </div>
     <div id="title">
             <b>智能家居</b>
     </div>
    <div id="control_sub" class="sub" class="control">
    </div>
    <div id="control" class="menu" class="control" style="font-family: 楷体">
    	家电控制
    </div>
    <div id="control_area" class="area" style="display: none;">
    </div>
    <!----------------------------家电控制部分页面  ----------------------------------------------->
    <div id="control_content" class="content" style="display:none;">
    	<div id="video" class="cc">   	
    	</div>
    	<img id="img1"  style="-webkit-user-select: none;" src=""> 
    	<div id="video_control" class="cc">
	    	<div id="video_font" class="word">
	    	视频控制	    	
	    	</div>
	    	<div id="videoControl"></div>
	    	<button id="video_up" class="video_control">上
	    	</button>
	    	<button id="video_down" class="video_control">下
	    	</button>
	    	<button id="video_left" class="video_control">左
	    	</button>
	    	<button id="video_right" class="video_control">右
	    	</button>
    	</div>
    	
    	
    	<div id="aircondition" class="cc">
	    	<div id="aircondition_font" class="word2">
	    	空调控制
	    	</div>
	    	<div id="air_data">
	    	25℃
	    	</div>
	    	<button id="air_open" value="openair" onclick="sendMessage(this)">开</button>
	    	<button id="air_close" value="closeair" onclick="sendMessage(this)">关</button>
	    	<button id="air_colde">制冷</button>
	    	<button id="air_hot">制热</button>
	    	<button id="air_speed">风速</button>
	    	<button id="air_sleep">睡眠</button>
	    	<button id="air_up">+</button>
	    	<button id="air_down">-</button>
    	</div>
    	
    	<div id="curtain" class="cc">
    	<div id="curtain_font" class="word2">
    	窗帘控制
    	</div>
    	<button id="curtain_open" value="opencurtain" onclick="sendMessage(this)">开</button>
	    <button id="curtain_stop" value="stopcurtain" onclick="sendMessage(this)">停</button>
	    <button id="curtain_close" value="closecurtain" onclick="sendMessage(this)">关</button>
    	</div>
    	
    	
    	<div id="light" class="cc">
    	<button id="light_open" value="openlight" onclick="sendMessage(this)">开灯</button>
    	<button id="light_close" value="closelight" onclick="sendMessage(this)">关灯</button>
    	<div id="light_font" class="word">
    	灯光控制
    	</div>
    	</div>
    	
    	<div id="fan" class="cc">  	
	    	<div id="fan_font" class="word">
	    	风扇控制
	    	</div>
	    	<button id="fan_open" value="openfan" onclick="sendMessage(this)">开</button>
	    	<button id="fan_stop" value="closefan" onclick="sendMessage(this)">关</button>
	    	
    	</div>
    </div>
    
    
    
    <!--------------------------环境监测部分页面  --------------------------------------------------->
    <div id="environment_sub" class="sub">
  </div>
   <div id="environment" class="menu" style="font-family: 楷体">
   		环境监测
  </div>
  <div id="environment_area" class="area" style="display: none;">
  		<div id="temp"></div>
   		<div id="hum"></div>
   		<div id="smog"></div>
   		<div id="smog2"></div>
  
    </div>
    
    
    
   <!--------------------------能耗管控部分页面  --------------------------------------------------->
  <div id="energy_sub" class="sub">
  </div>
   <div id="energy"  class="menu" style="font-family: 楷体">
   		能耗管控
  </div>
  <div id="energy_area" class="area" style="display:none">
  	<div id="en_area1">
  		<div id="en_table">
  		<table  style="border-collapse:collapse;">
  			<tbody>
  				<tr>
  					<td>设备</td>
  					<td>电流（A）</td>
  					<td>电压（V）</td>
  					<td>功率（W）</td>
  					<td>累计电量（Kw/h）</td>
  					<td>设备状态</td>
  					<td>设备控制</td>
  				</tr>
  				<tr>
  					<td>电视</td>
  					<td id="en_TV_I"></td>
  					<td id="en_TV_V"></td>
  					<td id="en_TV_W"></td>
  					<td id="en_TV_Kwh"></td>
  					<td><button class="en_button" id="en_TV_tag"></button></td>
  					<td><button class="en_control_btn" id="en_TV_open" value="en_tv_open" onclick="sendMessage(this)">开</button>
  					<button class="en_control_btn" id="en_TV_close" value="en_tv_close" onclick="sendMessage(this)">关</button></td>
  				</tr>
  				<tr>
  					<td>风扇</td>
  					<td id="en_fan_I"></td>
  					<td id="en_fan_V"></td>
  					<td id="en_fan_W"></td>
  					<td id="en_fan_Kwh"></td>
  					<td><button class="en_button" id="en_fan_tag"></button></td>
  					<td><button class="en_control_btn" id="en_fan_open" value="en_fan_open" onclick="sendMessage(this)">开</button>
  					<button class="en_control_btn" id="en_fan_close" value="en_fan_close" onclick="sendMessage(this)">关</button></td>
  				</tr>
  				<tr>
  					<td>灯光</td>
  					<td id="en_light_I"></td>
  					<td id="en_light_V"></td>
  					<td id="en_light_W"></td>
  					<td id="en_light_Kwh"></td>
  					<td><button class="en_button" id="en_light_tag"></button></td>
  					<td><button class="en_control_btn" id="en_light_open" value="en_light_open" onclick="sendMessage(this)">开</button>
  					<button class="en_control_btn" id="en_light_close" value="en_light_close" onclick="sendMessage(this)">关</button></td>
  				</tr>
  				<tr>
  					<td>热水壶</td>
  					<td id="en_hotwater_I"></td>
  					<td id="en_hotwater_V"></td>
  					<td id="en_hotwater_W"></td>
  					<td id="en_hotwater_Kwh"></td>
  					<td><button class="en_button" id="en_hotwater_tag"></button></td>
  					<td><button class="en_control_btn" id="en_hotwater_open" value="en_hotwater_open" onclick="sendMessage(this)">开</button>
  					<button class="en_control_btn" id="en_hotwater_close" value="en_hotwater_close" onclick="sendMessage(this)"hot>关</button></td>
  				</tr>
  				<tr>
  					<td>电饭煲</td>
  					<td id="en_dianfanbao_I"></td>
  					<td id="en_dianfanbao_V"></td>
  					<td id="en_dianfanbao_W"></td>
  					<td id="en_dianfanbao_Kwh"></td>
  					<td><button class="en_button" id="en_dianfanbao_tag" ></button></td>
  					<td><button class="en_control_btn" id="en_dianfanbao_open" value="en_dianfanbao_open" onclick="sendMessage(this)">开</button>
  					<button class="en_control_btn" id="en_dianfanbao_close" value="en_dianfanbao_close" onclick="sendMessage(this)">关</button></td>
  				</tr>
  				<!--<tr>
  					<td>空调</td>
  					<td id="en_air_I"></td>
  					<td id="en_air_V"></td>
  					<td id="en_air_W"></td>
  					<td id="en_air_Kwh"></td>
  					<td><button class="en_button"></button></td>
  				</tr>
  			--></tbody>
  		</table>
  	</div>
  	<div id="sanbiao">
  		<div class="sanbiao" id="shuibiao">
  			<div class="sanbiao_title">
  				<img src="img/drop2.png" style="height: 50px;width:50px" >
  				<div id="shuibiao_title">水 表</div>
  				<div id="shuibiao_data">1.0</div>
  			</div> 		
  		</div>
  		<div class="sanbiao" id="dianbiao">
  			<div class ="sanbiao_title">
  				<img src="img/level8.png" style="height: 40px;width:40px;position: relative;top:5px;" >
  				<div id="dianbiao_title">电表No.1</div>
  				<div id="dianbiao_data">null</div>
  			</div>
  		</div>
  		<div class="sanbiao" id="dianbiao2">
  			<div class ="sanbiao_title">
  				<img src="img/level8.png" style="height: 40px;width:40px;position: relative;top:5px;" >
  				<div id="dianbiao_title">电表No.2</div>
  				<div id="dianbiao2_data">null</div>
  			</div>
  		</div>
  		<div class="sanbiao" id="qibiao">
  			<div class ="sanbiao_title">
  				<img src="img/gas.png" style="height: 55px;width:55px;position: relative;top:-3px;" >
  				<div id="qibiao_title">气  表</div>
  				<div id="qibiao_data">1.04(m³)</div>
  			</div>
  		</div>
  		<div class="sanbiao" id="tubiao">
  			能耗图表 
  			<div><img src="img/chart4.png" style="width: 80px;height: 60px;"></div>			
  		</div>
  		
  	</div>
  	</div>
  	<div id="en_area2" style="display: none">
    	<div id="en_dianliang">
    	</div>
    	<div id="en_gonglv">
    	</div>
    	<div id="back">
    		能耗表格<img src="img/spreadsheet7.png" style="width:80px; height: 50px;">
    	</div>
    </div>
  
  </div>
    
   
   <!--------------------------综合安防部分页面  --------------------------------------------------->
  <div id="security_sub" class="sub">
  </div>
   <div id="security" class="menu" style="font-family: 楷体">
   		综合安防
  </div>
  <div id="security_area" class="area" style="display: none;">
  	<img id="dun_img" src="img/dun1.png"></img>
  	<img id="infrared" src="img/blue.png"></img>
  	<div id="inf_word">人体红外</div>
  	<img id="fire" src="img/blue.png"></img>
  	<div id="fire_word">火焰</div>
  	<img id="door" src="img/blue.png"></img>
  	<div id="door_word">窗磁门磁</div>
  	<img id="co" src="img/blue.png"></img>
  	<div id="co_word">一氧化碳</div>
    </div>
  </div>
  </body>
  <script src="js/jquery-1.2.6.js" type="text/javascript"></script>
  <script src="js/my.js" type="text/javascript"></script>
  <script src="js/jquery.min.js" type="text/javascript"></script>
  <script type="text/javascript" src="js/highcharts.js"></script>
  <script src="js/websocket.js" type="text/javascript"></script>
  <script src="js/temp.js" type="text/javascript" ></script>
  <script src="js/hum.js" type="text/javascript"></script>
  <script src="js/smog.js" type="text/javascript"></script>
  <script src="js/smog2.js" type="text/javascript"></script>
  <script src="js/eng.js" type="text/javascript"></script>
  <script src="js/en_gonglv.js" type="text/javascript"></script>
  <script src="js/updata.js" type="text/javascript"></script>
  <!--<script src="js/eng.js" type="text/javascript"></script>--> 
</html>

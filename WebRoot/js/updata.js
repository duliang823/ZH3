   		var t = window.setInterval("updata()",1000);		 															//3S进行一次此操作 

		var s=new Date();
		function updata(){
			
			if (window.XMLHttpRequest)
		  {// code for IE7+, Firefox, Chrome, Opera, Safari
		  xmlhttp=new XMLHttpRequest();
		  }
		else
		  {// code for IE6, IE5
		  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		  }
		xmlhttp.open("GET","SHServlet",false);
		xmlhttp.send();
		xmlDoc=xmlhttp.responseXML;
		
		
		
		
		/*****电流量 ****/		
		$("#en_TV_I").text(xmlDoc.getElementsByTagName("i")[0].childNodes[0].nodeValue);
		$("#en_fan_I").text(xmlDoc.getElementsByTagName("i")[1].childNodes[0].nodeValue);
		$("#en_light_I").text(xmlDoc.getElementsByTagName("i")[2].childNodes[0].nodeValue);
		$("#en_hotwater_I").text(xmlDoc.getElementsByTagName("i")[3].childNodes[0].nodeValue);
		$("#en_dianfanbao_I").text(xmlDoc.getElementsByTagName("i")[4].childNodes[0].nodeValue);
		//$("#en_light_I").text(xmlDoc.getElementsByTagName("i")[5].childNodes[0].nodeValue);
		/*****水电气量 ****/
		$("#shuibiao_data").text(xmlDoc.getElementsByTagName("i")[6].childNodes[0].nodeValue+"(m³)");		
		$("#dianbiao_data").text(xmlDoc.getElementsByTagName("i")[7].childNodes[0].nodeValue+"(Kw/h)");
		buffer_dianbiao_kwh= xmlDoc.getElementsByTagName("i")[7].childNodes[0].nodeValue; 
		localStorage.setItem("dianbiao_kwh",buffer_dianbiao_kwh);    //电表1数据写入缓存
		$("#dianbiao2_data").text(xmlDoc.getElementsByTagName("i")[8].childNodes[0].nodeValue+"(Kw/h)");
		buffer_dianbiao2_kwh= xmlDoc.getElementsByTagName("i")[8].childNodes[0].nodeValue; 
		localStorage.setItem("dianbiao2_kwh",buffer_dianbiao2_kwh);    //电表1数据写入缓存
		/*****电压量 ****/		
		$("#en_TV_V").text(xmlDoc.getElementsByTagName("v")[0].childNodes[0].nodeValue);
		$("#en_fan_V").text(xmlDoc.getElementsByTagName("v")[1].childNodes[0].nodeValue);
		$("#en_light_V").text(xmlDoc.getElementsByTagName("v")[2].childNodes[0].nodeValue);
		$("#en_hotwater_V").text(xmlDoc.getElementsByTagName("v")[3].childNodes[0].nodeValue);
		$("#en_dianfanbao_V").text(xmlDoc.getElementsByTagName("v")[4].childNodes[0].nodeValue);
		//$("#en_light_V").text(xmlDoc.getElementsByTagName("v")[5].childNodes[0].nodeValue);
		
		/*****功率量 ****/		
		$("#en_TV_W").text(xmlDoc.getElementsByTagName("w")[0].childNodes[0].nodeValue);
		buffer_tv_w= xmlDoc.getElementsByTagName("w")[0].childNodes[0].nodeValue; 
		localStorage.setItem("tv_w",buffer_tv_w);    //写入缓存
		$("#en_fan_W").text(xmlDoc.getElementsByTagName("w")[1].childNodes[0].nodeValue);
		buffer_fan_w= xmlDoc.getElementsByTagName("w")[1].childNodes[0].nodeValue; 
		localStorage.setItem("fan_w",buffer_fan_w);    //写入缓存
		$("#en_light_W").text(xmlDoc.getElementsByTagName("w")[2].childNodes[0].nodeValue);
		buffer_light_w= xmlDoc.getElementsByTagName("w")[2].childNodes[0].nodeValue;
		localStorage.setItem("light_w",buffer_light_w);
		$("#en_hotwater_W").text(xmlDoc.getElementsByTagName("w")[3].childNodes[0].nodeValue);
		buffer_hotwater_w= xmlDoc.getElementsByTagName("w")[3].childNodes[0].nodeValue;
		localStorage.setItem("hotwater_w",buffer_hotwater_w);
		$("#en_dianfanbao_W").text(xmlDoc.getElementsByTagName("w")[4].childNodes[0].nodeValue);
		buffer_dianfanbao_w= xmlDoc.getElementsByTagName("w")[4].childNodes[0].nodeValue;
		localStorage.setItem("dianfanbao_w",buffer_dianfanbao_w);
		//$("#en_light_W").text(xmlDoc.getElementsByTagName("w")[5].childNodes[0].nodeValue);
		
		/*****度数量 ****/		
		$("#en_TV_Kwh").text(xmlDoc.getElementsByTagName("kwh")[0].childNodes[0].nodeValue);
		buffer_tv_kwh= xmlDoc.getElementsByTagName("kwh")[0].childNodes[0].nodeValue; 
		localStorage.setItem("tv_kwh",buffer_tv_kwh);    //写入缓存
		$("#en_fan_Kwh").text(xmlDoc.getElementsByTagName("kwh")[1].childNodes[0].nodeValue);
		buffer_fan_kwh= xmlDoc.getElementsByTagName("kwh")[1].childNodes[0].nodeValue;
		localStorage.setItem("fan_kwh",buffer_fan_kwh);
		$("#en_light_Kwh").text(xmlDoc.getElementsByTagName("kwh")[2].childNodes[0].nodeValue);
		buffer_light_kwh= xmlDoc.getElementsByTagName("kwh")[2].childNodes[0].nodeValue;
		localStorage.setItem("light_kwh",buffer_light_kwh);
		$("#en_hotwater_Kwh").text(xmlDoc.getElementsByTagName("kwh")[3].childNodes[0].nodeValue);
		buffer_hotwater_kwh= xmlDoc.getElementsByTagName("kwh")[3].childNodes[0].nodeValue;
		localStorage.setItem("hotwater_kwh",buffer_hotwater_kwh);
		$("#en_dianfanbao_Kwh").text(xmlDoc.getElementsByTagName("kwh")[4].childNodes[0].nodeValue);
		buffer_dianfanbao_kwh= xmlDoc.getElementsByTagName("kwh")[4].childNodes[0].nodeValue;
		localStorage.setItem("dianfanbao_kwh",buffer_dianfanbao_kwh);
		//$("#en_light_Kwh").text(xmlDoc.getElementsByTagName("kwh")[5].childNodes[0].nodeValue);
		
		/*****状态量 ****/
		if(xmlDoc.getElementsByTagName("tag")[0].childNodes[0].nodeValue==1){
			$("#en_TV_tag").css("background","green");          //表示开
			$("#en_TV_open").disable;
		}else{$("#en_TV_tag").css("background","red");}
		if(xmlDoc.getElementsByTagName("tag")[1].childNodes[0].nodeValue==1){
			$("#en_fan_tag").css("background","green");          //表示开
		}else{$("#en_fan_tag").css("background","red");}
		if(xmlDoc.getElementsByTagName("tag")[2].childNodes[0].nodeValue==1){
			$("#en_light_tag").css("background","green");          //表示开
		}else{$("#en_light_tag").css("background","red");}
		if(xmlDoc.getElementsByTagName("tag")[3].childNodes[0].nodeValue==1){
			$("#en_hotwater_tag").css("background","green");          //表示开
		}else{$("#en_hotwater_tag").css("background","red");}
		if(xmlDoc.getElementsByTagName("tag")[4].childNodes[0].nodeValue==1){
			$("#en_dianfanbao_tag").css("background","green");          //表示开
		}else{$("#en_dianfanbao_tag").css("background","red");}
				
		}
	function StringBuffer(){
	   this.content=new Array;
   };
   StringBuffer.prototype.append=function(str){
	   this.content.push(str);
   };

  StringBuffer.prototype.toString = function(){ 
	   return this.content.join("");
   }
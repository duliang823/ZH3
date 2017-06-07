$(document).ready(function(){
				
				var t= window.setInterval("changeImage()",350);
				//var t= window.setInterval("sendMessage_dianbiao()",10000);
				//var iCount1 = setInterval("loop1()", 2500);
				//var iCount2 = setInterval("loop2()", 3000);
				//var iCount3 = setInterval("loop3()", 2400);
				//var iCount4 = setInterval("loop4()", 2400);
				$("#control").click(function(){
					move();
					//clearInterval(iCount1);clearInterval(iCount2);clearInterval(iCount3);clearInterval(iCount4);																
				$("#control_area,#control_content").show(500);
				$("#environment_area,#security_area,#energy_area").hide();
				
				});
				
				$("#environment").click(function(){
					move();
					//clearInterval(iCount1);clearInterval(iCount2);clearInterval(iCount3);clearInterval(iCount4);
				$("#environment_area").show(500);
				$("#control_area,#control_content,#security_area,#energy_area").hide();
				});
				
				$("#security").click(function(){
					move();	
					//clearInterval(iCount1);clearInterval(iCount2);clearInterval(iCount3);clearInterval(iCount4);
				$("#security_area").show(500);
				$("#control_area,#control_content,#environment_area,#energy_area").hide();
				});
				
				$("#energy").click(function(){
					
					move();
					//clearInterval(iCount1);clearInterval(iCount2);clearInterval(iCount3);clearInterval(iCount4);
				$("#energy_area").show(500);
				$("#control_area,#control_content,#environment_area,#security_area").hide();
				});
				
				$("#tubiao").click(function(){
					$("#en_area1").hide(200);
					$("#en_area2").show(200);
					
				});
				$("#back").click(function(){
					$("#en_area2").hide(200);
					$("#en_area1").show(200);
					
				});
				
				
				//********摄像头控制****************
				$(".video_control").mouseup(function(){
					var stop="<iframe  style=\"display:none;\" src=\"http://172.22.140.202:81/web/cgi-bin/hi3510/ptzctrl.cgi?-step=0&-act=stop\" height=\"0\" width=\"0\"></iframe>";
						$("#videoControl").html(stop);						
					});				
				$("#video_up").mousedown(function(){	
					var up="<iframe  style=\"display:none;\" src=\"http://172.22.140.202:81/web/cgi-bin/hi3510/ptzctrl.cgi?-step=0&-act=up\" height=\"0\" width=\"0\"></iframe>";
					$("#videoControl").html(up);
					
				});
				$("#video_down").mousedown(function(){	
					var up="<iframe  style=\"display:none;\" src=\"http://172.22.140.202:81/web/cgi-bin/hi3510/ptzctrl.cgi?-step=0&-act=down\" height=\"0\" width=\"0\"></iframe>";
					$("#videoControl").html(up);					
				});
				$("#video_left").mousedown(function(){	
					var up="<iframe  style=\"display:none;\" src=\"http://172.22.140.202:81/web/cgi-bin/hi3510/ptzctrl.cgi?-step=0&-act=left\" height=\"0\" width=\"0\"></iframe>";
					$("#videoControl").html(up);					
				});
				$("#video_right").mousedown(function(){	
					var up="<iframe  style=\"display:none;\" src=\"http://172.22.140.202:81/web/cgi-bin/hi3510/ptzctrl.cgi?-step=0&-act=right\" height=\"0\" width=\"0\"></iframe>";
					$("#videoControl").html(up);					
				});
				
							
});
function move(){
	$("#control,#control_sub,#security,#security_sub,#environment_sub,#environment,#energy_sub,#energy").animate({left:'50px',width:'100px',height:'100px','font-size':'20px','line-height':'100px'},500);
	$("#control,#control_sub").animate({top:'150px'});
	$("#environment_sub,#environment").animate({top:'250px'});
	$("#energy_sub,#energy").animate({top:'350px'});
	$("#security,#security_sub").animate({top:'450px'});
	
};

function loop1(){
	$(function(){
	$("#control,#control_sub")
	.animate({top:'+=30px'},1200)
	.animate({top:'-=30px'},1200);	
	;})	
}

function loop2(){
	$(function(){
	$("#security,#security_sub")
	.animate({top:'+=60px'},1400)
	.animate({top:'-=60px'},1400);	
	;})	
}
function loop3(){
	$(function(){
	$("#environment_sub,#environment")
	.animate({top:'+=40px'},1200)
	.animate({top:'-=40px'},1200);	
	;})	
}
function loop4(){
	$(function(){
	$("#energy_sub,#energy")
	.animate({top:'+=40px'},1200)
	.animate({top:'-=40px'},1200);	
	;})	
}
function changeImage(){
		
		//var path ="http://cquptsmarthome.xicp.net:81/tmpfs/auto.jpg？t"+new Date().getTime();  //路径1（有两个）
		//var path ="http://cquptsmarthome.xicp.net:81/tmpfs/auto.jpg";
		var path ="http://172.22.140.202:81/tmpfs/auto.jpg？t"+new Date().getTime();
		var bufferImage = new Image(); //缓冲图片
		bufferImage.src = path;		
		document.getElementById("img1").src=bufferImage.src;		
		}
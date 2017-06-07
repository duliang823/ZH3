$(function () {
	var buf1=new StringBuffer();	
   		buf1.append(localStorage.getItem("tv_kwh"));
   	var buf2=new StringBuffer();	
   		buf2.append(localStorage.getItem("fan_kwh"));
   	var buf3=new StringBuffer();	
   		buf3.append(localStorage.getItem("light_kwh"));
   	var buf4=new StringBuffer();	
   		buf4.append(localStorage.getItem("hotwater_kwh"));
   	var buf5=new StringBuffer();	
   		buf5.append(localStorage.getItem("dianfanbao_kwh"));
   	var buf6=new StringBuffer();	
   		buf6.append(localStorage.getItem("dianbiao_kwh"));
   	var buf7=new StringBuffer();	
   		buf7.append(localStorage.getItem("dianbiao2_kwh"));
   		
   	var s1 =parseFloat(buf1);	
   	var s2 =parseFloat(buf2);
   	var s3 =parseFloat(buf3);
   	var s4 =parseFloat(buf4);
   	var s5 =parseFloat(buf5);
   	var s6 =parseFloat(buf6);
   	var s7 =parseFloat(buf7);
   		
    $('#en_dianliang').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: '家庭电器电量统计表'
        },
        subtitle: {
            text: ''
        },
        xAxis: {
            categories: [
                '电视',
                '风扇',
                '灯光',
                '热水壶',
                '电饭煲',
                '电表NO.1',
                '电表NO.2'
            ]
        },
        yAxis: {
            min: 0,
            title: {
                text: 'dianliang (Kw/h)'
            }
        },
        credits:{
            	enabled:false			//去掉默认的右下角网址 
            },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },
        series: [{
            name: '电量',
            data: [s1, s2, s3, s4, s5,s6,s7]

        }]
    });
});
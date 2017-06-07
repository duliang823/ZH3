$(function () {
	var buf1=new StringBuffer();	
   		buf1.append(localStorage.getItem("tv_w"));
   	var buf2=new StringBuffer();	
   		buf2.append(localStorage.getItem("fan_w"));
   	var buf3=new StringBuffer();	
   		buf3.append(localStorage.getItem("light_w"));
   	var buf4=new StringBuffer();	
   		buf4.append(localStorage.getItem("hotwater_w"));
   	var buf5=new StringBuffer();	
   		buf5.append(localStorage.getItem("dianfanbao_w"));
   		
   	var s1 =parseFloat(buf1);	
   	var s2 =parseFloat(buf2);
   	var s3 =parseFloat(buf3);
   	var s4 =parseFloat(buf4);
   	var s5 =parseFloat(buf5);
    $('#en_gonglv').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: '家庭电器功率表'
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
       
            ]
        },
        yAxis: {
            min: 0,
            title: {
                text: 'gonglv(W)'
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
            name: '功率',
            data: [s1,s2,s3,s4,s5]

        }]
    });
});

$(function () {
    $(document).ready(function () {
        Highcharts.setOptions({
            global: {
                useUTC: false
            }
        });

        $('#temp').highcharts({
            chart: {
                type: 'spline',
                animation: Highcharts.svg, // don't animate in old IE
                marginRight: 10,
                events: {
                    load: function () {

                        // set up the updating of the chart each second
                        var series = this.series[0];
                        setInterval(function () {
                            var x = (new Date()).getTime(), // current time
                                y = 12+Math.random();
                            series.addPoint([x, y], true, true);
                        }, 5000);
                    }
                }
            },
            title: {
                text: '温度值'
            },
            credits:{
            	enabled:false			//去掉右下角的网址 
            },
            xAxis: {
                type: 'datetime',
                tickPixelInterval: 150
            },
            yAxis: {
                title: {
                    text: 'Temperature (°C)'
                },
                plotLines: [{
                    value: 20,
                    width: 25,
                    //color: '#808080'
                }]
            },
            tooltip: {
                formatter: function () {
                    return '<b>' + this.series.name + '</b><br/>' +
                        Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
                        Highcharts.numberFormat(this.y, 2);
                }
            },
            legend: {
                enabled: false
            },
            exporting: {
                enabled: false
            },
            series: [{
                name: '温度值',
                data: (function () {
                    // generate an array of random data
                    var data = [],
                        time = (new Date()).getTime(),
                        i;

                    for (i = -9; i <= 0; i += 1) {
                        data.push({
                            x: time + i * 1000,
                            y: 12+Math.random()
                        });
                    }
                    return data;
                }())
            }]
        });
    });
});


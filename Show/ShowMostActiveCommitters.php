


<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>echarts</title>
    <script type="text/javascript" src="echarts/jquery-1.12.4.min.js"></script>
    <script src="echarts/echarts.min.js"></script>


</head>
<body>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main1" style="width: 1400px;height:400px;"></div>
<script type="text/javascript">

    var arr1=[],arr2=[];
    function arrTest(){
        //这个功能块的作用就是读取json数据。
        $.ajax({
            type:"post",//请求服务器载入数据
            async:false,//异步属性
            url:"getMostActiveCommitter.php",
            data:{},
            dataType:"json",
            success:function(result){
                if (result) {
                    for (var i = 0; i < result.length; i++) {
                        arr1.push(result[i].username);
                        arr2.push(result[i].times);

                    }
                }
            }
        })
        return arr1,arr2;
    }
    arrTest();
    //第一个图
    var  myChart = echarts.init(document.getElementById('main1'));
    option = {
        tooltip: {
            trigger: 'axis',
            position: function (pt) {
                return [pt[0], '10%'];
            }
        },
        title: {
            left: 'center',
            text: "排名前三的committer",
        },
        toolbox: {
            feature: {
                dataZoom: {
                    yAxisIndex: 'none'
                },
                restore: {},
                saveAsImage: {}
            }
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data:arr1
        },
        yAxis: {
            type: 'value',
            boundaryGap: [0, '100%']
        },
        series: [
            {
                name:'次数',
                type:'line',
                smooth:true,
                symbol: 'none',
                sampling: 'average',
                itemStyle: {
                    normal: {
                        color: 'rgb(255, 70, 131)'
                    }
                },
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: 'rgb(255, 158, 68)'
                        }, {
                            offset: 1,
                            color: 'rgb(255, 70, 131)'
                        }])
                    }
                },
                data: arr2
            }
        ]
    };
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);



</script>
</body>
</html>

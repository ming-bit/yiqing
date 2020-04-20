$(function(){
	//运行test函数
	test("湖北");
})

//获取用户选择的省份
function selectByName(){
	//获取id=proNameOne的html元素选中的值
	var name=$("#proNameOne").val();
	//alert(name);
	//运行
	test(name);
}


//定义一个函数
function test(pName){
	//{name:pName}传参操作
$.get("xiaoming/selectAllCountByPName.do",{name:pName},function(data){
		
		var pie_fanzui =echarts.init(document.getElementById("pie_yiqing"),'infographic'); 
		option = {
		    title : {
		        x:'center'
		    },
		    tooltip : {
		        trigger: 'item',
		        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    },
		    legend: {
		        orient: 'vertical',
		        left: 'left',
		        data: ['现有确诊','现有治愈','现有死亡'],
		        textStyle: {color: 'balck'}
		    },
		    
			label: {
			     normal: {
			          textStyle: {
			                color: 'red'  // 改变标示文字的颜色
			          }
			     }
			},
		    series : [
		        {
		            name: '今日国内疫情分析',
		            type: 'pie',
		            radius : '55%',
		            center: ['50%', '60%'],
		            data:data,
		          
		            itemStyle: {
		                emphasis: {
		                    shadowBlur: 10,
		                    shadowOffsetX: 0,
		                    shadowColor: 'rgba(0, 0, 0, 0.5)'
		                }
		            }
		            
		        }
		    ],
		    color:["red","green","blue"]//修改颜色，这一行可以去掉
		};
		
		pie_fanzui.setOption(option);
	})
}
//定义文档加载事件
$(function(){
	//定义ajax操作   找到的数据存在data
	$.get("xiaoming/hongshaorou.do",function(data){
		//设置id=allcount元素的文本值
		$("#allcount").text(data)	
	})
})

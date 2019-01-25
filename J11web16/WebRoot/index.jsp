<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.3.1.js"></script>
<style>
	#tlist{
		list-style:none;
		
	}
	#tlist li{
	float:left;
	margin-left:20px;
	}
	
</style>
</head>
<body>
	<!--主题列表  -->
	<ul id="tlist">
		
	</ul><br>

	<hr>
	<!--新闻列表  -->
	<table id="opi">
	
	</table>
	
	<script>
	loadTopic();//加载主题
	loadNews();//加载新闻
	function loadTopic(){
	$.ajax({
		url:"GetTopicServlet",
		type:"get",
		dataType:"json",
		success:function(data){
			$(data.topics).each(function(i,item) {
				$("#tlist").append("<li>"+item.tname+"</li>");
			})
		}
	},"json")
	}
		/* $.get("GetTopicServlet",function(data){
			console.log(data);
		
		},"json") */
		function loadNews(){
		$.ajax({
		url:"GetNewsServlet",
		type:"get",
		dataType:"json",
		success:function(data){
			$(data.newss).each(function(i,item) {
				$("#opi").append("<tr><td>"+item.nid+
				"</td><td>"+item.ntitle+
				"</td><td>"+item.nauthor+
				"</td><td>"+item.ncreatedate+
				"</td><td><a href=''>修改</a>&nbsp;"+
				"<a href=''>删除</a></td></tr>");
				
			})
		}
	},"json")
		}
	</script>
</body>
</html>
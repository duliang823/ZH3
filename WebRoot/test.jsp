<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>雇员注册</title>
</head>
<body>
<h1>注册</h1>
<form action="#">
编号：<input id="id" type="text" style="display: block;">
姓名：<input id="name" type="text" style="display: block;">
工作：<input id="job" type="text" style="display: block;">
雇佣日期：<input id="date" type="text" style="display: block;">
基本工资：<input id="money" type="text" style="display: block;">
奖金：<input id="award" type="text" style="display: block;">
<input type="submit" value="提交" onclick="check()">
</form>
<script>
	function check(){
		/****获取文本框中的内容**************/
		var id = document.getElementById("id").value;
		var name = document.getElementById("name").value;
		var job = document.getElementById("job").value;
		var date = document.getElementById("date").value;
		var money = document.getElementById("money").value;
		var award = document.getElementById("award").value;
		var a = /^(\d{4})-(\d{2})-(\d{2})$/;     //日期格式的正则表达式 
		if(isNaN(id)||id==""){
			alert("编号请输入数字 ");
		}
		else if(name==""){
			alert("姓名不能为空 ")
		}
		else if(job==""){
			alert("工作不能为空")
		}
		else if(!a.test(date)){
			alert("日期格式不正确!") 
		}
		else if(isNaN(money)||money==""){
			alert("基本工资请输入数字 ");
		}
		else if(isNaN(award)||award==""){
			alert("奖金请输入数字");
		}
	}

</script>
</body>
</html>
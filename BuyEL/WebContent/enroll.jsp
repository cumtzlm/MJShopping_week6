<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<style>
	input[type=submit]{
    background-color: skyblue;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100px;
</style>
</head>
<body>
<center>
<h2 align='center'>MJ注册</h2>
<form action='enroll' method='post'>
用户昵称（name）：<br/>
<input type='text' name='name' placeholder='昵称'>&nbsp;<br/><br/>
用户账户（ID）：<br/>
<input type='text' name='id' placeholder='账户'>&nbsp;&nbsp;<br/><br/>
用户密码（PWD）：<br/>
<input type='text' name='pwd' placeholder='密码'>&nbsp;<br/><br/>
<input type='submit' value='立即注册'>
</center>
</form>
</body>
</html>
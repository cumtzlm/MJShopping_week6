<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选择物品购买</title>
<style>
	input[type=submit]{
    background-color: blue;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100px;}
    .b1{
    	background-image:url(image/background.jpg) ;
    }
</style>
</head>
<body class="b1">
<h5>在线人数为：${applicationScope.count}人</h5>
<center>
<h1>MJ MARKET</h1>

<c:forEach items="${sessionScope.shop}" var="good">
	<div style="border: 1px solid black;width:50%;"><label for="good">${good.gname}</label></div>
</c:forEach>
<br /><br />
<form action='shop' method='post'>
需要购买:
<select name='gname'>
	<c:forEach items="${sessionScope.shop}" var="good">
		<option  value="${good.gname}">${good.gname}</option>
	</c:forEach>
</select>

购买数量:<input type='text' name='gnumber' placeholder='请输入购买数量'>&nbsp;&nbsp;<br/><br/>
<input type='submit' value='立即购买'>

</center>
</body>
</html>
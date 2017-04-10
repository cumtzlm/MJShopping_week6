<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
<style>
	input[type=button]{
    background-color: blue;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 60px;
}
.b1{
    	background-image:url(image/background.jpg) ;
    }
</style>
</head>
<body class="b1">
<h5>用户：${numb}</h5>
<center>
<h1>MJ CART</h1>
<table style="border: 1px solid black">
	<tr style="border: 1px solid black">
		<td style="border: 1px solid black">您所购买的商品</td>
		<td style="border: 1px solid black">购买数量</td>
	</tr>
	<c:forEach items="${maplist}" var="cart"> 
	<tr style="border: 1px solid black">        
		<td style="border: 1px solid black">${cart.gname} </td>                 
		<td style="border: 1px solid black">${cart.gnumber}</td>
	</tr>
	</c:forEach>
</table>
<p><a href="shop.jsp"><input type="button" value="返回"/></a></p>

</center>
</body>
</html>
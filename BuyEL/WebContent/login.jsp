<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<style>
form {
    border: 3px solid #f1f1f1;
    width:60%;
    margin:0px auto;
}

input[type=text], input[type=password] {
    width: 25%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

button,input[type=button]{
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100px;
}


.imgcontainer {
    text-align: center;	
    margin: 24px 0 12px 0;
}

img.avatar {
    width: 10%;
    border-radius: 45%;
}

.container {
    padding: 16px;
}

span.psw {
    float: right;
    padding-top: 16px;
}


</style>
<body>
<center>
<h2>MJ欢迎您</h2>
</center>
<form action="login" method="post">
<center>
  <div class="container">
    <label><b>用户名</b></label>
    <input type="text" placeholder="请输入用户名" name="loginId" ><br />

    <label><b>密&emsp;码</b></label>
    <input type="password" placeholder="请输入密码" name="pwd" ><br />
        
    <button type="submit">登录</button>
    <a href="enroll.jsp"><input type="button" value="注册"/></a>
  </div>
</center>
</form>

</body>
</html>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>User Register</h1>

<form action="RegisterInt.jsp" method="post">

Name:<input type="text" name="uname" placeholder="Enter Your Name"> <br/>
E-Mail:<input type="text" name="email" placeholder="Enter Your EMail Address"/><br>
Password:<input type="password" name="pass" placeholder="Enter Your Password"/> <br/>
ReEnter Password:<input type="password" name="rpass" placeholder="Confirm Password"/><br/>

<input type="Submit" value="Register">

</form>

<b>${errormsg}</b>
</body>
</html>
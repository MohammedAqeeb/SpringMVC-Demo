<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>User Login</h1>
<form action="LoginInt.jsp" method="post"> <br/>

Enter Email:<input type="text"name="email" > <br/>
Enter Password:<input type="password"name="pass"><br/>
<input type="submit" value="submit">

</form>
<b>${errorMSG}</b>
</body>
</html>
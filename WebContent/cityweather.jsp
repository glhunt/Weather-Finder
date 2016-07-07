<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import = "main.FindWeather" %>   
<%
  FindWeather fw = new FindWeather();
// Grab the variables from the form.
  String city = request.getParameter("city");
  String temperature = fw.getWeather(city);
%>

The temperature in <%=city%><br>
 <%=temperature%> degrees Fareinheit.

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="bean" class="bean.SearchBean" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%if(bean.isExist()){%>

<%=bean.getId()%>
<%=bean.getName()%>
<%=bean.getDate() %>
<%=bean.getSex().getSex() %>
<% } else {%>
その会員はいません。
<%} %>
</body>
</html>
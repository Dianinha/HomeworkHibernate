<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="style.jspf"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All authors</title>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<h1>List of authors:</h1>
	<br>
	<c:forEach items="${authors}" var="author">
		Name: <c:out value="${author.firstName}"></c:out>
		<br>
		 Surname: <c:out value="${author.lastName}"></c:out>
		<br>
		<a href="/CMS/author/edit/${author.id}">
			<button type="button">Edit</button>
		</a>
		<a href="/CMS/author/delete/${author.id}">
			<button type="button">Delete</button>
		</a>
		<br>
		<br>
	</c:forEach>
</body>
</html>


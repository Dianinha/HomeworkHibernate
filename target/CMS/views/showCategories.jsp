<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="style.jspf"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All categories</title>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<h1>List of categories:</h1>
	<br>
	<c:forEach items="${categories}" var="cat">
		Name: <c:out value="${cat.name}"></c:out>
		<br>
		 Description: <c:out value="${cat.description}"></c:out>
		<br>
		<a href="/CMS/category/edit/${cat.id}">
			<button type="button">Edit</button>
		</a>
		<a href="/CMS/category/delete/${cat.id}">
			<button type="button">Delete</button>
		</a>
		<br>
		<br>
	</c:forEach>
</body>
</html>


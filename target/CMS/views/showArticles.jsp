<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="style.jspf"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All articles</title>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<h1>List of articles:</h1>
	<br>
	<c:forEach items="${articles}" var="article">
		Title: <c:out value="${article.title}"></c:out>
		<br>
		 Content: <c:out value="${article.content}"></c:out>
		<br>
		Author: <c:out value="${article.author.firstName}"></c:out> <c:out value="${article.author.lastName}"></c:out>
		<br>
		Categories: <br>
		<ul>
		<c:forEach items="${article.categories}" var="cat">
		<li><c:out value="${cat.name }"></c:out></li>
		<br>
		</c:forEach></ul>
		<br>
		<a href="/CMS/article/edit/${article.id}">
			<button type="button">Edit</button>
		</a>
		<a href="/CMS/article/delete/${article.id}">
			<button type="button">Delete</button>
		</a>
		<br>
		<br>
	</c:forEach>
	
</body>
</html>


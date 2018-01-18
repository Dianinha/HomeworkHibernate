<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit article</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<c:if test="${not empty message}">
<c:out value="${message}"></c:out>
</c:if>
<br>
<h1>Edit article:</h1>
<br>
<form:form method="post" modelAttribute="article">
		Title: <form:input path="title" value="${article.title}"/>
		<br>
		Content: <form:textarea path="content" rows="5" cols="30" placeholder="${article.content}"/>
		<br>
		Author: 
		<form:select path="author.id" >
		<form:options items="${authors}" itemLabel="lastName" itemValue="id"/>
		</form:select>
		<br>
		Categories: <br>
		<form:checkboxes path="categories" items="${categories}"
			itemLabel="name" itemValue="id" /> 
		<input type="submit" value="Save">
	</form:form>
	
	<br>
<a href=""> <button type="button">Back to homepage</button> </a>
</body>
</html>
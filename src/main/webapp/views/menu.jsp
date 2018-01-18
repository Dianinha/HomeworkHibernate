<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<ul>
	<li><a href=<c:url value="/homepage"/>>Home</a></li>
	<li><a href=<c:url value="/category/all"/>>Categories</a>
		<ul>
			<li><a href=<c:url value="/category/add"/>>Add new</a></li>
		</ul></li>
	<li><a href=<c:url value="/article/all"/>>Articles</a>
		<ul>
			<li><a href=<c:url value="/article/add"/>>Add new</a></li>
		</ul></li>
	<li><a href=<c:url value="/author/all"/>>Authors</a>
		<ul>
			<li><a href=<c:url value="/author/add"/>>Add new</a></li>
		</ul></li>
</ul>

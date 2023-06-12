<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Project Manager Dashboard</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>

	<div class="container">
		<h4>Hello, ${ usuario.nombre }</h4>
		<div class="text-end">
			<a href="/logout">Logout</a>
		</div>
		<hr />
		<h3>All Song Labs</h3>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Song</th>
					<th># of Collaborations</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ song_yo }" var="c">
					<tr>
						<td>
						<a href="/songs/${ c.id }">${ c.titulo }</a>
						<p>Genre: ${ c.genero }</p>
						</td>
						<td>${c.id}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		 <a class="btn btn-primary"
				href="/songs/new"> &#60; new song</a>
	</div>
</body>
</html>

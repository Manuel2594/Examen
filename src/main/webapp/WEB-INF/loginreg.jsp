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
<title>Project Manager</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>

	<div class="container">
	
	<h1 class="text-primary text-center">Lyrics Lab</h1>
		<div class="row">
			<div class="col-4 offset-1 ">

				<h2>Register</h2>
				<div>
					<form:errors path="user.*" class="text-danger" />
				</div>
				<form:form method="POST" action="/registration"
					modelAttribute="user">
					<div class="d-flex justify-content-between mt-3">
						<form:label path="nombre" class="fs-5 col-4">Name:</form:label>
						<form:input class="col-8 form-control w-50" type="text" path="nombre" />
					</div>
					<div class="d-flex justify-content-between mt-3">
						<form:label path="email" class="fs-5 col-4">Email:</form:label>
						<form:input class="col-8 form-control w-50" type="email" path="email" />
					</div>
					
					<div class="d-flex justify-content-between mt-3">
						<form:label path="password" class="fs-5 col-4">Password:</form:label>
						<form:password class="col-8 form-control w-50" path="password"  />
					</div>
					<div class="d-flex justify-content-between mt-3">
						<form:label path="passwordConfirmation" class="fs-5 col-4">Confirm PW:</form:label>
						<form:password path="passwordConfirmation" class="col-8 form-control w-50" />
					</div>
					<button type="submit" class="btn btn-success float-left mt-4">Register</button>
				</form:form>
				<p class="text-danger mt-2">
					<c:out value="${succesRegister}" />
				</p>
			</div>


			<div class="col-4 offset-2">
				<h2>Log in</h2>
				<div class="d-flex justify-content-between mt-3">
					<form:errors path="login.*" class="text-danger" />
				</div>
				<form:form method="POST" action="/login" modelAttribute="login">
					<div class="d-flex justify-content-between mt-3">
						<form:label path="email" class="fs-5 col-4">Email:</form:label>
						<form:input type="email" path="email" class="col-8 form-control w-50" />
					</div>
					<div class="d-flex justify-content-between mt-3">
						<form:label path="password" class="fs-5 col-4">Password:</form:label>
						<form:password path="password" class="col-8 form-control w-50" />
					</div>
					<button type="submit" class="btn btn-success mt-4">Login!!</button>
				</form:form>

			</div>
		</div>
	</div>

</body>
</html>

















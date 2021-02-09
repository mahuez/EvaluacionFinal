<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Ingreso</title>
<link rel="stylesheet" href='<c:out value="${pageContext.request.contextPath}"/>/resources/css/estilos.css' />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Questrial&family=Sansita+Swashed&display=swap">
<link rel="preconnect" href="https://fonts.gstatic.com/%22%3E">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Merriweather+Sans:wght@600&display=swap">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src='<c:out value="${pageContext.request.contextPath}"/>/resources/js/Jquery.js'></script>
<script src='<c:out value="${pageContext.request.contextPath}"/>/resources/js/JavaScript.js'></script>
</head>
<body>

	
	<%
	String error = (String) request.getAttribute("error");
	if (error != null && error.equals("true")) {
		out.println("<h4 style=\"color:red\">Los datos ingresados no son validos, por favor ingrese nuevamente.</h4>");
	}
	%>
	<div class="container">
		<div class="row justify-content-center align-items-center minh-100">
			<div class="w-50 p-3" style="background-color: #eee;">
	<form name='loginForm' action="<c:url value='login' />" method='POST'>
		
		<table>
			<tr>
				<td><h3>Ingresa tus datos</h3></td>
			</tr>
			<tr>
				<td>Usuario:</td>
				<td><input type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td>Contraseña:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td><input name="submit" type="submit" value="Ingresar" /></td>
				<td>
				<input name="reset" type="reset" /> 
				<input type="hidden"
					name="${_csrf.parameterName}" value="${_csrf.token}" /></td>

			</tr>
		</table>

	</form>
				</div>
		</div>
	</div>
	
</body>

</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear Cliente</title>
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

<header>
		<div class="menu_bar">
			<a href="#" class="bt-menu"><i class="fas fa-ellipsis-v"></i>Menú</a>
		</div>
		<nav>
			<ul>
				<li><a href="<%=request.getContextPath()%>/"><i class="fas fa-home"></i>Inicio</a></li>
				<li><a href="<%=request.getContextPath()%>/login"><i class="fas fa-sign-in-alt"></i>Ingresar</a></li>
				<li class="submenu"><a href="#"><i class="fas fa-users"></i>Usuarios<i class="caret fas fa-angle-down"></i></a>
					<ul class="children">
						<li><a href="<%=request.getContextPath()%>/crearusuario">Crear Usuarios</a></li>
						<li><a href="<%=request.getContextPath()%>/listarusuario">Listado Usuario</a></li>
					</ul>
				</li>	
				<li class="submenu"><a href="#"><i class="fas fa-user-graduate"></i>Capacitaciones<i class="caret fas fa-angle-down"></i></a>
					<ul class="children">
						<li><a href="<%=request.getContextPath()%>/crearcapacitacion">Crear Capacitacion</a></li>
						<li><a href="<%=request.getContextPath()%>/listarcapacitacion">Listado Capacitaciones</a></li>
					</ul>
				</li>
				<li><a href="#"><i class="fas fa-book-reader"></i>Asistentes</a></li>
				<li><a href="#"><i class="fas fa-handshake"></i>Visita a Terreno</a></li>
				<li><a href="<%=request.getContextPath()%>/checklist"><i class="fas fa-exclamation-triangle"></i>Checklist</a></li>
				<li class="submenu"><a href="#"><i class="fas fa-donate"></i>Pagos<i class="caret fas fa-angle-down"></i></a>
					<ul class="children">
						<li><a href="<%=request.getContextPath()%>/crearpagos">Crear Pago</a></li>
						<li><a href="<%=request.getContextPath()%>/listarpagos">Listado Pago</a></li>
					</ul></li>
				<li class="submenu"><a href="#"><i class="far fa-comments"></i>Asesorias<i class="caret fas fa-angle-down"></i></a>
					<ul class="children">
						<li><a href="#">Crear Asesoria</a></li>
						<li><a href="#">Listado Asesoria</a></li>
					</ul></li>
				<li><a href="#"><i class="far fa-file-alt"></i>Reportes</a></li>
				<li><a href="<%=request.getContextPath()%>/contacto"><i class="fas fa-envelope"></i>Contacto</a></li>
				<li><a href="<%=request.getContextPath()%>/logout"><i class="fas fa-times-circle"></i>Cerrar Sesion</a></li>
			</ul>
		</nav>
	</header>
	
	<div class="container-banner">
		<img src='<c:out value="${pageContext.request.contextPath}"/>/resources/img/empresa.jpg'> 
	</div>

<br/>
 <div class="container">
    	<form action='<c:out value= "${pageContext.request.contextPath}"/>/procesarcrearcliente' method="POST">
    	<!---->
    <h2>Ingrese datos de Cliente</h2><br>
    	<!-- <form action='<c:out value= "${pageContext.request.contextPath}"/>/procesarcrearcliente' method="POST"> -->
			<div class="mb-3">
				<label for="rutcliente" class="form-label">Rut cliente</label> 
				<input type="text" class="form-control" id="rutcliente" name="rutcliente" placeholder="123456789">
			</div>
			<div class="mb-3">
				<label for="clinombres" class="form-label">Nombres</label> 
				<input type="text" class="form-control" id="clinombres" name="clinombres" placeholder="Sebastian Luis">
			</div>
			<div class="mb-3">
				<label for="cliapellidos" class="form-label">Apellidos</label> 
				<input type="text" class="form-control" id="cliapellidos" name="cliapellidos" placeholder="Lopez Perez">
			</div>
			<div class="mb-3">
				<label for="clitelefono" class="form-label">Telefono</label> 
				<input type="text" class="form-control" id="clitelefono" name="clitelefono" placeholder="658967412">
			</div>
			<div class="mb-3">
				<label for="cliafp" class="form-label">A.F.P</label> 
				<input type="text" class="form-control" id="cliafp" name="cliafp" placeholder="Modelo">
			</div>
			<div class="mb-3">
				<label for="clisistemasalud" class="form-label">Sistema de Salud</label> 		
				<select class="form-control" id="clisistemasalud" name="clisistemasalud">
					<option>Seleccione opción</option>
					<option value="Fonasa">Fonasa</option>
					<option value="Isapre">Isapre</option>
				</select>
			
			</div>
			<div class="mb-3">
				<label for="clidireccion" class="form-label">Dirección</label> 
				<input type="text" class="form-control" id="clidireccion" name="clidireccion" placeholder="Av.Brasil 123">
			</div>
			<div class="mb-3">
				<label for="clicomuna" class="form-label">Comuna</label> 
				<input type="text" class="form-control" id="clicomuna" name="clicomuna" placeholder="Providencia">
			</div>
			<div class="mb-3">
				<label for="cliedad" class="form-label">Edad</label> 
				<input type="text" class="form-control" id="cliedad" name="cliedad" placeholder="35">
			</div>
			<div class="mb-3">
			<!--<c:forEach items="${lusuario}" var="myusu"> </c:forEach> -->
				<label for="usuario_runusu" class="form-label">Rut Usuario</label> 
				<input type="text" class="form-control" id="usuario_runusu" value='<c:out value="${usuario.getRunusu()}"/>' name="usuario_runusu">
			
			</div>
			 <div class="col-12">
    			<button type="submit" class="btn btn-primary">Crear Cliente</button>
  			</div>
		</form>
		
	</div>
	<br/>
	<br/>
    
</body>
</html>
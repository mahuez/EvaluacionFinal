<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar Pagos</title>
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
		<img
			src='<c:out value="${pageContext.request.contextPath}"/>/resources/img/empresa.jpg'>
	</div>
<br/>
	<div class="container">
		<br /> 
		<br />
		<h2>Listado Pagos</h2>
		<table class="table">
			<thead class="table-dark">
				<tr>
					<th scope="col">Id Pagos</th>
					<th scope="col">Fecha de pago</th>
					<th scope="col">Monto</th>
					<th scope="col">Mes</th>
					<th scope="col">Año</th>
					<th scope="col">Rut Cliente</th>
					<th scope="col">Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lpagos}" var="lpa">
					<tr>
						<td><c:out value="${lpa.getIdpagos()}" /></td>
						<td><c:out value="${lpa.getFechapago()}" /></td>
						<td><c:out value="${lpa.getMonto()}" /></td>
						<td><c:out value="${lpa.getMes()}" /></td>
						<td><c:out value="${lpa.getAño()}" /></td>
						<td><c:out value="${lpa.getCliente_rutcliente()}" /></td>
						<td>
						
							<a href='<c:out value="${pageContext.request.contextPath}" />/eliminarpagos/<c:out value="${lpa.getIdpagos()}" />'><i class="fas fa-trash-alt"  title="Eliminar"></i></a>
							&nbsp; &nbsp; &nbsp; | &nbsp; &nbsp; &nbsp; 
							<a href='<c:out value="${pageContext.request.contextPath}" />/editarpagos/<c:out value="${lpa.getIdpagos()}" />'><i class="fas fa-user-edit"  title="Editar"></i></a>
							&nbsp; &nbsp; &nbsp; | &nbsp; &nbsp; &nbsp; 
							<a href='<c:out value="${pageContext.request.contextPath}" />/detallepagos/<c:out value="${lpa.getIdpagos()}" />'><i class="far fa-file-archive"  title="Detalle"></i></a>
						
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href= '<c:out value= "${pageContext.request.contextPath}"/>/crearpagos' class="btn btn-primary">Crear pagos</a>
	</div>
	<br/>
	<br/>

	<footer class="contenedor-footer">
		<div class="siguenos">
			<h2>Siguenos en nuestras redes sociales</h2>
		</div>
		<div class="redes-footer">
			<img
				src='<c:out value="${pageContext.request.contextPath}"/>/resources/img/facebook.png'>
			<img
				src='<c:out value="${pageContext.request.contextPath}"/>/resources/img/instagram.png'>
			<img
				src='<c:out value="${pageContext.request.contextPath}"/>/resources/img/twitter.png'>
		</div>
	</footer>
	<div class="derechos">
		<h2>© 2021 @grupo4 - Todos los derechos reservados</h2>
	</div>

</body>
</html>


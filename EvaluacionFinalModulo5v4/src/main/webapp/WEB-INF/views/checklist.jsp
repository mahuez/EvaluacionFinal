<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Chequeos</title>
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
 <main>
        <section>
            <h2>Lista de Chequeos</h2><br>
            <form>
                <input type="checkbox" name="chequeo" value="Reglamento interno. "> Empresa cuenta con reglamento interno.<br>
                <input type="checkbox" name="chequeo" value="E.P.P. "> Empresa cuenta con E.P.P.<br>
                <input type="checkbox" name="chequeo" value="Comité paritario. "> Empresa cuenta con comité paritario.<br>
                <input type="checkbox" name="chequeo" value="Resolución sanitaria. "> Empresa cuenta con resolución sanitaria.<br>
                <input type="checkbox" name="chequeo" value="Sistema de evaluación ambiental."> Empresa cuenta con sistema de evaluación ambiental.<br>
                <br>
                <input type="button" onclick="validarlista()" value="Validar">
                <br><br>
                <textarea  id="contenido" rows="8" cols="42"></textarea><br>
                <input type="submit" value="Enviar">
            </form>
        </section>
    </main>
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
    
    
 <script>
        function validarlista() {
            var chequeo = document.forms[0];
            var txt = "";
            var i;
            for (i = 0; i < chequeo.length; i++) {
                if (chequeo[i].checked) {
                    txt = txt + chequeo[i].value + " ";
                    document.getElementById("contenido").value = "La empresa cuenta con: " + txt;
                } else if (txt == "") {
                    alert("Debe seleccionar al menos un chequeo.");
                    break;
                }
            }
        }
    </script>
</body>
</html>
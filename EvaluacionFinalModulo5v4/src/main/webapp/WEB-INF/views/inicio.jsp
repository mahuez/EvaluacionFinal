<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Inicio</title>
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
	
	    <!-- =============================== BANNER =============================== -->

    <div class="container-banner">
		<img src='<c:out value="${pageContext.request.contextPath}"/>/resources/img/empresa.jpg'> 
	</div>
	<br/>
	    <main>
        <section id="informacion">
            <h2>Sistema de Información</h2><br>
            <hr />
            <br>
            <h3>¿Cuál es el objetivo del sistema de información?</h3><br>
            <p>Las disposiciones preventivas requieren ser revisadas y mejoradas de forma continua.
                Para conocer la efectividad de las medidas tomadas, y a la vez estar alerta ante cualquier cambio en la
                situación,
                la empresa necesita la más amplia colaboración.</p>
            <p>Para cumplir los objetivos mencionados anteriormente, es necesario diseñar un sistema de información que
                permita canalizar y procesar adecuadamente los datos que se aporten.
                El artículo 29 de la Ley de Prevención de Riesgos Laborales, sobre Obligaciones de los Trabajadores en
                Materia de Prevención de Riesgos,
                contiene un esquema de un sistema de información útil para los objetivos de mejora continua de las
                condiciones de trabajo.</p>
            <br>
            <hr />
            <br>
            <h3>¿Quiénes deberían usarlo?</h3><br>
            <p>Cada trabajador debe velar por el cumplimiento de las medidas de prevención que se implementen en cada
                caso,
                esto para resguardar su propia seguridad y salud, y la de todas aquellas personas que se puedan ver
                afectadas en el entorno laboral,
                ya sea por acciones y/u omisiones en el trabajo que provoquen un riesgo.</p>
            <br>
            <hr />
            <br>
            <h3>¿Qué procesos considera la plataforma actualmente?</h3><br>
            <p>Orientación a la mejora de los procesos, a la satisfacción de las necesidades de las y los trabajadores,
                y responder a sus expectativas.</p>
            <p>La dedicación, el compromiso y la participación de los altos cargos.</p>
            <p>El inicio, desarrollo y mantenimiento de una cultura (conjunto de valores y compromisos) de
                transparencia, ligada a la mejora permanente.</p>
            <p>Incentivos a la participación, mediante la consideración positiva del trabajador.</p>
            <br>
            <hr />
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
</body>
</html>
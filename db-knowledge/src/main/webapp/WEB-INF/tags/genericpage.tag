<%@tag description="Template" pageEncoding="UTF-8"%>
<%@attribute name="head" fragment="true"%>
<%@attribute name="header" fragment="true"%>
<%@attribute name="title" required="true"%>
<%@attribute name="bodyClass" required="true"%>
<%@attribute name="footer" required="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="Proyecto final de Base de Datos y Base de Conocimientos.">
    <meta name="author" content="Grupo de Maestría en Sistemas Computacionales.">
	
	<link rel="shortcut icon" type="image/x-icon"
		href="${pageContext.request.contextPath}/resources/images/logo.jpg" />
	<link rel="icon" href="${pageContext.request.contextPath}/resources/images/logo.jpg" type="image/x-icon">
	
	<script>
	        /* Favor de no remover este script vacío. Es importante para un fix de chrome y chromium.
	         https://code.google.com/p/chromium/issues/detail?id=332189*/
	</script>
	
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	
	<title>Dulcería Sevilla</title>
	
</head>
<body class="${bodyClass}">
	
	<div class="container">
		<div class="row"><br/></div>
		<div class="header clearfix">
	        <nav>
	        	<ul class="nav nav-pills pull-right">
	            	<li role="presentation" class="active">
	            		<a href="#">
	            			<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>
	            			Mi Carrito
	            		</a>
	            	</li>
	          	</ul>
	        </nav>
	        <a href="${pageContext.request.contextPath}/index.jsp">
	        	<img src="${pageContext.request.contextPath}/resources/images/logo.png" alt="La Dulcería de Sevilla" width="255" height="108">
	        </a>
      	</div>
	</div>
	<div class="row">
      	<nav class="navbar navbar-default">
      		<div class="container-fluid">
			    <div class="navbar-header">
			      <a class="navbar-brand" href="#">Categorias</a>
			    </div>
			    <ul class="nav navbar-nav">
					<li><a href="${pageContext.request.contextPath}/items-page.jsp?cat=populares">Populares</a></li>
					<li><a href="${pageContext.request.contextPath}/items-page.jsp?cat=dulces">Dulces</a></li>
					<li><a href="${pageContext.request.contextPath}/items-page.jsp?cat=salados">Salados</a></li> 
					<li><a href="${pageContext.request.contextPath}/items-page.jsp?cat=bebidas">Bebidas</a></li>
					<li><a href="${pageContext.request.contextPath}/items-page.jsp?cat=repostreria">Reposteria</a></li>  
			    </ul>
			  	<form class="navbar-form navbar-right">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
			    </form>
		    </div>
		</nav>
	</div>
<jsp:doBody />
<div class="row"><br/></div>
	<div class="row"><br/></div>
	
    <!-- Site footer -->
    <footer class="footer">
		<div class="panel panel-default">
	  		<div class="panel-footer text-center">
	  			<p>©2016 | Todos los derechos reservados.</p>
	  			<p>sevilla-dulceria.com.mx: Siempre encuentras todo para tus eventos.</p>
	  			<p>Miguel Ángel de Quevedo 2779, Formando Hogar, 91897 Veracruz, Ver.</p>
	  		</div>
		</div>
    </footer>
</body>
</html>
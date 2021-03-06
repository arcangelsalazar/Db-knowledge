<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<t:genericpage title="Sevilla Dulcería" bodyClass="body2">
	<jsp:body>
		<c:if test="${not empty infor}">
			<div id="success-alert" class="alert alert-success fade in">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				<strong>Dulceria Sevilla:</strong> ${infor}
			</div>
		</c:if>
		<style>
	  		.carousel-inner > .item > img,
	  		.carousel-inner > .item > a > img {
	      		width: 50%;
	      		margin: auto;
	  		}
	  	</style>
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
		    <!-- Indicators -->
		    <ol class="carousel-indicators">
		    	<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		      	<li data-target="#myCarousel" data-slide-to="1"></li>
		      	<li data-target="#myCarousel" data-slide-to="2"></li>
		      	<li data-target="#myCarousel" data-slide-to="3"></li>
		    </ol>
		
		    <!-- Wrapper for slides -->
		    <div class="carousel-inner" role="listbox">
		      <div class="item active text-center">
		      	<a href="${pageContext.request.contextPath}/itemspage?cat=populares">
		      		<h2>Productos Populares</h2>
		        	<img src="${pageContext.request.contextPath}/resources/images/carrousel/populares.jpg" alt="Populares" width="270" height="145"> 
		      	</a>
		      </div>
		      <div class="item text-center">
		      	<a href="${pageContext.request.contextPath}/itemspage?cat=botanas">
		      		<h2>Botanas</h2>
		        	<img src="${pageContext.request.contextPath}/resources/images/carrousel/botanas.png" alt="Botanas" width="270" height="145"> 
		      	</a>
		      </div>
		      <div class="item text-center">
		      	<a href="${pageContext.request.contextPath}/itemspage?cat=confiteria">
		      		<h2>Confiteria</h2>
		        	<img src="${pageContext.request.contextPath}/resources/images/carrousel/confiteria.jpg" alt="Confiteria" width="270" height="145"> 
		      	</a>
		      </div>
		      <div class="item text-center">
		      	<a href="${pageContext.request.contextPath}/itemspage?cat=varios">
		      		<h2>Varios</h2>
		        	<img src="${pageContext.request.contextPath}/resources/images/carrousel/desechables.jpg" alt="Varios" width="270" height="145"> 
		      	</a>
		      </div>
		    </div>
		
		    <!-- Left and right controls -->
		    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
		      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
		      <span class="sr-only">Anterior</span>
		    </a>
		    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
		      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
		      <span class="sr-only">Siguiente</span>
		    </a>
		  </div>
		  <script type="text/javascript">
		$(document).ready (function(){
			$("#success-alert").fadeTo(5000, 500).slideUp(500, function(){
				$("#success-alert").slideUp(500); 
			});
		});
		</script>
	</jsp:body>
</t:genericpage>

<!--  
<div class="container">
	<form action=<c:url value="/login"/> method="post">
	<div class="row">
       <div class="col-md-offset-5 col-md-3">
           <div class="form-login">
           <h4>Iniciar sesión</h4>
           <input type="text" name="username" class="form-control input-sm chat-input" placeholder="Usuario" />
           </br>
           <input type="text" name="password" type="password" class="form-control input-sm chat-input" placeholder="Contraseña" />
           </br>
           <div class="wrapper">
           <span class="group-btn">     
               <input class="btn btn-primary btn-md" type="submit" value="Submit">
           </span>
           </div>
           </div>
       </div>
	</form>
</div>
-->

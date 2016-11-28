<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<t:genericpage title="Sevilla Dulcería" bodyClass="body2">
	<jsp:body>
		<div id="success-alert" class="alert alert-success fade in">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			<strong>Carrito de Compras:</strong> Producto agregado satisfactoriamente.
		</div>
		<div class="row col-md-12">
			<div class="col-md-4">
				<img src="${pageContext.request.contextPath}/resources/images/coca.png" alt="bebida" width="200" height="200">
    		</div>
    		<div class="col-md-8">
    			<h3>Coca Cola 600 ml.</h3>
    			<p>No hay mucho que decir, es una Coca Cola y es de 600 ml.</p>
    			<p>Y es de Pet.</p>
			</div>
		</div>
		<div class="row col-md-12">
			<br/><br/>
		</div>
		<div class="row col-md-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4>Articulos Recomendados</h4>
				</div>
			  	<div class="panel-body">
			  		<div class="row">
						<div class="col-md-6">
							<div class="col-lg-6 text-center">
					          	<img src="${pageContext.request.contextPath}/resources/images/coca.png" alt="La Dulcería de Sevilla" width="150" height="150">
					          	<p>Coca cola 600 ml</p>
					          	<p><a class="btn btn-primary" href="${pageContext.request.contextPath}/agregar-carrito.jsp?articulo=1" role="button"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></a></p>
					        </div>
					        <div class="col-lg-6 text-center">
					          	<img src="${pageContext.request.contextPath}/resources/images/coca.png" alt="La Dulcería de Sevilla" width="150" height="150">
					          	<p>Coca cola 600 ml</p>
					          	<p><a class="btn btn-primary" href="${pageContext.request.contextPath}/agregar-carrito.jsp?articulo=1" role="button"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></a></p>
					        </div>
						</div>
				        <div class="col-md-6">
							<div class="col-lg-6 text-center">
					          	<img src="${pageContext.request.contextPath}/resources/images/coca.png" alt="La Dulcería de Sevilla" width="150" height="150">
					          	<p>Coca cola 600 ml</p>
					          	<p><a class="btn btn-primary" href="${pageContext.request.contextPath}/agregar-carrito.jsp?articulo=1" role="button"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></a></p>
					        </div>
					        <div class="col-lg-6 text-center">
					          	<img src="${pageContext.request.contextPath}/resources/images/coca.png" alt="La Dulcería de Sevilla" width="150" height="150">
					          	<p>Coca cola 600 ml</p>
					          	<p><a class="btn btn-primary" href="${pageContext.request.contextPath}/agregar-carrito.jsp?articulo=1" role="button"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></a></p>
					        </div>
						</div>
					</div>
			  	</div>
			</div>
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

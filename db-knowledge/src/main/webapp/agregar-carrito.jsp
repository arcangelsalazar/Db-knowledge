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
				<img src="${pageContext.request.contextPath}/resources/images/productos/${producto_id}.png" alt="bebida" width="200" height="200">
    		</div>
    		<div class="col-md-8">
    			<h3>${producto}</h3>
    			<p>$ ${precio}</p>
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
					          	<c:if test="${not empty producto1_id}">
						          	<img src="${pageContext.request.contextPath}/resources/images/productos/${producto1_id}.png" alt="La Dulcería de Sevilla" width="150" height="150">
						          	<p>${producto1}</p>
						          	<p><a class="btn btn-primary" href="${pageContext.request.contextPath}/agregarcarrito?articulo=${producto1_id}" role="button"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></a></p>
						        </c:if>
					        </div>
					        <div class="col-lg-6 text-center">
					          	<c:if test="${not empty producto2_id}">
						          	<img src="${pageContext.request.contextPath}/resources/images/productos/${producto2_id}.png" alt="La Dulcería de Sevilla" width="150" height="150">
						          	<p>${producto2}</p>
						          	<p><a class="btn btn-primary" href="${pageContext.request.contextPath}/agregarcarrito?articulo=${producto2_id}" role="button"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></a></p>
						        </c:if>
					        </div>
						</div>
				        <div class="col-md-6">
							<div class="col-lg-6 text-center">
					          	<c:if test="${not empty producto3_id}">
						          	<img src="${pageContext.request.contextPath}/resources/images/productos/${producto3_id}.png" alt="La Dulcería de Sevilla" width="150" height="150">
						          	<p>${producto3}</p>
						          	<p><a class="btn btn-primary" href="${pageContext.request.contextPath}/agregarcarrito?articulo=${producto3_id}" role="button"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></a></p>
						        </c:if>
					        </div>
					        <div class="col-lg-6 text-center">
					          	<c:if test="${not empty producto4_id}">
						          	<img src="${pageContext.request.contextPath}/resources/images/productos/${producto4_id}.png" alt="La Dulcería de Sevilla" width="150" height="150">
						          	<p>${producto4}</p>
						          	<p><a class="btn btn-primary" href="${pageContext.request.contextPath}/agregarcarrito?articulo=${producto4_id}" role="button"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></a></p>
						        </c:if>
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

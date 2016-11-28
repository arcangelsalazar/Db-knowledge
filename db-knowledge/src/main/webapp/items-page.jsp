<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<t:genericpage title="Sevilla Dulcería" bodyClass="body2">
	<jsp:body>
		<div class="row col-md-12">
			<div class="col-md-2">
				<h4>Marcas</h4>
				<div class="list-group">
				    <a href="${pageContext.request.contextPath}/items-page.jsp?cat=populares&marca=marca1" class="list-group-item">Marca 1</a>
				    <a href="${pageContext.request.contextPath}/items-page.jsp?cat=populares&marca=marca2" class="list-group-item">Marca 2</a>
				    <a href="${pageContext.request.contextPath}/items-page.jsp?cat=populares&marca=marca3" class="list-group-item">Marca 3</a>
				    <a href="${pageContext.request.contextPath}/items-page.jsp?cat=populares&marca=marca4" class="list-group-item">Marca 4</a>
				    <a href="${pageContext.request.contextPath}/items-page.jsp?cat=populares&marca=marca5" class="list-group-item">Marca 5</a>
				    <a href="${pageContext.request.contextPath}/items-page.jsp?cat=populares&marca=marca6" class="list-group-item">Marca 6</a>
				    <a href="${pageContext.request.contextPath}/items-page.jsp?cat=populares&marca=marca7" class="list-group-item">Marca 7</a>
				    <a href="${pageContext.request.contextPath}/items-page.jsp?cat=populares&marca=marca8" class="list-group-item">Marca 8</a>
				    <a href="${pageContext.request.contextPath}/items-page.jsp?cat=populares&marca=marca9" class="list-group-item">Marca 9</a>
				    <a href="${pageContext.request.contextPath}/items-page.jsp?cat=populares&marca=marca10" class="list-group-item">Marca 10</a>
				  </div>
    		</div>
    		<div class="col-md-10">
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
				<div class="row">
					<div class="col-md-6">
						<div class="col-lg-6 text-center">
				          	<img src="${pageContext.request.contextPath}/resources/images/coca.png" alt="La Dulcería de Sevilla" width="150" height="150">
				          	<p>Coca cola 600 ml</p>
				          	<p><a class="btn btn-primary" href="#" role="button"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></a></p>
				        </div>
				        <div class="col-lg-6 text-center">
				          	<img src="${pageContext.request.contextPath}/resources/images/coca.png" alt="La Dulcería de Sevilla" width="150" height="150">
				          	<p>Coca cola 600 ml</p>
				          	<p><a class="btn btn-primary" href="#" role="button"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></a></p>
				        </div>
					</div>
			        <div class="col-md-6">
						<div class="col-lg-6 text-center">
				          	<img src="${pageContext.request.contextPath}/resources/images/coca.png" alt="La Dulcería de Sevilla" width="150" height="150">
				          	<p>Coca cola 600 ml</p>
				          	<p><a class="btn btn-primary" href="#" role="button"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></a></p>
				        </div>
				        <div class="col-lg-6 text-center">
				          	<img src="${pageContext.request.contextPath}/resources/images/coca.png" alt="La Dulcería de Sevilla" width="150" height="150">
				          	<p>Coca cola 600 ml</p>
				          	<p><a class="btn btn-primary" href="#" role="button"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></a></p>
				        </div>
					</div>
				</div>
			</div>
		</div>
	</jsp:body>
</t:genericpage>

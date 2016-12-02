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
				    <a href="${pageContext.request.contextPath}/itemspage?cat=${cat}&marca=${marca1}" class="list-group-item">${marca1}</a>
				    <c:if test="${not empty marca2}">
				    	<a href="${pageContext.request.contextPath}/itemspage?cat=${cat}&marca=${marca2}" class="list-group-item">${marca2}</a>
				    </c:if>
				    <c:if test="${not empty marca3}">	
				    	<a href="${pageContext.request.contextPath}/itemspage?cat=${cat}&marca=${marca3}" class="list-group-item">${marca3}</a>
				    </c:if>
				  </div>
    		</div>
    		<div class="col-md-10">
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
				          		<img src="${pageContext.request.contextPath}/resources/images/productos/${producto1_id}.png" alt="La Dulcería de Sevilla" width="150" height="150">
				          		<p>${producto2}</p>
				          		<p><a class="btn btn-primary" href="${pageContext.request.contextPath}/agregarcarrito?articulo=${producto2_id}" role="button"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></a></p>
				          	</c:if>
				        </div>
					</div>
			        <div class="col-md-6">
						<div class="col-lg-6 text-center">
				          	<c:if test="${not empty producto3_id}">	
				          		<img src="${pageContext.request.contextPath}/resources/images/productos/${producto1_id}.png" alt="La Dulcería de Sevilla" width="150" height="150">
				          		<p>${producto3}</p>
				          		<p><a class="btn btn-primary" href="${pageContext.request.contextPath}/agregarcarrito?articulo=${producto3_id}" role="button"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></a></p>
				          	</c:if>
				        </div>
				        <div class="col-lg-6 text-center">
				          	<c:if test="${not empty producto4_id}">	
				          		<img src="${pageContext.request.contextPath}/resources/images/productos/${producto4_id}.png" alt="La Dulcería de Sevilla" width="150" height="150">
				          		<p>${producto1}</p>
				          		<p><a class="btn btn-primary" href="${pageContext.request.contextPath}/agregarcarrito?articulo=${producto4_id}" role="button"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></a></p>
				          	</c:if>
				        </div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="col-lg-6 text-center">
				          	<c:if test="${not empty producto5_id}">	
				          		<img src="${pageContext.request.contextPath}/resources/images/productos/${producto1_id}.png" alt="La Dulcería de Sevilla" width="150" height="150">
				          		<p>${producto5}</p>
				          		<p><a class="btn btn-primary" href="${pageContext.request.contextPath}/agregarcarrito?articulo=${producto5_id}" role="button"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></a></p>
				          	</c:if>
				        </div>
				        <div class="col-lg-6 text-center">
				          	<c:if test="${not empty producto6_id}">	
				          		<img src="${pageContext.request.contextPath}/resources/images/productos/${producto1_id}.png" alt="La Dulcería de Sevilla" width="150" height="150">
				          		<p>${producto6}</p>
				          		<p><a class="btn btn-primary" href="${pageContext.request.contextPath}/agregarcarrito?articulo=${producto6_id}" role="button"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></a></p>
				          	</c:if>
				        </div>
					</div>
			        <div class="col-md-6">
						<div class="col-lg-6 text-center">
				          	<c:if test="${not empty producto7_id}">	
				          		<img src="${pageContext.request.contextPath}/resources/images/productos/${producto7_id}.png" alt="La Dulcería de Sevilla" width="150" height="150">
				          		<p>${producto7}</p>
				          		<p><a class="btn btn-primary" href="${pageContext.request.contextPath}/agregarcarrito?articulo=${producto7_id}" role="button"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></a></p>
				          	</c:if>
				        </div>
				        <div class="col-lg-6 text-center">
				          	<c:if test="${not empty producto8_id}">	
				          		<img src="${pageContext.request.contextPath}/resources/images/productos/${producto8_id}.png" alt="La Dulcería de Sevilla" width="150" height="150">
				          		<p>${producto8}</p>
				          		<p><a class="btn btn-primary" href="${pageContext.request.contextPath}/agregarcarrito?articulo=${producto8_id}" role="button"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></a></p>
				          	</c:if>
				        </div>
					</div>
				</div>
			</div>
		</div>
	</jsp:body>
</t:genericpage>

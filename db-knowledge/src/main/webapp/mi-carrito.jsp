<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<t:genericpage title="Sevilla Dulcería" bodyClass="body2">
	<jsp:body>
		<div class="row col-md-10 col-md-offset-1">
			<h3>Carrito de Compras</h3>
			<div class="table-responsive">
				${miTabla}
			</div>
		</div>
		<div class="row col-md-10 col-md-offset-1">
			<div class="col-md-10 text-right">
				<h4><strong>Total:</strong></h4>
			</div>
			<div class="col-md-2 text-right">
				<h4 class="text-right"><strong>${total}</strong></h4>
			</div>
		</div>
		<div class="row col-md-10 col-md-offset-1">
			<br/>
		</div>
		<div class="row col-md-10 col-md-offset-1">
			<div class="col-md-4 col-md-offset-1 text-center">
				<a class="btn btn-danger btn-primary" href="${pageContext.request.contextPath}/micarritostatus?status=cancelar" role="button">
					<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
					&nbsp;&nbsp;&nbsp;
					Vaciar Carrito
					&nbsp;
				</a>
			</div>
			<div class="col-md-4 col-md-offset-1 text-center">
				<a class="btn btn-primary" href="${pageContext.request.contextPath}/micarritostatus?status=comprar" role="button">
					<span class="glyphicon glyphicon-usd" aria-hidden="true"></span>
					&nbsp;
					Finalizar Compra
				</a>
			</div>
		</div>
	</jsp:body>
</t:genericpage>

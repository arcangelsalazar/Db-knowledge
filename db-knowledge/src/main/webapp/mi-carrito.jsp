<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<t:genericpage title="Sevilla Dulcería" bodyClass="body2">
	<jsp:body>
		<div class="row col-md-10 col-md-offset-1">
			<h3>Carrito de Compras</h3>
			<div class="table-responsive">
				<table class="table">
					<thead>
						<tr>
					        <th>#</th>
					        <th>Producto</th>
					        <th>Cantidad</th>
					        <th>Precio</th>
					        <th>Sub-Total</th>
					      </tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td>Coca Cola 600 ml</td>
							<td>2</td>
							<td class="text-right">$ 9.00</td>
							<td class="text-right">$18.00</td>
						</tr>
						<tr>
							<td>2</td>
							<td>Coca Cola 1 L</td>
							<td>6</td>
							<td class="text-right">$ 15.00</td>
							<td class="text-right">$90.00</td>
						</tr>
						<tr>
							<td>3</td>
							<td>Coca Cola 2 L</td>
							<td>4</td>
							<td class="text-right">$ 25.00</td>
							<td class="text-right">$100.00</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row col-md-10 col-md-offset-1">
			<div class="col-md-10 text-right">
				<h4><strong>Total:</strong></h4>
			</div>
			<div class="col-md-2 text-right">
				<h4 class="text-right"><strong>$ 208.00</strong></h4>
			</div>
		</div>
		<div class="row col-md-10 col-md-offset-1">
			<br/>
		</div>
		<div class="row col-md-10 col-md-offset-1">
			<div class="col-md-4 col-md-offset-1 text-center">
				<a class="btn btn-danger btn-primary" href="${pageContext.request.contextPath}/index.jsp" role="button">
					<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
					&nbsp;&nbsp;&nbsp;
					Vaciar Carrito
					&nbsp;
				</a>
			</div>
			<div class="col-md-4 col-md-offset-1 text-center">
				<a class="btn btn-primary" href="${pageContext.request.contextPath}/index.jsp" role="button">
					<span class="glyphicon glyphicon-usd" aria-hidden="true"></span>
					&nbsp;
					Finalizar Compra
				</a>
			</div>
		</div>
	</jsp:body>
</t:genericpage>

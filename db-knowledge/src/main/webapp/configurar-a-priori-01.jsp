<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<t:genericpage title="Sevilla Dulcería" bodyClass="body2">
	<jsp:body>
		<form action=<c:url value="/apriori"/> method="post">
			<div class="row col-md-6 col-md-offset-3">
				<h3>Configuracion de A-priori</h3>
			</div>
			<div class="row col-md-6 col-md-offset-3">
				<div class="col-md-6">
					<p>Soporte Minimo: </p>
	    		</div>
	    		<div class="col-md-6">
	    			<div class="input-group">
					    <span class="input-group-addon">%</span>
					    <input id="soporte" type="number" class="form-control" name="soporte" placeholder="Soporte Minimo">
					  </div>
				</div>
			</div>
			<div class="row col-md-6 col-md-offset-3 text-center">
				<br/>
			</div>
			<div class="row col-md-6 col-md-offset-3">
				<div class="col-md-6">
					<p>Confianza: </p>
	    		</div>
	    		<div class="col-md-6">
	    			<div class="input-group">
					    <span class="input-group-addon">%</span>
					    <input id="confianza" type="number" class="form-control" name="confianza" placeholder="Confianza">
					  </div>
				</div>
			</div>
			<div class="row col-md-6 col-md-offset-3 text-center">
				<br/><br/>
			</div>
			<div class="row col-md-6 col-md-offset-3 text-center">
				<span class="group-btn">
					<div class="wrapper">
                                        <span class="group-btn">     
                                            <input class="btn btn-primary btn-md" type="submit" value="Recalcular Algoritmo">
                                        </span>
                                    </div>
				</span>
			</div>
			<div class="row col-md-6 col-md-offset-3 text-center">
				<br/><br/>
			</div>
		</form>
	</jsp:body>
</t:genericpage>

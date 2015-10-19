<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/imports.jsp" %>
<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li class="active" style="text-align: center;"><a href="/site/expert/index">Principal</a></li>
		<li><button class="btn btn-warning btn-block" id="btn-form">Cadastrar Paciente</button></li>
	</ul>
	
	<c:if test="${not empty sessionScope.patient}">
		<app:showPatient/>
	</c:if>
	
</div>



<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/imports.jsp" %>

<div id="historic">
	<hr size="100">
	<div id="info" align="center">
		<c:if test="${not empty patient.photo}">
			<img class="thumbnail" width="140" height="140" src="${patient.photo}">
		</c:if>
		
		<label>${patient.name}</label><br>
		
		<c:if test="${not empty patient.rg}">
			<label>${patient.rg}</label><br>
		</c:if>
		
		<button class="btn btn-primary" onClick="location.href='/site/session/patient/finalize'">Finalizar</button>
		
	</div> 
	<hr/>
 </div>
 
 
 
 
 
 
 

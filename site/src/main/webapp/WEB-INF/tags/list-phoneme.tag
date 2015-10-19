<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/imports.jsp" %>

<%@ attribute name="list" required="true" rtexprvalue="true"
	type="java.util.List"%>

<div class="col-sm-1 col-sm-1 list-group" style="text-align: center;">
	<c:forEach items="${list}" var="element">
		<a class="select list-group-item">
			<strong style="font-size: 20px;">${element.content}</strong>
			<input type="hidden" id="phoneme" value="${element.id}"/>
		</a>
	</c:forEach>
</div>

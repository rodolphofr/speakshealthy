<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/imports.jsp"%>

<%@ attribute name="title" required="true" rtexprvalue="true"
	type="java.lang.String"%>

<%@ attribute name="list" required="true" rtexprvalue="true"
	type="java.util.List"%>

<div>
	<h4>${title}</h4>
	<c:forEach items="${list}" var="item">
		<a class="select" style="margin: 5px; font-size: 15px;">
			${item.name}
			<input type="hidden" value="${item.id}">
		</a>
	</c:forEach>
</div>
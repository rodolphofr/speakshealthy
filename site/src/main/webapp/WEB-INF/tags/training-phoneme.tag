<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/imports.jsp"%>

<%@ attribute name="phonemes" required="true" rtexprvalue="true"
	type="java.util.List"%>

<%@ attribute name="archiphonemes" required="true" rtexprvalue="true"
	type="java.util.List"%>

<div class="dropdown">
	<button class="btn btn-default dropdown-toggle" type="button"
		id="menu1" data-toggle="dropdown">
		Fonemas <span class="caret"></span>
	</button>
	<ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
		<li role="presentation"><a role="menuitem" tabindex="-1" href="#"
			class="title"><b>Fonema</b></a></li>
		<c:forEach items="${phonemes}" var="phoneme">
			<li role="presentation">
				<a class="select" style="margin: 5px; font-size: 15px;">
					${phoneme.name} <input type="hidden" value="${phoneme.id}">
				</a>
			</li>
		</c:forEach>

		<li role="presentation" class="divider"></li>

		<li role="presentation"><a role="menuitem" tabindex="-1" href="#"
			class="title"><b>Arquifonemas</b></a></li>
		<c:forEach items="${archiphonemes}" var="archiphoneme">
			<li role="presentation">
				<a class="select" style="margin: 5px; font-size: 15px;">
					${archiphoneme.name} <input type="hidden" value="${archiphoneme.id}">
				</a>
			</li>
		</c:forEach>

	</ul>
</div>








<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/imports.jsp"%>

<%@ attribute name="phonemes" required="true" rtexprvalue="true"
	type="java.util.List"%>

<%@ attribute name="archiphonemes" required="true" rtexprvalue="true"
	type="java.util.List"%>

<div class="dropdow">
	<button class="btn btn-default dropdown-toggle" type="button"
		id="menu1" data-toggle="dropdown">
		Fonemas <span class="caret"></span>
	</button>
	<ul class="dropdown-menu" role="menu" aria-labelledby="menu1">

		<li role="presentation"><a role="menuitem" tabindex="-1"
			href="/site/acquirement/vowel"><b>Vogais</b></a></li>

		<li role="presentation" class="divider"></li>

		<li role="presentation"><a role="menuitem" tabindex="-1" href="#"
			class="title"><b>Fonema</b></a></li>
		<c:forEach items="${phonemes}" var="phoneme">
			<li role="presentation"><a role="menuitem" tabindex="-1"
				href="/site/acquirement/consonant/${phoneme.id}">${phoneme.name}</a>
			</li>
		</c:forEach>

		<li role="presentation" class="divider"></li>

		<li role="presentation"><a role="menuitem" tabindex="-1" href="#"
			class="title"><b>Arquifonemas</b></a></li>
		<c:forEach items="${archiphonemes}" var="archiphoneme">
			<li role="presentation"><a role="menuitem" tabindex="-1"
				href="/site/acquirement/archiphoneme/${archiphoneme.id}">${archiphoneme.name}</a></li>
		</c:forEach>

	</ul>
</div>








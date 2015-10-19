<%@ include file="/WEB-INF/imports.jsp"%>
<app:head />
<app:border />
<body>
	<app:menu />
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div id="title">
					<h3>Fonema ${phoneme.name}</h3>
					<hr/>
				</div>
				<app:list-phoneme list="${consonants}"/>
				<c:choose>
					<c:when test="${not empty sessionScope.patient}">	
						<app:acquirement-records/>
					</c:when>
					<c:otherwise>
						<app:video-phoneme/>
					</c:otherwise>
				</c:choose>	
				<input type="hidden" id="exercise" value=""/>				
			</div>
		</div>
	</div>
	<script type="text/javascript" charset="utf8" src="<c:url value='/resources/js/exercise-acquirement-form.js'/>"></script>
	<script type="text/javascript" charset="utf8" src="<c:url value='/resources/js/session.js'/>"></script>
</body>

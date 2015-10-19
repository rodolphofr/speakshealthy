<%@ include file="/WEB-INF/imports.jsp"%>
<app:head />
<app:border />
<body>
	<app:menu />
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div id="title">
					<h2>Vogais</h2>
					<hr/>
				</div>
				<app:list-phoneme list="${vowels}"/>
				<c:choose>
					<c:when test="${not empty sessionScope.patient}">	
						<app:acquirement-records/>
					</c:when>
					<c:otherwise>
						<app:video-phoneme/>
					</c:otherwise>
				</c:choose>
			</div>
				<input type="hidden" id="exercise" value=""/>			
			</div>
		</div>
	<script type="text/javascript" charset="utf8" src="<c:url value='/resources/js/session.js'/>"></script>
	<script type="text/javascript" charset="utf8" src="<c:url value='/resources/js/exercise-acquirement-form.js'/>"></script>
	<script type="text/javascript" charset="utf8" src="<c:url value='/resources/js/recordings-form.js'/>"></script>
	<script type="text/javascript" charset="utf8" src="<c:url value='/resources/js/record/audio-form.js'/>"></script>
</body>

<%@ include file="/WEB-INF/imports.jsp"%>
<app:head />
<app:border />
<style>
	audio {
		width: 46px;
	}
</style>
<body>
	<app:menu />
	<div class="container-fluid">
		<div class="row" id="content" data-category="sentence">
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 id="title"></h1>
				<hr>
				<app:training-phoneme archiphonemes="${archiphonemes}" phonemes="${phonemes}"/>
				<hr/>
				<app:register-content title="Nova Frase"/>
				<c:choose>
					<c:when test="${not empty sessionScope.patient}">	
						<app:training-content-patient/>
					</c:when>
					<c:otherwise>
						<app:training-content-expert/>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
	<script type="text/javascript" charset="utf8" src="<c:url value='/resources/js/exercise.js'/>"></script>
	<script type="text/javascript" charset="utf8" src="<c:url value='/resources/js/record/audio-form.js'/>"></script>
	<script type="text/javascript" charset="utf8" src="<c:url value='/resources/js/session.js'/>"></script>
</body>

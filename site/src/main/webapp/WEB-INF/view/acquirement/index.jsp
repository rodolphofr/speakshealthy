<%@ include file="/WEB-INF/imports.jsp"%>
<app:head />
<app:border />
<body>
	<app:menu />
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<app:acquirement-phonemes phonemes="${phonemes}" archiphonemes="${archiphonemes}"/>
			</div>
		</div>
	</div>
</body>
</html>
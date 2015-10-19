<%@ include file="/WEB-INF/imports.jsp"%>
<app:head />
<app:border />
<body>
	<app:menu />
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div align="center">
					<div class="col-xs-8 col-sm-6">
						<h2 align="center">Palavras</h2>
						<a href="/site/training/words" class="thumbnail"> <img src="<c:url value="/resources/images/activities.png"/>"
							width="300px" height="300px">
						</a>
					</div>
					<div class="col-xs-8 col-sm-6">
						<h2	 align="center">Frases</h2>
						<a href="/site/training/sentences" class="thumbnail"> <img src="<c:url value="/resources/images/activities.png"/>"
							width="300px" height="300px">
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
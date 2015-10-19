<%@ tag language="java" pageEncoding="UTF-8"%>
	
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/site/expert/index"><font color="gray">Speaks</font><font color="bluecian">Healthy</font></a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li>
					<input type="search" id="search" placeholder="Buscar por paciente" class="form-control" style="margin-top: 8px;"/>
				</li>
				
				<li><a href="/site/expert/index"><b>${expert.name}</b></a></li>
				
				<li><a href="/site/session/expert/finalize">Sair</a></li>
			</ul>
		</div>
	</div>
</div>
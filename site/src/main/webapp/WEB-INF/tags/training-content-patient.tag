<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/imports.jsp"%>

<style>
	.selected {
		color:'#ff0000';
	}
</style>
<div class="col-xs-6 col-md-4 thumbnail">
	<div id="list"></div>
</div>
<div align="center" id="recordingHistory">
	<div class="col-xs-6 col-md-4">
		<div class="thumbnail">
			<strong>Nova Gravação</strong><br>
			
			<audio id="audioPatient" controls autoplay></audio><br>
			
			<button id="btn-audio-record" type="button" class="btn btn-danger" data-status="deactivated">
			 	 <span class="glyphicon glyphicon-record"></span>
			</button>
			
			<button id="btn-audio-save" type="button" class="btn btn-primary" disabled>
			 	 <span class="glyphicon glyphicon-floppy-disk"></span>
			</button>
		</div>
		
		<div class="thumbnail">	
			<h4>Histórico de gravações</h4>
			<div id="recordings"></div>
		</div>
		
		<input type="hidden" id="exercise" value=""/>
		
	</div>
</div>
<script type="text/javascript" charset="utf8" src="<c:url value='/resources/js/recordings-form.js'/>"></script>


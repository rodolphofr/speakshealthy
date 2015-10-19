<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/imports.jsp"%>

<div align="center" id="recordingHistory">
	<div class="col-md-4">
		<video class="thumbnail" id="video-phoneme" width="280" height="280" controls></video>
		<h1 id="content"></h1>
	</div>
	
	<div class="col-md-5">
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
		
	</div>
</div>


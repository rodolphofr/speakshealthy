<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/imports.jsp"%>
<app:head/>
<app:border/>
<body>
	<div id="title">
		<h3 style="margin-left: 20px;">Cadastro de videos</h3>
		<hr/>
	</div>	
	
	<div id="content" align="center">
<!-- 		<audio src="" controls></audio> -->
		<video class="thumbnail" id="video" width="320" height="240" autoplay controls></video>		
		
		<canvas class="thumbnail"  id="canvas" width="320" height="240"></canvas>
		
		<br>
		<button class="btn btn-primary" style="margin-right: 20px;" id="btn-ready">Gravar</button> 
		
		<button class="btn btn-primary" style="margin-right: 20px;" id="btn-stop">Parar</button> 
		
		<button class="btn btn-warning" id="btn-save" style="margin-right: 20px;">Salvar</button>
		
		<button class="btn btn-danger" onclick="history.go(0)" style="margin-right: 20px;">Novo vídeo</button>
		
		<br><br>
		<div class="form-group">
			<label class="control-label" for="rg">Nome do Arquivo</label>
			<div>
				<input id="fileName" name="fileName" type="text" class="form-control input-md"> 
			</div>
		</div>
		
	</div>
	
	<script>
		var recorder = new MRecordRTC(), 
		    blob,
		    context = canvas.getContext("2d"), 
		    video = document.getElementById("video"),
		    errBack = function(error) {
				console.log("Video capture error: ", error.code);
			};

		var videoObj = { audio : true, video : true	};
		
		$('#btn-ready').on('click', function() {
				
			if (navigator.getUserMedia) { // Standard
				navigator.getUserMedia(videoObj, function(stream) {
					start(stream);
				}, errBack);
			} else if (navigator.webkitGetUserMedia) { // WebKit-prefixed
				navigator.webkitGetUserMedia(videoObj, function(stream) {
					start(stream);
				}, errBack);
			} else if (navigator.mozGetUserMedia) { // Firefox-prefixed
				navigator.mozGetUserMedia(videoObj, function(stream) {
					start(stream);
				}, errBack);
			}
	
			var start = function(stream) {
				recorder.addStream(stream);
				recorder.mediaType = videoObj;
				recorder.startRecording();
				video.src = window.webkitURL.createObjectURL(stream);
				video.play();
			};
	
			timer = setInterval(function() {
				context.drawImage(video, 0, 0, 320, 240);
			}, 30);
	
		});
		
		$('#btn-stop').on('click', function() {
			recorder.stopRecording(function(url, type) {
				document.querySelector(type).src = url;
				recorder.getBlob(function(blobs) {
					blob = blobs.video;
				});
			});
		});
		
		$('#btn-save').on('click', function() {
			var data = new FormData();
			data.append("file", blob);
			data.append("fileName", $('#fileName').val());
			
			$.ajax({
				type : 'POST',
				url : '/site/upload/video',
				data : data,
				contentType : false,
				processData : false,
				success : function() { alert("Video salvo!"); },
				error: function() { alert("Não foi possível gravar o video"); }
			});
		});
		
	</script>
</body>

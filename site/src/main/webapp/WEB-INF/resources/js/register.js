var RegisterForm =	(function() {
	var form = {},
		blob,
		video,
		$photoDisplay;
		
				
	form.register = function() {
		$.get('/site/patient/register')
		.done(function(jsp) {
			bootbox.dialog({
				title: "Entre com as informações",
			    message: jsp,
			    buttons: {
			    	main: { label:"Foto", className:"btn-primary", callback: function() { start(); return false; } },
			    	render: { label:"Tirar Foto", className:"btn-warning", callback: function() { snap(); return false; } },
			    	sucess: { label:"Cadastrar", className:"btn-success", callback: function() { save(); return true; } }
			    },
			});
		});
	};
		
	function start() {
		video = document.getElementById("video");
		var videoObj = { video : true };

		// Put video listeners into place
		if(navigator.getUserMedia) { // Standard
			navigator.getUserMedia(videoObj, function(stream) {
				show(stream);
			}, errBack);
		} else if(navigator.webkitGetUserMedia) { // WebKit-prefixed
			navigator.webkitGetUserMedia(videoObj, function(stream){
				show(stream);
			}, errBack);
		}
		else if(navigator.mozGetUserMedia) { // Firefox-prefixed
			navigator.mozGetUserMedia(videoObj, function(stream){
				show(stream);
			}, errBack);
		}
		
	};
	
	function show(stream) {
		$photoDisplay = $('#photoDisplay');
		$photoDisplay.show();
		video.src = window.URL.createObjectURL(stream);
		video.play();
	};
	
	function snap() {
		var canvas = document.getElementById("canvas");
		var context = canvas.getContext("2d");
 		context.drawImage(video, 0,0, 200, 200);
 		blob = dataURItoBlob(canvas.toDataURL());
 	};
 	
 	function validation(name, rg, blob) {
 		var nameIsValid = (name !== undefined && name !== ""),
 			rgIsValid = (rg !== undefined && rg !== ""),
 			blobIsValid = blob !== undefined;
 		
 		if(nameIsValid && rgIsValid) 
 			return true;
 		
 		if(nameIsValid && blobIsValid) 
 			return true;
 		
 		if(nameIsValid && rgIsValid && blobIsValid) 
 			return true;
 		
 		return false;
 	};
 	
 	
	function save() {
		var $name = $('#name').val();
		var $rg = $('#rg').val();
		
		if(validation($name, $rg, blob)) {
			var data = new FormData();
			data.append("file", blob);
			data.append("name", $name);
			data.append("rg", $rg);
			
			
			$.ajax({
				type : 'POST',
				url : '/site/patient/save',
				data : data,
				contentType : false,
				processData : false,
				success : function(response) { 
					alert("Cadastrado!"); 
				},
				error: function() { 
					alert("Erro interno do sistema!"); 
				}
			});
			
		} else {
			alert("Preencha os campos do formulário");
		}
		
	};	
	
	
	function dataURItoBlob(dataURI) {
	    var byteString;
	    if (dataURI.split(',')[0].indexOf('base64') >= 0)
	        byteString = atob(dataURI.split(',')[1]);
	    else
	        byteString = unescape(dataURI.split(',')[1]);

	    var mimeString = dataURI.split(',')[0].split(':')[1].split(';')[0];

	    var ia = new Uint8Array(byteString.length);
	    for (var i = 0; i < byteString.length; i++) {
	        ia[i] = byteString.charCodeAt(i);
	    }

	    return new Blob([ia], {type:mimeString});
	}
	
	function errBack(e) {
		alert("Erro!");
	};
	
	return form;
	
})();
	
$(document)
.on('click', '#btn-form', RegisterForm.register);

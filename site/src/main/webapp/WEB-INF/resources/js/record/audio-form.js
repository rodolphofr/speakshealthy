var AudioForm = (function() {
		var form = {}, 
			recorder = null;
			
		form.blob = null;
		
		window.URL = window.URL || window.webkitURL;
		navigator.getUserMedia = navigator.getUserMedia	|| navigator.webkitGetUserMedia || navigator.mozGetUserMedia || navigator.msGetUserMedia;
		
		form.start = function() {
			if (navigator.getUserMedia) { //Verifica se o navegador e compativel para usar o microfone
				navigator.getUserMedia({
					audio : true //permissao ao navegador 
				}, record, error); //Caso for, e habilitado o audio e executado a funcao record
			} else {
				console.log('Seu navegador nao e compativel, por favor atualize-o!');
			}
		};
		
		function record(s) {
			var context = new AudioContext(); //Conecta entrada de audio
			var flow = context.createMediaStreamSource(s); //Obtem o fluxo de dados desde a fonte
			recorder = new Recorder(flow); //Todo o fluxo de dados que passamos a nossa lib para esta instancia
			recorder.record(); //Executa a funcao para processar a gravacaoo
		};

		form.stop = function(audioUrl) {
			recorder.stop(); //Para a gravacao
			recorder.exportWAV(function(blob) {
				audioUrl(window.URL.createObjectURL(blob)); //Cria uma URL blob temporaria;
				form.blob = blob;
			});
			recorder.clear();
		};
		
		function error(e) {
			console.log('Nao foi possivel iniciar gravacao!');
		};
		
		return form;
		
})();



var RecordingsHistoryForm = (function() {
	var form = {};

	form.audio = null;

	form.recordings = function(id) {
		$.get('/site/record/list/' + id)
		.done(function(list) {
			for (var i = 0; i < list.length; i++) {
				var record = list[i];
				create(record);
			}
		})
		.error(function() {
			alert("Erro interno do sistema!");
		});
	};

	form.recordAudio = function() {
		var $btnRecord = $(this),
			status = $btnRecord.data('status'), 
			$icon = $btnRecord.find('span'),
			$btnSave = $('#btn-audio-save');

		if (status === 'deactivated') {
			$btnRecord.data('status', "activated");

			AudioForm.start();

			var fade = function() {
				$icon.fadeOut(function() {
					$icon.fadeIn();
				});
			};

			interval = setInterval(fade, 1000);

		} else if (status === 'activated') {
			$btnRecord.data('status', "deactivated");
			
			AudioForm.stop(function(audioUrl) {
				clearInterval(interval);
				if(audioUrl != null) {
					$('#audioPatient').attr('src', audioUrl);
				}
			});
			
			$btnSave.prop('disabled', false);
		}
		
	};

	form.saveAudio = function() {
		var data = new FormData();
		data.append('file', AudioForm.blob);
		data.append('id', $('#exercise').val());

		$.ajax({
			type : 'POST',
			url : '/site/record/save/audio',
			data : data,
			contentType : false,
			processData : false,
			success : function(response) {
				create(response);
				
				if($('#content').data('category') != null) {
					ExerciseForm.list(response.exercise.phoneme.id);
				}
			},
			error : function() {
				alert("Nao foi possivel salvar o audio");
			}
		});
	};

	function create(response) {
		var html = '<strong>Data: ' + formateDate(response.date)
				+ '</strong><br>' + '<audio src="' + response.record
				+ '" controls></audio><br>';
		$('#recordings').append(html);
	};
	
	function formateDate(d) {
		var date = new Date(d),
			dateFormated = date.toLocaleDateString("pt-BR"),
			hours = date.getHours(),
			minutes = date.getMinutes(),
			seconds = date.getSeconds();

		result = dateFormated  + ' ' + hours + ':' + minutes + ':' + seconds;
		
		return result;
	}

	return form;

})();

$(document)
.on('click', '#btn-audio-save', RecordingsHistoryForm.saveAudio)
.on('click', '#btn-audio-record', RecordingsHistoryForm.recordAudio);

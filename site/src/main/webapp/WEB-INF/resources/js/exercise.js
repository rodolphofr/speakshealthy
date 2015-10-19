var ExerciseForm = (function() {
	var form = {}, $phoneme = $('#phoneme'), $title = $('#title'), $new = $('#new'), $list = $('#list'), category = $(
			'#content').data('category'), interval = null, resultOfSession = false, $lastLinkSelected = null;

	form.show = function() {
		var id = $(this).find('input').val();
		var phoneme = $(this).text();
		$title.html('Fonema ' + phoneme);
		$phoneme.attr('value', id);
		form.list(id);
	};

	form.list = function(id) {
		$.get("/site/exercise/list", {
			"id" : id,
			"category" : category
		}).done(function(list) {
			$new.val('');
			$list.empty();

			Session.hasSession(function(callback) {
				resultOfSession = callback;

				switch (category) {
				case 'word':
					for (var i = 0; i < list.length; i++) {
						showWord(list[i]);
					}

					break;

				case 'sentence':
					for (var i = 0; i < list.length; i++) {
						showSentence(list[i]);
					}

					break;
				}
				;
			});

		}).error(function() {
			alert("Erro interno do sistema");
		});
	};

	form.save = function() {

		var data = new FormData();
		data.append('content', $new.val());
		data.append('file', AudioForm.blob);
		data.append('phonemeId', $phoneme.val());
		data.append('category', category);

		var type = AudioForm.blob == null ? 'DOC' : 'AUDIO';

		data.append('type', type);

		$.ajax({
			type : 'POST',
			url : '/site/exercise/save',
			data : data,
			contentType : false,
			processData : false,
			success : function(response) {
				var blob = AudioForm.blob;

				if (blob != null) {
					blob = null;
				}

				form.list(response.phoneme.id);
			},
			error : function() {
				alert("Nao foi possivel salvar o audio");
			}
		});
	};

	form.record = function() {
		var $btnRecord = $(this), status = $btnRecord.data('status'), $icon = $btnRecord
				.find('span');

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
				if (audioUrl != null) {
					$('#audioExpert').attr('src', audioUrl);
				}
			});

		}
	};

	form.exists = function(result) {
		var content = $(this).val();
		$.get('/site/exercise/exists', {
			"content" : content
		}).done(function(response) {
			if (response) {
				alert("'" + content + "' não é uma frase!");
			}
		}).error(function() {
			alert("Erro interno do sistema");
		});
	};

	form.selectExercise = function() {
		if ($lastLinkSelected != null)
			$lastLinkSelected.css({
				"background-color" : ""
			});

		var $link = $(this), exerciseId = $link.data('exercise');

		$lastLinkSelected = $link;

		$('#exercise').attr('value', exerciseId);

		$link.css({
			"background-color" : "#B2FF99"
		});

		$('#recordings').empty();

		RecordingsHistoryForm.recordings(exerciseId);

	};

	function showSentence(exercise) {
		var content, text, check = '';

		if (exercise.demo == undefined) {
			content = '<span class="glyphicon glyphicon-asterisk" style="padding-left: 10px;"></span>';
		} else {
			content = '<audio controls style="width: 46px;"><source src="'
					+ exercise.demo + '"></audio>';
		}

		if (resultOfSession) {
			if (exercise.done) {
				check = '<span class="glyphicon glyphicon-ok"></span>';
			}
			text = '<a style="font-size: 1.8em; margin-left: 6px;" id="select" data-exercise='
					+ exercise.id + '>' + exercise.content + '</a>' + check;

		} else {
			text = '<label style="font-size: 25px;">' + exercise.content
					+ '</label>';
		}

		var html = '<div id="sentence" style="margin-left: 10px;">' + content
				+ text + '</div>';

		$list.append(html);
	}
	;

	function showWord(exercise) {
		var content, text, check = '';

		if (exercise.demo == undefined) {
			content = '<span class="glyphicon glyphicon-asterisk" style="padding-left: 15px;"></span>';
		} else {
			content = '<audio controls style="width: 46px;"><source src="'
					+ exercise.demo + '"></audio>';
		}

		if (resultOfSession) {
			if (exercise.done) {
				check = '<span class="glyphicon glyphicon-ok"></span>';
			}
			text = '<a style="font-size: 25px;" id="select" data-exercise='
					+ exercise.id + '>' + exercise.content + '</a>' + check;
		} else {
			text = '<label style="font-size: 25px;">' + exercise.content
					+ '</label>';
		}

		var html = '<div id="word" style="margin-left: 30px;">' + content
				+ text + '</div>';

		$list.append(html);
	}
	;

	return form;

})();

$(document).on('click', '.select', ExerciseForm.show)
.on('click', '#btnSave', ExerciseForm.save)
.on('click', '#btnRecord', ExerciseForm.record)
.on('blur', '#new', ExerciseForm.exists)
.on('click', '#select',		ExerciseForm.selectExercise);
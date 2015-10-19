var ExerciseForm = (function () {
	var form = {};
	
	form.get = function() {
		var id = $(this).find('input').val();
		$.get('/site/exercise/'+id)
		.done(function(exercise) {
			Session.hasSession(function(callback) {
				if(callback) {
					$('#recordings').empty();
					RecordingsHistoryForm.recordings(exercise.id);
					showExercise(exercise);
				} else {
					showExercise(exercise);
				}
			});
		})
		.error(function() {
			alert("Erro ao carregar video!");
		});
	};
	
	
	function showExercise(exercise) {
		$('#content').html(exercise.content);
		$('#video-phoneme').attr('src', exercise.demo);
		$('#exercise').attr('value', exercise.id);
	};
	
	return form;
	
})();

$(document)
.on('click', '.select', ExerciseForm.get);

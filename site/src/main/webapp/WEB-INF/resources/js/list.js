var ListExercise = (function() {
	var list = {}, 
		index = 0;
		exercises = [],
		$back = $('#btn-back').hide();
		
		
	list.exercises = function() {
		$.get("/healthyspeech/exercise/list", {
			"id" : $('#patientCareId').attr('value')
		}).done(function(list) {
			exercises = list;
			ListExercise.next();
		}).error(function() {
			alert("Erro interno do sistema!");
		});
	};
	
	list.next = function() {
		if(index >= 1) {
			$back.show();
		}
		
		if (index < exercises.length) {
			show(getExercise(index));
			index += 1;
		} else {
			alert("acabou!");
		} 
	};

	list.back = function() {
			index -= 1;
			show(getExercise(index));
			if(index == 0) {
				$back.hide();
			}
	};

	var getExercise = function(index) {
		return exercises[index];
	};

	var show = function(exercise) {
		$('#audio').css({"background-color": "black"});
		$('#url').attr('src', exercise.url);
		$('#title').html(exercise.description);
		$('#audio').attr('src', exercise.demonstration);
		$('#exercise').attr('value', exercise.id);
		$('#btn-save').prop("disabled",true);
	};

	return list;

})();

$(document)
.ready(ListExercise.exercises)
.on('click', '#btn-next', ListExercise.next)
.on('click', '#btn-back', ListExercise.back);

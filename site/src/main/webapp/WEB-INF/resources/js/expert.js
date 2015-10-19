var ExpertForm = (function() {
	var form = {},
		redirect = "/site/expert/index";
	
	form.signin = function() {
		var register = $('#register').val(),
			region = $('#select').val();
		
		if(validRegion(region)) {
			var crfa = region + '-' + register;
			if(validCrfa(crfa)) {
				$.post('/site/expert/signin', { "crfaUser" : crfa })
				.done(function(response) {
					
					switch(response){
					case "granted":
						location.href = redirect;
						break;
						
					case "denied":
						alert('CRFa não encontrado!');
						break;
						
					case "newExpert":
						form.register();
						break;
					}
				})
				.error(function() {
					alert("Erro interno do sistema!");
				});
			} else {
				alert('CRFa inválido. Digite novamente!');
			}
		}
	};
	
	function validCrfa(crfa) {
		var regex = '^[1-8]-[0-9]{1,4}$';
		return crfa.match(regex);
	};
	
	function validRegion(region) {
		var regex = '^[1-8]$',
			valid = region.match(regex);
		if(valid) {
			return true;
		} else {
			alert("Selecione uma região!");
			return false;
		}
	};
	
	form.register = function() {
		$.get('/site/expert/register')
		.done(function(jsp) {
			bootbox.dialog({
				title: "Entre com seu nome",
			    message: jsp,
			    buttons: {
			    	main: { label:"Cancelar", className:"btn-danger" },
			    	sucess: { 
			    		label:"Salvar", 
			    		className:"btn-success", 
			    		callback: function() { 
			    				signup(function(callback) {
			    					if(callback) {
			    						location.href = redirect;
			    					}
			    				});} 
			    		}
			    },
			});
		});
	};
	
	function signup(callback) {
		$.post('/site/expert/signup', { "name": $('#name').val() })
		.done(function(response) {
			callback(response);
		})
		.error(function() {
			alert("Erro interno do sistema!");
		});
	};
	
	return form;
	
})();

$(document)
.on('click', '#submit', ExpertForm.signin);
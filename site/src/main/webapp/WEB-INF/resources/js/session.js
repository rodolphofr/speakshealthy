var Session = (function() {
	session = {};

	session.hasSession = function(callback) {
		$.get('/site/session/hasSession')
		.done(function(response) {
			callback(response);
		})
		.error(function() {
			alert("Erro ao verificar sessão!");
		});
	};
		
	return session;
	
})();

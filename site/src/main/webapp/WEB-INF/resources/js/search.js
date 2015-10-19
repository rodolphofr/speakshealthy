$(document).ready(function() {
	$('#search').autocomplete({
		source:'/site/patient/search'
	}).data( "ui-autocomplete" )._renderItem = function( ul, item ) {
		var showRg = '';
		
		if(item.rg != null) {
			showRg = '<div class="description">'+ item.rg +'</div>';
		}
		
		var inner_html = '<a href="/site/patient/'+ item.id +'">'
		+
		'<div class="list_item_container">'
		+
		'<div class="image"><img width="75px" height="75px" src="' + item.photo + '"></div>'
		+
		'<div class="name">'+ item.name +'</div>'
		+
		 showRg
		+
		'</div>'
		+
		'</a>';
		
		return $( "<li></li>" )
				.data( "item.autocomplete", item )
				.append(inner_html)
				.appendTo( ul );
	};
});
	

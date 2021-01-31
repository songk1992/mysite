
const FooterFunction = {
	
	
	
	_getYymmdd: function(date) {
	const yyyy = date.getFullYear();
	const mm = date.getMonth() < 9 ? '0' + (date.getMonth()+1) : (date.getMonth()+1);
	const dd = date.getDate() < 10 ? '0${date.getDate()}' : date.getDate();
	return '(c)opyright ' + yyyy + ' - ' +  mm + ' - ' + dd;
	},

	_setYymmdd: function() {
		
	let str1 = FooterFunction._getYymmdd(new Date());
	$('._year').append('<div class=\'_year\'>' + str1 + '</div>');
	},
	
	
	
	init: function() {
		$(function() {
			FooterFunction._setYymmdd();
			
		});

	}
};





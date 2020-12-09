/*************************************************
*	JAVASCRIPT POUR LA CONFIRMATION
*	DE SUPPRESSION DE COMPTE
*************************************************/
$('#confirm-delete').on('show.bs.modal', function(e) {
	$(this).find('.btn-ok').attr('href', $(e.relatedTarget).data('href'));
});

/*************************************************
*	JAVASCRIPT POUR AFFICHER UNE BULLE
*	AVEC LA VALEUR DE RANGE CONTROL
*************************************************/
var rangeSlider = function(){
  var slider = $('.range-slider'),
      range = $('.range-slider__range'),
      value = $('.range-slider__value');
    
  slider.each(function(){

    value.each(function(){
      var value = $(this).prev().attr('value');
      $(this).html(value);
    });

    range.on('input', function(){
      $(this).next(value).html(this.value);
    });
  });
};

rangeSlider();


/*************************************************
*	JAVASCRIPT TOGGLE OPEN CLOSE
*	FORMULAIRE RENVOI MOT DE PASSE
*************************************************/
$(document).on('click', '.js-closeSidebar', function() {
	$('#retrievePassword').removeClass('sidebar-open');
	$('#retrievePassword').addClass('sidebar-closed');
});
$(document).on('click', '.js-openSidebar', function() {
	$('#retrievePassword').removeClass('sidebar-closed');
	$('#retrievePassword').addClass('sidebar-open');
});


/*************************************************
*	JAVASCRIPT POUR LE FORMULAIRE DE CONNEXION
*************************************************/
(function ($) {
	"use strict";
	/* Focus Contact2 */
	$('.input-check').each(function(){
		$(this).on('blur', function(){
			if($(this).val().trim() != "") {
				$(this).addClass('has-val');
			}
			else {
				$(this).removeClass('has-val');
			}
 		})
	})
 
	/* Validate */
//	var input = $('.validate-input-check .input-check');
//
//	$('.validate-form-check').on('submit',function(){
//		var check = true;
//
//		for(var i=0; i<input.length; i++) {
//			if(validate(input[i]) == false){
//				showValidate(input[i]);
//				check=false;
//			}
//		}
//
//		return check;
//	});
//	$('.validate-form-check .input-check').each(function(){
//		$(this).focus(function(){
//			hideValidate(this);
//		});
//	});

//	function validate (input) {
//		if($(input).attr('type') == 'email' || $(input).attr('name') == 'email') {
//			if($(input).val().trim().match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
//				return false;
//			}
//		}
//		else {
//			if($(input).val().trim() == ''){
//				return false;
//			}
//		}
//	}

//	function showValidate(input) {
//		var thisAlert = $(input).parent();
//
//		$(thisAlert).addClass('alert-validate');
//	}
//
//	function hideValidate(input) {
//		var thisAlert = $(input).parent();
//
//		$(thisAlert).removeClass('alert-validate');
//	}
})(jQuery);
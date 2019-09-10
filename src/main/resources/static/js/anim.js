
(function ($) {
    "use strict";

    /*==================================================================
    [ Focus Contact2 ]*/
    $('.input100').each(function(){
        $(this).on('blur', function(){
            if($(this).val().trim() != "") {
                $(this).addClass('has-val');
            }
            else {
                $(this).removeClass('has-val');
            }
        })    
    })

    /*==================================================================
    [ Validate ]*/
    var input = $('.validate-input .input100');

    $('.validate-form').on('submit',function(){
        var check = true;

        for(var i=0; i<input.length; i++) {
            if(validate(input[i]) == false){
                showValidate(input[i]);
                check=false;
            }
        }

        return check;
    });


    $('.validate-form .input100').each(function(){
        $(this).focus(function(){
           hideValidate(this);
        });
    });

    function validate (input) {
        if($(input).attr('type') == 'email' || $(input).attr('name') == 'email') {
            if($(input).val().trim().match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
                return false;
            }
        }
        else {
            if($(input).val().trim() == ''){
                return false;
            }
        }
    }

    function showValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).addClass('alert-validate');
    }

    function hideValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).removeClass('alert-validate');
    }
    

})(jQuery);




//If you like this and wish to use it please give credit where it is due! -Kaigth :)

//variables
var document = window.document,
	
	  $_window = $( window ),
  
timeout,
  
isAnimating = false,
slideNum = 0,

	$welcomeBarL = $( ".bt-sl-solid-l" ),
	  $welcomeBarR = $( ".bt-sl-solid-r" ),
	  $btSlideActive = $( ".welcome-button" ).find( ".bt-slide-l" ),

	  $welcomeBtn = $( ".welcome-button a" );
  
//------//

//Delegation
$welcomeBtn.on( 'mouseenter', function () {
	  var timeout,
		    $slidebar = $( '.bt-slider-' + slideNum ),
		    
  animate = function () {
    
			      timeout = setTimeout(function () {
				        clearTimeout( timeout );

				        if ( slideNum === 5 ) {
					
					          isAnimating = false;
        					slideNum = 0;

				        } else {

        					isAnimating = true;
        					$slidebar = $( '.bt-slider-' + slideNum );

        					$slidebar.removeClass( 'bt-slide-l' );

        					slideNum++;

        					animate();

				        }

    			}, 100 );
		   };

	  animate();

});

$welcomeBtn.on( 'mouseout', function () {
	  var timeout,
		      $slidebar = $( '.bt-slider-' + slideNum ),
      
		      animate = function () {
			
      timeout = setTimeout(function () {
        				clearTimeout( timeout );

        				if ( slideNum === 5 ) {

          					isAnimating = false;
          					slideNum = 0;

        				} else {

          					isAnimating = true;
          					$slidebar = $( '.bt-slider-' + slideNum );

          					$slidebar.addClass( 'bt-slide-l' );

          					slideNum++;

          					animate();

				          }

      			}, 100 );
  		};

	animate();

});

$_window.on( "load", function () {

timeout = setTimeout(function () {
					    clearTimeout();

					    $welcomeBarL.removeClass( "down" );
  					$welcomeBarR.removeClass( "down" );

				}, 100 );

				timeout = setTimeout(function () {
  					clearTimeout();

  					$welcomeBarL.removeClass( "out" );
  					$welcomeBarR.removeClass( "out" );

				}, 400 );

timeout = setTimeout(function () {
  					clearTimeout();

  					$welcomeBtn.removeClass( "out" );

				}, 800 );

timeout = setTimeout(function () {
  					clearTimeout();

  					$btSlideActive.removeClass( "out" );

				}, 1000 );

});

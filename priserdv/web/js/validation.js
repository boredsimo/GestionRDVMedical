$( document ).ready( function () {
                    //Validation du formulaire via l'attribut id de 
			$( "#signupForm" ).validate( {
				rules: {
                                        sex : "required",
					prenom: "required",
					nom: "required",
					identifiant: {
						required: true,
						minlength: 2
					},
					password: {
						required: true,
						minlength: 5
					},
					confirm_password: {
						required: true,
						minlength: 5,
						equalTo: "#password"
					},
					email: {
						required: true,
						email: true
					},
					formation : "required",
			              Commentaire : "required"
				},
				messages: {
                                        sex: "Veuillez cocher votre genre",
					prenom: "Veuillez saisir votre prenom",
					nom: "Veuillez saisir votre nom",
					identifiant: {
						required: "Veuillez saisir votre identifiant",
						minlength: "Votre identifiant doit contenir au moins deux characters"
					},
					password: {
						required: "Veuillez saisir votre mot de passe",
						minlength: "Votre mot de passe doit contenir au moins 5 characters"
					},
					confirm_password: {
						required: "Veuillez saisir votre mot de passe",
						minlength: "Votre identifiant doit contenir au moins 5 characters",
						equalTo: "Veuillez saisir le meme mot de passe que précédent"
					},
					email: { required : "Veuillez saisir un email valide"},
			               formation: "Choisissez une formation",
			               Commentaire : "Saisissez un commentaire"
				},
				errorElement: "em",
				errorPlacement: function ( error, element ) {
					// Ajoutez la classe `help-block` à l'élément d'erreur
					error.addClass( "help-block" );

					// Ajouter la classe `has-feedback` au parent div.form-group
					// afin d'ajouter des icônes aux inputs entrées
					element.parents( ".col-sm-5" ).addClass( "has-feedback" );

					if ( element.prop( "type" ) === "checkbox" ) {
						error.insertAfter( element.parent( "label" ) );
					} else {
						error.insertAfter( element );
					}

					// Ajoutez l'élément span, s'il n'existe pas, et appliquez-lui les classes d'icônes.
					if ( !element.next( "span" )[ 0 ] ) {
						$( "<span class='glyphicon glyphicon-remove form-control-feedback'></span>" ).insertAfter( element );
					}
				},
				success: function (element ) {
					// Ajoutez l'élément span, s'il n'existe pas, et appliquez-lui les classes d'icônes..
					if ( !$( element ).next( "span" )[ 0 ] ) {
						$( "<span class='glyphicon glyphicon-ok form-control-feedback'></span>" ).insertAfter( $( element ) );
					}
				},
				highlight: function ( element) {
					$( element ).parents( ".col-sm-5" ).addClass( "has-error" ).removeClass( "has-success" );
					$( element ).next( "span" ).addClass( "glyphicon-remove" ).removeClass( "glyphicon-ok" );
				},
				unhighlight: function ( element) {
					$( element ).parents( ".col-sm-5" ).addClass( "has-success" ).removeClass( "has-error" );
					$( element ).next( "span" ).addClass( "glyphicon-ok" ).removeClass( "glyphicon-remove" );
				}
                                
			} );
                        
                        
                      //La méthode on() attache un ou plusieurs gestionnaires d'événements
                    //pour pour les éléments sélectionnés
                    //ici on v disactive le bouton submit si le formulaire
                    // n'est pas valide
                     $('input').on('blur', function () {
                         //verifi si le formulaire est valide
                        if ($("#signupForm").valid()) {
                           // Activer le bouton submit : ajoutez propriété disabled a  false
                            $('#submit').prop('disabled', false);
                        } else {
                            //Desactiver le bouton submit: met la proprieté disabled à disabled
                            $('#submit').prop('disabled', 'disabled');
                        }
                    });
		} );
                

  //une méthode qui permet de verifier si le champ mot de passe correspond au pattern spécifié
	jQuery.validator.addMethod(
			  "password",
			  function(value){
				  return  /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/.test(value) ;
			  },
			  'Le mot de passe doit contenir : au moins une lettre minuscule,au moins une lettre majuscule, au moins un chiffre,au moins huit caractères ' 
		     
			  
	);

//une méthode qui permet de verifier si le champ email correspond au pattern spécifié
	jQuery.validator.addMethod(
			  "email",
			  function(value){
				  return  /^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@(?:\S{1,63})$/.test( value );
			  },
			  'Rentrez une adresse email valide ' 
		     
			  
	);

// si le formulaire est bien, on affiche submittes
	$.validator.setDefaults( {
			submitHandler: function () {
				alert( "submitted!" );
			}
		} );


function checkFormation() {
       if (document.getElementById("reguliere").checked && document.getElementById("continue").checked){
	    document.getElementById("reguliere").checked = false;
           document.getElementById("continue").checked = false;
           document.getElementById('formation').innerHTML = '<i>On peut choisir seulement une type de formation!</i>';
	   }
	   else		  
	       document.getElementById('formation').innerHTML = '';
    }
    
    



		

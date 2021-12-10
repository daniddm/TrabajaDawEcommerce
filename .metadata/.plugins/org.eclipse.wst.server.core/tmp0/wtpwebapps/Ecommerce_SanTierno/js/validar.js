$(document).ready(function () {
	
	$("#formLogin").show();
	$("#formRegister").hide();
	
    //funcion que hace que aparezca el formulario login
    $("#login_button").on("click", function (e) {
        if ($("#formRegister").css("display") == "block") {
            e.preventDefault(); 
            $("#formRegister").hide();
            $("#formLogin").show();
        }
    });

    //funcion que hace que aparezca el formulario registro
    $("#register_button").on("click", function (e) {
        if ($("#formLogin").css("display") == "block") {
            e.preventDefault(); 
            $("#formLogin").hide();
            $("#formRegister").show();
        }
    });

});
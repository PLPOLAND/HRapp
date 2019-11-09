$(document).ready(function () {
    $("#subbutton").click(function () {
        var username = $("#nick").val();
        var password = $("#pass").val();
        if (username != "" && password != "") {
            $.ajax({
                url: '/api/login',
                type: 'post',
                data: { nick: username, pass: password },
                success: function (response) {
                    $("#err-msg").html(response);
                    
                    var msg = "";
                    if (response == 1) {
                        window.location = "/adminhome";
                    } else {
                        msg = "Podano błędny login lub hasło"; 
                        $("#err-msg").html(msg);
                        $("#err-msg").show('slow');
                    }
                    
                }
            });
        }
    });
    $(".container").click(function(){

        $("#err-msg").hide('slow');
    })
});
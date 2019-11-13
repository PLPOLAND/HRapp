jQuery(document).ready(function($) {
    showUsers();
    $('.banner-icons-etc').hide();
    // $('img.userlogo').click(function () {
    //     $('.banner-icons').toggle('slow');
    // });
    $('.cover').click(function () {
        $('.banner-icons-etc').toggle('slow');
    });
})

function showUsers() {
    var tabela = $(".tabelauserow");
    var danejson;
    $.ajax({
        url: '/api/alluserslist',
        type: 'post',
        data: {},
        success: function (response) {
            danejson = response;
            var dane = jQuery.parseJSON(danejson);
            console.info(dane[0].nick);
        }
    });

    
}
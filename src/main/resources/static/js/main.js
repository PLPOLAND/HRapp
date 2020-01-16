var ostatnio_kliknięty_naglowek_tabeli;

jQuery(document).ready(function($) {
    
    $('.banner-icons-etc').hide();
    
    $('.cover').click(function () {//pokazywanie/chowanie rozwijanego banneru w banerze
        $('.banner-icons-etc').toggle('slow');
    });

    dis_input();//ustaw blokady pól w razie potrzeby
    $('input[name = "admin"]').click(dis_input);//przypisz działanie do przycisku o nazwie admin

})
//odpowiada za blokowanie i odblokowywanie pól w fomularzu edycji uprawnień
//dodać kolejne pola w razie potrzeby
function dis_input() {
    if ($('input[name = "admin"]').prop("checked")){
        // alert("Is checked");
        $('input[name = "add_user"]').attr("disabled", true);
        $('input[name = "del_user"]').attr("disabled", true);
        $('input[name = "edit_user"]').attr("disabled", true);
        $('input[name = "show_all_users"]').attr("disabled", true);
        $('input[name = "show_d_data"]').attr("disabled", true);
        $('input[name = "finance_management"]').attr("disabled", true);
    }
    else{
        // alert("Is not checked");
        $('input[name = "add_user"]').attr("disabled", false);
        $('input[name = "del_user"]').attr("disabled", false);
        $('input[name = "edit_user"]').attr("disabled", false);
        $('input[name = "show_all_users"]').attr("disabled", false);
        $('input[name = "show_d_data"]').attr("disabled", false);
        $('input[name = "finance_management"]').attr("disabled", false);
    }
}


//odpowiada za sortowanie względem imienia
function sort_by_name(a,b) {
    return ('' + a.imie).localeCompare(b.imie);
}

//odpowiada za sortowanie względem nazwiska
function sort_by_surname(a,b) {
    return ('' + a.nazwisko).localeCompare(b.nazwisko);
} 

//odpowiada za sortowanie względem emaila
function sort_by_email(a, b) {
    return ('' + a.email).localeCompare(b.email);
} 

//odpowiada za sortowanie względem stanowiska
function sort_by_stanowisko(a, b) {
    return ('' + a.stanowisko).localeCompare(b.stanowisko);
}

//odpowiada za sortowanie
function sortUsers(sortfunction,t) {

    

    var tabela = $(".tabelauserow");
    tabela.fadeOut(600);
    
    $.ajax({
        url: '/api/alluserslist',
        type: 'post',
        data: {},
        success: function (response) {
            
            setTimeout(function (){
                $(".tabelauserow tr.pos").remove();
                response.sort(sortfunction);

                for (var i = 0; i < response.length; i++) {
                    var td = $('<tr class="pos">' +
                        '<td>' + response[i].imie + '</td>' +
                        '<td>' + response[i].nazwisko + '</td>' +
                        '<td>' + response[i].email + '</td>' +
                        '<td>' + response[i].stanowisko + '</td>' +
                        '<td class="przycisk" onclick="location.href=\'/edit_user_page?id=' + response[i].id + '\'" >' +
                        '<div class="tooltip">' +
                        '<i class="icon-edit"></i>' +
                        '<span class="tooltiptext">Edytuj</span>' +
                        '</div>' +
                        '</td>' +
                        '<td class="przycisk delete" >' +
                        '<div class="tooltip">' +
                        '<i class=\'icon-trash\'></i>' +
                        '<span class="tooltiptext">Usuń</span>' +
                        '</div>' +
                        '</td>' +
                        '<td class="przycisk" onclick="location.href=\'/user_profile_page?id=' + response[i].id + '\'">' +
                        '<div class="tooltip">' +
                        '<i class=\'icon-list\'></i>' +
                        '<span class="tooltiptext">Szczegóły</span>' +
                        '</div>' +
                        '</td>' +
                        '<td class="przycisk" onclick="location.href=\'/user_payment_page?id=' + response[i].id + '\'">' +
                        '<div class="tooltip">' +
                        '<i class=\'icon-credit-card\'></i>' +
                        '<span class="tooltiptext">Wyciąg</span>' +
                        '</div>' +
                        '</td>' +
                        '</tr>');

                    tabela.append(td);
                }
                // tabela.toggle("slow");
                
                if ($(ostatnio_kliknięty_naglowek_tabeli).hasClass("Clicked")) {//jeśli ma klasę Clicked to usun ją
                    //console.log("have")
                    $(ostatnio_kliknięty_naglowek_tabeli).toggleClass("Clicked");
                }
                else {
                    //console.log("nothave");
                }
                ostatnio_kliknięty_naglowek_tabeli = t;
                $(t).toggleClass("Clicked");
                tabela.fadeIn(600);
            },500);
        }
    });
    
    
}
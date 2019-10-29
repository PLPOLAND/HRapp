<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");
%>
<html lang="pl">

<head>
    <c:url value="/css/main.css" var="jstlCss" />
    <c:url value="/css/themes/maintheme.css" var="jstlCsstheme" />
    <c:url value="/js/main.js" var="javaScript" />
    <c:url value="/img/icon.png" var="icon" />
    <link href="${jstlCsstheme}" rel="stylesheet" />
    <link href="${jstlCss}" rel="stylesheet" />
    <link href="${icon}" rel="shortcut icon" >
    <link href='http://fonts.googleapis.com/css?family=Barlow&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="${javaScript}"></script>
    <title>HR MAJ Profil <!--tu można dać imie jeśli się da--></title>
</head>

<body>
    <div id="backgroundContainer"></div>
    <div class="container">
        <div id="banner">
            ${banner.printBanner()}
        </div>
        <div id="logo_tlo">
                <img width="600", height="450", src="/img/logo3.png"/>
        </div>
        <div id="mainbody">
            <div id="praco_logo">
                
                Imię Nazwisko<!--Imie i nazwisko osoby ktorej konto wybraliśmy wczejściej przyciskiem SZCZEGÓŁY-->
                <br><br>
            </div>
            <div id="osoba_detail">
                    <!--To z bazy danych vvvv-->
                    <li>Nickname: adwadawd</li>
                    <li>email: adawdawd@awdawd.pl</li>
                    <li>Numer konta bankowego: 455635345345345</li>
                    <li>Typ umowy: niewolnik</li>
                    <li>Stanowisko: uzupełnianie tabelek w excelu</li>
                    <li>Hasło: <input type="password" value="FakePSW" id="myInput"></li><!--CHYBA zakrywa hasło, ale nie wiem-->
                    <input type="checkbox" onclick="myFunction()">Pokaż hasło <!--To domyślnie jest INPUT, nie wiem jak zadziała jako OUTPUT-->
                    <!--https://www.w3schools.com/howto/howto_js_toggle_password.asp    w tym jest JavaScrip jaki dodać-->
                
            </div>
            <br><br><br><br><br><br><br><br><br><br><br><br>
            <button class="konto" style="vertical-align:middle"><i class='far fa-edit'></i><span>Edytuj dane</span></button><!--przenosi do strony AeditUserPage-->         
        </div>
        <div id="footer">
            MAJ<br>
            © Wszelkie prawa zastrzeżone
        </div>
    </div>
</body>

</html>
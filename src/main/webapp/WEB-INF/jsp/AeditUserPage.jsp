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
    <title>HR MAJ Edytuj Imie Nazwisko</title>
</head>

<body>
    <div id="backgroundContainer"></div>
    <div class="container">
        <div id="banner">
            ${banner.printBanner()}
        </div>
        <div id="mainbody">
                <div id="praco_logo">
                
                        Imię Nazwisko<!--Imie i nazwisko osoby ktorej konto wybraliśmy wcześniej przyciskiem SZCZEGÓŁY-->
                        <br>
                    </div>
                    <div id="osoba_detail">
                            <!--To z bazy danych vvvv + zapisywanie do bazy danych TO EDYCJA JAKO ADMIN-->
                            <li>Aktualny nickname: adwadawd</li> 
                            Zmień nickname:<input type="text" name="x1" background>
                            <input type="submit" value="Zaktualizuj">
                            <li>Aktualny email: adawdawd@awdawd.pl</li>
                            Zmień email:<input type="text" name="x2">
                            <input type="submit" value="Zaktualizuj">
                            <li>Aktualny numer konta bankowego: 455635345345345</li> 
                            Zmień numer konta:<input type="text" name="x3">
                            <input type="submit" value="Zaktualizuj">
                            <li>Typ umowy: niewolnik</li>
                            Zmień typ umowy:<input type="text" name="x4">
                            <input type="submit" value="Zaktualizuj">
                            <li>Stanowisko: uzupełnianie tabelek w excelu</li> 
                            Zmień stanowisko:<input type="text" name="x5">
                            <input type="submit" value="Zaktualizuj">
                    </div>
        </div>
        <div id="footer">
            MAJ<br>
            © Wszelkie prawa zastrzeżone
        </div>
    </div>
</body>

</html>
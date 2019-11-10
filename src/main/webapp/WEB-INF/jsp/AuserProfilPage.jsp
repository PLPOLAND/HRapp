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
            <div id="mainbody">
               
                    <div id="praco_logo">
                
                            ${user1.getImie()} ${user1.getNazwisko()}<!--Imie i nazwisko osoby ktorej konto wybraliśmy wczejściej przyciskiem SZCZEGÓŁY-->
                         <br><br>
                    </div>
            
                    <div id="osoba_detail">
                    <!--To z bazy danych vvvv-->
                        <table>
                            <tr>
                                <th><h3>Dane pracownika:</h3></th>
                            </tr>
                            <tr>
                                <th>Imię:</th><th>${user1.getImie()}</th> 
                            </tr>
                            <tr>
                                <th>Nazwisko:</th><th>${user1.getNazwisko()}</th> 
                            </tr>
                            <tr>
                                <th>Nickname:</th><th>${user1.getNick()}</th> 
                            </tr>
                            <tr>
                                <th>Email:</th><th>${user1.getEmail()}</th>
                            </tr>
                           
                            <tr>
                                <th>Typ umowy:</th><th>${user1.getTypUmowy()}</th>
                            </tr>
                            <tr>
                                <th>Stanowisko:</th><th>${user1.getStanowisko()} </th>
                            </tr>
                            <tr>
                                <th>Numer konta:</th><th>${user1.getKontoBankowe()}</th> 
                            </tr>
                            <tr>
                                <th>Wypłata brutto:</th><th>${user1.getWyplataBrutto()} zł</th> 
                            </tr>
                            <tr>
                                <th>Wypłata netto:</th><th>${user1.getWyplataNetto()} zł</th> 
                            </tr>
                            <tr>
                                <th>Podatek:</th><th>${user1.getProcentPodatku()}%</th> 
                            </tr>
                            <tr>
                                <th>Uprawnienia:</th><th>${user1.getUprawnienia()}</th> 
                            </tr>
                        </table> 
                        <br><br>
                        <button class="konto" style="vertical-align:middle" onclick="location.href='/edit_user_page?id=${user1.getID()}'"><i class='far fa-edit'></i><span>Edytuj dane</span></button>
                        <!--przenosi do strony AeditUserPage-->  
                        
                     </div>   
                 
                </div>
         
        <div id="footer">
            MAJ<br>
            © Wszelkie prawa zastrzeżone
        </div>
    </div>
</body>

</html>
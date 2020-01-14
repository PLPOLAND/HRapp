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
    <c:url value="/css/themes/sunflowers.css" var="jstlCsstheme" />
    <c:url value="/js/main.js" var="javaScript" />
    <c:url value="/img/icon.png" var="icon" />
    <c:url value="/css/fontello.css" var="fontello" />
    <link href="${fontello}" rel="stylesheet" />
    <link href="${jstlCsstheme}" rel="stylesheet" />
    <link href="${jstlCss}" rel="stylesheet" />
    <link href="${icon}" rel="shortcut icon" >
    <link href='http://fonts.googleapis.com/css?family=Barlow&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="${javaScript}"></script>
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
    <meta charset="utf-8">
    
    <title>HR MAJ Admin Page</title>
</head>

<body>
    <div id="backgroundContainer"></div>
    <div class="container">
        <div id="banner">
            ${banner.printBanner()}            
        </div>
        <div id="mainbody">
            <div id="praco_logo">
                    Dodaj wypłatę dla użytkownika ...
                    <br><br>
            </div>
            <div id="pracownicy">
                <table class="tabelauserow">
                    <tr>
                        <td onclick="sortUsers(sort_by_name,this)">Imie</td>
                        <td onclick="sortUsers(sort_by_surname,this)">Nazwisko</td>
                        <td onclick="sortUsers(sort_by_email,this)">Email</td>
                        <td onclick="sortUsers(sort_by_stanowisko,this)">Stanowisko</td>         
                        <td class="nohover"></td>
                        <td class="nohover"></td>
                        <td class="nohover"></td>
                        <td class="nohover"></td>
                    </tr>
                    <c:forEach var="userval" items="${userList}">
                        <tr class="pos">
                            <td>${userval.getImie()}</td>
                            <td>${userval.getNazwisko()}</td>
                            <td>${userval.getEmail()}</td>
                            <td>${userval.getStanowisko()}</td>
                            <td class="przycisk" onclick="location.href='/user_add_payment_page?id=${userval.getID()}'">                               
                                <div class="tooltip">
                                    <i class='icon-credit-card'></i>
                                    
                                    <span class="tooltiptext">Dodaj Wypłatę</span>
                                    
                                </div>                                
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>    
        </div>
        <div id="footer">
            MAJ<br>
            © Wszelkie prawa zastrzeżone
        </div>
    </div>
</body>

</html>
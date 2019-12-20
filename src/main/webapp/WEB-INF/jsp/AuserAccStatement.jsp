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
    <!-- <c:url value="/css/themes/maintheme.css" var="jstlCsstheme" /> -->
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
    <meta charset="utf-8">
    <title>HR MAJ Wyciąg </title>
</head>

<body>
    <div id="backgroundContainer"></div>
    <div class="container">
        <div id="banner">
            ${banner.printBanner()}
        </div>
        <div id="mainbody">
            <div id="praco_logo">
                ${user1.getImie()} ${user1.getNazwisko()}
            </div>
            <br><br><br>
            <button class="konto" style="vertical-align:middle" onclick="location.href='/user_add_payment_page?id=${user1.getID()}'">
                <i class='far fa-edit'></i>
                <span>Dodaj wypłatę</span>
            </button>
            <div class="osoba_detail">     
                <div class="kolumnaB">      
                    <table>
                        <tr>
                            <th><h2>Wynagordzenie:</h2></th>
                        </tr>
                        <tr>
                            <th>Wynagrodzenie brutto:</th><td>${user1.getWyplataBrutto()} zł/h</td> 
                        </tr>
                        <tr>
                            <th>Wynagrodzenie netto:</th><td>${user1.getWyplataNetto()} zł/h</td> 
                        </tr>
                        <tr>
                            <th>Całkowity koszt pracownika:</th><td>${user1.getCalkowityKosztPracownika()} zł/h</td> 
                        </tr>
                        <br>
                    </table>
                </div>

                    <table class="kolumnaB">
                            <tr>
                                    <th><h2>Historia wypłat:</h2></th>
                                </tr>
                                <tr>
                                    <th>Okres rozliczeniowy:</th> 
                                    <th>Data zaksięgowania:</th>
                                    <th>Wypłacona kwota:</th>
                                </tr>
                        <c:forEach var="wypval" items="${wyplaty}">
                                <tr class="pos">
                                <td> Od ${wypval.getDataOd()} do ${wypval.getDataDo()}</td>
                                <td>${wypval.getDataZaksiegowania()}</td>
                                <td>${wypval.getKwotaBrutto()}</td>                               
                            </tr>
                        </c:forEach>
                    </table>
                <!--</div>    -->
            </div>
            <br><br><br>
            <button class="konto" style="vertical-align:middle" onclick="location.href='/user_specific_payment_data_page?id=${user1.getID()}'">
                <i class='far fa-edit'></i>
                <span>Szczegóły</span>
            </button>
        </div>
        <div id="footer">
            MAJ<br>
            © Wszelkie prawa zastrzeżone
        </div>
    </div>
</body>

</html>
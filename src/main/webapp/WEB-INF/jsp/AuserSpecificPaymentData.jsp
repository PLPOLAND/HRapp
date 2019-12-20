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
    <link href="${jstlCsstheme}" rel="stylesheet" />
    <link href="${jstlCss}" rel="stylesheet" />
    <link href="${icon}" rel="shortcut icon" >
    <link href="${fontello}" rel="stylesheet" />
    <link href='http://fonts.googleapis.com/css?family=Barlow&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="${javaScript}"></script>
    <meta charset="utf-8">
    <title>HR MAJ ...</title>
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
                <div class="osoba_detail">
                    <div class="kolumnaB">                  
                        <table>
                            <tr>
                                <th><h2><b>Koszty Pracodawcy:</h2></th>
                                
                            </tr>
                            <tr>
                                <th>Wynagrodzenie brutto:</th><td>${user1.getWyplataBrutto()}  zł/h</td> 
                            </tr>
                            <tr>
                                <th>FGŚP:</th><td>${typUmowy.getFGSP()}%</td> 
                            </tr>
                            <tr>
                                <th>Fundusz Pracy:</th><td>${typUmowy.getFunduszPracy()}%</td> 
                            </tr>
                            <tr>
                                <th>Ubezpieczenie wypadkowe:</th><td>${typUmowy.getUbWypadkowe()}%</td> 
                            </tr>
                            <tr>
                                <th>Ubezpieczenie rentowe:</th><td>${typUmowy.getUbRentowePracodawca()}%</td> 
                            </tr>
                            <tr>
                                <th>Ubezpieczenie emerytalne:</th><td>${typUmowy.getUbEmerytalnePracodawca()}%</td>
                            </tr>
                            <tr>
                                <th>Całkowity koszt pracownika:</th><td>${user1.getCalkowityKosztPracownika()}  zł/h</td> 
                            </tr>
                            <tr>
                            </table>
                    </div>
                            <table class = kolumnaB>
                                    <th><h2><b>Koszty Pracownika:</h2></th>
                                    
                                </tr>
                                <tr>
                                    <th>Zaliczka na PIT:</th><td>${typUmowy.getZaliczkaPIT()}%</td> 
                                </tr>
                                <tr>
                                    <th>Ubezpieczenie zdrowotne:</th><td>${typUmowy.getUbZdrowotne()}%</td> 
                                </tr>
                                <tr>
                                    <th>Ubezpieczenie chorobowe:</th><td>${typUmowy.getUbChorobowe()}%</td> 
                                </tr>
                                <tr>
                                    <th>Ubezpieczenie rentowe:</th><td>${typUmowy.getUbRentowePracownik()}%</td> 
                                </tr>
                                <tr>
                                    <th>Ubezpieczenie emerytalne:</th><td>${typUmowy.getUbEmerytalnePracownik()}%</td>
                                </tr>
                                <tr>
                                    <th>Wynagrodzenie netto:</th><td>${user1.getWyplataNetto()}  zł/h</td> 
                                </tr>
                        </table>
                    </div> 
                    <br><br><br>
                    <button class="konto" style="vertical-align:middle" onclick="location.href='/user_payment_page?id=${user1.getID()}'">
                        <i class='far fa-edit'></i>
                        <span>Wróć</span>
                    </button>
                </div>
               
        </div>
        <div id="footer">
            MAJ<br>
            © Wszelkie prawa zastrzeżone
        </div>
    </div>
</body>

</html>
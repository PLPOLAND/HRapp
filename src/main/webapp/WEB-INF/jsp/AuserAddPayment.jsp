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
                        Dodaj wypłatę dla  ${user1.getImie()} ${user1.getNazwisko()}   
                </div>
                <div class="osoba_detail"> 
                    <form action="/user_add_payment" autocomplete="off">
                        <div class="kolumnaA"> 
                            <table>    
                                <tr>
                                    <th><h2><b>Okres rozliczeniowy</h2></th>
                                        <input type="hidden" name="id" value="${user1.getID() }">
                                </tr>          
                                <tr>
                                    <th>Od:</th><td><input type="date" name="dataOd" size="40" value ="${dzis}" required></td> 
                                </tr>
                                <tr>
                                    <th>Do:</th><td><input type="date" name="dataDo" size="40" value ="${dzis}" required></td> 
                                </tr>
                                <tr>
                                    <th>Dni urlopu:</th><td><input type="number" name="dniUrlopu" size="40" value = 0 required></td> 
                                </tr>
                                <tr>
                                    <th>Ilość nadgodzin:</th><td><input type="number" name="iloscNadgodzin" size="40" value = 0 required></td> 
                                </tr>
                                <tr>
                                    <th>Preimia (zł):</th><td><input type="number" name="premia" size="40" value = 0 required></td> 
                                </tr>
                            </table>
                            <br><br>
                        <input type="submit" class="konto" value="Dodaj" style="vertical-align:middle">
                        <br><br><br><br><br><br>
                        </div>
                    </form>
                </div>
                    
        </div>
        <div id="footer">
            MAJ<br>
            © Wszelkie prawa zastrzeżone
        </div>
    </div>
</body>

</html>
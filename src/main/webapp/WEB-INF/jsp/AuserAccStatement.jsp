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
    <c:url value="/css/fontello.css" var="fontello" />
    <link href="${fontello}" rel="stylesheet" />
    <link href="${jstlCsstheme}" rel="stylesheet" />
    <link href="${jstlCss}" rel="stylesheet" />
    <link href="${icon}" rel="shortcut icon" >
    <link href='http://fonts.googleapis.com/css?family=Barlow&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="${javaScript}"></script>
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
                ${user1.getImie()} ${user1.getNazwisko()} Imie nazwisko 
            </div>
            <div id="osoba_detail">                    
                    <table>
                        <tr>
                            <th><h3>Wypłaty dla pracownika:</h3></th>
                        </tr>
                        <tr>
                            <th>Kwota:</th> 
                            <th>Data zaksięgowania:</th>
                        </tr>
                        <tr>
                            <td>6kk yang</td> 
                            <td>11.10.2019</td>
                        </tr>
                        <tr>
                            <td>7kk yang</td> 
                            <td>11.11.2019</td>
                        </tr>
                        <tr>
                            <td>3kk yang</td> 
                            <td>11.12.2019</td>
                        </tr>

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
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
    <c:url value="/img/kot1.png" var="kot1" />
    <c:url value="/img/icon.png" var="icon" />
    <link href="${jstlCsstheme}" rel="stylesheet" />
    <link href="${jstlCss}" rel="stylesheet" />
    <link href="${icon}" rel="shortcut icon" >
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="${javaScript}"></script>
    <title>HR MAJ Nie można odnaleźć strony</title>
</head>

<body>
    <div id="backgroundContainer"></div>
    <div class="container">
        <div id="logo">
            <img style="float: right", width="60", height="60", src="/img/logomaj.png"/>
        </div>
        <div id="banner">
            ${banner.printBanner()}    
            <h3>Błąd! Nie można odnaleźć strony</h1>  
        </div>
        <div id="mainbody">
            <br/><br/><br/><br/><br/><br/>
            Kliknij obrazek aby powrócić do ekranu logowania
            <br/><br/><br/>
            <a href="/">
                <img width="500", height="350", src="/img/house.png"/>
            </a>
            <title>Powrót do strony logowania</title>
         
        </div>
        <div id="footer">
            MAJ<br>
            © Wszelkie prawa zastrzeżone
        </div>
        
    </div>
</body>

</html>
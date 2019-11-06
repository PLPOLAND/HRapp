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
    <link href="${icon}" rel="shortcut icon">
    <link href='http://fonts.googleapis.com/css?family=Barlow&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="${javaScript}"></script>
    <title>HR MAJ ...</title>
</head>

<body>
    <div id="backgroundContainer"></div>
    <div class="container">
        <div id="banner">
            <div id="BannerDataSpace">
                <div class="left"><a href="/"><img class="pagelogo" src="${icon}"></a></div> <div class="right"><div class="userdata">Marek Pałdyna <img class="userlogo" src="${grav}"></div></div> 
            </div>
            <!-- ${banner.printBanner()} -->
            <div class="menu">
                <ul>
                    <li><a href="/">logowanie</a></li>
                    <li><a href="/adminhome">strona admina</a>
                        <ul class="drop-down">
                            <li><a href="#">Poz1</a></li>
                            <li><a href="#">Poz1</a></li>
                            <li><a href="#">Poz2</a></li>
                            <li><a href="#">Poz3</a></li>
                            <li><a href="#">Poz4</a></li>
                            <li><a><img src="${grav}"></a></li>
                        </ul>
                    </li>
                    <li><a href="/test">test</a></li>
                    <li><a href="/tmp">templatka</a></li>
                </ul>
            </div>
        </div>
        <div id="mainbody">

        </div>
        <div id="footer">
            MAJ<br>
            © Wszelkie prawa zastrzeżone
        </div>
    </div>
</body>

</html>
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="${javaScript}"></script>
    <title>HR MAJ Admin Page</title>
</head>

<body>
    <div id="backgroundContainer"></div>
    <div class="container">
        <div id="banner">
            ${banner.printBanner()} Menu główne admin <br>
            
        </div>
        <div id="mainbody">
            <div id="praco_logo">
                Pracownicy<br><br>
            </div>
            <div id="pracownicy">
                <c:forEach var="vart" items="${userList}">
                    <div class="osoba"> 
                            ${vart.getImie()} ${vart.getNazwisko()}
                            <div class="button1">Edit</div>
                            <div class="button1">Kosz</div>
                            <div type="button" class="button1" oneclic="location.href= '/AuserProfilPage'">Szczegoly</div>
                            <div class="button1">wyplaty</div>
                            <div style="clear:both"></div>
                            <br>
                    </div>               
                </c:forEach>
            </div>    
            <div id="person">
                    <div class="konto">Moje konto 
                        <img width="50", height="50", src="/img/Ricardo_Milos.png"/>
                    </div>      
                    <div class ="ikona"></div>
            </div>      
        </div>
        <div id="footer">
            MAJ<br>
            © Wszelkie prawa zastrzeżone
        </div>
    </div>
</body>

</html>
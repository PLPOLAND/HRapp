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
                Historia wypłat
            </div>
                    <table class="kolumnaWyplaty">
                                <tr>
                                    <th>Okres rozliczeniowy:</th> 
                                    <th>Data zaksięgowania:</th>
                                    <th>Wypłacona kwota (brutto):</th>
                                    <th>Adresat:</th>
                                </tr>
                        <c:forEach var="wypval" items="${wyplaty}">
                                <tr class="pos">
                                <td> Od ${wypval.getDataOd()} do ${wypval.getDataDo()}</td>
                                <td>${wypval.getDataZaksiegowania()}</td>
                                <td>${wypval.getKwotaBrutto()}</td> 
                                <td>${wypval.getImie()} ${wypval.getNazwisko()}, nr. konta: ${wypval.getNrKonta()}</td>                              
                            </tr>
                        </c:forEach>
                    </table>
                <!--</div>    -->
            </div>
        </div>
        <div id="footer">
            MAJ<br>
            © Wszelkie prawa zastrzeżone
        </div>
    </div>
</body>

</html>
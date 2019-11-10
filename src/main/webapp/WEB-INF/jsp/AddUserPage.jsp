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
    <title>HR MAJ Dodaj nowego pracownika</title>
</head>

<body>
    <div id="backgroundContainer"></div>
    <div class="container">
        <div id="banner">
            ${banner.printBanner()}
        </div>
        <div id="mainbody">
            <div id="praco_logo">               
                Dane pracownika:    
            </div>
            <div id="osoba_detail"> 
                <form action="/add_user" autocomplete="off">
                    
                    <table>              
                        <tr>
                            <th>Imię:</th><th><input type="text" name="Imie" size="40" value=""></th> 
                        </tr>
                        <tr>
                            <th>Nazwisko:</th><th><input type="text" name="nazwisko" size="40" value=""></th> 
                        </tr>
                        <tr>
                            <th>Hasło:</th><th><input type="text" name="haslo" size="40" value=""></th>
                            <th><input type="submit" class="konto" value="Generuj nowe hasło" style="vertical-align:middle">
                            </th> 
                        </tr>
                        <tr>
                            <th>Nickname:</th><th><input type="text" name="nickname" size="40" value=""></th> 
                        </tr>
                        <tr>
                            <th>Email:</th><th><input type="email" name="email" size="40" value=""></th>
                        </tr>
                        <tr>
                            <th>Numer konta:</th><th><input type="number" name="nrkonta" size="40" value="" style="width:100%;"></th> 
                        </tr>
                        <tr>
                            <th>Typ umowy:</th><th><!--</th><input type="text" name="umowy" size="40" value="Umowa"></th>-->
                            <select id="TypUmowy" name="typumowy"  style="width:100%;"> 
                                <c:forEach var="typyUmowy" items="${typyUmowy}">
                                    <option value="${typyUmowy.getID()}">${typyUmowy.getNazwa()}</option>
                                </c:forEach>
                            </select>
                            </th>
                        </tr>
                        <tr>
                            <th>Stanowisko:</th><th><!--<input list="Stanowisko" type="text" name="x5" size="40" value="Stanow">-->
                            <select id="Stanowisko" name="stanowiska" style="width:100%;"> 
                                <c:forEach var="stanowiska" items="${stanowiska}">
                                    <option value="${stanowiska.getID()}">${stanowiska.getNazwa()}</option>
                                </c:forEach>                                         
                            </select> 
                            </th>
                        </tr>
                        <tr>
                            <th>Wypłata brutto:</th><th></td><input type="number" name="wyplatabrutto" size="40" value="" min = "1" step="0.01" style="width:100%;"></th> 
                        </tr>
                        <tr>
                            <th>Uprawnienia:</th><th></td><input type="checkbox" name="uprawnienia" value="1">Administrator</th> 
                        </tr>
                    </table>
                        <br><br>
                        <input type="submit" class="konto" value="Dodaj pracownika" style="vertical-align:middle">                  
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
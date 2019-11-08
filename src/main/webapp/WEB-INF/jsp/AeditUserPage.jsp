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
    <title>HR MAJ Edytuj Imie Nazwisko</title>
</head>

<body>
    <div id="backgroundContainer"></div>
    <div class="container">
        <div id="banner">
            ${banner.printBanner()}
        </div>
        <div id="mainbody">
                <div id="praco_logo">
                
                        Imię Nazwisko<!--Imie i nazwisko osoby ktorej konto wybraliśmy wcześniej przyciskiem SZCZEGÓŁY-->
                        <br>
                    </div>
                    <div id="osoba_detail">                   
                        <!--To z bazy danych vvvv + zapisywanie do bazy danych TO EDYCJA JAKO ADMIN-->
                            <form action="przeniesie danych">
                                <table>
                                    <tr>
                                        <th><h3>Dane pracownika:</h3></th>
                                    </tr>
                                    <tr>
                                        <th>Imię:</th><th><input type="text" name="Imie" size="40" value="John"></th> 
                                    </tr>
                                    <tr>
                                        <th>Nazwisko:</th><th><input type="text" name="nazwisko" size="40" value="John"></th> 
                                    </tr>
                                    <tr>
                                        <th>Nickname:</th><th><input type="text" name="nickname" size="40" value="John"></th> 
                                    </tr>
                                    <tr>
                                        <th>Email:</th><th><input type="text" name="email" size="40" value="John@john.john"></th>
                                    </tr>
                                    <tr>
                                        <th>Numer konta:</th><th><input type="text" name="nrkonta" size="40" value="12341234123412341234"></th> 
                                    </tr>
                                    <tr>
                                        <th>Typ umowy:</th><th><!--</th><input type="text" name="umowy" size="40" value="Umowa"></th>-->
                                        <select id="TypUmowy" name="typumowy" style="width: 100%;"> 
                                            <option value="Typ1" >Typ1</option>
                                            <option value="Typ2" >Typ2</option>
                                            <option value="Typ3" >Typ3</option>
                                            <option value="Typ4" selected>Typ4</option>   
                                        </th>                                          
                                    </select>
                                    </tr>
                                    <tr>
                                        <th>Stanowisko:</th><th><!--<input list="Stanowisko" type="text" name="x5" size="40" value="Stanow">-->
                                        <select id="Stanowisko" name="stanowiska" style="width: 100%;"> 
                                                <option value="Stan1" >Stan1</option>
                                                <option value="Stan2" >Stan2</option>
                                                <option value="Stan3" >Stan3</option>
                                                <option value="Stan4" selected>Stan3</option>                                            
                                        </select> 
                                        </th>
                                    </tr>
                                    <tr>
                                        <th>Wypłata brutto:</th><th><input type="text" name="wyplatabrutto" size="40" value="John"></th> 
                                    </tr>
                                </table>
                                    <br><br>
                                    <input type="submit" class="konto" value="Zaktualizuj" style="vertical-align:middle">
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
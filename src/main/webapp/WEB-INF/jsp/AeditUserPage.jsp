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
                
                    ${user1.getImie()} ${user1.getNazwisko()}<!--Imie i nazwisko osoby ktorej konto wybraliśmy wcześniej przyciskiem SZCZEGÓŁY-->
                        <br>
                    </div>
                    <div id="osoba_detail">                   
                        <!--To z bazy danych vvvv + zapisywanie do bazy danych TO EDYCJA JAKO ADMIN-->
                            <form action="/edit_user">
                                <table>
                                    <tr>
                                        <th><h3>Dane pracownika:</h3></th>
                                    </tr>
                                    <tr>
                                        <th>Imię:</th><th><input type="hidden" name="id" value="${user1.getID() }"><input type="text" name="Imie" size="40" value="${user1.getImie()}"></th> 
                                    </tr>
                                    <tr>
                                        <th>Nazwisko:</th><th><input type="text" name="nazwisko" size="40" value="${user1.getNazwisko()}"></th> 
                                    </tr>
                                    <tr>
                                        <th>Nickname:</th><th><input type="text" name="nickname" size="40" value="${user1.getNick()}"></th> 
                                    </tr>
                                    <tr>
                                        <th>Email:</th><th><input type="email" name="email" size="40" value="${user1.getEmail()}"></th>
                                    </tr>
                                    <tr>
                                        <th>Numer konta:</th><th><input type="number" name="nrkonta" size="40" value="${user1.getKontoBankowe()}" style="width:100%;"></th> 
                                    </tr>
                                    <tr>
                                        <th>Typ umowy:</th><th><!--</th><input type="text" name="umowy" size="40" value="Umowa"></th>-->
                                        <select id="TypUmowy" name="typumowy"  style="width:100%;">
                                                <c:forEach var="typyUmowy" items="${typyUmowy}">
                                                    <option ${user1.getTypUmowy() == typyUmowy.getNazwa()  ? 'selected="selected"' : '' } value="${typyUmowy.getID()}">${typyUmowy.getNazwa()}</option>
                                                </c:forEach>
                                            </select>
                                    </tr>
                                    <tr>
                                        <th>Stanowisko:</th><th><!--<input list="Stanowisko" type="text" name="x5" size="40" value="Stanow">-->
                                            <select id="Stanowisko" name="stanowiska" style="width:100%;"> 
                                                    <c:forEach var="stanowiska" items="${stanowiska}">
                                                        <option ${user1.getStanowisko() == stanowiska.getNazwa()  ? 'selected="selected"' : '' } value="${stanowiska.getID()}">${stanowiska.getNazwa()}</option>
                                                    </c:forEach>                                         
                                                </select> 
                                        </th>
                                    </tr>
                                    <tr>
                                        <th>Wypłata brutto:</th><th><input type="number" name="wyplatabrutto" size="40" value="${user1.getWyplataBrutto()}" style="width:100%;"></th> 
                                    </tr>
                                    <tr>
                                        <th>Uprawnienia:</th><th></td><input type="checkbox" name="uprawnienia" value="1" ${user1.getUprawnienia() == "Administrator"  ? 'checked="checked"' : '' }>Administrator</th> 
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
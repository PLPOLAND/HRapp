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
                Dodaj użytkownika:    
            </div>
            <div class="osoba_detail"> 
                <form action="/add_user" autocomplete="off">
                    <div class="kolumnaA"> 
                        <table>    
                            <tr>
                                <th><h2><b>Dane pracownika:</h2></th>
                            </tr>          
                            <tr>
                                <th>Imię:</th><td><input type="text" name="Imie" size="40" required></td> 
                            </tr>
                            <tr>
                                <th>Nazwisko:</th><td><input type="text" name="nazwisko" size="40" required></td> 
                            </tr>
                            <tr>
                                <th>Hasło:</th><td><input type="text" name="haslo" size="40" required></td>
                                <th><input type="submit" class="konto" value="Generuj hasło" style="vertical-align:middle">
                                </th> 
                            </tr>
                            <tr>
                                <th>Nickname:</th><td><input type="text" name="nickname" size="40" required></td> 
                            </tr>
                            <tr>
                                <th>Pesel:</th><td><input type="number" name="pesel" size="40" required></td> 
                            </tr>
                            <tr>
                                <th>Data urodzenie:</th><td><input type="date" name="dataurodzenia" size="40" required></td> 
                            </tr>
                            <tr>
                                <th>Numer konta:</th><td><input type="number" name="nrkonta" size="40" required></td> 
                            </tr>
                            <tr>
                                <th>Typ umowy:</th><td><!--</th><input type="text" name="umowy" size="40" value="Umowa"></th>-->
                                <select id="TypUmowy" name="typumowy"  > 
                                    <c:forEach var="typyUmowy" items="${typyUmowy}">
                                        <option value="${typyUmowy.getID()}">${typyUmowy.getNazwa()}</option>
                                    </c:forEach>
                                </select>
                                </td>
                            </tr>
                            <tr>
                                <th>Stanowisko:</th><td><!--<input list="Stanowisko" type="text" name="x5" size="40" value="Stanow">-->
                                <select id="Stanowisko" name="stanowiska" > 
                                    <c:forEach var="stanowiska" items="${stanowiska}">
                                        <option value="${stanowiska.getID()}">${stanowiska.getNazwa()}</option>
                                    </c:forEach>                                         
                                </select> 
                                </td>
                            </tr>
                            <tr>
                                <th>Wypłata brutto:</th><td><input type="number" name="wyplatabrutto" size="40" value="" min = "1" step="0.01" required></td> 
                            </tr>
                            <tr>
                                <th>Uprawnienia:</th><td><input type="checkbox" name="uprawnienia" value="1">Administrator</td> 
                            </tr>
                        </table>
                            <br><br>
                            <input type="submit" class="konto" value="Dodaj pracownika" style="vertical-align:middle">            
                    </div>    
                    <div class="kolumnaA">                             
                            <table>
                                    <tr>
                                            <th><h2>Dane kontaktowe:</h2></th>                          
                                    </tr>
                                    <tr>
                                        <th>Email:</th><th><input type="email" name="email" size="40" required></th>
                               </tr>
                               <tr>
                                       <th>Numer telefonu:</th><th><input type="number" name="nrtelefonu" size="40" required></th>
                               </tr>
                               <tr>
                                        <th><h2>Adres:</h2></th>
                               </tr>
                               <tr>      
                                       <th>Ulica:</th><td><input type="text" name="ulica" size="40" required></td> 
                               </tr>
                               <tr>                                      
                                       <th>Numer Domu:</th><td><input type="text" name="nrdomu" size="40" required></td> 
                               </tr> 
                               <tr>  
                                       <th>Numer Mieszkania:</th><td><input type="number" name="nrmieszkania" size="40" value=""></td> 
                               </tr>  
                               <tr>                                      
                                        <th>Miasto:</th><td><input type="text" name="miasto" size="40" required></td> 
                                </tr>   
                               <tr>                                      
                                        <th>Kod pocztowy:</th><td><input type="text" name="kodpocztowy" size="40" required></td> 
                               </tr>                                       
                                </table>
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
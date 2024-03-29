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
    <link href="${icon}" rel="shortcut icon">
    <link href='http://fonts.googleapis.com/css?family=Barlow&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="${javaScript}"></script>
    <meta charset="utf-8">
    <title>HR MAJ Profil</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>
    <div id="backgroundContainer"></div>
        <div class="container">
            <div id="banner">
                 ${banner.printBanner()}
            </div>
            <div id="mainbody">
                    <div id="praco_logo">
                            ${user1.getImie()} ${user1.getNazwisko()}
                    </div>
                    <div class="osoba_detail">
                        <div class="kolumnaB">                  
                            <table>
                                <tr>
                                    <th><h2><b>Dane pracownika:</h2></th>
                                    
                                </tr>
                                <tr>
                                    <th>Imię:</th><td>${user1.getImie()}</td> 
                                </tr>
                                <tr>
                                    <th>Nazwisko:</th><td>${user1.getNazwisko()}</td> 
                                </tr>
                                <tr>
                                    <th>Nickname:</th><td>${user1.getNick()}</td> 
                                </tr>
                                <tr>
                                    <th>Pesel:</th><td>${user1.getPesel()}</td> 
                                </tr>
                                <tr>
                                    <th>Data urodzenia:</th><td>${user1.getDataUrodzenia()}</td> 
                                </tr>
                                <tr>
                                    <th>Typ umowy:</th><td>${user1.getTypUmowy()}</td>
                                </tr>
                                <tr>
                                    <th>Stanowisko:</th><td>${user1.getStanowisko()} </td>
                                </tr>
                                <tr>
                                    <th>Numer konta:</th><td>${user1.getKontoBankowe()}</td> 
                                </tr>
                                
                                <tr>
                                    <th>Uprawnienia:</th><td>${user1.getUprawnienia()}</td> 
                                </tr>
                            </table>
                        </div> 
                        <div class="kolumnaB">
                            <table>
                                <tr>
                                        <th><h2>Dane kontaktowe:</h2></th>                          
                                </tr>
                                <tr>
                                        <th>Email:</th><td>${user1.getEmail()}</td>
                                </tr>
                                <tr>
                                         <th>Numer telefonu:</th><td>${user1.getNrTelefonu()}</td> 
                                </tr>
                                <!-- 
                                <tr>
                                        <th><h2>Adres:</h2></th>
                                        <td>ul. ${user1.getUlica()} ${user1.getNrDomu()}   ${user1.getNrMieszkania() == 0  ? '' :  "m." }${user1.getNrMieszkania() == 0  ? '' :  user1.getNrMieszkania() }</td> 
                                </tr>
                                <tr>
                                        <td>${user1.getKodPocztowy()}  ${user1.getMiasto()}</td> 
                                </tr>  
                                --> 
                                <tr>
                                        <th><h2>Adres:</h2></th>
                                </tr>
                                <tr>      
                                        <th>Ulica:</th><td>${user1.getUlica()}</td> 
                                </tr>
                                <tr>                                      
                                        <th>Numer Domu:</th><td>${user1.getNrDomu()}</td> 
                                </tr> 
                                <tr>  
                                        <th>Numer Mieszkania:</th><td>${user1.getNrMieszkania() == 0  ? '' :  "m." } ${user1.getNrMieszkania() == 0  ? '' :  user1.getNrMieszkania() }</td> 
                                </tr>  
                                <tr>                                      
                                        <th>Miasto:</th><td>${user1.getMiasto()}</td> 
                                </tr>   
                                <tr>                                      
                                        <th>Kod pocztowy:</th><td>${user1.getKodPocztowy()}</td> 
                                </tr>               
                            </table>
                        </div>
                        <br><br>                       
                    </div>
                    <br><br><br><br>
                </div>
        <div id="footer">
            MAJ<br>
            © Wszelkie prawa zastrzeżone
        </div>
    </div>
</body>

</html>
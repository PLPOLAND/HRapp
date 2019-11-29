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
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
    
    <title>HR MAJ Admin Page</title>
</head>

<body>
    <div id="backgroundContainer"></div>
    <div class="container">
        <div id="banner">
            ${banner.printBanner()}            
        </div>
        <div id="mainbody">
            <div id="praco_logo">
                    Pracownicy
                    <br><br>
            </div>
            <div class="wyszukaj">
                <form>
                    <input type="text" name="search" placeholder="Wyszukaj pracownika...">
                </form>
                <br>
            </div>
            <div id="pracownicy">
                <!-- <c:forEach var="vart" items="${userList}">
                    <div class="osoba"> 
                            ${vart.getImie()} ${vart.getNazwisko()}
                            <div class="button1" class="button1" onclick="location.href='/edit_user_page?id=${vart.getID()}'"><i class='far fa-edit'></i></div>
                            <div class="button1"><i class='far fa-trash-alt'></i></div>
                            <div type="button" class="button1" onclick="location.href='/user_profile_page?id=${vart.getID()}'"><i class='far fa-address-card'></i></div>
                            <div class="button1"><i class='far fa-money-bill-alt'></i></div>
                            <div style="clear:both"></div>
                            <br>
                    </div>               
                </c:forEach> -->

                <table class="tabelauserow">
                    <tr>
                        <td onclick="sortUsers(sort_by_name,this)">Imie</td>
                        <td onclick="sortUsers(sort_by_surname,this)">Nazwisko</td>
                        <td onclick="sortUsers(sort_by_email,this)">Email</td>
                        <td onclick="sortUsers(sort_by_stanowisko,this)">Stanowisko</td>         
                        <td class="nohover"></td>
                        <td class="nohover"></td>
                        <td class="nohover"></td>
                        <td class="nohover"></td>
                    </tr>
                    <c:forEach var="userval" items="${userList}">
                        <tr class="pos">
                            <td>${userval.getImie()}</td>
                            <td>${userval.getNazwisko()}</td>
                            <td>${userval.getEmail()}</td>
                            <td>${userval.getStanowisko()}</td>
                            <td class="przycisk" onclick="location.href='/edit_user_page?id=${userval.getID()}'" >
                                <div class="tooltip">
                                        <i class="icon-edit"></i>
                                    <span class="tooltiptext">Edytuj</span>
                                </div>
                                <!-- <input type="button" class="" value="Edytuj" onclick="location.href='/edit?id=${userval.getID()}'" /> -->
                            </td>
                            <td class="przycisk delete" >
                                <div class="tooltip">
                                        <i class='icon-trash'></i>
                                    <span class="tooltiptext">Usuń</span>
                                </div>
                                <!--<input type="button" class="" value="Usuń"
                                    onclick="confirmation(<c:out value='${userval.getID()}' />);" /> -->
                            </td>
                            <td class="przycisk" onclick="location.href='/user_profile_page?id=${userval.getID()}'">
                                <div class="tooltip">
                                    <i class='icon-list'></i>
                                    <span class="tooltiptext">Szczegóły</span>
                                </div> 
                            </td>
                            <td class="przycisk" onclick="location.href='/user_payment_page?id=${userval.getID()}'">
                                <div class="tooltip">
                                    <i class='icon-credit-card'></i>
                                    <span class="tooltiptext">Wyciąg</span>
                                </div> 
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>    
            <!-- <div id="person">  
                    <button class="konto" style="vertical-align:middle"><span><i class="fa fa-male"></i>  Moje konto 
                        <img width="50", height="50", src="/img/Ricardo_Milos.png"/>
                    </span></button> Tu ma byc przycisk do AeditUserPage albo AdminProfile --> 
                    <!--Zalezy czy admin ma miec specjalną stronę dla swojego konta czy nie -->   
                    <!-- <div class ="ikona"></div>
            </div>       -->
        </div>
        <div id="footer">
            MAJ<br>
            © Wszelkie prawa zastrzeżone
        </div>
    </div>
</body>

</html>
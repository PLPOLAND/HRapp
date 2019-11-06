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
                Pracownicy<br><br>
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

                <table>
                    <tr>
                        <td>Imie</td>
                        <td>Nazwisko</td>
                        <td>Email</td>
                        <td>Nr Konta Bankowego</td>
                        <td>Wypłata NETTO</td>
                        <td>Wypłata BRUTTO</td>
                        <td>Stanowisko</td>
                        <td>Typ Umowy</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <c:forEach var="userval" items="${userList}">
                        <tr>
                            <td>${userval.getImie()}</td>
                            <td>${userval.getNazwisko()}</td>
                            <td>${userval.getEmail()}</td>
                            <td>${userval.getKontoBankowe()}</td>
                            <!-- <td>${userval.getWyplataBrutto()} zł</td> -->
                            <td>pińćsetZłoty(TODO ;-P )</td>
                            <td>${userval.getWyplataBrutto()} zł</td>
                            <td>${userval.getStanowisko()}</td>
                            <td>${userval.getTypUmowy()}</td>
                            <td class="przycisk" onclick="location.href='/edit_user_page?id=${userval.getID()}'" >
                                <i class='far fa-edit'></i>
                                <!-- <input type="button" class="" value="Edytuj" onclick="location.href='/edit?id=${userval.getID()}'" /> -->
                            </td>
                            <td class="przycisk" >
                                <i class='far fa-trash-alt'></i>
                                <!--<input type="button" class="" value="Usuń"
                                    onclick="confirmation(<c:out value='${userval.getID()}' />);" /> -->
                            </td>
                            <td class="przycisk" onclick="location.href='/user_profile_page?id=${userval.getID()}'"> <i class='far fa-address-card'></i> </td>
                            <td class="przycisk" > <i class='far fa-money-bill-alt'></i> </td>
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
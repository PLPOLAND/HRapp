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
    <c:url value="/css/login.css" var="jstlCss" />
    <c:url value="/js/login.js" var="javaScript" />
    <c:url value="/img/icon.png" var="icon" />
    <link href="${jstlCss}" rel="stylesheet" />
    <link href="${icon}" rel="shortcut icon" >
    <link href='http://fonts.googleapis.com/css?family=Barlow&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="${javaScript}"></script>
    <title>HR MAJ Logowanie</title>
</head>

<body>
    <div class="container">
            <div class="login-container">
            <div class="login-form">
                <h3>Logowanie do systemu</h3>
                <form action="none">
                    <div id="err-msg">Podano błędny login lub hasło</div>
                    <div class="login-field">
                        <input type="text" class="form-control" placeholder="Twój Nick *" value="" name="nick" id="nick"/>
                    </div>
                    <div class="login-field">
                        <input type="password" class="form-control" placeholder="Twoje Hasło *" value="" name="pass" id="pass"/>
                    </div>
                    <div id="subbutton" class="login-field btn-field">
                        <input type="button" class="btnSubmit" value="Zaloguj" />
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>

</html>
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
    <c:url value="/css/main.css" var="jstlCss2" />
    <c:url value="/css/login.css" var="jstlCss" />
    <c:url value="/js/main.js" var="javaScript" />
    <c:url value="/img/icon.png" var="icon" />
    <link href="${jstlCss}" rel="stylesheet" />
    <link href="${jstlCss2}" rel="stylesheet" />
    <link href="${icon}" rel="shortcut icon" >
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="${javaScript}"></script>
    <title>HR MAJ Logowanie</title>
</head>

<body>
    <div class="container tmp_img">
            <img style="float: right", width="60", height="60", src="/img/logomaj.png"/>
        <div class="login-container">
            <div class="login-form">
                <h3>Logowanie do systemu</h3>
                <form action="login" method="POST">
                    <div class="login-field">
                        <input type="text" class="form-control" placeholder="Twój Nick *" value="" name="nick" />
                    </div>
                    <div class="login-field">
                        <input type="password" class="form-control" placeholder="Twoje Hasło *" value="" name="pass" />
                    </div>
                    <div class="login-field btn-field">
                        <input type="submit" class="btnSubmit" value="Zaloguj" />
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>

</html>
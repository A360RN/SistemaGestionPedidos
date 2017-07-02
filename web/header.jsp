<%-- 
    Document   : header
    Created on : 01-jul-2017, 21:09:09
    Author     : alonsorn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css">
        <link rel="stylesheet" href="resources/css/styles.css">
        <title>Sunshine Andina</title>
    </head>

    <%
        boolean userFlag = false;
        if (session.getAttribute("user") != null) {
            userFlag = true;
        }
    %>

    <body>
        <nav class="navbar-material default-primary-color">
            <div class="nav-wrapper container">
                <a href="#!" class="brand-logo left">Sunshine Andina</a>
                <a href="#" data-activates="sidebar" class="button-collapse right"><i class="material-icons">menu</i></a>
                <ul class="right hide-on-med-and-down">
                    <%if (!userFlag) {%>
                    <li><a href="index.jsp">Login</a></li>
                    <li><a href="register.jsp">Registrarse</a></li>
                    <%}else{%>
                    <li><a href="products.jsp">Tienda<i class="material-icons right">store</i></a></li>
                    <li><a href="SaleController?action=cart">Ver carrito<i class="material-icons right"> shopping_cart</i></a></li>
                    <li><a href="profile.jsp">Mi Perfil</a></li>
                    <li><a href="UserController?action=logout">Salir</a></li>
                    <%}%>
                </ul>
                <ul class="side-nav dark-primary-color" id="sidebar">
                    <%if (!userFlag) {%>
                    <li><a href="index.jsp">Login</a></li>
                    <li><a href="register.jsp">Register</a></li>
                    <%}else{%>
                    <li><a href="products.jsp">Tienda<i class="material-icons right">store</i></a></li>
                    <li><a href="cart.jsp">Ver carrito<i class="material-icons right">shopping_cart</i></a></li>
                    <li><a href="profile.jsp">Mi Perfil</a></li>
                    <li><a href="UserController?action=logout">Salir</a></li>
                    <%}%>
                </ul>
            </div>
        </nav>

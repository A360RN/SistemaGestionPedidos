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
    <body>
        <nav class="navbar-material default-primary-color">
            <div class="nav-wrapper container">
                <a href="products.jsp" class="brand-logo left">Sunshine Andina</a>
                <a href="#" data-activates="sidebar" class="button-collapse right"><i class="material-icons">menu</i></a>
                <ul class="right hide-on-med-and-down">
                    <li><a href="index.jsp">Login</a></li>
                    <li><a href="register.jsp">Register</a></li>
                    <li><a href="#">Logout</a></li>
                    <li><a href="cart.jsp">Ver carrito<i class="material-icons right"> shopping_cart</i></a></li>
                    <li><a href="profile.jsp">Mi Perfil</a></li>
                </ul>
                <ul class="side-nav dark-primary-color" id="sidebar">
                    <li><a href="index.jsp">Login</a></li>
                    <li><a href="register.jsp">Register</a></li>
                    <li><a href="#">Logout</a></li>
                    <li><a href="cart.jsp">Ver carrito<i class="material-icons right">shopping_cart</i></a></li>
                    <li><a href="profile.jsp">Mi Perfil</a></li>
                </ul>
            </div>
        </nav>
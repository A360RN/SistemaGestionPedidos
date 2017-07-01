<%@page import="Modelo.Category"%>
<%@page import="Modelo.Product"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css">
    <link rel="stylesheet" href="resources/css/styles.css">
    <title>Document</title>
</head>

<body>
    <%
        ArrayList<Category> listaCategorias = null;
        ArrayList<Product> listaProductos = null;
        if(request.getAttribute("listProducts")!= null){
            listaProductos = (ArrayList<Product>)request.getAttribute("listProducts");
        }
        if(request.getAttribute("categories")!= null){
            listaCategorias = (ArrayList<Category>)request.getAttribute("categories");
        }
        
    %>

    <nav class="navbar-material default-primary-color">
        <div class="nav-wrapper container">
            <a href="products.html" class="brand-logo left">Sunshine Andina</a>
            <a href="#" data-activates="sidebar" class="button-collapse right"><i class="material-icons">menu</i></a>
            <ul class="right hide-on-med-and-down">
                <li><a href="index.html">Login</a></li>
                <li><a href="register.html">Register</a></li>
                <li><a href="#">Logout</a></li>
                <li><a href="cart.html">Ver carrito<i class="material-icons right"> shopping_cart</i></a></li>
                <li><a href="profile.html">Mi Perfil</a></li>
            </ul>
            <ul class="side-nav dark-primary-color" id="sidebar">
                <li><a href="index.html">Login</a></li>
                <li><a href="register.html">Register</a></li>
                <li><a href="#">Logout</a></li>
                <li><a href="cart.html">Ver carrito<i class="material-icons right">shopping_cart</i></a></li>
                <li><a href="profile.html">Mi Perfil</a></li>
            </ul>
        </div>
    </nav>

    <div class="row">
        <div class="col s12 m3">
            <div class="collection">
                <% if(listaCategorias != null){ %>
                <%for(Category c : listaCategorias){%>
                <a href="#!" class="category-search collection-item waves-effect" data-id="<%= c.getIdCategory()%>"><%= c.getName()%></a>
                <% } %>
                <% } %>
                <a href="#!" id="most-wanted" class="collection-item waves-effect">M�s Vendidos</a>
            </div>
        </div>

        <div id="product-grid" class="col s12 m9 right">
            <!-- empieza card -->
            <% if(listaProductos != null){%>
            <% for(Product p : listaProductos){%>
            <div class="col s12 m6 l4">
                <div class="card sticky-action">
                    <div class="card-image">
                        <img src="<%= p.getImage()%>"
                            alt="" class="responsive-img">
                    </div>
                    <div class="card-content">
                        <span class="card-title"><%= p.getName()%></span>
                        <span class="green-text text-darken-2">S/. <%= p.getPrice()%></span>
                        <br>
                        <a href="#!" class="activator">Mas informacion<i class="material-icons right">info</i></a>
                    </div>
                    <div class="card-action">
                        <form action="#!">
                            <div class="row">
                                <div class="input-field inline col s12 m7"><input type="number" placeholder="Cantidad"></div>
                                <div class="input-field inline">
                                    <button class="btn accent-color"><i class="material-icons">shopping_cart</i></button>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="card-reveal">
                        <span class="card-title"><%= p.getName()%><i class="material-icons right">close</i></span>
                        <p class="flow-text"><%= p.getDescription()%></p>
                    </div>
                </div>
            </div>
            <% } %>
            <% }%>
            <!-- termina card -->
        </div>

    </div>

    <footer class="page-footer default-primary-color">
        <div class="footer-copyright">
            <div class="container">
                <div class="right">&copy; 2017</div>
            </div>
        </div>
    </footer>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>
    <script src="resources/js/main.js"></script>
</body>

</html>

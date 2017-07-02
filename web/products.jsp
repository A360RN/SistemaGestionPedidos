<%@page import="Modelo.Category"%>
<%@page import="Modelo.Product"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="header.jsp"></jsp:include>

<%
    ArrayList<Category> listaCategorias = null;
    ArrayList<Product> listaProductos = null;
    if (session.getAttribute("listProducts") != null) {
        listaProductos = (ArrayList<Product>) session.getAttribute("listProducts");
    }
    if (session.getAttribute("categories") != null) {
        listaCategorias = (ArrayList<Category>) session.getAttribute("categories");
    }

%>

<jsp:include page="flash-message.jsp"></jsp:include>

<div class="row">
    <div class="col s12 m3">
        <div class="collection">
            <% if (listaCategorias != null) { %>
            <%for (Category c : listaCategorias) {%>
            <a href="#!" class="category-search collection-item waves-effect" data-id="<%= c.getIdCategory()%>"><%= c.getName()%></a>
            <% } %>
            <% } %>
            <a href="#!" id="most-wanted" class="collection-item waves-effect">Más Vendidos</a>
        </div>
    </div>

    <div id="product-grid" class="col s12 m9 right">
        <!-- empieza card -->
        <% if (listaProductos != null) {%>
        <% for (Product p : listaProductos) {%>
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
                                <button data-id="<%= p.getIdProduct()%>" class="cart-btn btn accent-color"><i class="material-icons">shopping_cart</i></button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="card-reveal">
                    <span class="card-title"><%= p.getName()%><i class="material-icons right">close</i></span>
                    <span class="green-text text-darken-2">S/. <%= p.getPrice()%></span>
                    <p><%= p.getDescription()%></p>
                </div>
            </div>
        </div>
        <% } %>
        <% }%>
        <!-- termina card -->
    </div>

</div>

<jsp:include page="footer.jsp"></jsp:include>

<%@page import="java.math.RoundingMode"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="Modelo.Sale"%>
<%@page import="Modelo.SaleDetail"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="header.jsp"></jsp:include>

<%
    ArrayList<SaleDetail> cartDetails = null;
    Sale cart = null;
    if (session.getAttribute("cartDetails") != null) {
        cartDetails = (ArrayList<SaleDetail>) session.getAttribute("cartDetails");
    }
    if (session.getAttribute("cart") != null) {
        cart = (Sale) session.getAttribute("cart");
    }
%>

<div class="row">
    <%if (cartDetails != null) {%>
    <table class="responsive-table">
        <thead>
            <tr>
                <th>Producto</th>
                <th>Cantidad</th>
                <th>Precio Unitario</th>
                <th>Sub-Total</th>
                <th>Descuento</th>
                <th>Total Detalle</th>
                <th></th>
            </tr>
        </thead>
        <tbody>

            <%for (SaleDetail detail : cartDetails) {%>
            <tr>
                <td><%= detail.getProduct().getName()%></td>
                <td><input type="number" value="<%= detail.getQuantity()%>"></td>
                <td>S/. <%= detail.getProduct().getPrice()%></td>
                <td>S/. <%= detail.getProduct().getPrice() * detail.getQuantity()%></td>
                <td>S/. <%= detail.getDiscount()%></td>
                <td>S/. <%= detail.getProduct().getPrice() * detail.getQuantity() - detail.getDiscount()%></td>
                <td><button data-id="<%=detail.getIdProduct()%>" class="delete-detail-btn btn red waves-effect"><i class="material-icons prefix">delete</i></button></td>
            </tr>
            <%}%>

        </tbody>
    </table>

    <div class="col s6 offset-s4">
        <p class="right-align">Subtotal: S/. <%= new BigDecimal(cart.getTotalDiscount() + cart.getTotal()).setScale(2, RoundingMode.HALF_UP).doubleValue()%></p> 
    </div>
    <div class="col s6 offset-s4">
        <p class="right-align">Descuento total: S/. <%= new BigDecimal(cart.getTotalDiscount()).setScale(2, RoundingMode.HALF_UP).doubleValue()%></p> 
    </div>
    <div class="col s6 offset-s4">
        <p class="right-align">Total: S/. <%= new BigDecimal(cart.getTotal()).setScale(2, RoundingMode.HALF_UP).doubleValue()%></p>
    </div>

    <div class="col s12 m6 right">

    </div>
    <div class="col s12 center-align">
        <button id="save-cart-btn" class="btn accent-color waves-effect">Guardar Pedido</button>
    </div>
    <div class="col s12 center-align">
        <button id="delete-cart-btn" class="btn red darken-2 waves-effect">Eliminar Pedido</button>
    </div>        
    <%} else {%>
    <h1 class="center-align">CARRITO VACIO...</h1>
    <%}%>
</div>

<jsp:include page="footer.jsp"></jsp:include>
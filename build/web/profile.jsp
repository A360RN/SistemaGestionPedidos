<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Modelo.SaleDetail"%>
<%@page import="Modelo.Sale"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="header.jsp"></jsp:include>

<%
    ArrayList<Sale> lastSales = null;
    if (session.getAttribute("lastSales") != null) {
        lastSales = (ArrayList<Sale>) session.getAttribute("lastSales");
    }
%>

<div class="container">
    <div class="row">
        <h1>Mi Perfil</h1>
        <div class="col m4 s12">
            <a href="myuser.jsp" class="btn waves-effect green">Actualizar Datos</a>
        </div>
        <div class="col m4 s12">
            <a class="btn waves-effect red">Cambiar contraseña</a>
        </div>

        <div class="clearfix"></div>
        <div class="divider divider-color"></div>

        <h3>Pedidos Recientes</h3>

        <%if (lastSales != null) {%>
        <div class="col s12">
            <ul class="collapsible" data-collapsible="accordion">
                <%
                    for (Sale s : lastSales) {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        Date date = sdf.parse(s.getDateSale());
                        SimpleDateFormat newDateFormat = new SimpleDateFormat("dd/MM/yyy hh:mm:ss a");
                        String dateString = newDateFormat.format(date);
                %>
                <li>
                    <div class="collapsible-header">
                        <span><%= dateString %></span>
                        <span class="badge">Total: S/. <%= s.getTotal()%></span>
                    </div>
                    <div class="collapsible-body">
                        <table class="responsive-table">
                            <thead>
                                <tr>
                                    <th>Producto</th>
                                    <th>Cantidad</th>
                                    <th>Precio Unitario</th>
                                    <th>Sub-Total</th>
                                    <th>Descuento</th>
                                    <th>Total Detalle</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%for (SaleDetail detail : s.getSaleDetails()) {%>
                                <tr>
                                    <td><%= detail.getProduct().getName()%></td>
                                    <td><%= detail.getQuantity()%></td>
                                    <td>S/. <%= detail.getProduct().getPrice()%></td>
                                    <td>S/. <%= detail.getSubtotal() + detail.getDiscount()%></td>
                                    <td>S/. <%= detail.getDiscount()%></td>
                                    <td>S/. <%= detail.getSubtotal()%></td>
                                </tr>
                                <% }%>
                            </tbody>
                        </table>
                    </div>
                </li> 
                <% } %>
            </ul>
        </div>
        <% }%>
    </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>
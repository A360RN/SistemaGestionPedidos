<%@page import="Modelo.SaleDetail"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="header.jsp"></jsp:include>

    <%
        ArrayList<SaleDetail> cartDetails = null;
        if(session.getAttribute("cartDetails")!= null){
            cartDetails = (ArrayList<SaleDetail>)session.getAttribute("cartDetails");
        }
    %>

    <div class="row">
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
                
                <tr>
                    <td>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Culpa, a!</td>
                    <td><input type="number"></td>
                    <td>Data</td>
                    <td>Data</td>
                    <td>Data</td>
                    <td>Data</td>
                    <td><button class="btn red waves-effect"><i class="material-icons prefix">delete</i></button></td>
                </tr>
                
            </tbody>
        </table>
        <div class="col s12 m6 right">

        </div>
        <div class="col s12 center-align">
            <button class="btn accent-color waves-effect">Guardar Pedido</button>
        </div>
    </div>

<jsp:include page="footer.jsp"></jsp:include>
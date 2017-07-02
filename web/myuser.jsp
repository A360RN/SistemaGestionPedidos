<%@page import="Modelo.Customer"%>
<jsp:include page="header.jsp"></jsp:include>

<%
    Customer user = null;
    if (session.getAttribute("user") != null) {
        user = (Customer) session.getAttribute("user");
    }
%>

<%if (user != null) {%>
<div class="container">
    <div class="row">
        <form action="UserController?action=update" method="POST" class="col s12">
            <div class="row">
                <div class="input-field col s6">
                    <input type="text" name="username" id="username" value="<%=user.getUserName()%>" disabled>
                    <label for="username">Usuario</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col m6 s12">
                    <input type="text" value="<%=user.getFirstName()%>" name="firstname" id="firstname" disabled>
                    <label for="firstname">Primer Nombre</label>
                </div>
                <div class="input-field col m6 s12">
                    <input type="text" value="<%=user.getMiddleName()%>" name="middlename" id="middlename" disabled>
                    <label for="middlename">Segundo Nombre</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col m6 s12">
                    <input type="text" value="<%=user.getLastName()%>" name="lastname" id="lastname" disabled>
                    <label for="lastname">Apellido Paterno</label>
                </div>
                <div class="input-field col m6 s12">
                    <input type="text" value="<%=user.getLastName2()%>" name="lastname2" id="lastname2" disabled>
                    <label for="lastname2">Apellido Materno</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col m6 s12">
                    <input type="text" value="<%=user.getDni()%>" name="lastname2" id="dni" disabled>
                    <label for="dni">DNI</label>
                </div>
                <div class="input-field col m6 s12">
                    <input type="text" value="<%=user.getRuc()%>" name="lastname2" id="ruc" disabled>
                    <label for="ruc">RUC</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field inline col s12 m6">
                    <input type="text" id="phone" name="phone" value="<%=user.getPhoneNumber()%>" required>
                    <label for="phone">Telefono</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col m6 s12">
                    <textarea class="materialize-textarea" type="text" name="address" id="direccion" required><%=user.getAddress()%>
                    </textarea>
                    <label for="address">Direccion</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col m6 s12">
                    <input type="email" id="email" name="email" value="<%=user.getEmail()%>" required>
                    <label for="email">Email</label>
                </div>
            </div>
            <div class="row">
                <div class="col s12 center-align">
                    <button class="btn waves-effect red">Guardar Cambios</button>
                </div>
            </div>
        </form>
    </div>
</div>
<%}%>
<jsp:include page="footer.jsp"></jsp:include>
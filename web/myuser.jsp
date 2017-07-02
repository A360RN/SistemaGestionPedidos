<jsp:include page="header.jsp"></jsp:include>

    <div class="container">
        <div class="row">
            <form action="#!" class="col s12">
                <div class="row">
                    <div class="input-field col s6">
                        <input type="text" name="username" id="username" value="Username">
                        <label for="username">Usuario</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col m6 s12">
                        <input type="text" value="Alonso" name="firstname" id="firstname">
                        <label for="firstname">Primer Nombre</label>
                    </div>
                    <div class="input-field col m6 s12">
                        <input type="text" value="Naohiko" name="middlename" id="middlename">
                        <label for="middlename">Segundo Nombre</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col m6 s12">
                        <input type="text" value="Reynoso" name="lastname" id="lastname">
                        <label for="lastname">Apellido Paterno</label>
                    </div>
                    <div class="input-field col m6 s12">
                        <input type="text" value="Nishida" name="lastname2" id="lastname2">
                        <label for="lastname2">Apellido Materno</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col m6 s12">
                        <input type="text" value="72791237" name="lastname2" id="dni">
                        <label for="dni">DNI</label>
                    </div>
                    <div class="input-field col m6 s12">
                        <input type="text" value="10727912377" name="lastname2" id="ruc">
                        <label for="ruc">RUC</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field inline col s12 m6">
                        <input type="text" id="phone" name="phone" value="4712054">
                        <label for="phone">Telefono</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col m6 s12">
                        <textarea class="materialize-textarea" type="text" value="Direccion" name="direccion" id="direccion">Av. Santa Catalina 630 La Victoria
                        </textarea>
                        <label for="firstname">Direccion</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col m6 s12">
                        <input type="email" id="email" name="email" value="alonso.reynoso9715@gmail.com">
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

<jsp:include page="footer.jsp"></jsp:include>
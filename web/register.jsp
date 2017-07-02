<jsp:include page="header.jsp"></jsp:include>

    <div class="container">
        <div class="row">
            <h2 class="center-align">Ingrese sus datos</h2>

            <form action="" class="col s6 offset-s3 user-form">
                <div class="row">
                    <div class="input-field inline col s12 m6">
                        <input type="text" id="username">
                        <label for="username">Usuario</label>
                    </div>
                    <div class="input-field inline col s12 m6">
                        <input type="password" id="password">
                        <label for="password">Contraseña</label>
                    </div>
                    <div class="input-field inline col s12 m6">
                        <input type="text" id="firstname">
                        <label for="firstname">Primer Nombre</label>
                    </div>
                    <div class="input-field inline col s12 m6">
                        <input type="text" id="middlename">
                        <label for="middlename">Segundo Nombre</label>
                    </div>
                    <div class="input-field inline col s12 m6">
                        <input type="text" id="firstname">
                        <label for="lastname">Apellido Paterno</label>
                    </div>
                    <div class="input-field inline col s12 m6">
                        <input type="text" id="firstname">
                        <label for="lastname2">Apellido Materno</label>
                    </div>
                    <div class="input-field inline col s12 m6">
                        <input type="text" id="dni">
                        <label for="dni">DNI</label>
                    </div>
                    <div class="input-field inline col s12 m6">
                        <input type="text" id="ruc">
                        <label for="ruc">RUC</label>
                    </div>
                    <div class="input-field inline col s12 m6">
                        <input type="text" id="phone">
                        <label for="phone">Telefono</label>
                    </div>
                    <div class="input-field col s12">
                        <input type="email" id="email" name="email">
                        <label for="email">Email</label>
                    </div>
                    <div class="input-field inline col s12">
                        <textarea id="direccion" class="materialize-textarea"></textarea>
                        <label for="direccion">Direccion</label>
                    </div>
                    <div class="col s12 center-align">
                        <button class="btn waves-effect accent-color">Registrarse</button>
                    </div>
                </div>
            </form>

        </div>
    </div>
    
<jsp:include page="footer.jsp"></jsp:include>
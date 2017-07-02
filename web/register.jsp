<jsp:include page="header.jsp"></jsp:include>

    <div class="container">
        <div class="row">
            <h2 class="center-align">Ingrese sus datos</h2>

            <form action="UserController?action=register" method="POST" class="col s6 offset-s3 user-form">
                <div class="row">
                    <div class="input-field inline col s12 m6">
                        <input name="username" type="text" id="username" required>
                        <label for="username">Usuario</label>
                    </div>
                    <div class="input-field inline col s12 m6">
                        <input name="password" type="password" id="password" required>
                        <label for="password">Contraseña</label>
                    </div>
                    <div class="input-field inline col s12 m6">
                        <input name="firstname" type="text" id="firstname" required>
                        <label for="firstname">Primer Nombre</label>
                    </div>
                    <div class="input-field inline col s12 m6">
                        <input name="middlename" type="text" id="middlename">
                        <label for="middlename">Segundo Nombre</label>
                    </div>
                    <div class="input-field inline col s12 m6">
                        <input name="lastname" type="text" id="lastname" required>
                        <label for="lastname">Apellido Paterno</label>
                    </div>
                    <div class="input-field inline col s12 m6">
                        <input name="lastname2" type="text" id="lastname2"  required>
                        <label for="lastname2">Apellido Materno</label>
                    </div>
                    <div class="input-field inline col s12 m6">
                        <input name="dni" type="text" id="dni" required size="8" minlength="8" maxlength="8">
                        <label for="dni">DNI</label>
                    </div>
                    <div class="input-field inline col s12 m6">
                        <input name="ruc" type="text" id="ruc" required size="11" minlength="11" maxlength="11">
                        <label for="ruc">RUC</label>
                    </div>
                    <div class="input-field inline col s12 m6">
                        <input name="phone" type="text" id="phone" required maxlength="9" minlength="7">
                        <label for="phone">Telefono</label>
                    </div>
                    <div class="input-field col s12">
                        <input name="email" type="email" id="email" name="email" required>
                        <label for="email">Email</label>
                    </div>
                    <div class="input-field inline col s12">
                        <textarea name="address" id="address" class="materialize-textarea" required></textarea>
                        <label for="address">Direccion</label>
                    </div>
                    <div class="col s12 center-align">
                        <button class="btn waves-effect accent-color">Registrarse</button>
                    </div>
                </div>
            </form>

        </div>
    </div>
    
<jsp:include page="footer.jsp"></jsp:include>
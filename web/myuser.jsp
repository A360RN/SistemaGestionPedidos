<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css">
    <link rel="stylesheet" href="resources/css/styles.css">
</head>

<body>
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
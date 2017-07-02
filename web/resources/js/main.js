$(document).ready(() => {
    $(".button-collapse").sideNav({
        edge: 'right'
    });

    $('select').material_select();

    init();

    function init() {
        validateNumberInput();
        addProduct();
        cartButtonEvent();
    }

    function cartButtonEvent() {
        $('#save-cart-btn').on('click', function () {
            $.ajax({
                type: 'POST',
                url: 'SaleController',
                data: {action: 'save-cart'},
                success: function () {
                    window.location.href = "products.jsp";
                }
            });
        });

        $('#delete-cart-btn').on('click', function () {
            $.ajax({
                type: 'POST',
                url: 'SaleController',
                data: {action: 'delete-cart'},
                success: function () {
                    window.location.href = "products.jsp";
                }
            });
        });
    }

    // si val en cantidad <= 0
    function validateNumberInput() {
        $('input[type="number"]').on('keyup mouseup', function () {
            let val = $(this).val();
            if (val <= 0) {
                $(this).val(null);
            }
        });
    }

    $('.collapsible').collapsible();

    $('#btn-actualizar').on('click', function () {
        window.location.href = 'myuser.html';
    });

    function addProduct() {
        $('.cart-btn').on('click', function (e) {
            e.preventDefault();
            let quantity = $(this).parent().prev().children('input').val();
            let idProduct = $(this).data('id');
            if (quantity > 0) {
                $.ajax({
                    type: 'POST',
                    url: 'SaleController',
                    data: {action: 'addSale', quantity: quantity, idProduct: idProduct}
                }).done(function () {
                    $('#message').text("Producto agregado al carrito");
                });
            }
        });
    }

    function generateProductGrid(res) {
        let productList = JSON.parse(res);
        let newHtml = "";
        productList.forEach((product) => {
            newHtml += `
                <div class="col s12 m6 l4">
                    <div class="card sticky-action">
                        <div class="card-image">
                            <img src="${product.image}"
                                alt="" class="responsive-img">
                        </div>
                        <div class="card-content">
                            <span class="card-title">${product.name}</span>
                            <span class="green-text text-darken-2">S/. ${product.price}</span>
                            <br>
                            <a href="#!" class="activator">Mas informacion<i class="material-icons right">info</i></a>
                        </div>
                        <div class="card-action">
                            <form action="#!">
                                <div class="row">
                                    <div class="input-field inline col s12 m7"><input type="number" placeholder="Cantidad"></div>
                                    <div class="input-field inline">
                                        <button data-id="${product.idProduct}" class="card-btn btn accent-color"><i class="material-icons">shopping_cart</i></button>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="card-reveal">
                            <span class="card-title">${product.name}<i class="material-icons right">close</i></span>
                            <span class="green-text text-darken-2">S/. ${product.price}</span>
                            <p>${product.description}</p>
                        </div>
                    </div>
                </div>
                `;
        });
        $('#product-grid').html(newHtml);
    }

    $('.category-search').on('click', function () {
        let idCategory = $(this).data('id');
        $.ajax({
            type: 'GET',
            url: 'ProductController',
            data: {idCategory: idCategory, action: 'category'}
        }).done(function (res) {
            generateProductGrid(res);
            validateNumberInput();
        });
    });

    $('#most-wanted').on('click', function () {
        $.ajax({
            type: 'GET',
            url: 'ProductController',
            data: {action: 'most-wanted'}
        }).done(function (res) {
            generateProductGrid(res);
            btnCartEvent();
        });
    });
});

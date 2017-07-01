$(document).ready(() => {
    $(".button-collapse").sideNav({
        edge: 'right'
    });

    $('select').material_select();

    // si val en cantidad <= 0
    $('input[type="number"]').bind('keyup mouseup', function(){
        let val = $(this).val();
        if(val <= 0){
            $(this).val(null);
        }
    });

    $('.collapsible').collapsible();

    $('#btn-actualizar').on('click', function(){
        window.location.href = 'myuser.html';
    });
    
    $('.category-search').on('click', function(){
        let idCategory = $(this).data('id');
        $.ajax({
            type: 'GET',
            url: 'ProductController',
            data: {idCategory: idCategory}
        }).done(function(res){
            let productList = JSON.parse(res);
            let newHtml = "";
            
            productList.forEach((product) =>{
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
                                        <button class="btn accent-color"><i class="material-icons">shopping_cart</i></button>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="card-reveal">
                            <span class="card-title">${product.name}<i class="material-icons right">close</i></span>
                            <p class="flow-text">${product.description}</p>
                        </div>
                    </div>
                </div>
                `
            });
            $('#product-grid').html(newHtml);
        });
    });
});
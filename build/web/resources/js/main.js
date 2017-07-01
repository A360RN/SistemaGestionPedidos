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
});
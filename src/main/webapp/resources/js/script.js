$(document).ready(function(){
    $('.collapsible').collapsible();
});

$(document).ready(function() {
    $('select').material_select();
});



var activeType;

function qTypeChanged(v){
    // 4 - 1, 2 - 1, 4+pic - 1, pic + map
    var textType;
    if (v == 1)
        textType = '#firstType';
    else if (v == 2)
        textType = '#secondType';
    else if (v == 3)
        textType = '#thirdType';
    else if (v == 4)
        textType = '#fourthType';

    if (activeType != null) {
        $(activeType).hide();
    }
    $(textType).show();

    activeType = textType;
}
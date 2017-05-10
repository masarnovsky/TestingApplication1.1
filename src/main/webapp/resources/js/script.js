$(document).ready(function() {
    $('select').material_select();
});

function submitForm(id) {
    document.getElementById("userAnswer").setAttribute("value", id);
}



var activeType;

var firstType = '<div id="firstType">' +
    '<div class="col s12">' +
    '<div class="input-field col s12">' +
    '<label>Правильный ответ:</label>' +
    '<input name="answer1" type="text" />'+
    '</div><div class="input-field col s12">'+
    '<label>Ответ:</label><input name="answer2" type="text" /></div>'+
    '<div class="input-field col s12"><label>Ответ:</label>'+
    '<input name="answer3" type="text" /></div><div class="input-field col s12">' +
    '<label>Ответ:</label><input name="answer4" type="text" /></div></div></div>';

var secondType = '<div id="secondType"><div class="col s12"><div class="col s12"><div class="input-field col s12">'  +
    '<label>Правильный ответ:</label><input name="answer1" type="text" /></div><div class="input-field col s12">' +
'<label>Ответ:</label><input name="answer2" type="text" /></div></div></div></div>';

var thirdType = '<div id="thirdType"><div class="col s12">'+
    '<div class="col s12 file-field input-field"><div class="btn"><span>Загрузить картинку</span>'+
    '<input type="file" name="image" accept="image/*"></div><div class="file-path-wrapper">'+
    '<input name="image-name" class="file-path validate" type="text"></div></div></div><div class="col s12">'+
    '<div class="col s12"><div class="input-field col s12"><label>Правильный ответ:</label>'+
    '<input name="answer1" type="text" /></div><div class="input-field col s12"><label>Ответ:</label>'+
    '<input name="answer2" type="text" /></div><div class="input-field col s12">'+
    '<label>Ответ:</label><input name="answer3" type="text" /></div><div class="input-field col s12">'+
    '<label>Ответ:</label><input name="answer4" type="text" /></div></div></div></div>';

var fourthType = '<div id="fourthType"><div class="col s12"><div class="col s12 file-field input-field">' +
    '<div class="btn"><span>Загрузить картинку</span><input type="file" name="image" accept="image/*">' +
    '</div><div class="file-path-wrapper"><input class="file-path validate" type="text">' +
    '</div></div></div></div>';

function qTypeChanged(v){
    if (v == 1){
       document.getElementById('module').innerHTML = firstType;
    }
    if (v == 2){
       document.getElementById('module').innerHTML = secondType;
    }
    if (v == 3){
        document.getElementById('module').innerHTML = thirdType;
    } else if (v == 4){
        document.getElementById('module').innerHTML = fourthType;
    }
}
$(document).ready(function() {
    $('select').material_select();
});

function setModule(id) {
    console.log(id);
    $('#moduleInput').attr('value', id);
}

$('#butt').click(function() {
    $.ajax({
        type: "GET",
        cache: false,
        url: "/admin/getQuestionsListForModule?module=" + $('#moduleInput').val(),
        data: "",
        success: function(response){
            $('#containerForModules').html(response);
        }
    });
});


function openModal() {
    $('#breakModel').modal();
}

var minutes = $('#minutes').val();
var seconds = $('#seconds').val();
var runTumer = true;

$('#testPage').ready(function () {
    setInterval(function () {
        $('#timer').html('Минут: ' + minutes + '    секунд: ' + seconds);
        if (runTumer == true) {
            --seconds;
            if (seconds == 0){
                --minutes;
                if (minutes < 0){
                    minutes = 0;
                    runTumer = false;
                    $('#timeIsOverModal').modal({
                        dismissible: false
                    });
                    $('#timeIsOverModal').modal('open');
                } else {
                    seconds = 59;
                }
            }
        }
    }, 1000);
});

function submitForm(id) {
    $('#userAnswer').attr('value', id);
}

function setActionToPrevQ() {
    document.getElementById('answerForm').setAttribute('action', '/testing/getPrevQuestion');
}

function setActionToNextQ() {
    $('#minutes').attr('value', minutes);
    $('#seconds').attr('value', seconds);
    document.getElementById('answerForm').setAttribute('action', '/testing/getNextQuestion');
}

function historyAction() {
    if ($('#historyButton').html() == 'История прохождения') {
        $('#history').show();
        $('#historyButton').html('Скрыть историю');
    } else {
        $('#history').hide();
        $('#historyButton').html('История прохождения');
    }
}

var activeType;

var firstType =
    '<div id="firstType">' +
        '<div class="col s12">' +
            '<div class="input-field col s12">' +
                '<label>Правильный ответ:</label>' +
                '<input name="answer1" type="text" />'+
            '</div>' +
            '<div class="input-field col s12">'+
                    '<label>Ответ:</label>' +
                    '<input name="answer2" type="text" />' +
            '</div>'+
            '<div class="input-field col s12">' +
                '<label>Ответ:</label>'+
                '<input name="answer3" type="text" />' +
            '</div>' +
            '<div class="input-field col s12">' +
                '<label>Ответ:</label>' +
                '<input name="answer4" type="text" />' +
            '</div>' +
        '</div>' +
    '</div>';

var secondType =
    '<div id="secondType">' +
        '<div class="col s12">' +
            '<div class="input-field col s12">'  +
                '<label>Правильный ответ:</label>' +
                '<input name="answer1" type="text" />' +
            '</div>' +
            '<div class="input-field col s12">' +
                '<label>Ответ:</label>' +
                '<input name="answer2" type="text" />' +
            '</div>' +
        '</div>' +
    '</div>';

var thirdType =
    '<div id="thirdType">' +
        '<div class="col s12">'+
            '<div class="col s12 file-field input-field">' +
                '<div class="btn"><span>Загрузить картинку</span>'+
                    '<input id="imgFile" type="file" name="image" onchange="readURL(this)" accept="image/*">' +
                '</div>' +
                '<div class="file-path-wrapper">'+
                    '<input name="image-name" class="file-path validate" type="text">' +
                '</div>' +
            '</div>' +
            '<div class="col s12 center-align" id="imgPlaceholder" hidden>' +
                '<img id="imgPic" class="responsive-img" src="#" style="border: 1px solid black;" />' +
            '</div>' +
        '</div>' +

        '<div class="col s12">'+
            '<div class="input-field col s12">' +
                '<label>Правильный ответ:</label>'+
                '<input name="answer1" type="text" />' +
            '</div>' +
            '<div class="input-field col s12">' +
                '<label>Ответ:</label>'+
                '<input name="answer2" type="text" />' +
            '</div>' +
            '<div class="input-field col s12">'+
                '<label>Ответ:</label>' +
                '<input name="answer3" type="text" />' +
            '</div>' +
            '<div class="input-field col s12">'+
                '<label>Ответ:</label>' +
                '<input name="answer4" type="text" />' +
            '</div>' +
        '</div>' +
    '</div>';

var fourthType =
    '<div id="fourthType">' +
        '<div class="col s12">' +
            '<div class="col s12 file-field input-field">' +
                '<div class="btn"><span>Загрузить картинку</span>' +
                    '<input type="file" name="image" accept="image/*">' +
                '</div>' +
                '<div class="file-path-wrapper">' +
                    '<input class="file-path validate" type="text">' +
                '</div>' +
            '</div>' +
        '</div>' +
    '</div>';

function qTypeChanged(v){
    if (v == 1){
        // $('#module').html(firstType);
       document.getElementById('module').innerHTML = firstType;
    }
    if (v == 2){
       document.getElementById('module').innerHTML = secondType;
    }
    if (v == 3 || v == 4){
        document.getElementById('module').innerHTML = thirdType;
    }
    // else if (v == 4){
    //     document.getElementById('module').innerHTML = fourthType;
    // }
}

function readURL(input) {
    if (input.files && input.files[0]) {
        $('#imgPlaceholder').show();
        var reader = new FileReader();
        reader.onload = function (e) {
            $('#imgPic').attr('src', e.target.result);
        }
        reader.readAsDataURL(input.files[0]);
    }
}
/**
 * Created by artem on 24.11.16.
 */

var currency = '';
$(document).ready(function() {
    $('.dropdown-menu-kind li a').click(function(){
        currency = $(this).data('val');
    })
});

function deleteKindOfControl() {
    var disciplineForDelete = $('#disciplineForDelete').val();
    $.ajax({
        type: "GET",
        url: "/discipline/search/deleteByDiscipline?discipline=" + disciplineForDelete.replace("/ /g", "%20"),
        contentType: "application/json",
        dataType: 'json'
    });
}

function addNewDiscipline() {
    var discipline = $('#discipline').val();
    var requestJSONparametr = "{\"discipline\": \"" + discipline + "\"}";
    $.ajax({
        type: "POST",
        url: "/discipline/add",
        contentType: "application/json",
        dataType: 'json',
        data: requestJSONparametr
    });
}


function getChair() {
    var priceRequest = new XMLHttpRequest();
    priceRequest.open("GET", "/discipline/", true);   //Указываем адрес GET-запроса
    priceRequest.onload = function (){             //Функция которая отправляет запрос на сервер для получения всех студентов
        var parsedItem = JSON.parse(this.responseText);
        var itemsTable = document.getElementById('all-clients'); //получаем элемент по Id
        itemsTable.innerHTML = '';      //очищаем таблицу от устаревших данных
        parsedItem._embedded.discipline.forEach(function(item)  {
            var itemNameElement = document.createElement('td'); //создаем элемент ячейку с названием для таблицы
            itemNameElement.innerHTML =  item['discipline'] ;     //внедряем название предмета, полученное с сервера
            var elementRow = document.createElement('tr'); /// /создаем строку таблицы
            elementRow.appendChild(itemNameElement);      //помещаем обе ячейки в строку
            itemsTable.appendChild(elementRow);           //помещаем строку в таблицу
        });
    };
    priceRequest.send(null);
    $("#all-clients").tablesorter();
}

$(document).ready(function() {
    getChair();
});
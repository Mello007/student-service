
var currency = '';
$(document).ready(function() {
    $('.dropdown-menu-kind li a').click(function(){
        currency = $(this).data('val');
    })
});

function deleteSpecialty() {
    var specialtyForDelete = $('#specialtyForDelete').val();
    $.ajax({
        type: "GET",
        url: "/specialty/search/deleteBySpecialty?specialty=" + specialtyForDelete.replace("/ /g", "%20"),
        contentType: "application/json",
        dataType: 'json'
    });
}

function addNewSpecialty() {
    var specialty = $('#specialty').val();
    var faculty = $('#faculty').val();
    var requestJSONparametr = "{\"specialty\": \"" + specialty + "\", \"faculty\": \"" + faculty + "\"}";
    $.ajax({
        type: "POST",
        url: "/specialty/add",
        contentType: "application/json",
        dataType: 'json',
        data: requestJSONparametr
    });
}


function getSpecialtyes() {
    var priceRequest = new XMLHttpRequest();
    priceRequest.open("GET", "/specialty/", true);   //Указываем адрес GET-запроса
    priceRequest.onload = function (){             //Функция которая отправляет запрос на сервер для получения всех студентов
        var parsedItem = JSON.parse(this.responseText);
        var itemsTable = document.getElementById('all-employees'); //получаем элемент по Id
        itemsTable.innerHTML = '';      //очищаем таблицу от устаревших данных
        parsedItem._embedded.specialty.forEach(function(item)  {
            var itemNameElement = document.createElement('td'); //создаем элемент ячейку с названием для таблицы
            itemNameElement.innerHTML =  item['specialty'] ;     //внедряем название предмета, полученное с сервера
            var itemPriceElement = document.createElement('td');
            itemPriceElement.innerHTML = item['faculty'];
            var elementRow = document.createElement('tr'); /// /создаем строку таблицы
            elementRow.appendChild(itemNameElement);      //помещаем обе ячейки в строку
            elementRow.appendChild(itemPriceElement);
            itemsTable.appendChild(elementRow);           //помещаем строку в таблицу
        });
    };
    priceRequest.send(null);
    $("#all-clients").tablesorter();
}

$(document).ready(function() {
    getSpecialtyes();
});
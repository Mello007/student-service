
var currency = '';
$(document).ready(function() {
    $('.dropdown-menu-kind li a').click(function(){
        currency = $(this).data('val');
    })
});

function deleteGroupList() {
    var numberOfGroupForDelete = $('#numberOfGroupForDelete').val();
    $.ajax({
        type: "GET",
        url: "/groupList/search/deleteByNumberOfGroup?numberOfGroup=" + numberOfGroupForDelete.replace("/ /g", "%20"),
        contentType: "application/json",
        dataType: 'json'
    });
}

function addNewGroupList() {
    var year = $('#year').val();
    var semester = $('#semester').val();
    var numberOfGroup = $('#numberOfGroup').val();

    var requestJSONparametr = "{\"year\": \"" + year + "\", \"semester\": \"" + semester + "\", \"numberOfGroup\": \"" + numberOfGroup + "\"}";
    $.ajax({
        type: "POST",
        url: "/groupList/add",
        contentType: "application/json",
        dataType: 'json',
        data: requestJSONparametr
    });
}


function getSchedule() {
    var priceRequest = new XMLHttpRequest();
    priceRequest.open("GET", "/groupList/", true);   //Указываем адрес GET-запроса
    priceRequest.onload = function (){             //Функция которая отправляет запрос на сервер для получения всех студентов
        var parsedItem = JSON.parse(this.responseText);
        var itemsTable = document.getElementById('all-tests'); //получаем элемент по Id
        itemsTable.innerHTML = '';      //очищаем таблицу от устаревших данных
        parsedItem._embedded.groupList.forEach(function(item)  {
            var itemNameElement = document.createElement('td'); //создаем элемент ячейку с названием для таблицы
            itemNameElement.innerHTML =  item['year'] ;     //внедряем название предмета, полученное с сервера
            var itemPriceElement = document.createElement('td');
            itemPriceElement.innerHTML = item['semester'];
            var date = document.createElement('td');
            date.innerHTML = item['numberOfGroup'];
            var elementRow = document.createElement('tr'); /// /создаем строку таблицы

            elementRow.appendChild(itemNameElement);      //помещаем обе ячейки в строку
            elementRow.appendChild(itemPriceElement);
            elementRow.appendChild(date);
            itemsTable.appendChild(elementRow);           //помещаем строку в таблицу
        });
    };
    priceRequest.send(null);
    $("#all-tests").tablesorter();

}




$(document).ready(function() {
    getSchedule();
});

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
        url: "/kindOfControl/search/deleteByDiscipline?discipline=" + disciplineForDelete.replace("/ /g", "%20"),
        contentType: "application/json",
        dataType: 'json'
    });
}

function addNewKindOfControl() {
    var specialty = $('#specialty').val();
    var year = $('#year').val();
    var cours = $('#cours').val();
    var discipline = $('#discipline').val();
    var countOfHours = $('#countOfHours').val();
    var kindOfControl = $('#kindOfControl').val();
    var requestJSONparametr = "{\"specialty\": \"" + specialty + "\", \"year\": \"" + year + "\"," +
        " \"cours\": \"" + cours + "\", \"discipline\": \"" + discipline + "\", \"countOfHours\": \"" + countOfHours + "\"" +
        " \"kindOfControl\": \"" + kindOfControl + "\"}";
    $.ajax({
        type: "POST",
        url: "/plan/add",
        contentType: "application/json",
        dataType: 'json',
        data: requestJSONparametr
    });
}


function getKindOfControls() {
    var priceRequest = new XMLHttpRequest();
    priceRequest.open("GET", "/kindOfControl/", true);   //Указываем адрес GET-запроса
    priceRequest.onload = function (){             //Функция которая отправляет запрос на сервер для получения всех студентов
        var parsedItem = JSON.parse(this.responseText);
        var itemsTable = document.getElementById('all-employees'); //получаем элемент по Id
        itemsTable.innerHTML = '';      //очищаем таблицу от устаревших данных
        parsedItem._embedded.plan.forEach(function(item)  {
            var itemNameElement = document.createElement('td'); //создаем элемент ячейку с названием для таблицы
            itemNameElement.innerHTML =  item['specialty'] ;     //внедряем название предмета, полученное с сервера
            var itemPriceElement = document.createElement('td');
            itemPriceElement.innerHTML = item['year'];
            var priceElement = document.createElement('td');
            priceElement.innerHTML = item['cours'];
            var dateOfreception = document.createElement('td');
            dateOfreception.innerHTML = item['discipline'];
            var dateOfPass = document.createElement('td');
            dateOfPass.innerHTML = item['countOfHours'];
            var kindOfControl = document.createElement('td');
            kindOfControl.innerHTML = item['kindOfControl'];
            var elementRow = document.createElement('tr'); /// /создаем строку таблицы


            elementRow.appendChild(itemNameElement);      //помещаем обе ячейки в строку
            elementRow.appendChild(itemPriceElement);
            elementRow.appendChild(priceElement);
            elementRow.appendChild(dateOfreception);
            elementRow.appendChild(dateOfPass);
            elementRow.appendChild(kindOfControl);
            itemsTable.appendChild(elementRow);           //помещаем строку в таблицу
        });
    };
    priceRequest.send(null);
    $("#all-employees").tablesorter();
}

$(document).ready(function() {
    getKindOfControls();
    // setInterval(getCars,5000);
});
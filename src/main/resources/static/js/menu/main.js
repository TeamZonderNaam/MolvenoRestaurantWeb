// The main file is meant to construct the dataTable and provide a global variable for other javascript files to use
var DATA_TABLE;
var BASE_URL = "/api/menuItem/";
var SERVING_URL = "/api/serving/";

var DATA_PAIRS = {
    category: ".category",
    name: ".name",
    price: ".price",
    number: ".number"
};


$(function() {
    DATA_TABLE = $("table").DataTable({
        columns: [
            {data: "id"},
            {data: "category"},
            {data: "name"},
            {data: "price", render: $.fn.dataTable.render.number( ',', '.', 2, '¥ ' ) },
            {data: "number"},
            {
                data: null,
                className: "center",
                defaultContent: "<a href='ingredients'>View ingredients</a>"
            },
            {
                data: null,
                className: "center",
                defaultContent: '<a href="edit"><i class="fas fa-edit"></i></a> / <a href="delete"><i class="far fa-trash-alt"></i></a>'
            }
        ]
    });
});
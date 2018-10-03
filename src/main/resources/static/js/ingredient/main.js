// The main file is meant to construct the dataTable and provide a global variable for other javascript files to use
var DATA_TABLE;
var BASE_URL = "/api/ingredient/";
var UNIT_URL = "/api/unit/";
var DATA_PAIRS = {
    name: ".name",
    pricePerUnit: ".price",
    unit: ".unit"
};

$(function() {
    DATA_TABLE = $("table").DataTable({
        columns: [
            {data: "id"},
            {data: "name"},
            {data: "pricePerUnit", render: $.fn.dataTable.render.number( ',', '.', 2, '¥ ' ) },
            {data: "unit.name"},
            {
                data: null,
                className: "center",
                defaultContent: '<a href="edit"><i class="fas fa-edit"></i></a> / <a href="delete"><i class="far fa-trash-alt"></i></a>'
            }
        ]
    });
});
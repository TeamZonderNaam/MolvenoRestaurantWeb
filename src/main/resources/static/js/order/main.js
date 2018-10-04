// The main file is meant to construct the dataTable and provide a global variable for other javascript files to use
var DATA_TABLE;
var BASE_URL = "/api/order/";
var DATA_PAIRS = {
    status: ".status",
    name: ".name",
    price: ".price",
    number: ".number"
};


$(function() {
    DATA_TABLE = $("table").DataTable({
        columns: [
            {data: "id"},
            {data: "status"},
            {data: "items[0].name"},
            {data: "items[0].price", render: $.fn.dataTable.render.number( ',', '.', 2, '¥ ' ) },
            {data: "table.number"},
            {
                data: null,
                className: "center",
                defaultContent: '<a href="edit"><i class="fas fa-edit"></i></a> / <a href="delete"><i class="far fa-trash-alt"></i></a>'
            }
        ]
    });
});
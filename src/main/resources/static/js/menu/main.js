// The main file is meant to construct the dataTable and provide a global variable for other javascript files to use
var DATA_TABLE;
var BASE_URL = "/api/menuItem/";
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
            {data: "price"},
            {data: "number"},
            {
                data: null,
                className: "center",
                defaultContent: '<a href="edit">Edit</a> / <a href="delete">Delete</a>'
            }
        ]
    });
});
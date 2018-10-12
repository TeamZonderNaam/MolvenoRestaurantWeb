// The main file is meant to construct the dataTable and provide a global variable for other javascript files to use
var DATA_TABLE;
var BASE_URL = "/api/table/";
var DATA_PAIRS = {
    number: ".number",
    numberOfPersons: ".capacity",
    shape: ".shape",
    // status: ".status"
};

$(function() {
    DATA_TABLE = $("table").DataTable({
        columns: [
            {data: "number"},
            {data: "numberOfPersons"},
            {data: "shape", render: function(data) {
                // We can use == here because it needs to be an integer
                // TODO: This is not the nicest way to do this, but works for now (only two table types were defined)
                return (data === 0) ? "Rectangle" : "Round";
            }},
            {
                data: null,
                className: "center",
                defaultContent: '<a href="edit"><i class="fas fa-edit"></i></a> / <a href="delete"><i class="far fa-trash-alt"></i></a>'
            }
        ]
    });
});


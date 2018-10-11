// The main file is meant to construct the dataTable and provide a global variable for other javascript files to use
var DATA_TABLE;
var BASE_URL = "/api/reservation/";

var DATA_PAIRS = {
    customer            : ".customer.name",
    numberOfPersons     : ".amount",
    numberOfChildSeats  : ".childseats",
    time                : "#time",
    parkingSpaceNeeded  : "#parking"
};

$(function() {
    DATA_TABLE = $("table").DataTable({
        columns: [
            {data: "customer.name"},
            {data: "numberOfPersons"},
            {data: "numberOfChildSeats"},
            {data: "time"},
            {data: "parkingSpaceNeeded", render: function(data) {
                return (data == true) ? "Yes" : "No";
                }},
            {
                data: null,
                className: "center",
                defaultContent: '<a href="edit"><i class="fas fa-edit"></i></a> / <a href="delete"><i class="far fa-trash-alt"></i></a>'
            }
        ]
    });
});
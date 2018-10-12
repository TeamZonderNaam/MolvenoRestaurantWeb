// The main file is meant to construct the dataTable and provide a global variable for other javascript files to use
var DATA_TABLE;
var BASE_URL = "/api/reservation/";
var DATA_PAIRS = {
    name                : ".name",
    numberOfPersons     : ".amount",
    numberOfChildSeats  : ".child-seats",
    date                : "#datepicker",
    startTime           : "#time",
    parkingSpaceNeeded  : "#parking"
};

$(function() {
    DATA_TABLE = $("table").DataTable({
        columns: [
            {data: "name"},
            {data: "numberOfPersons"},
            {data: "numberOfChildSeats"},
            {data: "startTime"},
            {data: "endTime"},
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
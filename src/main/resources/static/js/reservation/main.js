// The main file is meant to construct the dataTable and provide a global variable for other javascript files to use
var DATA_TABLE;
var BASE_URL = "/api/reservation/";
var DATA_PAIRS = {
    guest           : ".guest.name",
    numberOfPersons    : ".amount",
    numberOfChildSeats : ".childseats",
    tablenumber        : ".tablenumber",
    reservedtable      : ".reservedtable",
    time               : ".time",
    totalTimeInMinutes : ".timeamount",
    parkingSpaceNeeded : "#parkingspot"
};

$(function() {
    DATA_TABLE = $("table").DataTable({
        columns: [
            {data: "guest.name"},
            {data: "numberOfPersons"},
            {data: "numberOfChildSeats"},
            // {data: "tablenumber"}, //TODO IEK
            // {data: "reservedtable"}, //TODO IEK
            // {data: "time"}, //TODO IEK
            {data: "totalTimeInMinutes"},
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
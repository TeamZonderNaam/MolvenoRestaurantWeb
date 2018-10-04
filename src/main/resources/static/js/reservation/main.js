// The main file is meant to construct the dataTable and provide a global variable for other javascript files to use
var DATA_TABLE;
var BASE_URL = "/api/reservation/";
var DATA_PAIRS = {
    //customer: { name: customerName},
    customer           : ".customer.name",
    numberOfPersons    : ".amount",
    numberOfChildSeats : ".childseats",
    tablenumber        : ".tablenumber",
    reservedtable      : ".reservedtable",
    time               : ".time",
    totalTimeInMinutes : ".timeamount",
    parkingSpaceNeeded : ".parkingspot"
};

$(function() {
    DATA_TABLE = $("table").DataTable({
        columns: [
            {data: "id"},
            {data: "customer.name"},
            {data: "amount"},
            {data: "childseats"},
            {data: "tablenumber"},
            {data: "reservedtable"},
            {data: "time"},
            {data: "timeamount"},
            {data: "parkingspot"},
            {
                data: null,
                className: "center",
                defaultContent: '<a href="edit"><i class="fas fa-edit"></i></a> / <a href="delete"><i class="far fa-trash-alt"></i></a>'
            }
        ]
    });
});
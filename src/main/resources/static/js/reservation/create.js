function postData() {
    console.log("posting a new item...");

    //Get values from html
    var customerName = $("#inputCustomerName").val();
    var parkingSpot = $("#inputParkingSpot").val();
    var childSeats = $("#inputChildSeats").val();
    var numberOfPersons = $("#inputNumberOfCustomers").val();
    var tableNumber = $("#inputTableNumber").val();
    var reservedTable;
    var startReservation;
    var totalTimeInMinutes;

    // Create JS object with data.
    var reservation = {
        customer : { name: customerName},
        parkingSpaceNeeded : parkingSpot,
        numberOfChildSeats : childSeats,
        numberOfPersons : numberOfPersons,
        tableNumber: tableNumber,
        reservedTable : reservedTable,
        startReservation : startReservation,
        totalTimeInMinutes : totalTimeInMinutes
    };
    console.log(reservation);

    // Convert JS object to JSON.
    var validJsonItem = JSON.stringify(reservation);
    console.log(validJsonItem);

    // Post JSON to endpoint.
    $.ajax({
        url:"api/reservation/",
        type:"post",
        data: validJsonItem,
        contentType: "application/json",
        success: function(result) {
            // On successful post, reload data to get the added one as well.
            console.log("success post data!");
            getData();
        }
    });
}

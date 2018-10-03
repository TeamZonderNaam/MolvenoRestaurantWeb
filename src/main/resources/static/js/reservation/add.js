function postData() {
    console.log("posting a new item...");

    //Get values from html
    var customerName = $("#inputCustomerName").val();
    var numberOfCustomers = $("#inputNumberOfCustomers").val();
    var childSeats = $("#inputChildSeats").val();
    var tableNumber = $("#inputTableNumber").val();

    // Create JS object with data.
    var reservation = {
        customerName : customerName,
        numberOfCustomers : numberOfCustomers,
        childSeats : childSeats,
        tableNumber: tableNumber
    };
    console.log(newItem);

    // Convert JS object to JSON.
    var validJsonItem = JSON.stringify(newItem);
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

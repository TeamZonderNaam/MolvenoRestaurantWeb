function putData() {
    console.log("changing item...");

    //Get values from html
    var customerName = $("#inputCustomerName").val();
    var numberOfCustomers = $("#inputNumberOfCustomers").val();
    var numberOfChildSeats = $("#inputNumberOfChildSeats").val();
    var id = $("#inputChangeId").val();
    var tableNumber = $("#inputTableNumber").val();

    // Create JS object with data.
    var changeItem = {
        customerName : customerName,
        numberOfCustomers : numberOfCustomers,
        numberOfChildSeats : numberOfChildSeats,
        tableNumber : tableNumber
    };
    console.log(changeItem);

    // Convert JS object to JSON.
    var validJsonItem = JSON.stringify(changeItem);
    console.log(validJsonItem);

    var src = "api/reservation/" + id;

    // Post JSON to endpoint.
    $.ajax({
        url: src,
        type:"put",
        data: validJsonItem,
        contentType: "application/json",
        success: function(result) {
            // On successful post, reload data to get the added one as well.
            console.log("success put data!");
            getData();
        }
    });
}
function getData() {
    console.log("getting reservation data...");

    // Get the data from endpoint.
    $.ajax({
        url:"/api/reservation/",
        type:"get",
        success: function(reservations) {
            // On successful get, reload the datatable with new data.
            console.log("This is the data: " + reservations);
            $('#reservationTable').DataTable().clear();
            $('#reservationTable').DataTable().rows.add(reservations);
            $('#reservationTable').DataTable().columns.adjust().draw();
        }
    });
}
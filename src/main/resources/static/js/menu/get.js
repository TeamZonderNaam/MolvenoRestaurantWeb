$(function() {
   URLUtil.get(BASE_URL).then(function(arr) {
       console.log(arr);
       DATA_TABLE.rows.add(arr).draw(false);
   });

    // We can't use the default click function, because the data is loaded in dynamically.
    // The following line lets jQuery listen on all clicks on the body and only filter out those whose
    // selector matches the one that was clicked on. This allows us to get click events on dynamic content.
    $("body").on("click", "a[href*='ingredients']", function(e) {
        // Call parent() two times to get the original table row and get the data via DataTable.
        var tr = $(this).parent().parent();
        var data = DATA_TABLE.row(tr).data();

        console.log("ID:", data.id);

        e.preventDefault();
    });

});
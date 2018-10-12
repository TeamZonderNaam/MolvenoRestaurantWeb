$(function() {
    var modal = $("#delete-modal");

    // We can't use the default click function, because the data is loaded in dynamically.
    // The following line lets jQuery listen on all clicks on the body and only filter out those whose
    // selector matches the one that was clicked on. This allows us to get click events on dynamic content.
    $("body").on("click", "a[href*='delete']", function(e) {
        // Call parent() two times to get the original table row and get the data via DataTable.
        var tr = $(this).parent().parent();
        var data = DATA_TABLE.row(tr).data();
        modal.find("#name").html(data.name);
        modal.modal("toggle");

        modal.find(".delete").click(function() {

            URLUtil.delete(BASE_URL+data.id).then(function() {
                DATA_TABLE.row(tr).remove().draw();
                modal.modal("toggle");
            });

            // Remove the listener, otherwise we get 5 click listeners when clicking delete on an item after having
            // deleted 4 items before.
            $(this).off("click");
        });

        e.preventDefault();
    });
});

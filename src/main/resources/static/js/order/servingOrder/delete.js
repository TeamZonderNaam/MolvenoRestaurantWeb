$(function() {
    var modal = $("#delete-servingOrder-modal");

    // We can't use the default click function, because the data is loaded in dynamically.
    // The following line lets jQuery listen on all clicks on the body and only filter out those whose
    // selector matches the one that was clicked on. This allows us to get click events on dynamic content.
    $("#menuItems-modal").on("click", "a[href*='delete']", function(e) {
        // Call parent() two times to get the original table row and get the data via DataTable.
        var tr = $(this).parent().parent();
        var id = tr.find(".id").val();
        modal.find(".name").html(tr.find(".name").html());
        modal.modal("toggle");


        modal.find(".delete").click(function() {
            URLUtil.delete(SERVING_URL+id).then(function() {
                tr.remove();
                modal.modal("toggle");
            });

            // Remove the listener, otherwise we get 5 click listeners when clicking delete on an item after having
            // deleted 4 items before.
            $(this).off("click");
        });

        e.preventDefault();
    });
});

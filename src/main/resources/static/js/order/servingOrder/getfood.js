$(function() {
    // We can't use the default click function, because the data is loaded in dynamically.
    // The following line lets jQuery listen on all clicks on the body and only filter out those whose
    // selector matches the one that was clicked on. This allows us to get click events on dynamic content.
    $("body").on("click", "a[href*='foodItems']", function(e) {
    e.preventDefault();
        URLUtil.get(MENUITEM_URL).then(function(arr) {
            $.each(arr, function(i, obj) {
//              var unit = obj.unit.name;
                var name = obj.name /*+ " ("+unit+")"*/;

                $("#servingOrder-modal select.menuItem").append('<option value='+obj.id+'>' + obj.name  + '</option');
            });
        });

        // Call parent() two times to get the original table row and get the data via DataTable.
        var tr = $(this).parent().parent();
        var data = DATA_TABLE.row(tr).data();
        $("#menuItems-modal").modal("toggle");
        $("#add-servingOrder .orderId").val(data.id);

        // Set the MenuItem id for the serving at this stage, because you can only reach this modal
        // when you press the "View ingredients" link.

        URLUtil.get(FOOD_URL+"for/"+data.id).then(function(arr) {
            emptyMenuItemList();
            $.each(arr, function(i, obj) {
                addMenuItemToList(obj);
            });
        });
        e.preventDefault();
    });
});
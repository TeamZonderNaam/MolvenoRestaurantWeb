$(function() {
    var modal = $("#servingOrder-modal");
    var form = modal.find("form");

    // We can't use the default click function, because the data is loaded in dynamically.
    // The following line lets jQuery listen on all clicks on the body and only filter out those whose
    // selector matches the one that was clicked on. This allows us to get click events on dynamic content.
    $("#menuItems-modal").on("click", "a[href*='edit']", function(e) {
        // Call parent() two times to get the original table row and get the data via DataTable.
        var tr = $(this).parent().parent();
        var data = {id: tr.find(".id").val(), amount: tr.find(".amount").html(), name: tr.find(".name").html()};
        modal.find(".amount").val(data.amount);
        modal.find(".id").val(data.id);


        modal.find(".menuItem option").filter(function() {
            return $(this).text() === data.name;
        }).prop('selected', true);


        modal.modal("toggle");

        // Set the form into a editable state, this allows us to wait for a click on button.edit.
        FormUtil.makeFormEdit(form);

        form.find("button.edit").click(function() {
            var model = FormUtil.formToValues(SERVING_DATA_PAIRS, form);
            // The model now has a unit value set to an id. We want this to be it's own object
            // and than set the id of that object.
            model.menuItem = {id: model.menuItem};
            var id = model.id;
            delete model.item;
            delete model.id;

            URLUtil.put(SERVING_URL+id, model).then(function(obj) {
                tr.find(".amount").html(obj.numberOfMenuItems);
                tr.find(".name").html(obj.menuItem.name);

                form.find(".amount").val("");
                form.find(".menuItem").val("1");

                modal.modal("toggle");
            });

            // Remove the listener, otherwise we get 5 click listeners when clicking edit on an item after having
            // edited 4 items before.
            $(this).off("click");
        });


        e.preventDefault();
    });
});
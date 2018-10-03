$(function() {
    var modal = $("#item-modal");
    var form = modal.find("form");

    // We can't use the default click function, because the data is loaded in dynamically.
    // The following line lets jQuery listen on all clicks on the body and only filter out those whose
    // selector matches the one that was clicked on. This allows us to get click events on dynamic content.
    $("body").on("click", "a[href*='edit']", function(e) {
        // Call parent() two times to get the original table row and get the data via DataTable.
        var tr = $(this).parent().parent();
        var data = DATA_TABLE.row(tr).data();

        modal.modal("toggle");

        // Set the form into a editable state, this allows us to wait for a click on button.edit.
        FormUtil.makeFormEdit(form);
        FormUtil.fillForm(DATA_PAIRS, data, form);


        form.find("button.edit").click(function() {
            var model = FormUtil.formToValues(DATA_PAIRS, form);
            // We don't keep a reference of the id on the form, so use the original data to set the correct id.
            model.id = data.id;

            URLUtil.put(BASE_URL+model.id, model).then(function(obj) {
                DATA_TABLE.row(tr).data(obj).invalidate();
                modal.modal("toggle");
            });

            FormUtil.emptyForm(form);

            // Remove the listener, otherwise we get 5 click listeners when clicking edit on an item after having
            // edited 4 items before.
            $(this).off("click");
        });


        e.preventDefault();
    });
});
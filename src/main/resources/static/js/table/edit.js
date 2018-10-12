$(function() {
    var modal = $("#item-modal");
    var form = modal.find("form");

    // We can't use the default click function, because the data is loaded in dynamically.
    // The following line lets jQuery listen on all clicks on the body and only filter out those whose
    // selector matches the one that was clicked on. This allows us to get click events on dynamic content.

    $("body").on("click", "a[href*='edit']", function(e) {
        clearErrors();

        // Call parent() two times to get the original table row and get the data via DataTable.
        var tr = $(this).parent().parent();
        var data = DATA_TABLE.row(tr).data();

        modal.modal("toggle");

        // Set the form into a editable state, this allows us to wait for a click on button.edit.
        FormUtil.makeFormEdit(form);
        FormUtil.fillForm(DATA_PAIRS, data, form);
        form.find("select.shape").val(data.shape);


        form.find("button.edit").click(function() {
            clearErrors();

            var model = FormUtil.formToValues(DATA_PAIRS, form);

            // Check the user input
            var error = false;
            if (model.number < 0 || model.number == "" || !((model.number-Math.floor(model.number))==0)) {
                $('#errorNumber').empty().append("Invalid table number");
                error = true;
            }
            if (model.numberOfPersons <= 0 || !((model.numberOfPersons-Math.floor(model.numberOfPersons))==0)) {
                $('#errorCapacity').empty().append("Invalid capacity");
                error = true;
            }
            if (error == true) {
                throw "InvalidInput";
            }

            // We don't keep a reference of the id on the form, so use the original data to set the correct id.
            model.id = data.id;

            URLUtil.put(BASE_URL+model.id, model).then(function(obj) {
                DATA_TABLE.row(tr).data(obj).invalidate();
                FormUtil.emptyForm(form);
                // Remove the listener, otherwise we get 5 click listeners when clicking edit on an item after having
                // edited 4 items before.
                $(this).off("click");
                modal.modal("toggle");
            }, function(XMLHttpRequest, textStatus, errorThrown) {
                         var error = JSON.parse(XMLHttpRequest.responseText); //if this is JSON otherwise just alerting XMLHttpRequest.responseText will do
                         console.log(error.message);
                         $('#errorNumber').empty().append(error.message);
            });
        });
        e.preventDefault();
    });
});
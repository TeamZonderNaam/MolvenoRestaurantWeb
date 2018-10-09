$(function() {
    var modal = $("#item-modal");
    var form = modal.find("form");

    // We can't use the default click function, because the data is loaded in dynamically.
    // The following line lets jQuery listen on all clicks on the body and only filter out those whose
    // selector matches the one that was clicked on. This allows us to get click events on dynamic content.
    $("body").on("click", ".save", function() {
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
        URLUtil.post(BASE_URL, model).then(function(obj) {
            DATA_TABLE.row.add(obj).draw(false);
            modal.modal('toggle');
            FormUtil.emptyForm(form);
        }, function(XMLHttpRequest, textStatus, errorThrown) {
            var error = JSON.parse(XMLHttpRequest.responseText); //if this is JSON otherwise just alerting XMLHttpRequest.responseText will do
            $('#errorNumber').empty().append(error.message);
        });
    }).on("click", ".add-item", function() {
        clearErrors();
        // It's possible that a new value will be added after editing.
        // Editing an item sets the edit state, so we need to revert it back if that's the case
        FormUtil.makeFormSave(form);
    });
});

function clearErrors() {
    $('#errorNumber').empty();
    $('#errorCapacity').empty();
}
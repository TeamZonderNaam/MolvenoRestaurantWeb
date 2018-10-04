$(function() {
    var modal = $("#item-modal");
    var form = modal.find("form");
    var body = $("body");

    // We can't use the default click function, because the data is loaded in dynamically.
    // The following line lets jQuery listen on all clicks on the body and only filter out those whose
    // selector matches the one that was clicked on. This allows us to get click events on dynamic content.
    body.on("click", ".save", function() {
        var model = FormUtil.formToValues(DATA_PAIRS, form);
        // The model now has a unit value set to an id. We want this to be it's own object
        // and than set the id of that object.
        model.unit = {id: model.unit};

        URLUtil.post(BASE_URL, model).then(function(obj) {
            DATA_TABLE.row.add(obj).draw(false);
            modal.modal('toggle');
            FormUtil.emptyForm(form);
        });
    });

    body.on("click", ".add-item", function() {
        // It's possible that a new value will be added after editing.
        // Editing an item sets the edit state, so we need to revert it back if that's the case
        FormUtil.makeFormSave(form);

        fillFormWithUnits(form);
    });
});
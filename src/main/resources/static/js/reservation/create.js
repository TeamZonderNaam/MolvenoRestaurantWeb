$(function() {
    var modal = $("#item-modal");
    var form = modal.find("form");

    // We can't use the default click function, because the data is loaded in dynamically.
    // The following line lets jQuery listen on all cli  cks on the body and only filter out those whose
    // selector matches the one that was clicked on. This allows us to get click events on dynamic content.
    $("body").on("click", ".save", function() {
        var model = FormUtil.formToValues(DATA_PAIRS, form);
        //model.guest = {name: model.guest};

        URLUtil.post(BASE_URL, model).then(function(obj) {
            //model.time = {table: model.time}
            DATA_TABLE.row.add(obj).draw(false);
            modal.modal('toggle');
            FormUtil.emptyForm(form);

            $("#status").html("Thank you for your reservation.");
        });
    }).on("click", ".add-item", function() {
        // It's possible that a new value will be added after editing.
        // Editing an item sets the edit state, so we need to revert it back if that's the case
        FormUtil.makeFormSave(form);
        $("#choosetimeframelabel").css("display", "none");
        $("#parkingDiv").css("display", "none");
        $("#timeDiv").css("display", "none");
        $("#save").css("display", "none");
        $("#choosetimelabel").css("display", "block");
    });
});
$(function() {
    var modal = $("#serving-modal");
    var form = modal.find("#add-serving");

    $("#add-ingredient").on("click", ".add", function() {
        // It's possible that a new value will be added after editing.
        // Editing an item sets the edit state, so we need to revert it back if that's the case
        FormUtil.makeFormSave(form);

        form.find(".save").click(function() {
            var model = FormUtil.formToValues(SERVING_DATA_PAIRS, form);
            // The model now has a unit value set to an id. We want this to be it's own object
            // and than set the id of that object.
            model.ingredient = {id: model.ingredient};

            var itemId = model.item;
            delete model.item;
            delete model.id;

            $("#add-ingredient select.ingredient").empty();
            URLUtil.post(SERVING_URL+"for/"+itemId, model).then(function(obj) {
                addIngredientToList(obj);
                modal.modal("toggle");
            });
            $(this).off("click");
        });
    });
});
$(function() {
    var form = $("#add-serving");
    form.find(".save").click(function() {
        var model = FormUtil.formToValues(SERVING_DATA_PAIRS, form);
        // The model now has a unit value set to an id. We want this to be it's own object
        // and than set the id of that object.
        model.ingredient = {id: model.ingredient};

        var itemId = model.item;
        delete model.item;
        console.log("ItemID:", itemId);

        URLUtil.post(SERVING_URL+"for/"+itemId, model).then(function() {
            console.log("Hello World!?");
        });
    });
});
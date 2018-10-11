$(function() {
    var modal = $("#servingOrder-modal");
    var form = modal.find("#add-servingOrder");

    $("#add-menuItem").on("click", ".add", function() {
        // It's possible that a new value will be added after editing.
        // Editing an item sets the edit state, so we need to revert it back if that's the case
        FormUtil.makeFormSave(form);

        form.find(".save").click(function() {
            var model = FormUtil.formToValues(SERVING_DATA_PAIRS, form);
            // The model now has a unit value set to an id. We want this to be it's own object
            // and than set the id of that object.
            console.log("model is: ", model);
            model.menuItem = {id: model.menuItem};
            //model.menuItem = {name: model.menuItem};

            var orderId = model.order;
            delete model.order;
            delete model.id;
            console.log("dit is orderid: ", orderId);
            console.log(1111);

            emptyMenuItemList();
             URLUtil.post(SERVING_URL+"for/"+orderId, model).then(function(obj){
            console.log(2222222222);
            console.log("this is obj: ",obj);
                addMenuItemToList(obj);
                modal.modal("toggle");
            });
            $(this).off("click");
        });
    });
});
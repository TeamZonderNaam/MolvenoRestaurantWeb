$(function() {
    // We can't use the default click function, because the data is loaded in dynamically.
    // The following line lets jQuery listen on all clicks on the body and only filter out those whose
    // selector matches the one that was clicked on. This allows us to get click events on dynamic content.
    $("body").on("click", "a[href*='ingredients']", function(e) {
        URLUtil.get(INGREDIENT_URL).then(function(arr) {
            console.log(arr);
            $.each(arr, function(i, obj) {
                var unit = obj.unit.name;
                var name = obj.name + " ("+unit+")";

                $("#serving-modal select.ingredient").append("<option value='"+obj.id+"'>"+name+"</option>");
            });
        });

        // Call parent() two times to get the original table row and get the data via DataTable.
        var tr = $(this).parent().parent();
        var data = DATA_TABLE.row(tr).data();

        $("#ingredient-modal").modal("toggle");
        $("#add-serving .itemId").val(data.id);

        // Set the MenuItem id for the serving at this stage, because you can only reach this modal
        // when you press the "View ingredients" link.
        URLUtil.get(SERVING_URL+"for/"+data.id).then(function(arr) {
            emptyIngredientList();
            $.each(arr, function(i, obj) {
                addIngredientToList(obj);
            });
        });

        e.preventDefault();
    });
});
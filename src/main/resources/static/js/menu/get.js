$(function() {
    var template = '<li class="list-group-item ingredient"><span class="amount"></span> <span class="name"></span> <span class="tool"><a href="edit"><i class="fas fa-edit"></i></a> / <a href="delete"><i class="far fa-trash-alt"></i></a></span></li>';
    URLUtil.get(BASE_URL).then(function(arr) {
        DATA_TABLE.rows.add(arr).draw(false);
    });

    // We can't use the default click function, because the data is loaded in dynamically.
    // The following line lets jQuery listen on all clicks on the body and only filter out those whose
    // selector matches the one that was clicked on. This allows us to get click events on dynamic content.
    $("body").on("click", "a[href*='ingredients']", function(e) {
        // Call parent() two times to get the original table row and get the data via DataTable.
        var tr = $(this).parent().parent();
        var data = DATA_TABLE.row(tr).data();

        $("#ingredient-modal").modal("toggle");

        URLUtil.get(SERVING_URL+"for/"+data.id).then(function(arr) {
            $.each(arr, function(i, obj) {

                var ingredient = $(template);
                $("#add-ingredient .list-group").append(ingredient)
                ingredient.find(".amount").html(obj.numberOfUnits);
                ingredient.find(".name").html(obj.ingredient.name);
            });
        });

        e.preventDefault();
    });

});
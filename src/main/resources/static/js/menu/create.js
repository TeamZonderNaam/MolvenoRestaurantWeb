$(function() {
    var pairs = {
        category: ".category",
        name: ".name",
        price: ".price",
        number: ".number"
    };

    var modal = $("#item-modal");
    // We can't use the default click function, because the data is loaded in dynamically.
    // The following line lets jQuery listen on all clicks on the body and only filter out those whose
    // selector matches the one that was clicked on. This allows us to get click events on dynamic content.
    $("body").on("click", ".save", function() {
        var form = modal.find("form");
        var model = FormUtil.formToValues(pairs, form);

        URLUtil.post(BASE_URL, model).then(function(obj) {
            DATA_TABLE.row.add(obj).draw(false);
            modal.modal('toggle');
        });
    });
});
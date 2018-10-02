$(function() {
    var pairs = {
        category: ".category",
        name: ".name",
        price: ".price",
        number: ".number"
    };

    var modal = $("#item-modal");
    $("body").on("click", ".save", function() {
        var form = modal.find("form");
        var model = FormUtil.formToValues(pairs, form);

        URLUtil.post(BASE_URL, model).then(function(obj) {
            DATA_TABLE.row.add(obj).draw(false);
            modal.modal('toggle');
        });
    });
});
$(function() {
    function convert(arr) {
        var data = {};
        $.each(arr, function(i, obj) {
            data[obj.name] = obj.value;
        });
        return data;
    }

    $("form#ingredient").submit(function(e) {
        var arr = $(this).serializeArray();
        var data = convert(arr);
        console.log("Editing data:", data);

        // TODO: Add $.put
        e.preventDefault();
    });
});
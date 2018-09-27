$(function() {
    // Can't use $("a[href*='delete']"), because it's dynamicly added (after this function gets called).
    // On allows us to check the body for links to be added to the body
    $("body").on("click", "a[href*='delete']", function(e) {
        // .parent() returns td, parent on that should return the tr
        var tr = $(this).parent().parent();
        var id = tr.find(".id").html();
        var name = tr.find(".name").html();
        var ok = confirm("Are you sure you want to delete "+name+"?");
        if (ok) {
            var url = "/api/ingredient/"+id;
            $.ajax({method:"DELETE", url: url, contentType:"application/json; charset=utf-8", dataType:"json"}).done(function(data) {
                tr.remove();
            }).fail(function(a, b, c) {
                window.alert("There was an error deleting the ingredient.");
                console.log("Error saving ingredient:", a, b, c);
            });
        }
        e.preventDefault();
    });
});
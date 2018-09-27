$(function() {
    var ingredients = $(".ingredients");
    var ingredientTemplate = $("#ingredient-template");


    $.get("/api/ingredient/").done(function(data) {
        $.each(data, function(index, obj) {
            console.log(obj);
            var id = obj.id;
            var template = $(ingredientTemplate.html());
            template.find(".id").html(id);
            template.find(".name").html(obj.name);
            template.find(".price").html("¥"+obj.pricePerUnit);
            // template.find(".unit").html(obj.unit.name);


            setCorrectIdInHref(template.find("a[href*='edit']"), id);
            setCorrectIdInHref(template.find("a[href*='delete']"), id);

            ingredients.append(template);
        });
    }).fail(function (a, b, c) {
        console.log(a, b, c);
    });

    function setCorrectIdInHref(a, id) {
        var href = a.attr("href");
        href = href.replace("{id}", id);
        a.attr("href", href);
    }
});
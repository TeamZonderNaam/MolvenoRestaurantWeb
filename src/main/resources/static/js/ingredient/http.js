$(function() {
    var ingredients = $(".ingredients");
    var ingredientTemplate = $("#ingredient-template");


    $.get("/api/ingredient/").done(function(data) {
        $.each(data, function(index, obj) {
            var template = $(ingredientTemplate.html());
            template.find(".id").html(obj.id);
            template.find(".name").html(obj.name);
            template.find(".price").html("¥"+obj.pricePerUnit);
            template.find(".unit").html(obj.unit.name);

            ingredients.append(template);
        });
    }).fail(function (a, b, c) {
        console.log(a, b, c);
    });
});
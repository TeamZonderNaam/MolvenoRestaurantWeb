// The main file is meant to construct the dataTable and provide a global variable for other javascript files to use
var DATA_TABLE;
var BASE_URL = "/api/menuItem/";
var SERVING_URL = "/api/serving/";
var INGREDIENT_URL = "/api/ingredient/";
var CATEGORY_URL = "/api/category/";

var DATA_PAIRS = {
    category: ".category",
    name: ".name",
    price: ".price",
    number: ".number",
    menuItemMargin: ".menuItemMargin"
};

var SERVING_DATA_PAIRS = {
    item: ".itemId",
    id: ".id",
    numberOfUnits: ".amount",
    ingredient: ".ingredient"
};

var INGREDIENT_TEMPLATE = '<li class="list-group-item ingredient"><input type="hidden" class="id"><span class="amount"></span> <span class="unit"></span> <span class="name"></span>    ¥ <span class="price"></span> <span class="tool"><a href="edit"><i class="fas fa-edit"></i></a> / <a href="delete"><i class="far fa-trash-alt"></i></a></span></li>';

$(function() {
    DATA_TABLE = $("table").DataTable({
        columns: [
            {data: "number"},
            {data: "category.name"},
            {data: "name"},
            {data: "price", render: $.fn.dataTable.render.number( ',', '.', 2, '¥ ' ) },
            {data: "costPrice", render: $.fn.dataTable.render.number( ',', '.', 2, '¥ ' ) },
            {data: "menuItemMargin"},
            {data: "sellingPrice", render: $.fn.dataTable.render.number( ',', '.', 2, '¥ ' ) },
            {
                data: null,
                className: "center",
                defaultContent: "<a href='ingredients'>View ingredients</a>"
            },
            {
                data: null,
                className: "center",
                defaultContent: '<a href="edit"><i class="fas fa-edit"></i></a> / <a href="delete"><i class="far fa-trash-alt"></i></a>'
            }
        ]
    });
});


function fillFormWithCategories(form) {
    return new Promise(function(resolve) {
        // Get all the units from the database and fill the form with it
        getCategories().then(function(arr) {
            var out = "";
            $.each(arr, function(i, item) {
                out += "<option value='"+item.id+"'>"+item.name+"</option>";
            });
            form.find("select.category").html(out);
            resolve();
        });
    });
}

function getCategories() {
    return new Promise(function(resolve, reject) {
        URLUtil.get(CATEGORY_URL).then(resolve, reject);
    });
}

function emptyIngredientList() {
    $("#add-ingredient .list-group").empty();
}

// Over here because this function should be available to serving/add.js and serving/get.js
function addIngredientToList(ingredient) {
    console.log(ingredient);
    var ele = $(INGREDIENT_TEMPLATE);
    $("#add-ingredient .list-group").append(ele);
    ele.find(".amount").html(ingredient.numberOfUnits);
    ele.find(".unit").html(ingredient.ingredient.unit.name);
    ele.find(".name").html(ingredient.ingredient.name);
    ele.find(".price").html(ingredient.servingPrice.toFixed(2));
    ele.find(".id").val(ingredient.id);

}
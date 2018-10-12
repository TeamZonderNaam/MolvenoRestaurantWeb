// The main file is meant to construct the dataTable and provide a global variable for other javascript files to use
var DATA_TABLE;
var BASE_URL = "/api/order/";
var SERVING_URL = "/api/servingOrder/";
var FOOD_URL = "/api/servingOrder/food/";
var DRINKS_URL = "/api/servingOrder/drinks/";
var MENUITEM_URL = "/api/menuItem/";

var DATA_PAIRS = {
    table: ".number",
    status: ".status"
};

var SERVING_DATA_PAIRS = {
    order: ".orderId",
    id: ".id",
    numberOfMenuItems: ".amount",
    menuItem: ".menuItem"
};
var MenuItems_TEMPLATE = '<li class="list-group-item orderItem"><input type="hidden" class="id"><span class="amount"></span> <span class="menuItem"></span> <span class="tool"><a href="edit"><i class="fas fa-edit"></i></a> / <a href="delete"><i class="far fa-trash-alt"></i></a></span></li>';

$(function() {
    DATA_TABLE = $("table").DataTable({
        columns: [
            {data: "table.number"},
            {data: "status"},
            {data: "menuCostPrice", render: $.fn.dataTable.render.number( ',', '.', 2, '¥ ' ) },
            {
                data: null,
                className: "center",
                defaultContent: "<a href='menuItems'>View MenuItems</a><br><a href='foodItems'>View FoodItems</a><br><a href='drinkItems'>View Drinks</a>"
            },
            {
                data: null,
                className: "center",
                defaultContent: '<a href="edit"><i class="fas fa-edit"></i></a> / <a href="delete"><i class="far fa-trash-alt"></i></a>'
            }
        ]
    });
});


function emptyMenuItemList() {
    $("#add-menuItem .list-group").empty();
}

function addMenuItemToList(serving) {
    var ele = $(MenuItems_TEMPLATE);
    $("#add-menuItem .list-group").append(ele);
    ele.find(".amount").html(serving.numberOfMenuItems);
    ele.find(".category").html(serving.menuItem.category);
    ele.find(".menuItem").html(serving.menuItem.name);
    ele.find(".number").html(serving.menuItem.number);
    ele.find(".id").val(serving.id);
}
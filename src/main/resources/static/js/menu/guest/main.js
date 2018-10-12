var BASE_URL = "/api/menuItem/";
$(function() {
    var CATEGORY_TEMPLATE = $("#category-template").html();
    var ITEM_TEMPLATE = $("#item-template").html();

    console.log($(".pay-hotel"));
    $(".pay-hotel").click(function() {
        $("#pay-modal").modal("toggle");
        $("#hotel-modal").modal("toggle");
    });

    $(".pay").click(function() {
        var name = $("#hotel .name").val();
        console.log("TODO Pay for customer: "+name);
    });

    URLUtil.get(BASE_URL).then(function(arr) {
        // Create buckets of arrays based on the categories.
        var bucket = sortToBuckets(arr);

        for(var key in bucket) {
            var obj = bucket[key];

            var category = constructCategory(key);
            $(".categories").append(category);

            category.find("h2").click(function() {
                var self = $(this);
                self.parent().find(".items").collapse('toggle');
            });

            constructItemsOnCategory(obj, category);
        }
    });

    /**
     * Fired when the order button has been pressed.The method finds out the
     * original form, get the id and name from it.Use the ID when adding an
     * order, and use the name in the popup dialog.
     */
    function orderItem() {
        var item = $(this).closest(".item");
        var id = item.find(".id").val();
        console.log("Item ID:", id);
        
        var order = {
            id: id
        };
        URLUtil.post("/api/order/add/70", order).then(function() {
            var name = item.find(".title").html();
            var modal = $("#added-order-modal");
            modal.find(".name").html(name);
            modal.modal("toggle");
        }, function() {
            alert("Something went wrong");
        });
    }

    /**
     * Constructs HTML items from the ITEM_TEMPLATE constant, with the values
     * provided by an item. Make the first letter of the name uppercase, just
     * in case this was not done in the backend yet.
     *
     * @param items
     * @param category
     */
    function constructItemsOnCategory(items, category) {
        $.each(items, function(i, item) {
            var template = $(ITEM_TEMPLATE);
            template.find(".id").val(item.id);

            var name = item.name;
            // Make the first letter of the name uppercase, just to be sure
            name = name.charAt(0).toUpperCase() + name.slice(1);
            name += " (¥ " + item.price + ")";

            template.find(".title").html(name);
            var description = "Contains the following ingredients: ";

            var len = item.servings.length;
            $.each(item.servings, function(i, serving) {
                var name = serving.ingredient.name;
                description += name;
                if (i < len - 1) {
                    description += ", ";
                } else {
                    description += ".";
                }
            });

            template.find(".description").html(description);
            category.find(".items").append(template);

            template.find(".order").click(orderItem);
        });
    }

    /**
     * Constructs a HTML category from the CATEGORY_TEMPLATE constant, with the
     * values provided by a category.
     *
     * @param category
     * @return {jQuery|HTMLElement}
     */
    function constructCategory(category) {
        var template = $(CATEGORY_TEMPLATE);
        template.find(".name").html(category);
        return template;
    }


    /**
     * Sorts an array of items based on the category
     * The resulting object will have properties which are the same as a
     * category, the property will have an array of items with the same category.
     *
     * @param arr Items
     * @return Bucket
     */
    function sortToBuckets(arr) {
        var buckets = {};
        $.each(arr, function(i, obj) {
            var category = obj.category.name;
            // There wasn't an occurrence of this category yet
            if (buckets[category] === undefined) {
                buckets[category] = [];
            }

            buckets[category].push(obj);
        });

        return buckets;
    }
});

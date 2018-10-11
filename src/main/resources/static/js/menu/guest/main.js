var BASE_URL = "/api/menuItem/";
$(function() {
    var CATEGORY_TEMPLATE = $("#category-template").html();
    var ITEM_TEMPLATE = $("#item-template").html();

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

    function orderItem() {
        var item = $(this).closest(".item");
        var id = item.find(".id").val();
        console.log("Item ID:", id);

        // TODO: Add the call to order an item!
        var name = item.find(".title").html();
        var modal = $("#added-order-modal");
        modal.find(".name").html(name);
        modal.modal("toggle");
    }

    function constructItemsOnCategory(items, category) {
        $.each(items, function(i, item) {
            var template = $(ITEM_TEMPLATE);
            template.find(".id").val(item.id);

            var name = item.name;
            // Make the first letter of the name uppercase, just to be sure
            name = name.charAt(0).toUpperCase() + name.slice(1);

            template.find(".title").html(item.name);
            template.find(".description").html("Lorem ipsum sit amet");
            category.find(".items").append(template);

            template.find(".order").click(orderItem);
        });
    }

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

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

    function constructItemsOnCategory(items, category) {
        $.each(items, function(i, item) {
            var template = $(ITEM_TEMPLATE);
            template.find(".title").html(item.name);
            template.find(".description").html("Lorem ipsum sit amet");

            console.log(template);
            category.find(".items").append(template);
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

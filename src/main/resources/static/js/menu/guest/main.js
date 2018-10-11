var BASE_URL = "/api/menuItem/";
$(function() {
    URLUtil.get(BASE_URL).then(function(arr) {
        console.log("Arr: ", arr);
        // Create buckets of arrays based on the categories.
        var bucket = sortToBuckets(arr);
        console.log(bucket);
    });


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

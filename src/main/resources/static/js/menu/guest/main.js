var BASE_URL = "/api/menuItem/";
$(function() {
    URLUtil.get(BASE_URL).then(function(arr) {
        console.log("Arr: ", arr);
    });
});

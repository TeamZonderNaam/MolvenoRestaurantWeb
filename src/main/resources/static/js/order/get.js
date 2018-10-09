$(function() {
   URLUtil.get(BASE_URL).then(function(arr) {
       DATA_TABLE.rows.add(arr).draw(false)
       console.log(arr);
   });
});

$(function() {
   URLUtil.get(MENUITEM_URL).then(function(arr) {

       console.log(arr);
   });
});
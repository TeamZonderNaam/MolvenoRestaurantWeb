$(function() {
   URLUtil.get(BASE_URL).then(function(arr) {
       DATA_TABLE.rows.add(arr).draw(false)
   });
});
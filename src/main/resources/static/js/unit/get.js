$(function() {
   URLUtil.get(BASE_URL).then(function(arr) {
       console.log(arr);
       DATA_TABLE.rows.add(arr).draw(false)
   });
});
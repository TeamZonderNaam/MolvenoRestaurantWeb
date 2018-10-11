$(function() {
   URLUtil.get(BASE_URL).then(function(arr) {
       DATA_TABLE.rows.add(arr).draw(false)
       console.log(arr);
       console.log("dit is arr: ", arr[0].totalPrice);
   });
});

$(function() {
   URLUtil.get(BASE_URL).then(function(arr) {
       console.log(arr);
       // DATA_TABLE.rows.add(arr).draw(false);

       $.each(arr, function(i, obj) {
           console.log("Obj:", obj);
            DATA_TABLE.row.add(obj).draw();
       });
       // DATA_TABLE.rows.draw(false);
   });
});
function deleteData() {
            console.log("deleting...");

            //Get values from html
            var id = $("#inputDeleteId").val();

            // Create JS object with data.
            var deleteItem = {
                id : id
            };
            console.log(deleteItem);

            // Convert JS object to JSON.
            var validJsonItem = JSON.stringify(deleteItem);
            console.log(validJsonItem);
            console.log("Delete item" + id);


            var src = "api/menuItem/" + id;

            // Post JSON to endpsoint.
            $.ajax({
                url: src,
                type:"delete",
                data: validJsonItem,
                contentType: "application/json",
                success: function(result) {
                    // On successful post, reload data to get the added one as well.
                    console.log("success delete data!");
                    getData();
                }
            });
        }

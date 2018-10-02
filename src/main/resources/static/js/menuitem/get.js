function getData() {
            console.log("getting menu item data...");

            // Get the data from endpoint.
            $.ajax({
                url:"/api/menu/",
                type:"get",
                success: function(items) {
                    // On successful get, reload the datatable with new data.
                    console.log("This is the data: " + items);
                    $('#table').DataTable().clear();
                    $('#table').DataTable().rows.add(items);
                    $('#table').DataTable().columns.adjust().draw();
                }
            });
        }
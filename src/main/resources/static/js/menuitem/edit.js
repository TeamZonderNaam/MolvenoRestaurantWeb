 function putData() {
            console.log("changing item...");

            //Get values from html
            var name = $("#inputChangeName").val();
            var price = $("#inputChangePrice").val();
            var number = $("#inputChangeNumber").val();
            var id = $("#inputChangeId").val();
            var category = $("#inputChangeCategory").val();

            // Create JS object with data.
            var changeItem = {
                name : name,
                price : price,
                number : number,
                category : category
            };
            console.log(changeItem);

            // Convert JS object to JSON.
            var validJsonItem = JSON.stringify(changeItem);
            console.log(validJsonItem);

            var src = "api/menu/" + id;

            // Post JSON to endpoint.
            $.ajax({
                url: src,
                type:"put",
                data: validJsonItem,
                contentType: "application/json",
                success: function(result) {
                    // On successful post, reload data to get the added one as well.
                    console.log("success put data!");
                    getData();
                }
            });
        }
function postData() {
            console.log("posting a new item...");

            //Get values from html
            var name = $("#inputName").val();
            var price = $("#inputPrice").val();
            var number = $("#inputNumber").val();
            var category = $("#inputCategory").val();

            // Create JS object with data.
            var newItem = {
                name : name,
                price : price,
                number : number,
                category: category
            };
            console.log(newItem);

            // Convert JS object to JSON.
            var validJsonItem = JSON.stringify(newItem);
            console.log(validJsonItem);

            // Post JSON to endpoint.
            $.ajax({
                url:"api/menuItem/",
                type:"post",
                data: validJsonItem,
                contentType: "application/json",
                success: function(result) {
                    // On successful post, reload data to get the added one as well.
                    console.log("success post data!");
                    getData();
                }
            });
        }

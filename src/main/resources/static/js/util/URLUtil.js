/**
 * The purpose of this class is to remove the need of having to type $.ajax.
 * While jQuery offers .get() and .post(), it does not offer .put() and .delete()
 * To keep it all nicely and type as less as possible, this class is created.
 * Every method returns a default JavaScript Promise instead of a jQuery promise,
 * because I honestly prefer the default style over the one provided by jQuery.
 *
 */
var URLUtil = function(){};

URLUtil.get = function(url) {
    var promise = new Promise(function(resolve, reject) {
        $.ajax({url: url, type: "GET"}).done(function(data) {
            resolve(data);
        }).fail(function(a, b, c) {
            // Jquery returns stupid amount of variables when failing
            // Just return b, which is probably the text: ERROR. SO far the error messages of jQuery aren't helpfull.
            reject(b);
        });
    });
    return promise;
};

URLUtil.post = function(url, data) {
    var promise = new Promise(function(resolve, reject) {
        $.ajax({url: url, data: JSON.stringify(data), type: "POST", contentType:"application/json; charset=utf-8", dataType:"json"}).done(function(data) {
            resolve(data);
        }).fail(function(a, b, c) {
            // Jquery returns stupid amount of variables when failing
            // Just return b, which is probably the text: ERROR. SO far the error messages of jQuery aren't helpfull.
            reject(a, b, c);
        });
    });
    return promise;
};

URLUtil.put = function(url, data) {
    var promise = new Promise(function(resolve, reject) {
        $.ajax({url: url, data: JSON.stringify(data), type: "PUT", contentType:"application/json; charset=utf-8", dataType:"json"}).done(function(data) {
            resolve(data);
        }).fail(function(a, b, c) {
            // Jquery returns stupid amount of variables when failing
            // Just return b, which is probably the text: ERROR. SO far the error messages of jQuery aren't helpfull.
            reject(b);
        });
    });
    return promise;
};

URLUtil.delete = function(url) {
    var promise = new Promise(function(resolve, reject) {
        $.ajax({url: url, type: "DELETE"}).done(function(data) {
            resolve(data);
        }).fail(function(a, b, c) {
            // Jquery returns stupid amount of variables when failing
            // Just return b, which is probably the text: ERROR. SO far the error messages of jQuery aren't helpfull.
            reject(b);
        });
    });
    return promise;
};
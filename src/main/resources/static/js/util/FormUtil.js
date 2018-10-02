var FormUtil = function() {};

/**
 * Converts the values writen in the form into an object that can be processed further.
 * The functions expect pairs to be given, which are noted like the following:
 * {id: ".id", name: "#name"}
 *
 * The first part is the identifier the value should be added to, and the second
 * part is the selector that will be used to find that value on the form.
 *
 *
 * @param pairs
 * @param form
 * @return {Object}
 */
FormUtil.formToValues = function(pairs, form) {
    var vals = {};
    for(var key in pairs) {
        vals[key] = form.find(pairs[key]).val();
    }
    return vals;
};
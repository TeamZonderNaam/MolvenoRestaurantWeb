var FormUtil = function() {};

/**
 * Converts the values writen in the form into an object that can be processed further.
 * The functions expect pairs to be given, which are noted like the following:
 * {id: ".id", name: "#name"}
 *
 * The first part of the pair is the identifier the value should be added to, and the second
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

/**
 * Fills the form with the given data according to the pairs.
 * The functions expect pairs to be given, which are noted like the following:
 * {id: ".id", name: "#name"}
 *
 * The first part of the pair is the identifier the value should be added to, and the second
 * part is the selector that will be used to find that value on the form. Which is used to set the value.
 *
 * @param pairs
 * @param data
 * @param form
 */
FormUtil.fillForm = function(pairs, data, form) {
    for (var key in pairs) {
        form.find(pairs[key]).val(data[key]);
    }
};

/**
 * Empties all the inputs in a form, this is useful when done with either creating or editing.
 * @param form
 */
FormUtil.emptyForm = function(form) {
    form.find("input").val("");
};

/**
 * Makes a form editable by removing the edit class on the button and making the class save
 * @param form
 */
FormUtil.makeFormEdit = function(form) {
    var btn = form.find("button.save");
    FormUtil.__swapClass("save", "edit", btn);
};
/**
 * Makes a form saveble by removing the save class on the button and making the class edit
 * @param form
 */
FormUtil.makeFormSave = function(form) {
    var btn = form.find("button.edit");
    FormUtil.__swapClass("edit", "save", btn);
};


/**
 * Removes the first class and adds the second class, this will be used when setting the form in a save state
 * and a edit state.
 * @param class1
 * @param class2
 * @param input
 * @private
 */
FormUtil.__swapClass = function(class1, class2, input) {
    input.removeClass(class1).addClass(class2);
};
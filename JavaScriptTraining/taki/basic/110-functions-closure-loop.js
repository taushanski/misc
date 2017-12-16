// a common mistake - creating closures in loops
function makeCallbacks() {
    var result = [];
    var data = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
    for (var i = 0; i < data.length; i++) {
        var item = data[i];
        // console.log(item);
        // simulate assigning callbacks
        result.push(function() {
            console.log(item);
        });
    }
    return result;
}

function invokeCallbacks(callbacks) {
    for (var i = 0; i < callbacks.length; i++) {
        callbacks[i]();
    }
}

var callbacks = makeCallbacks();
invokeCallbacks(callbacks);



// fix by wrapping in a closure and capturing the value at the time of execution as a parameter
function makeCallbacksFixed() {
    var result = [];
    var data = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
    for (var i = 0; i < data.length; i++) {
        var item = data[i];
        // simulate assigning callbacks
        (function (curItem) {
            result.push(function() {
                console.log(curItem);
            });
        }(item));
    }
    return result;
}

invokeCallbacks(makeCallbacksFixed()); // 0,1,2... - as expected

// scroll down for an even better solution



















































// a more readable solution
function makeCallbacksImprovedStep1() {
    var result = [];
    var data = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
    data.forEach(function (curItem) {
        result.push(function () {
            console.log(curItem);
        });
    });
    return result;
}
invokeCallbacks(makeCallbacksImprovedStep1());


// even more readable solution
function makeCallbacksImprovedFinal() {
    var data = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
    return data.map(function (item) {
        return function () {
            console.log(item);
        };
    });
}
invokeCallbacks(makeCallbacksImprovedFinal());

// managing own scope
var data1 = 1;      // pollute global scope
var data2 = 2;
function doWork() {
    console.log(data1, data2);
}
doWork();

// Immediately-Invoked Function Expression (IIFE)
(function () {
    var data1 = 5;
    // var data2 = 6;
    function doWork() {
        console.log(data1, data2);
    };
    doWork();
}());

console.log(data1, data2);  // the global ones, not polluted because of the closure

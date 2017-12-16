// empty array
var a = [];

// defining by object literal
var a = [1, 2, 3];

// access
console.log("by index: " + a[0]);

// loops
for (var i = 0; i < a.length; i++) {
    console.log("loop: " + a[i]);
}

// arrays are objects -> appending
a.push(4);

// methods
// https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/prototype#Methods
a.join("-")

// a better loop
a.forEach(function (el) {
    console.log("better loop: " + el);
});

// if we need the element index
a.forEach(function (el, idx) {
    console.log("even better loop: " + idx + "->" + el);
    // how do we break - see later
});

// more at
// https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/forEach

// more realistic example: disable each button
buttons = [/*b1, b2, b3*/];
buttons.forEach(function(b) {
    b.disable();
});
// vs
for (var i = 0; i < buttons.length; i++) {
    var b = buttons[i];
    b.disable();
}

// map
prefixes = a.map(function (el) { return "prefix" + el; });
// vs
var prefixes = [];
for (var i = 0; i < a.length; i++) {
    var el = a[i];
    prefixes.push("prefix" + el);
}

// filter
var todos = [
    {id:1, done: false},
    {id:2, done: true},
    {id:3, done: false}
];
// classic algorithm
for (var i = todos.length - 1; i >= 0; i--) {
    if (todos[i].done === true) {
        todos.splice(i, 1);
    }
}
// filter
todos = todos.filter(function (todo) { return todo.done === false; });

// reduce
// every
// some
// https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/prototype#Methods

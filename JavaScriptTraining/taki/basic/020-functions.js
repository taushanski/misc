// defining
function square (x) {
    return x*x;
};

// invoking
console.log(square(5));

// functions are objects
s = square;
s(5);

// function name
square2 = function (x) {
    return x*x;
};

console.log(s.name);
console.log(square2.name);

// functions are data - can be passed as parameters, returned from other functions
// the difference from other data is that they also have code, so they can be invoked

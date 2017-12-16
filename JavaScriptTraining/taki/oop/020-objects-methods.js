// object notaion
var obj = {
    a: 5,
    b: 6
}

// functions can be assigned as object properties
square = obj.square = function (x) {
    return x * x;
}

// as expected, both return 36
square(6);
obj.square(6);

// "this" is the difference
obj.sum = function () {
    debugger;
    return this.a + this.b;
}

obj.sum();  // 11

sum = obj.sum;
sum();      // "this" is the global scope and a is not defined there

// methods are only convention - they use "this" and are called in the context of an object

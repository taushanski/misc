// if statements work not only with booleans
if ("content") {
    console.log("string has content");
}

// empty strings are treated as false - they are falsy
if ("") {
    console.log("string has content");
}

// all numbers are treated as true
if (5) {
    console.log("non zero number");
}

// except 0
if (0) {
    console.log("non zero number");
}

var x = {
    a : 5
};

// properties
if (x.a) {
    console.log("property is defined and has content");
}

// undefined property
if (x.b) {
    console.log("variable is defined and has content");
}

// arrays (even empty) are objects in memory
if ([]) {
    console.log("arrays are truthy");
}

// objects (even empty) are allocated in memory
if ({}) {
    console.log("objects are truthy");
}

// null is falsy
var a = null;
if (a) {
    console.log("will not happen");
}

// uninitialized variables (undefined) are falsy
var b;
if (b) {
    console.log("will not happen");
}

// takeaway
var s = "some data";
// java way
if (s !== undefined && s.length > 0) {}
// same but better - JS way
if (s) {}

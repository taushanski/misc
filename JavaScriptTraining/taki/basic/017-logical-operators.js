// logical operators can be used with non boolean operands
"cat" || "dog";     // result is "cat"

// logical OR - Returns expr1 if it can be converted to true; otherwise, returns expr2. 
"cat" || "dog";     // result is "cat"
"" || "dog";        // result is "dog"

// Short-Circuit Evaluation - true || (anything) is short-circuit evaluated to true.
// practical use - default values
var person = { name : "John" };
var name = person.name || "guest";
// person.name is present, so name has its value
console.log(name);

person = {};
name = person.name || "guest";
// person.name is not present, so name has a default value of "guest"
console.log(name);

// equivalent but more verbose
if (person.name === undefined || person.name.length === 0) {
    name = "guest";
} else {
    name = person.name;
}

// -----------
// logical AND - Returns expr1 if it can be converted to false; otherwise, returns expr2.
"cat" && "dog";     // result is "dog"
"" && "dog";        // result is ""
// Short-Circuit Evaluation - false && (anything) is short-circuit evaluated to false.
// practical use - guard operator
var controller;
controller.init();  // results in error
controller && controller.init();    // with a guard - init only if present
controller = {
    init : function () {
               console.log("init done");
           }
};
controller && controller.init();

// equivalent but more verbose
if (controller) {
    controller.init();
}

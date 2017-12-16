function ex1() {
    console.log(notDeclared);   // reference error: variable not declared
}
ex1();

function ex2() {
    console.log(declaredLater); // no reference error this time, but undefined, no assignment
    var declaredLater = 1;
    console.log(declaredLater);
}
ex2();

function ex3() {
    console.log(declaredLater); // even unreachable declarations are still declared
    if (false) {
        var declaredLater = 1;
    }
}
ex3();

// real world gotcha
name = "John";      // global var
function ex4() {
    console.log(name);      // expected "John"
    var name = "Inner John";
}
ex4();

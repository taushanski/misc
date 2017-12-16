globalVar = 5;
console.log("global scope access: " + globalVar);

function main () {
    var localVar = 10;
    // global scope access
    console.log("global scope access: " + globalVar);

    // local scope access
    console.log("local scope access: " + localVar);
};

main();
console.log("global scope access: " + globalVar)
// no access to localVar outside function main()

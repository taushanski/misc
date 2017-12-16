parent = {}
parent.a = 5

child = {}
child.b = 6;

child.a    // undefined
// make parent prototype of child
child.__proto__ = parent

child.a;   // 5 - access the prototype
child.a = 8;    // create a local property
child.a;   // 8 - own property found, no prototype lookup
delete child.a;     // will lookup the prototype again
delete child.a;


// prototypes are live, changes are visible immediatly in children
parent.c = 5;
child.c;    // 5

// A side note on loops
// --------------------

// this is why we need a hasOwnProperty check
// latent bug - works as expected with empty prototype, but if the prototype has properties, iterates over them unintentionally
for (var key in child) {
    console.log("key: " + key + ", value: " + child[key]);
}
// key: b, value: 6
// key: a, value: 5 
// key: c, value: 5 

// what is usually intended when objects are used as maps
for (var key in child) {
    if (child.hasOwnProperty(key)) {
        console.log("key: " + key + ", value: " + child[key]);
    }
}
// key: b, value: 6

// why Object.keys is slightly better - less verbose and reads like English
Object.keys(child).forEach(function (key) {
    console.log("key: " + key + ", value: " + child[key]);
});
// key: b, value: 6

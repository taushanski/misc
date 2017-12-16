createAnimal = function (name) {
    var that = {};

    that.name = name;

    that.sayHello = function () {
        console.log("hi, i'm " + this.name);
    };

    return that;
};

animal = createAnimal("sammy");
// biggest drawback: create 1 million animals, get 1 million equivalent "methods" sayHello in memory
// also difficult to debug (see only object in console)

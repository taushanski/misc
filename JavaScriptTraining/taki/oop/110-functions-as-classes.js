// can be viewed both as class and constructor
function Animal(name) {
    this.name = name;
};

// all instances of animal will have Animal.prototype as prototype, thus the say function as a property
Animal.prototype.say = function (prefix) {
    console.log(prefix + this.name);
};

var snake = new Animal("sammy");
var cat = new Animal("tommy");
snake.say("pss ");      // pss sammy
cat.say("meow ");       // meow tommy

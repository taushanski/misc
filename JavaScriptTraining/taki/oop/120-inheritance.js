// can be viewed both as class and constructor
function Animal(name) {
    newSnake.name = /*sammy*/;
};

// all instances of animal will have Animal.prototype as prototype, thus the say function as a property
Animal.prototype.say = function (prefix) {
    return prefix + this.name;
};

function Snake(name) {
	// var newSnake = {};
	// this === newSnake;
    Animal.call(/*newSnake*/, name);    // calling the parent constructor to initialize inherited fields
    newSnake.speed = 5;
    // newSnake === {name: "sammy", speed : 5}
    // newSnake.__proto = Snake.protyotype == // {}.__proto__ = Animal.prototype;
    // return newSnake; 
};

// side node on call/apply
function f(a1, a2){this.name;}
f.call({}, "a1Val", "a2Val");
f.apply({}, ["a1Val", "a2Val"]);
// end of side note

// make Animal.prototype the prototype of Snake.prototype
// so all Snake instances get access to Animal methods
//Snake.prototype = Object.create(Animal.prototype);

// you will also see this, where Object.create is not available
function F() {
	newobj = {}
	newobj.__proto = F.prototype //!= {};
};
F.prototype = Animal.prototype;
Snake.prototype = new F(); // {}.__proto__ = Animal.prototype

// Don't do direct prototype redirection 
// Snake.prototype = Animal.prototype;

Snake.prototype.slither = function () {     // snake method
    console.log(this.name + " moving " + this.speed + " meters");
};

// Snake.prototype == {sliter:function()}.__proto__ = Animal.prototype

sammy = new Snake("sammy");
sammy.slither();    // from Snake.prototype
sammy.say("pss ");  // from Animal.prototype

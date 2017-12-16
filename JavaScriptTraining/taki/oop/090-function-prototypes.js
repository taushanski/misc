function F() {
    // when F is called with 'new', a new object is created and assigned to `this`
    this.b = 5;
};

// each function gets a predefined empty object accessible via the "prototype" property
F.prototype;    // {}
// this object becomes the __proto__ of all objects create with "new"

child1 = new F();
child1.b;   // 5

child2 = new F();
child2.b;   // 5

child1.__proto__ === F.prototype;  // true, F.prototype is the __proto__ of all objects created with new F()
F.prototype.a = 99;
child1.a;   // 99
child2.a;   // 99

function F() {
	// var newObj = {}
	// this = newObj;
    // when F is called with 'new', a new object is created and assigned to `this`
    this.b = 5;
    // newObj.__proto__ = F.prototype // {}
    // return newObj;
};

F();

child1 = new F();
child1.b;   // 5

child2 = new F();
child2.b;   // 5

child1.__proto__ === child2.__proto__;  // true, they have the same object as prototype
parent = child1.__proto__;
parent.a = 99;
child1.a;   // 99
child2.a;   // 99

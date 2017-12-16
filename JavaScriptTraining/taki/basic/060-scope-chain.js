var a = 1;
function f() {
    if(true){
    	let b = 2;
    }
    console.log(a);
    function n() {
        var c = 3;
        console.log(b);     // access b to avoid optimization, otherwise it won't be put in the scope
        debugger;           // see the scope chain in the debugger before and after commenting console.log(b)
    }
    n();
}
f();

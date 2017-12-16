function publicFunc(a, b) {
    var private1 = function (param) {
        return "transformation 1: " + param;
    }

    function private2(param) {
        return "transformation 2: " + param;
    }

    globalVar = 1;
    
    return [private1(a), private2(b)];
}
publicFunc(100, 200);
// private1 and private2 not accessible here, but globalVar is

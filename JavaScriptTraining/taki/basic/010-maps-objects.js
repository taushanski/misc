// empty map
var o = {};

// defining a map with an object literal
var map = {
    "key1": "val1",
    "key2": "val2"
}

// same as string keys
var map = {
		key1: "val1",
		key2: "val2"
}

// but different from variable values
var val1 = "differentVal1";
var map = {
		key1: val1,
		key2: "val2"
}

// access
console.log("by key: " + map["key1"]);

// if keys have valid JS syntax
map.key3 = "val3";

// any kind of key or through a variable
map["key+/4"] = "val4"

var unknownKey = "key5";
map[unknownKey] = "val5"
	
// loops
for (var key in map) {
    if (map.hasOwnProperty(key)) {
        console.log("key: " + key + ", value: " + map[key]);
    }
}

// somewhat better loop
Object.keys(map);   // returns an array
Object.keys(map).forEach(function (key) {
    console.log("alt_key: " + key + ", value: " + map[key]);
});

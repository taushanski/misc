globalVar = 5;
console.log("global scope access: " + globalVar);

function main () {
    // global scope access
    console.log("global scope access: " + globalVar);   // 5

    globalVar = 10;
    // local scope access
    console.log("local scope access: " + globalVar);    // 10
};

main();
console.log("global scope access: " + globalVar);   // intended to be 5, but is 10

// examples for namesapces
// libraries define their APIs as global objects for access
sap.ui.commons.Label

// namespace notion implemented as nested objects
sap = {
		ui : {
			commons : {
				Label : function(){}
			}
		}
}
// callbacks
function main() {
    var label = {}; // pretend it is a UI element

    getDataFromServer(function (data) {
        label.text = data;
    });
}
main();

// TODO: make this function aware of which element called it (i.e. avoid passing `id`)
function seed(id) {
    var doc = document.getElementById(id);
    var x = Number(doc.innerHTML);
    doc.innerHTML = x + 1;
}

function setHoles(num) {
    MAX_HOLES = 5;
    if (num > MAX_HOLES) {
        window.alert("O número de buracos deve estar entre 2 e 5.")
    }
    else {
        document.getElementById("rumba").innerHTML = 0;
        for (var i = 1; i < MAX_HOLES; i++) {
            console.log(`Updating hole ${i}`);
            var element = document.getElementById(`hole${i}`)
            element.style.display = i < num ? 'block' : 'none';
            element.innerHTML = 2;
        }
    }
    // TODO: dynamically generate whole HTML for the board whenever it changes (this also should make MAX_HOLES
    // unnecessary.)
}
// TODO: make this function aware of which element called it (i.e. avoid passing `id`)
function seed(id) {
    var doc = document.getElementById(id);
    var x = Number(doc.innerHTML);
    doc.innerHTML = x + 1;
}

function setHoles(num) {
    MAX_HOLES = 5;
    if (num > MAX_HOLES) {
        window.alert("O número de buracos deve ser menor que 5.")
    }
    else {
        for (var i = 1; i < MAX_HOLES; i++) {
            console.log(`Updating hole ${i}`);
            document.getElementById(`hole${i}`).style.display = i < num ? 'block' : 'none';
        }
    }
    // TODO: restart board state whenever this function runs
    // TODO: dynamically generate whole HTML for the board whenever it changes (this also should make MAX_HOLES
    // unnecessary.)
}
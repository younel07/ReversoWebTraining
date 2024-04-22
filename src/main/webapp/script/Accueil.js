function updateActions() {
    var clientRadio = document.getElementById("client-checkbox");
    var prospectRadio = document.getElementById("prospect-checkbox");

    if (clientRadio.checked) {
        document.getElementById("client-select").style.display = "flex";
        document.getElementById("prospect-select").style.display = "none";
        document.getElementById("btnAfficherBddId").onclick = function() {
            window.location.href = "ListClient";
        };

        document.getElementById("btnNewId").onclick = function() {
            window.location.href = "gestionClient";
        };
        document.getElementById("btnUpdateId").onclick = function() {
            window.location.href = "gestionClient.jsp";
        };
        document.getElementById("btnDeleteId").onclick = function() {
            window.location.href = "gestionClient.jsp";
        };
    } else if (prospectRadio.checked) {
        document.getElementById("prospect-select").style.display = "flex";
        document.getElementById("client-select").style.display = "none";
        document.getElementById("btnAfficherBddId").onclick = function() {
            window.location.href = "login";
        };
        document.getElementById("principal").innerText = "prospect";
        document.getElementById("btnNewId").onclick = function() {
            window.location.href = "login";
        };
        document.getElementById("btnUpdateId").onclick = function() {
            window.location.href = "login";
        };
        document.getElementById("btnDeleteId").onclick = function() {
            window.location.href = "login";
        };
    }
}

    document.getElementById("btnQuit").onclick = function() {
        window.location.href = "login";
    };

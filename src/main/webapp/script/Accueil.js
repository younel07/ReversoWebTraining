function updateActions() {
    var clientRadio = document.getElementById("client-checkbox");
    var prospectRadio = document.getElementById("prospect-checkbox");

    if (clientRadio.checked) {
        document.getElementById("client-select").style.display = "flex";
        document.getElementById("prospect-select").style.display = "none";

        document.getElementById("btnAfficherBddId").onclick = redirectToClientList;
        document.getElementById("btnNewId").onclick = redirectToCreateClient;
        document.getElementById("btnUpdateId").onclick = updateSelectedClient;
        document.getElementById("btnDeleteId").onclick = redirectToDetelteClientJSP;
    } else if (prospectRadio.checked) {
        document.getElementById("prospect-select").style.display = "flex";
        document.getElementById("client-select").style.display = "none";

        document.getElementById("btnAfficherBddId").onclick = redirectToLogin;
        document.getElementById("btnNewId").onclick = redirectToLogin;
        document.getElementById("btnUpdateId").onclick = redirectToLogin;
        document.getElementById("btnDeleteId").onclick = redirectToLogin;
        document.getElementById("principal").innerText = "prospect";
    }

    document.getElementById("btnQuit").onclick = redirectToLogin;
}

function redirectToClientList() {
    window.location.href = "ListClient";
}

function redirectToCreateClient() {
    window.location.href = "creationClient";
}

function updateSelectedClient() {
    let clientSelected = document.getElementById("client-select").value;
    document.getElementById("selected-entity").value = clientSelected;
}

function redirectToDetelteClientJSP() {
    let clientSelected = document.getElementById("client-select").value;
    document.getElementById("selected-entity").value = clientSelected;
    document.getElementById("selected-entity").name = "deleteClient";
}

function redirectToLogin() {
    window.location.href = "login";
}

updateActions(); // Call the function to initialize

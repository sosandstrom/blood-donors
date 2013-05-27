
function crud_Create(url, body) {
    return $.ajax(url, {
        contentType: "application/json",
        data: JSON.stringify(body),
        type: "POST"
    });
}

function crud_Read(url, id) {
    return $.getJSON(url + '/' + id);
}
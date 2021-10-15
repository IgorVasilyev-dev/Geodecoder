
const baseUrl = "http://localhost:8080/geolocation"


async function sendRequest(method, url,body=null) {
    const headers = {
        'Content-type': 'application/json'
    }
    if(body !== null) {
        body = JSON.stringify(body)
    }
    return await fetch(url, {
        method: method,
        body: body,
        headers: headers
    }).then(response => {
        if(response.ok) {
            if (method === 'GET') {
                console.log("OK")
                return response.json()
            }
            return response.status
        } else {
            return response.json().then(error => {
                const e = new Error('Что-то пошло не так')
                e.data = error
                throw e
            })
        }
    })
}

window.addEventListener("DOMContentLoaded", () => {


    let element = document.createElement('div')
    let element1 = document.createElement('div')
    createFormElement(element, 'row1')
    const buttons = document.querySelectorAll(".btn");
        const handlerClick = (event) => {
            if (parseInt(event.target.dataset.num) === 2) {
                createHtmlElement(element1, 'row2')
            }
        }
        buttons.forEach(button => {
            button.addEventListener('click', handlerClick)
        });

    function createFormElement(element,idElement) {
        element.innerHTML = '<form id="form1" class="row g-3">\n' +
            '        <div class="col">\n' +
            '            <label for="geoCode"  class="form-label">Address or Coordinates</label>\n' +
            '            <input type="address" placeholder="input address or coordinates" class="form-control" id="geoCode">\n' +
            '        </div>\n' +
            '        <div class="col-12">\n' +
            '            <button type="button" data-num="2" class="btn btn-primary">convert</button>\n' +
            '            </div>\n' +
            '        </form>'
        document.getElementById(idElement).appendChild(element);
    }

    function createHtmlElement(element, id) {
        let geocode;
        let elements = document.getElementById('form1');
        let selector = elements.querySelectorAll("input")

        selector.forEach(selector => {
            if (selector.value !== null) {
                geocode = selector.value
            }
        });
        sendRequest('GET',baseUrl + '?geoCode=' + geocode).then(response => {
                createHtmlResponse(element, id, response)
        })
    }

});


function createHtmlResponse(element, idElement, data) {

    element.innerHTML = '<div class="col"> Result </div>' +
        '<div class="alert alert-success" role="alert">' + data.response + '</div>'
    document.getElementById(idElement).appendChild(element);
}

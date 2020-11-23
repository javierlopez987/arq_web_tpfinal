"use strict";
document.addEventListener("DOMContentLoaded", function () {
    let user;
    const URLBASE = "http://localhost:8080/";
    const URL = "http://localhost:8080/viajes/";
    const token = "http://localhost:8081/";//ver token formato
    const USUARIOURI_1 = "http://localhost:8081/user?email=pmarmol@gmail.com&password=1234";
    const USUARIOURI_2 = "http://localhost:8081/user?email=jn@doe&password=1234";

    let msjError = document.querySelector(".errorMsj");    msjError.setAttribute("display", "none");
   //Elementos de viaje
    let btnListarRealizados = document.querySelector("#btnViajes");
    btnListarRealizados.addEventListener('click',listarRealizados);

    let btnListarProximos = document.querySelector("#btnViajesProx");
    btnListarProximos.addEventListener('click',listarProximos);

    //Lista los viajes realizados

    let btnLogin = document.querySelector("#btnLogin");
    console.log(btnLogin);
    btnLogin.addEventListener("click", async function getToken(){
        console.log(this);
        try {
            let request = fetch(USUARIOURI_1, {
                "method": "POST",
            }); 
            let response = await request;
            if (response.ok) {
                user = await response.json();
                console.log(user);
                return user;
            }
         } catch (e){
            console.log(e);
            return e;
        }

    });
  

    async function listarRealizados(){
        let request;
        // request = URL + "/realizados/usuario/{"+usuario.id+"}";//tomar el valos de token
        request = URLBASE + "reportes/viajes/realizados";
        let container = document.querySelector("#listViajes");
        container.innerHTML = "<li>Cargando...</li>";
        try {
            let response = await fetch(request, {
                "method": "GET",
                "headers": {"authorization": user.token}
            });
            if (response.ok) {
                let dato = await response.json();
                container.innerHTML = "";
                for (let elemento of dato) {
                    container.innerHTML += "<tr><td>"+elemento.nombre+"</td>"+
                   "<td>"+ elemento.destino+"</td>"+
                   "<td>"+ elemento.inicio+"</td>"+
                   "<td>"+ elemento.fin+"</td>"+
                   "<td>"+ elemento.descripcion+"</td>"+
                   "<td><button id='"+elemento.id+"' class='btnMostrar'>Mostrar</button></td>"+  //ver handler listar planes
                   "</tr>";
                }
                handlearBtnMostrar();
            } else {
                container.innerHTML = "";
            	msjError.setAttribute("display", "visible");
            	msjError.innerHTML = "Error - Por favor, contáctese con proveedor del servicio";
                console.log("URL error");
                console.log(response);
            }
        } catch (response) {
            container.innerHTML = "";
            msjError.setAttribute("display", "visible");
            msjError.innerHTML = "Error - Por favor, contáctese con proveedor del servicio";
            console.log("Connection error");
            console.log(response);
        }
    }

    async function listarProximos(){
        let request = URLBASE + "reportes/viajes/proximos";//tomar el valos de token
        let container = document.querySelector("#listViajes");
        container.innerHTML = "<li>Cargando...</li>";
        try {
            let response = await fetch(request, {
                "method": "GET",
                "headers": {"authorization": user.token}
            });
            if (response.ok) {
                let dato = await response.json();
                container.innerHTML = "";
                for (let elemento of dato) {
                    container.innerHTML += "<tr><td>"+elemento.nombre+"</td>"+
                   "<td>"+ elemento.destino+"</td>"+
                   "<td>"+ elemento.inicio+"</td>"+
                   "<td>"+ elemento.fin+"</td>"+
                   "<td>"+ elemento.descripcion+"</td>"+
                   "<td><a id='"+elemento.id+"' class='btnMostrar' href='viajes.html'>Mostrar</a></td>"+  //ver handler listar planes
                   "</tr>";
                }
                handlearBtnMostrar();
            } else {
                container.innerHTML = "";
            	msjError.setAttribute("display", "visible");
            	msjError.innerHTML = "Error - Por favor, contáctese con proveedor del servicio";
                console.log("URL error");
                console.log(response);
            }
        } catch (response) {
            container.innerHTML = "";
            msjError.setAttribute("display", "visible");
            msjError.innerHTML = "Error - Por favor, contáctese con proveedor del servicio";
            console.log("Connection error");
            console.log(response);
        }
    }

    function handlearBtnMostrar () {
        let btnDelete = document.querySelectorAll(".btnMostrar");
        for (let element of btnDelete) {
            element.addEventListener("click", function () {
                mostrarPlan(element.id);
            })

        }
    }

    function mostrarPlan(id){

    }
})
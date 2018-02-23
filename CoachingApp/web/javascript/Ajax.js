/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Méthode qui retourne l'objet XMLHttpRequest en fonction du navigateur.
 */

/*function test(){
 alert(document.getElementById("catExo").value);
 }*/
/*(function() {
 document.getElementsByClassName("btn btn-outline btn-warning btn-xs").addEventListener("click", function(){
 console.log("test");
 }); 
 })*/

function modalParam(button) {
    var id = button.getAttribute("id");
    var elt = document.getElementById("parametre");
    var url = "ServletSupprExercice?idExo=" + id;
    elt.href = url;

}

/**
 * Méthode qui retourne l'objet XMLHttpRequest en fonction du navigateur.
 */
function getXMLHttpRequest()
{
    var xhr = null;

    // Firefox et bien d'autres.
    if (window.XMLHttpRequest)
        xhr = new XMLHttpRequest();
    else

    // Internet Explorer.
    if (window.ActiveXObject)
    {
        try {
            xhr = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e)
        {
            xhr = new ActiveXObject("Microsoft.XMLHTTP");
        }
    }

    // XMLHttpRequest non supporté.
    else
    {
        alert("Votre navigateur ne supporte pas l'objet XmlHttpRequest.");
        xhr = false;
    }

    return xhr;
}

function rechercherProgramme() {
    var saisie = document.getElementById("RechercheListe").value;

    var xhr = getXMLHttpRequest();

    xhr.onreadystatechange = function ()
    {
        // Si l'on a tout reçu et que la requête http s'est bien passée.
        if (xhr.readyState === 4 && xhr.status === 200)
        {
            var i;
            var xmlDoc = xhr.responseXML;
            var results = xmlDoc.getElementsByTagName("saisie");
            var lignes = "";
            var div = "<div onmousedown=\"selectWord(this.textContent)\">";

            // Elément html que l'on va mettre à jour.
            var elt = document.getElementById("zoneaff");

            for (i = 0; i < results.length; i++) {
                var res = results[i].childNodes[0].nodeValue;
                lignes += div + res + "</div>";
            }

            if (saisie.length !== 0) {
                elt.style.display = "block";
            } else {
                elt.style.display = "none";
            }
            elt.innerHTML = lignes;
        }
    };

    // Requête au serveur avec les paramètres éventuels.
    xhr.open("POST", "ServletMot", true);
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send("saisie=" + saisie);
}

/**
 * Cette méthode affiche les exos d'une séance.
 *
 * On utilise la propriété 'responseXML' de l'objet XMLHttpRequest afin
 * de récupérer sous forme d'arbre DOM le document XML envoyé par le serveur.
 */
function l_maSeance()
{
    var date = document.getElementById("lseance").value;
    var idcli = document.getElementById("idcli").value;
    var xhr = getXMLHttpRequest();

    xhr.onreadystatechange = function ()
    {
        // Si l'on a tout reçu et que la requête http s'est bien passée.
        if (xhr.readyState === 4 && xhr.status === 200)
        {
            var xmlDoc = xhr.responseXML;
            var tableau = xmlDoc.getElementsByTagName("unExercice");
            var lignes = "<div class=\"card mb-5\"><div class=\"card-block p-0\"><table class=\"table table-bordered table-sm m-0\"><thead class=\"\"><tr><th>#</th><th>Name</th><th>Registration Date</th><th>E-mail address</th><th>Premium Plan</th><th>Premium Plan</th><th>Premium Plan</th><th>Premium Plan</th></tr></thead><tbody>";
                    
            // Elément html que l'on va mettre à jour.
            var elt = document.getElementById("maseance");

            for (i = 0; i < tableau.length; i++) {
                lignes += "<tr><td><label class=\"custom-control custom-checkbox\"><input type=\"checkbox\" class=\"custom-control-input\"><span class=\"custom-control-indicator\"></span></label></td>"
                        + "<td>" + tableau[i].childNodes[1].nodeValue + "</td>"
                        + "<td>" + tableau[i].childNodes[3].nodeValue + "</td>"
                        + "<td>" + tableau[i].childNodes[5].nodeValue + "</td>"
                        + "<td>" + tableau[i].childNodes[7].nodeValue + "</td>"
                        + "<td>" + tableau[i].childNodes[9].nodeValue + "</td>"
                        + "<td>" + tableau[i].childNodes[11].nodeValue + "</td>"
                        + "<td>" + tableau[i].childNodes[13].nodeValue + "</td>"
                        + "<td><span class=\"label label-success\">Active</span></td></tr>";
            }
            elt.innerHTML = lignes + "</tbody></table></div></div></div>";
        }
    };

    // Requête au serveur avec les paramètres éventuels.
    xhr.open("POST", "ServletMaSeance", true);
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send("date=" + date + "&idcli=" + idcli);
}



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

function modalParam(button){
    var id = button.getAttribute("id");
    var elt = document.getElementById("parametre");
    var url = "ServletSupprExercice?idExo="+id;
    elt.href = url;
    
}

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
 * Cette méthode "Ajax" affiche la liste des auteurs.
 *
 * On utilise la propriété 'responseXML' de l'objet XMLHttpRequest afin
 * de récupérer sous forme d'arbre DOM le document XML envoyé par le serveur.
 */
function l_auteurs()
{
    var xhr = getXMLHttpRequest();

    xhr.onreadystatechange = function ()
    {
        // Si l'on a tout reçu et que la requête http s'est bien passée.
        if (xhr.readyState === 4 && xhr.status === 200)
        {
            var i;
            var xmlDoc = xhr.responseXML;
            var tableau = xmlDoc.getElementsByTagName("nom");
            var option = "<option>--</option>";

            // Elément html que l'on va mettre à jour.
            var elt = document.getElementById("lnom");

            for (i = 0; i < tableau.length; i++) {
                option += "<option>" + tableau[i].childNodes[0].nodeValue + "</option>";
            }

            elt.innerHTML = option;
        }
    };

    // Requête au serveur avec les paramètres éventuels.
    xhr.open("GET", "ServletAuteur", true);
    xhr.send(null);
}


/**
 * Cette méthode "Ajax" affiche la liste des citations.
 *
 * On utilise la propriété 'responseXML' de l'objet XMLHttpRequest afin
 * de récupérer sous forme d'arbre DOM le document XML envoyé par le serveur.
 */
function l_maSeance()
{
    var nomauteur = document.getElementById("lnom").value;

    var xhr = getXMLHttpRequest();

    xhr.onreadystatechange = function ()
    {
        // Si l'on a tout reçu et que la requête http s'est bien passée.
        if (xhr.readyState === 4 && xhr.status === 200)
        {
            var i;
            var xmlDoc = xhr.responseXML;
            var tableau = xmlDoc.getElementsByTagName("citation");
            var lignes = "<ul>";

            // Elément html que l'on va mettre à jour.
            var elt = document.getElementById("lcitations");

            for (i = 0; i < tableau.length; i++) {
                lignes += "<li>" + tableau[i].childNodes[0].nodeValue + "</li>";
            }

            elt.innerHTML = lignes + "</ul>";
        }
    };

    // Requête au serveur avec les paramètres éventuels.
    xhr.open("POST", "ServletCitation", true);
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send("nomauteur=" + nomauteur);
    console.log(nomauteur);
}



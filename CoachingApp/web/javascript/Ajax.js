/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Méthode qui retourne l'objet XMLHttpRequest en fonction du navigateur.
 */

function categorieExercice (){
        // Objet XMLHttpRequest.
	var xhr = getXMLHttpRequest();
        var elt = document.getElementById("catExo");
	xhr.onreadystatechange = function(){
            if (xhr.readyState === 4 && xhr.status === 200){
		var xmlDoc = xhr.responseXML;
                var myNodeNames = xmlDoc.getElementsByTagName("categorie");
                var content = "";
                for (let oneNodename of myNodeNames) {
                    content += "<option>" + oneNodename.firstChild.nodeValue + "</option>";
                } 
		elt.innerHTML = content;
            }
        };
	xhr.open("GET","ServletCategorieExercice",true);
	xhr.send(null); 
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



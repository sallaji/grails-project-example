/**
 * @fileoverview this document was originally created by Martin Hawksey and modified by santiago llano for particular uses of this web application
 * @author Martin Hawskey (modified by Santiago Llano)
 */


function validEmail(email) {
    var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
    return re.test(email);
}

// get all data in form and return object
function getFormData() {
    var form = document.getElementById("gform");
    var elements = form.elements; // all form elements
    var data = {};

    // add form-specific values into the data
    data.formGoogleSheetName = form.dataset.sheet || "responses"; // default sheet name
    //data from endEmail.gsp form
    data.formInterestedUsername = form.name.value || "a user";
    data.formMessage = form.message.value || "";
    data.formInterestedEmail = form.email.value || "";
    data.formInterestedPhoneNumber = form.phone.value || "";
    data.formGoogleSendEmail = form.donoremail.value || ""; // no email by default
    data.formDonorUsername = form.donorusername.value || "user";
    data.formAnnouncementName = form.announcementName.value || "your announcement";

    return data;
}

function handleFormSubmit(event) {  // handles form submit withtout any jquery
    event.preventDefault();           // we are submitting via xhr below
    var data = getFormData();         // get the values submitted in the form

    /* OPTION: Remove this comment to enable SPAM prevention, see README.md
    if (validateHuman(data.honeypot)) {  //if form is filled, form will not be submitted
      return false;
    }
    */

    if (data.email && !validEmail(data.email)) {   // if email is not valid show error
        var invalidEmail = document.getElementById("email-invalid");
        if (invalidEmail) {
            invalidEmail.style.display = "block";
            return false;
        }
    } else {
        var url = event.target.action;  //
        var xhr = new XMLHttpRequest();
        xhr.open('POST', url);
        // xhr.withCredentials = true;
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.onreadystatechange = function () {
            console.log(xhr.status, xhr.statusText);
            console.log(xhr.responseText);
            document.getElementById("titleSendEmail").style.display = "none"; // hide form
            document.getElementById("gform").style.display = "none"; // hide form
            var thankYouMessage = document.getElementById("thankyou_message");
            if (thankYouMessage) {
                thankYouMessage.style.display = "block";
            }

        };
        // url encode form data for sending as post data
        var encoded = Object.keys(data).map(function (k) {
            return encodeURIComponent(k) + "=" + encodeURIComponent(data[k])
        }).join('&');
        xhr.send(encoded);
    }
}

function loaded() {
    console.log("Contact form submission handler loaded successfully.");
    // bind to the submit event of our form
    var form = document.getElementById("gform");
    form.addEventListener("submit", handleFormSubmit, false);
};
document.addEventListener("DOMContentLoaded", loaded, false);

<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=iso-8859-1">
    <meta name="layout" content="template"/>
    <title>Reyours | Contact Donor User</title>
</head>

<body>
<div class="container" style="text-align: left">
    <div id="titleSendEmail">
        <h1 style="margin-top: 40px;">Send request for ${this.announcement.articleName}</h1>
        <span style="font-weight: 300">Please fill in the required fields to establish contact with the donor user</span>

    </div>

    <div class="container" style="text-align:center;">

        <form id="gform" method="POST"
              action="https://script.google.com/macros/s/AKfycbzOqykV1Avr6Hoq5X6IywI3SjyzupFMMkfxPtAzUa0LzLOwNbE/exec">

            <fieldset class="pure-group">
                <input type="hidden" name="donoremail" type="email" value="${this.announcement.email}"/>
                <input type="hidden" name="donorusername" type="text" value="${this.announcement.username}"/>
                <input type="hidden" name="announcementName" type="text" value="${this.announcement.articleName}"/>
            </fieldset>

            <div class="center-children-form fieldcontain required">
                <label for="name">Your Name<span class='required-indicator'>*</span></label>
                <g:textField
                        class="textfields"
                        type="text"
                        name="name"
                        id="name"
                        required=""
                        placeholder="enter your name"/>
            </div>

            <div class="center-children-form fieldcontain ">
                <label for="message">Message</label>
                <g:textArea
                        class="textfields"
                        type="text"
                        name="message"
                        id="message"
                        placeholder="tell the donor user why are you interested in this announcement"/>
            </div>

            <div class="center-children-form fieldcontain required">
                <label for="email">E-mail<span class='required-indicator'>*</span></label>
                <g:textField
                        class="textfields"
                        type="email"
                        name="email"
                        id="email"
                        required=""
                        placeholder="enter your email address"/>
            </div>

            <div class="center-children-form fieldcontain ">
                <label for="phone">Phone number</label>
                <g:textField
                        class="textfields"
                        type="number"
                        name="phone"
                        id="phone"
                        placeholder="phone number"/>
            </div>

            <button class="btn btn-outline-primary btn-lg" style="margin-top: 20px; margin-bottom: 20px;">
                <i class="fa fa-paper-plane"></i>&nbsp;Send</button>
        </form>
    </div>

    <div style="display:none; margin-top: 40px; text-align: center" id="thankyou_message">
        <asset:image src="correct.png"/>
        <h1>Your request has been successfully processed</h1>

        <p>Thank you very much for your interest in this announcement. We have sent an email to the donor user.
        </p>

        <p>We wish you good luck with your product request and hope that the donor user can contact you as soon as possible</p>
    </div>
</div>
<asset:javascript src="form-submission-handler.js" data-cfasync="false" type="text/javascript"/>

</body>
</html>

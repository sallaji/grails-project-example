<%@ page import="exercise.AnnouncementController" %>
<html>
<head>
    <meta name="layout" content="template"/>
    <title>Reyours | Announcement Details</title>

</head>

<body>

<div class="container" style="margin-top:40px; margin-bottom:40px; text-align: left;">
    <h1>Announcement Details</h1>
</div>

<div class="container" id="announcement-details">
    <div>
        <g:if test="${this.announcement.articleName}">
            <h2>Name</h2>
            <h3>${this.announcement.articleName}</h3>
        </g:if>

        <g:if test="${this.announcement.articleDescription}">
            <h2>Description</h2>
            <h3>${this.announcement.articleDescription}</h3>
        </g:if>
        <g:if test="${this.announcement.quantity}">
            <h2>Quantity available:</h2>

            <h3>${this.announcement.quantity} Units</h3>
        </g:if>

        <g:if test="${this.announcement.address}">
            <h2>Address:</h2>

            <h3>${this.announcement.address}</h3>
        </g:if>
        <g:if test="${this.announcement.email}">
            <h2>E-mail:</h2>

            <h3>${this.announcement.email}</h3>
        </g:if>
        <g:if test="${this.announcement.username}">
            <h2>Username:</h2>

            <h3>${this.announcement.username}</h3>
        </g:if>

        <g:if test="${this.announcement.phoneNumber}">
            <h2>Phone number:</h2>

            <h3>${this.announcement.phoneNumber}</h3>
        </g:if>

        <g:if test="${this.announcement.finalizationDate}">
            <h2>Finalization date:</h2>
            <g:set var="timeLeft"
                   value="${new AnnouncementController().timesLeft(this.announcement.finalizationDate)}"/>
            <h3>${timeLeft} (<g:formatDate date="${this.announcement.finalizationDate}" format="MMM-dd-yyyy"/>)</h3>
        </g:if>
    </div>


    <div class="image-show">
        <span>move the mouse over the image to change it</span>

        <div class="post">
            <g:if test="${this.announcement.featuredImageBytes}">
                <img src="<g:createLink controller="announcement" action="featuredImage"
                                        id="${this.announcement.id}"/>"/>
            </g:if>
            <g:else>
                <asset:image src="reuso.png"/>
            </g:else>

            <div class="post-s">
                <g:link class="edit" action="editFeaturedImage"
                        resource="${this.announcement}">
                    <button type="button" class="btn btn-outline-dark btn-lg ">Upload new image</button>
                </g:link>
            </div>
        </div>
    </div>
</div>


<div class="container" style="text-align: center">

    <g:link action="sendEmail" id="${this.announcement.id}">
        <button class="btn btn-outline-primary btn-lg ">Contact donor</button>
    </g:link>
    <div class="container" id="show-bottom-buttons">
        <g:form resource="${this.announcement}" method="DELETE" style="margin-right: 5px;">
            <input class="btn btn-danger btn-sm" type="submit"
                   value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                   onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
        </g:form>

        <g:form resource="${this.announcement}" action="edit" controller="announcement" style="margin-left: 5px;">
            <input class="btn btn-warning btn-sm" type="submit"
                   value="${message(code: 'default.button.edit.label', default: 'Edit')}"/>
        </g:form>
    </div>
</div>
</body>
</html>






<%@ page import="exercise.AnnouncementController; java.time.LocalDateTime; exercise.Announcement" %>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <meta name="layout" content="template"/>
    <title>Reyours | Announcements</title>

</head>

<body>

<f:table collection="${announcementsList}" properties="['name']"/>
<div class="container-search">
    <g:form controller="announcement" action="searchResults"
            style="display: flex;  align-items: center; justify-content: center;">
        <g:textField class="textfields searchFieldAnnouncements"
                     name="searchfield"
                     value="${params.searchfield}" placeholder="search by title"/>
        <g:submitButton class="btn btn-outline-primary" name="search"/>
    </g:form>

    <div style="padding-top: 20px;">
        <span>filter by</span>
        <g:link name="filters" action="newest">
            <button type="button" class="btn btn-outline-secondary btn-sm">soonest</button>
        </g:link>
        <g:link
                name="filters" action="oldest">
            <button type="button" class="btn btn-outline-secondary btn-sm">latest</button>
        </g:link>
    </div>
</div>

<div class="container" id="announcement-results">
    <span>${filteredAnnouncements.size()} results</span>

    <g:if test="${filteredAnnouncements}">
        <g:each in="${filteredAnnouncements}">
            <g:link action="show" id="${it.id}" class="card card-hover">
                <div>

                </div>

                <div id="announcement-list-item">

                    <div class="image-list-container">
                        <g:if test="${it.featuredImageBytes}">
                            <img class="card-img-top" alt="Card image cap"
                                 src="<g:createLink controller="announcement" action="featuredImage"
                                                    id="${it.id}"/>"/>
                        </g:if>
                        <g:else>
                            <asset:image src="reuso.png"
                                         class="card-img-top" alt="Card image cap"/>
                        </g:else>
                    </div>

                    <div>
                        <div class="card-body">
                            <div class="card-title">
                                <h3>${it.articleName}</h3>
                            </div>

                            <div class="card-text">
                                <h3>${it.articleDescription}</h3>
                            </div>

                            <div class="card-subtitle">
                                <g:set var="timeLeft"
                                       value="${new AnnouncementController().timesLeft(it.finalizationDate)}"/>
                                <h3><strong>Finalization Date:</strong><span> ${timeLeft}</span></h3>
                            </div>
                        </div>
                    </div>
                </div>
            </g:link>
        </g:each>
    </g:if>
</div>

</body>
</html>
<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Reyours"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="reuso.png" type="image/x-ico"/>

    <asset:stylesheet src="application.css"/>

    <g:layoutHead/>

</head>

<body>

<!-- navigation -->
<nav class="navbar navbar-expand-md navbar-light sticky-top shadow">
    <div class="container-fluid">

        <g:link class="navbar-brand" style="display: inline-block;" controller="home" action="index">
            <div>
                <asset:image src="reuso.png" style="width:30px; height: 30px;"/>
            </div>
        </g:link>

        <button class="navbar-toggler" type="button" data-toggle="collapse"
                data-target="#navbarResponsive">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <g:link class="nav-link" controller="announcement" action="create">Create Announcement</g:link>
                </li>
                <li class="nav-item">
                    <g:link class="nav-link" controller="announcement" action="index">See Announcements</g:link>
                </li>
            </ul>
        </div>
    </div>
</nav>

<g:layoutBody/>

<div class="footer" role="contentinfo">
<span>A Grails Project - 2018</span>
</div>

<div id="spinner" class="spinner" style="display:none;">
    <g:message code="spinner.alt" default="Loading&hellip;"/>
</div>

<asset:javascript src="application.js"/>

</body>
</html>

<%@ page import="exercise.Announcement" %>
<html>
<head>
    <meta name="layout" content="template"/>
    <title>Reyours | Home</title>

    <asset:javascript src="jquery-3.1.1.js"/>
    <script type="text/javascript">
        $(document).ready(function () {
            console.log("jQuery 3.1.1 loaded!");
        });
    </script>

</head>

<body>

<div class="container">

    <h1>Welcome to Reyours</h1>
</div>

<div id="home-newsletter">
    <h2>At the moment there are ${announcementTotal} announcements in the database</h2>

    <g:link controller="announcement" action="index">
        <button class="btn btn-outline-primary btn-lg">See Announcements</button></g:link>

    <g:link controller="announcement" action="create">

        <button class="btn btn-outline-primary btn-lg">Create Announcement</button>
    </g:link>

</div>

<div id="home-showcase">
    <div>
        <h2>Are you new here?</h2>

        <h3>check out our <strong>index.html</strong> in the root project folder to learn about the features of this web application
        </h3>
    </div>

</div>

</body>
</html>
<html>
<head>
    <meta name="layout" content="template"/>
    <title>Reyours | Create Announcement</title>

</head>

<body>

<div class="container">
    <form id="announcementform" action="save" method="post">
        <h1>Create an Announcement</h1>

        <fieldset class="form" style="">
            <g:render template="form"/>
        </fieldset>
        <fieldset style="text-align: right">
            <input
                    type="submit"
                    name="create"
                    class="save btn btn-outline-primary btn-lg"
                    value="Publish"
                    id="create"/>
        </fieldset>
    </form>
</div>
</body>
</html>
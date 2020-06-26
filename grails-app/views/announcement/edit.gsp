<html>
<head>
    <meta name="layout" content="template"/>
    <title>Reyours | Edit Announcement</title>
</head>

<body>

<div class="container">
    <h1>Edit Announcement</h1>
    <g:form method="PUT" action="update">
        <g:hiddenField name="id" value="${this.announcement?.id}" />
        <g:hiddenField name="version" value="${this.announcement?.version}" />
        <fieldset class="form">
            <g:render template="form"/></fieldset>
        <fieldset style="text-align: right">
            <input class="btn btn-outline-primary btn-lg"
                   type="submit"
                   value="${message(code: 'default.button.update.label', default: 'Update')}"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
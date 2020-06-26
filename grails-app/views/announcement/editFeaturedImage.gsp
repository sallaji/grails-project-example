<html xmlns="http://www.w3.org/1999/html">
<head>
    <meta name="layout" content="template"/>
    <title>Reyours | Upload Image</title>

</head>

<body>
<div class="container">
    <h1 style="margin-top: 40px;">Please choose a new image for your announcement</h1>

    <div class="container" style="
    text-align: center;
    margin-top: 100px;
    margin-bottom: 100px;">
        <g:uploadForm name="uploadFeaturedImage" action="uploadFeaturedImage"
                      style="
                  display: flex;
                  justify-content: center;
                  align-items: center;">
            <g:hiddenField name="id" value="${this.announcement?.id}"/>
            <g:hiddenField name="version" value="${this.announcement?.version}"/>
            <input type="file" name="featuredImageFile" class="textfields"/>
            <input class="save btn btn-outline-dark btn-sm"
                   style="margin-left: 5px;"
                   type="submit"
                   value="${message(code: 'announcement.featuredImage.upload.label', default: 'Confirm')}"/>
        </g:uploadForm>
    </div>
</div>
</body>
</html>
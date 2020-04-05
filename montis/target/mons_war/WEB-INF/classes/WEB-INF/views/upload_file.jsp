<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Guru Uploading File</title>
</head>
<body>
File: <br />
<form action="uploadFile" method="post" enctype="multipart/form-data">
    <p>Author name<p/>
    <input type="text" class="text-field" name="authorName" size="50"/>
    <br />
    <p>Author surname<p/>
    <input type="text" class="text-field" name="authorSurName" size="50" />
    <br />
    <p>Author's book name<p/>
    <input type="text" class="text-field" name="authorBookName" size="50" />
    <br />
    <input type="file" class="file" name="file" size="500000" />
    <br />
    <input type="submit" value="Upload" />
</form>

<br/>

<%--String: <br />--%>
<%--<form action="uploadText" method="post"--%>
<%--      enctype="text">--%>
<%--    <input type="text" name="text"/>--%>
<%--    <br />--%>
<%--    <input type="submit" value="Upload" />--%>
<%--</form>--%>

</body>
</html>
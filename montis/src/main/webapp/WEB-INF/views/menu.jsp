<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.util.Random" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <title>MENU</title>
</head>
<body>

<c:set var="rand"><%= new Random().nextBoolean() %></c:set>
<c:set var="firstColor"><%= "" %></c:set>
<c:set var="secondColor"><%= "" %></c:set>

<c:choose>
    <c:when test = "${rand}">
        <c:set var="firstColor"><%= "beige" %></c:set>
        <c:set var="secondColor"><%= "cadetblue" %></c:set>
    </c:when>

    <c:otherwise>
        <c:set var="secondColor"><%= "beige" %></c:set>
        <c:set var="firstColor"><%= "cadetblue" %></c:set>
    </c:otherwise>
</c:choose>

<h1 STYLE="color: <c:out value="${firstColor}"/>">MENU</h1>
<br/>



<div  style="background-color: <c:out value= "${firstColor}"/>; height: 370px; width: 900px; border-radius:3px">
    <h2>Information for : <%= session.getAttribute("name")%></h2>
    <p>Now is <%= LocalDate.now().toString()%></p>
    <p>Your addres is <%= request.getRemoteAddr()%> and port is <%= request.getRemotePort()%></p>
    <p>and host is <%= request.getRemoteHost()%></p>
    <p>Session id <%= session.getId()%></p>
    <p>Last session date <%= new Date(session.getLastAccessedTime())%></p>
    <p>Is session new <%= session.isNew()%></p>
    <p>Session creation date <%= new Date(session.getCreationTime())%></p>
</div>

<br />
<div  style="background-color: <c:out value= "${secondColor}"/>; height: 200px; width: 300px; margin-left: 200px; border-radius:3px;">
    <a href="getUpload">Upload file</a>
    <br/>
    <a href="saveWord">Save word</a>

</div>


<br/>

<a></a>
<br/>

<a></a>
<br/>
</body>
</html>
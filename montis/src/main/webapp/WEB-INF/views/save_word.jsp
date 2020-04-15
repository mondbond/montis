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

<h1 STYLE="color: <c:out value="${firstColor}"/>">UPLOAD FILE</h1>
<br/>


<div  style="background-color: <c:out value= "${firstColor}"/>; height: 200px; width: 300px; margin-left: 200px; border-radius:3px;">

    <form action="saveWord" method="post" enctype="application/x-www-form-urlencoded">
        <input type="text" class="text-input" name="word" size="5000" style="width: 100px"/>
        <br />
        <input type="submit" value="Save word" />
    </form>
    <p>
        Next words updated:
    </p>
    <p>
        <c:out value='${saved}' />
    </p>

</div>
<br />
<div  style="background-color: <c:out value= "${secondColor}"/>; height: 200px; width: 300px; margin-left: 200px; border-radius:3px;">
    <a href="home">Go home</a>
</div>


<br/>

<a></a>
<br/>

<a></a>
<br/>
</body>
</html>
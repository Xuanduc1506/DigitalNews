<%-- 
    Document   : left
    Created on : May 11, 2021, 8:10:42 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.12.0.min.js"></script>
        <script src="js/pagging.js" type="text/javascript"></script>
        <link href="css/right.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="right">
            <div class="newsTitle"><b>Digital News</b></div>
            <div class="shortContent">${dig.shortContent}</div>
            <form id="form" name="formSearch" action="Search" method="GET"  > 
                <div class="searchTitle">Search</div>
                <input class="searchText" type="text" name="search" value="${title.trim()}" id="s" required="required" pattern="[ ]{0,10}[A-Za-z0-9]+"> 
                <input class="searchButton" type="submit" value="Go">
                <!--<input class="searchButton" type="button" value="Go" onclick="required1()">-->
            </form>
            <div class="lastArticles">
                <div class="lastArticlesTitle">Last Articles</div>
             
                <c:forEach items="${digitals}" var="d">
                        <a href="Detail?id=${d.id}">${d.title}</a><br>
                </c:forEach>
            </div>
        </div>
    </body>
</html>

<script>
    $("#form").keypress(
        function (event) {
            if (event.which == '13') {
                var empt = document.getElementById("s").value;
                if (empt.trim() == "")
                {
                    alert("Please input a Value");
                     event.preventDefault();
                }
            }
        });
</script>


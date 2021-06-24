<%-- 
    Document   : Detail
    Created on : May 12, 2021, 3:50:02 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="page">
            <jsp:include page="Header.jsp"/>
            <div class="body">
                <div class="news">
                    <div class="title"><b>${dig.title}</b></div>
                    <div class="pic"> <img src="img/${dig.image}"></div>
                    <div class="content">${dig.content}</div>
                    <div class="horizontal"> </div>
                    <div class="authDate"><img src="img/timeicon.gif"> <img src="img/comment.gif"> ${dig.author} | ${dig.date}</div>
                </div>
                    <div class="vertical"> </div>
                    <jsp:include page="Right.jsp"/>
            </div>
                    <jsp:include page="Footer.jsp"/>
        </div>
    </body>
</html>

<%-- 
    Document   : Error
    Created on : May 17, 2021, 3:05:36 PM
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
                    <div class="title"><b>${message}</b></div>
                </div>
                    <div class="vertical"> </div>
                    <jsp:include page="Right.jsp"/>
            </div>
                    <jsp:include page="Footer.jsp"/>
        </div>
    </body>
</html>

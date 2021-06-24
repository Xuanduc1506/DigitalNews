<%-- 
    Document   : Search
    Created on : May 12, 2021, 6:25:24 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <script src="js/pagging.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="page">
            <jsp:include page="Header.jsp"/>
            <div class="body">
                <div class="news">
                    <c:forEach items="${digitalSearch}" var="d">
                        <div class="title"><a href="Detail?id=${d.id}"><b>${d.title}</b></a><br></div>
                        <div class="content">${d.shortContent}</div>
                    </c:forEach>
                        <div id="bottomPagger" class="pagger">
                            <c:if test="${totalpage < 1}">
                            <h3>Not Found !!</h3>
                        </c:if>
                        <c:if test="${totalpage > 1}">
                            <c:forEach begin="1" end="${totalpage}" var="i">
                                <a class="${i==pageindex?"active":""}" href="Search?page=${i}&search=${title.trim()}">${i}</a>
                            </c:forEach>
                        </c:if>
                        </div>
<!--                    <script>
                        renderPager("bottomPagger", ${requestScope.pageindex}, ${requestScope.totalpage}, 2, ${requestScope.title});
                    </script>-->
                </div>
                <div class="vertical"> </div>
                <jsp:include page="Right.jsp"/>
            </div>
            <jsp:include page="Footer.jsp"/>
        </div>
    </body>
</html>

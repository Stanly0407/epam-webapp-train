<%@ page contentType="text/html;charset=utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<body>

<div class="header">
    <jsp:include page="view/fragments/header.jsp"/>
</div>


<div class="container" align="center">


    <c:if test="${name != null}">
        <b>Hello, ${name}!</b>
    </c:if>
    <c:if test="${errorMessage != null}">
        <div style="color: red">
                ${errorMessage}
        </div>
    </c:if>
</div>

</body>
</html>

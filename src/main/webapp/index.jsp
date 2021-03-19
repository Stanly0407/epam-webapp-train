<%@ page contentType="text/html;charset=utf-8" isELIgnored="false" %>

<html>

<body>

<div class="header">
    <jsp:include page="WEB-INF/view/fragments/header.jsp"/>
</div>

<div class="container-login">
    <form action="/epam-first-web/controller?command=login" method="post">
<%--    <form action="/epam-first-web/controller" method="post">--%>
<%--        <input type="hidden" name="command" value="login"/>--%>

        <div class="common-label"><label for="username">Username</label></div>
        <input class="common-input" type="text" id="username" placeholder="Enter Username" name="username" required/>
        <br/><br/>

        <div class="common-label"><label for="password">Password</label></div>
        <input class="common-input" type="password" id="password" placeholder="Enter Password" name="password" required>
        <br/>
        <button class="button-main" type="submit">Login</button>
    </form>
</div>


</body>
</html>

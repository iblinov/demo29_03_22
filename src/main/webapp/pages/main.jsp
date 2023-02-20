
<%@ page contentType="text/html;charset=UTF-8"  pageEncoding="utf-8"  %>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> --%>
<fmt:setLocale value="${locale}" />
<fmt:setBundle basename="prop.message"  />
<fmt:message key="label.welcome" var="label" />
<html>
<head>
 <%-- <c:set var="path" value="${pageContext.request.contextPath}"/> --%>
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet"/>
    <title>Main</title>
</head>
<body>
<hr/>
${label}
<hr/>
${label}
Hello (forward) = ${user}
<hr/>
Hi (redirect/forward) = ${user_name}
<hr/>
${filter_attr}
<hr/>
<hr/>
<hr/>
${request.getParameter("abc")}
<hr/>
<form action="controller">
    <input type="hidden" name="command" value="logout"/>
    <input type="submit" value="logOut"/>
</form>
</body>
</html>

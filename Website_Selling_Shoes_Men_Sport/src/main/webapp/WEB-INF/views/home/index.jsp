<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zxx" class="no-js">

<head>
    <%@ include file="../home/common/head.jsp" %>
</head>

<body>

<!-- Start Header Area -->

<%@ include file="../home/common/header.jsp" %>

<jsp:include page="${view}"/>

<!-- start footer Area -->
<%@ include file="../home/common/footer.jsp" %>

<!-- End footer Area -->

<%@include file="common/script.jsp" %>
</body>

</html>
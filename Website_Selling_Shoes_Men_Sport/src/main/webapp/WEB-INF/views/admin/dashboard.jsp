<%@ page pageEncoding="utf-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<br>
<!DOCTYPE html>
<html lang="en">

<head>

    <%@include file="common-admin/head.jsp" %>
    <link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" />
    <script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>
</head>

<body>

<!-- ======= Header ======= -->
<%@include file="common-admin/header.jsp" %>
<!-- End Header -->

<%@include file="common-admin/aside.jsp" %>

<main id="main" class="main">

    <section class="section dashboard">
        <div class="row">

            <!-- Left side columns -->
            <jsp:include page="${view}"/>
            <!-- End Right side columns -->

        </div>
    </section>

</main><!-- End #main -->

<!-- ======= Footer ======= -->
<%@include file="common-admin/footer.jsp" %>
<!-- End Footer -->


<%@include file="common-admin/script.jsp" %>

</body>

</html>
<%@ page pageEncoding="utf-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<br>
<div class="container">


    <a href="/admin/mau-sac/hien-mau-sac" class="btn btn-primary"><i class="bi bi-arrow-return-left"></i></a>
    <a href="/admin/mau-sac/view-add" class="btn btn-primary"><i class="bi bi-plus-circle-fill"></i></a>

    <br>
    <br>
    <div class="row">

        <form:form action="/mau-sac/search" modelAttribute="searchForm" method="get">
            <div class="input-group mb-3"><form:input type="text" path="keyword" class="form-control"
                                                      placeholder="Nhập mã hoặc tên màu sắc..."
                                                      aria-describedby="button-addon2"></form:input>
                <button class="btn btn-success"  type="submit" id="button-addon2">Search</button>
            </div>
        </form:form>

    </div>
    <br>
    <table class="table table-bordered">
        <thead class="table table-danger">
        <tr>
            <th>#</th>
            <th style="display: none;">ID</th>
            <th>Mã Màu Sắc</th>
            <th>Tên Màu</th>
            <th>Ngày Tạo</th>
            <th>Ngày cập nhật Cuối</th>
            <th>Trạng Thái</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.getContent()}" var="mausac" varStatus="i">
            <tr>
                <td>${i.index+1}</td>
                <td style="display: none;">${mausac.id}</td>
                <td>${mausac.ma}</td>
                <td>${mausac.tenMau}</td>
                <td>${mausac.createDate}</td>
                <td>${mausac.lastModifiledDate}</td>
                <td>${mausac.trangThai == 0 ? "Còn màu sắc":"Hết màu sắc"}</td>
                <td>

                    <a href="/admin/mau-sac/view-update/${mausac.id}" class="btn btn-warning"><i class="bi bi-pencil-square"></i></a>
                    <a href="/admin/mau-sac/delete/${mausac.id}" class="btn btn-danger"><i class="bi bi-trash3-fill"></i></a>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="text-center">
        <nav aria-label="Page navigation example" class="text-center">
            <ul class="pagination justify-content-center">
                <li class="page-item"><a class="page-link" href="/mau-sac/hien-mau-sac?p=0">Previous</a></li>
                <li class="page-item"><a class="page-link" href="/mau-sac/hien-mau-sac?p=${page.number-1}"><<</a></li>
                <li class="page-item"><a class="page-link" href="/mau-sac/hien-mau-sac?p=${page.number+1}">>></a></li>
                <li class="page-item"><a class="page-link" href="/mau-sac/hien-mau-sac?p=${page.totalPages-1}">Next</a>
                </li>
            </ul>
        </nav>
    </div>
</div>


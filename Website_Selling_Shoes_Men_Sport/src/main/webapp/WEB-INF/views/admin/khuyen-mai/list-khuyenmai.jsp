<%@ page pageEncoding="utf-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<br>
<div class="container">


    <a href="/admin/khuyen-mai/hien-khuyen-mai" class="btn btn-primary"><i class="bi bi-house-fill"></i></a>
    <a href="/admin/khuyen-mai/view-add" class="btn btn-primary"><i class="bi bi-plus-circle-fill"></i></a>

    <br>
    <br>
    <div class="row">

        <form:form action="/khuyen-mai/search" modelAttribute="searchForm" method="get">
            <div class="input-group mb-3"><form:input type="text" path="keyword" class="form-control"
                                                      placeholder="Nhập mã hoặc tên đế giầy..."
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
            <th>Mã Khuyến Nãi</th>
            <th>Tên Khuyến Mãi</th>
            <th>Giá Trị</th>
            <th>Loại Khuyến Mãi</th>
            <th>Ngày Bắt Đầu</th>
            <th>Ngày Kết Thúc</th>
            <th>Ngày Tạo</th>
            <th>Ngày Cập Nhật Cuối</th>
            <th>Trạng Thái</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.getContent()}" var="khuyenmai" varStatus="i">
            <tr>
                <td>${i.index+1}</td>
                <td style="display: none;">${khuyenmai.id}</td>
                <td>${khuyenmai.maKhuyenMai}</td>
                <td>${khuyenmai.tenKhuyenMai}</td>
                <td>${khuyenmai.giaTri}</td>
                <td>${khuyenmai.loaiKhuyenMai}</td>
                <td>${khuyenmai.ngayBatDau}</td>
                <td>${khuyenmai.ngayKetThuc}</td>
                <td>${khuyenmai.createDate}</td>
                <td>${khuyenmai.lastModifiledDate}</td>
                <td>${khuyenmai.trangThai == 0 ? "Còn khuyến mãi":"Hết khuyến mãi"}</td>
                <td>

                    <a href="/admin/khuyen-mai/view-update/${khuyenmai.id}" class="btn btn-warning"><i class="bi bi-pencil-square"></i></a>
                    <a href="/admin/khuyen-mai/delete/${khuyenmai.id}" class="btn btn-danger"><i class="bi bi-trash3-fill"></i></a>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="text-center">
        <nav aria-label="Page navigation example" class="text-center">
            <ul class="pagination justify-content-center">
                <li class="page-item"><a class="page-link" href="/khuyen-mai/hien-khuyen-mai?p=0">Previous</a></li>
                <li class="page-item"><a class="page-link" href="/khuyen-mai/hien-khuyen-mai?p=${page.number-1}"><<</a></li>
                <li class="page-item"><a class="page-link" href="/khuyen-mai/hien-khuyen-mai?p=${page.number+1}">>></a></li>
                <li class="page-item"><a class="page-link" href="/khuyen-mai/hien-khuyen-mai?p=${page.totalPages-1}">Next</a>
                </li>
            </ul>
        </nav>
    </div>
</div>


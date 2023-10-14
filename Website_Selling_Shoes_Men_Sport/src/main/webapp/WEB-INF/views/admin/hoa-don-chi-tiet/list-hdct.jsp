<%@ page pageEncoding="utf-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<br>

<div class="pagetitle">
    <h1>Data Tables</h1>
    <nav>
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="/admin/hoa-don-chi-tiet/hien-thi">Quản Lý Hoá Đơn Chi Tiết</a></li>

            <li class="breadcrumb-item active">Danh Sách Hóa Đơn Chi Tiết</li>
        </ol>
    </nav>
</div>
<!-- End Page Title -->
<br>

<section class="section">
    <div class="row">
        <div class="col-lg-12">

            <div class="card">
                <div class="card-body">

                    <!-- Table with stripped rows -->
                    <div class="row">
                        <div class="col-md-4 col-sm-4 col-lg-4">
                            <h5 class="card-title">Danh Sách Hóa Đơn Chi Tiết</h5>
                        </div>
                        <div class="col-md-6 col-sm-6 col-lg-6">
                            <form:form action="/admin/hoa-don-chi-tiet/search" modelAttribute="searchForm" method="post">
                                <div class="input-group mb-3"><form:input type="text" path="keyword"
                                                                          class="form-control"
                                                                          placeholder="Nhập số lượng..."
                                                                          aria-describedby="button-addon2"></form:input>
                                    <button class="btn btn-success" type="button" id="button-addon2">Tìm kiếm</button>
                                </div>
                            </form:form>
                        </div>
                        <div class="col-md-2 col-sm-2 col-lg-2"><a href="/admin/hoa-don-chi-tiet/view-add" class="btn btn-primary"><i
                                class="bi bi-plus-square-dotted"></i>Thêm mới</a>
                        </div>
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead class="table table-danger">
                        <tr>
                            <th>#</th>
                            <th>ID</th>
<%--                            <td>Id Hoa Don</td>--%>
<%--                            <td>Id Chi Tiet SP</td>--%>
                            <th>Số Lượng</th>
                            <th>Đơn Giá</th>
                            <th>Giá Bán</th>
                            <th>Giảm Giá Khuyến Mại</th>
                            <th>Ngày Tạo</th>
                            <th>Ngày cập nhật</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${page.getContent()}" var="hdct" varStatus="i">
                            <tr>
                                <td>${i.index+1}</td>
                                <td>${hdct.id}</td>
                                <td>${hdct.soLuong}</td>
                                <td>${hdct.donGia}</td>
                                <td>${hdct.giaBan}</td>
                                <td>${hdct.giamGiaKhuyenMai}</td>
                                <td>${hdct.createDate}</td>
                                <td>${hdct.lastModifiedDate}</td>
                                <td>
                                    <a href="/admin/hoa-don-chi-tiet/view-update/${hdct.id}" class="btn btn-warning"><i
                                            class="bi bi-pencil-square"></i></a>
                                    <a href="/admin/hoa-don-chi-tiet/delete/${hdct.id}" class="btn btn-danger"><i class="bi bi-trash3-fill"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                </div>

            </div>
        </div>
    </div>
</section>
<div class="text-center">
    <nav aria-label="Page navigation example" class="text-center">
        <ul class="pagination justify-content-center">
            <li class="page-item"><a class="page-link" href="/admin/hoa-don-chi-tiet/hien-thi?p=0">Previous</a></li>
            <li class="page-item"><a class="page-link" href="/admin/hoa-don-chi-tiet/hien-thi?p=${page.number-1}"><<</a></li>
            <li class="page-item"><a class="page-link" href="/admin/hoa-don-chi-tiet/hien-thi?p=${page.number+1}">>></a></li>
            <li class="page-item"><a class="page-link" href="/admin/hoa-don-chi-tiet/hien-thi?p=${page.totalPages-1}">Next</a>
            </li>
        </ul>
    </nav>
</div>

<%@ page pageEncoding="utf-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<br>

<div class="pagetitle">

    <nav>
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="/admin/san-pham/hien-thi">Quản Lý Sản Phẩm</a></li>

            <li class="breadcrumb-item active">Danh Sách sản Phẩm</li>
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
                    <div class="row">
                        <div class="col-lg-2 col-md-2 col-sm-2">
                            <a href="/admin/san-pham/view-add"
                               class="btn btn-primary"><i
                                    class="bi bi-plus-square-dotted"></i>Thêm mới</a>
                        </div>
                        <div class="col-lg-10 col-md-8 col-sm-6">
                            <form:form action="/admin/san-pham/search" modelAttribute="searchForm" method="post">
                            <div class="search">
                                <div class="row">
                                    <div class="col-lg-4 col-md-4 col-sm-2">
                                        <form:input placeholder="Tìm kiếm theo mã hoặc tên sản phẩm" path="keyword"
                                                    cssClass="form-control"/>
                                    </div>
                                    <div class="col-lg-2 col-md-2 col-sm-2">
                                        <button type="submit" class="btn btn-primary btn-search">Tìm kiếm</button>
                                    </div>
                                    <div class="col-4 col-md-4 col-sm-2">
                                        <a href="/chi-tiet-san-pham/hien-thi" class="btn"
                                           style="background: #0d6efd; color: whitesmoke"><i class="bi bi-eye-fill"></i>Danh sách
                                            chi tiết</a>
                                        <br>
                                    </div>
                                </div>
                            </div>
                        </div>
                        </form:form>
                    </div>
                    <!-- Table with stripped rows -->
                    <div class="row">
                        <div class="col-md-4 col-sm-4 col-lg-4">
                            <h5 class="card-title">Danh sách sản phẩm</h5>
                        </div>
                    </div>

                    <table class="table table-bordered">
                        <thead class="table table-danger">
                        <tr>
                            <th>#</th>
                            <th>Mã Sản Phẩm</th>
                            <th>Tên Sản Phẩm</th>
                            <th>Ngày Tạo</th>
                            <th>Ngày cập nhật</th>
                            <th>Trạng Thái</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${page.getContent()}" var="sp" varStatus="i">
                            <tr>
                                <td>${i.index+1}</td>
                                <td>${sp.maSanPham}</td>
                                <td>${sp.tenSanPham}</td>
                                <td>${sp.createDate}</td>
                                <td>${sp.lastModifiedDate}</td>
                                <td>${sp.trangThai == 0 ? "Còn sản phẩm":"Hết sản phẩm"}</td>
                                <td>

                                    <a href="/admin/san-pham/view-update/${sp.id}" class="btn btn-warning"><i
                                            class="bi bi-pencil-square">Sửa</i></a>

                                    <a href="/chi-tiet-san-pham/list-san-pham/${sp.id}" class="btn btn-danger"><i
                                            class="bi bi-eye-fill"></i></a>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <!-- End Table with stripped rows -->

                </div>
            </div>

        </div>
    </div>
</section>
<div class="text-center">
    <nav aria-label="Page navigation example" class="text-center">
        <ul class="pagination justify-content-center">
            <li class="page-item"><a class="page-link" href="/admin/san-pham/hien-thi?p=0">Previous</a></li>
            <li class="page-item"><a class="page-link" href="/admin/san-pham/hien-thi?p=${page.number-1}"><<</a></li>
            <li class="page-item"><a class="page-link" href="/admin/san-pham/hien-thi?p=${page.number+1}">>></a></li>
            <li class="page-item"><a class="page-link" href="/admin/san-pham/hien-thi?p=${page.totalPages-1}">Next</a>
            </li>
        </ul>
    </nav>
</div>


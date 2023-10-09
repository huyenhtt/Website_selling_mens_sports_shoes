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
            <li class="breadcrumb-item"><a href="/admin/kich-co/hien-thi">Quản Lý Kích Cỡ</a></li>

            <li class="breadcrumb-item active">Danh Sách Kích Cỡ</li>
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
                        <div class="col-lg-2 col-md-4 col-sm-2">
                            <a href="/admin/kich-co/view-add"
                               class="btn btn-primary"><i
                                    class="bi bi-plus-square-dotted"></i>Thêm mới</a>
                        </div>
                        <div class="col-lg-8 col-md-6 col-sm-8">
                            <form:form action="/admin/kich-co/search" modelAttribute="searchForm" method="post">
                                <div class="input-group mb-3"><form:input type="text" path="keyword"
                                                                          class="form-control"
                                                                          placeholder="Nhập mã hoặc loại size giầy..."
                                                                          aria-describedby="button-addon2"></form:input>
                                    <button class="btn btn-success" type="button" id="button-addon2">Search</button>
                                </div>
                            </form:form></div>

                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead class="table table-danger">
                        <tr>
                            <th>#</th>
                            <th>Mã Kích Cỡ</th>
                            <th>Size</th>
                            <th>Loại Size</th>
                            <th>Giới tính</th>
                            <th>Ngày tạo</th>
                            <th>Ngày cập nhật</th>
                            <th>Trạng Thái</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${page.getContent()}" var="kc" varStatus="i">
                            <tr>
                                <td>${i.index+1}</td>

                                <td>${kc.maKichCo}</td>
                                <td>${kc.size}</td>
                                <td>${kc.loaiSize}</td>
                                <td>${kc.gioiTinh == true ? "Nam" : "Nữ"}</td>
                                <td>${kc.createDate}</td>
                                <td>${kc.lastModifiedDate}</td>
                                <td>${kc.trangThai == 0 ? "Còn sản phẩm":"Hết sản phẩm"}</td>
                                <td>

                                    <a href="/admin/kich-co/view-update/${kc.id}" class="btn btn-warning"><i
                                            class="bi bi-pencil-square"></i></a></td>
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
            <li class="page-item"><a class="page-link" href="/admin/kich-co/hien-thi?p=0">Previous</a></li>
            <li class="page-item"><a class="page-link" href="/admin/kich-co/hien-thi?p=${page.number-1}"><<</a></li>
            <li class="page-item"><a class="page-link" href="/admin/kich-co/hien-thi?p=${page.number+1}">>></a></li>
            <li class="page-item"><a class="page-link" href="/admin/kich-co/hien-thi?p=${page.totalPages-1}">Next</a>
            </li>
        </ul>
    </nav>
</div>


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
            <li class="breadcrumb-item"><a href="/dashboard">Quản Lý Kích Cỡ</a></li>

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
                        <div class="col-md-4 col-sm-4 col-lg-4">
                            <h5 class="card-title">Danh sách kích cỡ</h5>
                        </div>
                        <form:form action="/admin/kich-co/search" modelAttribute="searchForm" method="post">
                            <div class="input-group mb-3"><form:input type="text" path="keyword" class="form-control"
                                                                      placeholder="Nhập mã hoặc loại size giầy..."
                                                                      aria-describedby="button-addon2"></form:input>
                                <button class="btn btn-success" type="button" id="button-addon2">Search</button>
                            </div>
                        </form:form>

                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead class="table table-danger">
                        <tr>
                            <th>#</th>
                            <th>ID</th>
                            <th>Mã Kích Cỡ/th>
                            <th>Size</th>
                            <th>Loại Size</th>
                            <th>Giới tính</th>
                            <th>Ngày cập nhật</th>
                            <th>Trạng Thái</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${page.getContent()}" var="kc" varStatus="i">
                            <tr>
                                <td>${i.index+1}</td>
                                <td>${kc.id}</td>
                                <td>${kc.maKichCo}</td>
                                <td>${kc.size}</td>
                                <td>${kc.Loaisize}</td>
                                <td>${kc.gioiTinh == true ? "Nam" : "Nữ"}</td>
                                <td>${kc.createDate}</td>
                                <td>${kc.lastModifiedDate}</td>
                                <td>${kc.trangThai == 0 ? "Còn sản phẩm":"Hết sản phẩm"}</td>
                                <td>

                                    <a href="/admin/kich-co/view-update/${kc.id}" class="btn btn-warning"><i
                                            class="bi bi-pencil-square"></i></a> class="bi bi-trash3-fill"></i></a>--%>
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

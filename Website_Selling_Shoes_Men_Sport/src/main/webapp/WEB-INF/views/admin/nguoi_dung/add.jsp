<%@ page pageEncoding="utf-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<br>
<div class="container">


    <a href="/admin/mau-sac/hien-mau-sac" class="btn btn-primary"><i class="bi bi-house-fill"></i></a>
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

        <thead  class="table table-danger">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Mã</th>
            <th scope="col">Họ Và Tên</th>
            <th scope="col">Giới Tính</th>
            <th scope="col">Ngày Sinh</th>
            <th scope="col">Địa Chỉ</th>
            <th scope="col">Số Điện Thoại</th>
            <th scope="col">Email</th>
            <th scope="col">Create Date</th>
            <th scope="col">Last Modified Date</th>
            <th scope="col">Trạng Thái</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach varStatus="i" var="nd" items="${lstNd}">
            <tr>
                <th scope="row">${i.index+1}</th>
                <td>${nd.ma}</td>
                <td>${nd.ho} ${nd.tenDem} ${nd.ten}</td>
                <td>${nd.gioiTinh==true ?"Nam":"Nữ"}</td>
                <td>${nd.ngaySinh}</td>
                <td>${nd.diaChi}</td>
                <td>${nd.soDienThoai}</td>
                <td>${nd.email}</td>
                <td>${nd.createDate}</td>
                <td>${nd.lastModifiedDate}</td>
                <td>${nd.trangThai}</td>

                <td style="display: flex">
                    <button type="button" class="btn btn-primary"><a style="color: #cccccc" href="/admin/nguoi-dung/update/${nd.id}">Update</a></button>
                    <button type="button" class="btn btn-danger"><a style="color: #cccccc" href="/admin/nguoi-dung/delete/${nd.id}">Delete</a></button>
                </td>
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


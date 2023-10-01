<%@ page pageEncoding="utf-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<br>
<br>
<div class="container">
    <div class="row">
        <div class="col-6 col-md-6 col-sm-6">
            <a href="/admin/khuyen-mai/hien-khuyen-mai" class="btn btn-primary"><i class="bi bi-house-fill"></i></a>
            <br>
        </div>

    </div>
    <form:form action="${action}" modelAttribute="khuyenMai" >
        <form:input path="id" class="form-control" type="hidden"/>

        <div class="mb-3">
            <label class="form-label">Mã Khuyến Mãi</label>
            <form:input path="maKhuyenMai" class="form-control"/>
            <form:errors path="maKhuyenMai" cssStyle="color: crimson"/>
        </div>

        <div class="mb-3">
            <label class="form-label">Tên Khuyến Mãi</label>
            <form:input path="tenKhuyenMai" class="form-control"/>
            <form:errors path="tenKhuyenMai" cssStyle="color: crimson"/>
        </div>
        <div class="mb-3">
            <label class="form-label">Giá Trị</label>
            <form:input path="giaTri" class="form-control"/>
            <form:errors path="giaTri" cssStyle="color: crimson"/>
        </div>
        <div class="mb-3">
            <label class="form-label">Loại Khuyến Mãi</label>
            <form:input path="loaiKhuyenMai" class="form-control"/>
            <form:errors path="loaiKhuyenMai" cssStyle="color: crimson"/>
        </div>
        <div class="mb-3">
            <label class="form-label">Ngày Bắt Đầu</label>
            <form:input path="ngayBatDau" class="form-control"/>
            <form:errors path="ngayBatDau" cssStyle="color: crimson"/>
        </div>
        <div class="mb-3">
            <label class="form-label">Ngày Kết Thúc</label>
            <form:input path="ngayKetThuc" class="form-control"/>
            <form:errors path="ngayKetThuc" cssStyle="color: crimson"/>
        </div>
        <div class="mb-3">
            <label class="form-label">Trạng Thái</label>
            <form:radiobuttons items="${dsTrangThai}" path="TrangThai" class="form-check-input"/>
            <form:errors path="trangThai" cssStyle="color: crimson"/>
        </div>
        <div class="text-center">
            <button type="submit" class="btn btn-success" onclick="return confirm('Bạn có chắc muốn thực hiện ?');">
                Submit
            </button>
        </div>
    </form:form>
    <div class="text-center" style="color: crimson">${mess}</div>
</div>
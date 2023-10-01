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
            <a href="/admin/de-giay/hien-de-giay" class="btn btn-primary"><i class="bi bi-house-fill"></i></a>
            <br>
        </div>

    </div>
    <form:form action="${action}" modelAttribute="deGiay" >
        <form:input path="id" class="form-control" type="hidden"/>

        <div class="mb-3">
            <label class="form-label">Mã Đế Giầy</label>
            <form:input path="ma" class="form-control"/>
            <form:errors path="ma" cssStyle="color: crimson"/>
        </div>


        <div class="mb-3">
            <label class="form-label">Loại Đế</label>
            <form:input path="loaiDe" class="form-control"/>
            <form:errors path="loaiDe" cssStyle="color: crimson"/>
        </div>
        <div class="mb-3">
                    <label class="form-label">Mô tả</label>
                    <form:input path="moTa" class="form-control"/>
                    <form:errors path="moTa" cssStyle="color: crimson"/>
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
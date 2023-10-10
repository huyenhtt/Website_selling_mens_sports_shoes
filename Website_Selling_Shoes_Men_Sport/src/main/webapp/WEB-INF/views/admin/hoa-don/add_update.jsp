<%@ page pageEncoding="utf-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<br>
<%----%>

<div class="pagetitle">

    <nav>
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="/dashboard">Quản Lý Hoá Đơn</a></li>

            <li class="breadcrumb-item active">Hóa Đơn</li>
        </ol>
    </nav>
</div>
<!-- End Page Title -->

<section class="section">
    <div class="row">
        <div class="col-lg-12">

            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Thêm/sửa hóa đơn</h5>

                    <!-- Table with stripped rows -->
                    <form:form action="${action}" modelAttribute="hoaDon">
                        <form:input path="id" class="form-control" type="hidden"/>

                        <div class="mb-3">
                            <label class="form-label">Mã hóa đơn: </label>
                            <form:input path="MaHD" class="form-control"/>
                            <form:errors path="MaHD" cssStyle="color: crimson"/>
                        </div>


                        <div class="mb-3">
                            <label class="form-label">Địa chỉ: </label>
                            <form:input path="diaChi" class="form-control"/>
                            <form:errors path="diaChi" cssStyle="color: crimson"/>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Hình thức thanh toán: </label>
                            <form:radiobuttons items="${dsHinhThucThanhoan}" path="hinhThucThanhToan" class="form-check-input"/>
                            <form:errors path="hinhThucThanhToan" cssStyle="color: crimson"/>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Hình thức giao hàng: </label>
                            <form:radiobuttons items="${dsHinhThucGiaoHang}" path="hinhThucGiaoHang" class="form-check-input"/>
                            <form:errors path="hinhThucGiaoHang" cssStyle="color: crimson"/>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">SDT người nhận: </label>
                            <form:input path="sdtNguoiNhan" class="form-control"/>
                            <form:errors path="sdtNguoiNhan" cssStyle="color: crimson"/>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">SDT người ship: </label>
                            <form:input path="sdtNguoiShip" class="form-control"/>
                            <form:errors path="sdtNguoiShip" cssStyle="color: crimson"/>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Tên người nhận: </label>
                            <form:input path="tenNguoiNhan" class="form-control"/>
                            <form:errors path="tenNguoiNhan" cssStyle="color: crimson"/>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Trạng Thái: </label>
                            <form:radiobuttons items="${dsTrangThai}" path="trangThai" class="form-check-input"/>
                            <form:errors path="trangThai" cssStyle="color: crimson"/>
                        </div>
                        <div class="text-center">
                            <button type="submit" class="btn btn-success"
                                    onclick="return confirm('Bạn có chắc muốn thực hiện ?');">
                                Submit
                            </button>
                        </div>
                    </form:form>
                    <div class="text-center" style="color: crimson">${mess}</div>
                    <!-- End Table with stripped rows -->

                </div>
            </div>

        </div>

    </div>
</section>

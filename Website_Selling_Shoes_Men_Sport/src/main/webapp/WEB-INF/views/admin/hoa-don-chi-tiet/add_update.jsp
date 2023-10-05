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
            <li class="breadcrumb-item"><a href="/admin/hoa-don-chi-tiet/hien-thi">Quản Lý Hóa Đơn Chi Tiết</a></li>

            <li class="breadcrumb-item active">Hóa Đơn Chi Tiết</li>
        </ol>
    </nav>
</div>
<!-- End Page Title -->

<section class="section">
    <div class="row">
        <div class="col-lg-12">

            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Thêm/sửa hóa đơn chi tiết</h5>

                    <!-- Table with stripped rows -->
                    <form:form action="${action}" modelAttribute="hoaDonChiTiet">
                        <form:input path="id" class="form-control" type="hidden"/>

                        <div class="mb-3">
                            <label class="form-label">Số lượng: </label>
                            <form:input path="soLuong" class="form-control"/>
                            <form:errors path="soLuong" cssStyle="color: crimson"/>
                        </div>


                        <div class="mb-3">
                            <label class="form-label">Đơn giá: </label>
                            <form:input path="donGia" class="form-control"/>
                            <form:errors path="donGia" cssStyle="color: crimson"/>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Giá bán: </label>
                            <form:input path="giaBan" class="form-control"/>
                            <form:errors path="giaBan" cssStyle="color: crimson"/>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Giảm giá khuyến mại: </label>
                            <form:input path="giamGiaKhuyenMai" class="form-control"/>
                            <form:errors path="giamGiaKhuyenMai" cssStyle="color: crimson"/>
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
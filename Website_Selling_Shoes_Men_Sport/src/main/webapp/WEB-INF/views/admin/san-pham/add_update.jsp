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
            <li class="breadcrumb-item"><a href="/admin/san-pham/hien-thi">Quản Lý Sản Phẩm</a></li>

            <li class="breadcrumb-item active">Sản Phẩm</li>
        </ol>
    </nav>
</div>
<!-- End Page Title -->

<section class="section">
    <div class="row">
        <div class="col-lg-12">

            <div class="card">
                <div class="card-body">
                    <form:form action="${action}" modelAttribute="sanPham">
                        <form:input path="id" class="form-control" type="hidden"/>

                        <div class="mb-3">
                            <label class="form-label">Mã Sản Phẩm</label>
                            <form:input path="maSanPham" class="form-control"/>
                            <form:errors path="maSanPham" cssStyle="color: crimson"/>
                        </div>


                        <div class="mb-3">
                            <label class="form-label">Tên Sản Phẩm</label>
                            <form:input path="tenSanPham" class="form-control"/>
                            <form:errors path="tenSanPham" cssStyle="color: crimson"/>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Trạng Thái</label>
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
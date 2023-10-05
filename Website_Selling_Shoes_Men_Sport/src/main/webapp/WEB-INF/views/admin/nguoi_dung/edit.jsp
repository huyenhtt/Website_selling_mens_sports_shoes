<%@ page pageEncoding="utf-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<br>
    <section class="section">
        <div class="row">
            <div class="col-lg-10">

                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Thêm Mới Tài Khoản</h5>

                        <!-- General Form Elements -->
                        <form:form modelAttribute="nd" action="/admin/nguoi-dung/add">
                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">Mã</label>
                                <div class="col-sm-10">
                                    <form:input path="ma" cssClass="form-control" ></form:input>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">Họ</label>
                                <div class="col-sm-10">
                                    <form:input path="ho" cssClass="form-control"></form:input>
                                </div>
                            </div>


                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">Tên Đệm</label>
                                <div class="col-sm-10">
                                    <form:input path="tenDem" cssClass="form-control"></form:input>
                                </div>
                            </div>

                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">Tên</label>
                                <div class="col-sm-10">
                                    <form:input path="ten" cssClass="form-control"></form:input>
                                </div>
                            </div>


                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">Giới Tính</label>
                                <div class="col-sm-10">
                                    <form:radiobutton path="gioiTinh" cssClass="form-check-input" label="Nam" value="true"></form:radiobutton>
                                    <form:radiobutton path="gioiTinh" cssClass="form-check-input" label="Nữ" value="false"></form:radiobutton>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">Ngày Sinh</label>
                                <div class="col-sm-10">
                                    <form:input path="ngaySinh" type="date" cssClass="form-control"></form:input>
                                </div>
                            </div>


                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">Địa Chỉ</label>
                                <div class="col-sm-10">
                                    <form:input path="diaChi" cssClass="form-control"></form:input>
                                </div>
                            </div>

                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">Số Điện Thoại</label>
                                <div class="col-sm-10">
                                    <form:input path="soDienThoai" cssClass="form-control"></form:input>
                                </div>
                            </div>

                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">Email</label>
                                <div class="col-sm-10">
                                    <form:input path="email" cssClass="form-control" tyle="email"></form:input>
                                </div>
                            </div>

                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">Trạng Thái</label>
                                <div class="col-sm-10">
                                    <form:select path="trangThai" cssClass="form-select">
                                        <form:option value="1" label="Hoạt Đông"></form:option>
                                        <form:option value="0" label="Ngủ"></form:option>
                                    </form:select>
                                </div>
                            </div>

                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label"></label>
                                <div class="col-sm-10">
                                    <button type="submit" class="btn btn-primary">Thêm Mới</button>
                                </div>
                            </div>

                        </form:form><!-- End General Form Elements -->

                    </div>
                </div>

            </div>

        </div>
    </section>



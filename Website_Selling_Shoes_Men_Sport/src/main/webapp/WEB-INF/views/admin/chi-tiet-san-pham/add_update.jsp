<%@ page pageEncoding="utf-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">


<link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" />
<script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>
</br>
<style>
    .container-sm {
        margin: 0;
        padding: 0;
        background-color: #D9D9D9;

    }

    .item-right {
        padding-top: 20px;
    }

    #but {
        background-color: #1492AE;
        border-radius: 0;
        border: none;
        width: 100px;
    }


    .left {
        width: 45%;
        padding-left: 20px;
    }

    .item {
        float: left;
    }

    .ite {
        float: left;
    }


    .inp input {
        border: none;
        width: 280px;
        border-radius: 15px;
    }

    .right {
        width: 27%;
        margin-right: 150px;
    }

    .form {
        display: flex;
        justify-content: space-between;
    }


    .img input {
        background-color: white;
    }

    .item input {
        margin-top: 20px;
    }


    .item-right select {
        height: 30px;
        margin-top: 20px;
        width: 150px;
        border: none

    }

</style>
<div class="pagetitle">

    <nav>
        <ol class="breadcrumb">
            <li class="breadcrumb-item "><a href="/chi-tiet-san-pham/hien-thi">Chi Tiết Sản Phẩm</a></li>

            <li class="breadcrumb-item active">Thêm sửa chi tiết sản phẩm</li>
        </ol>
    </nav>
</div>
<!-- End Page Title -->
<div class="container-sm">
    <h2 style="text-align: center;padding-top: 20px;margin-bottom: 20px">Thêm/Sửa Chi Tiết Sản Phẩm</h2>
    <form:form action="${action}" modelAttribute="sanpham" cssClass="text-center" enctype="multipart/form-data">
        <form:input path="id" class="form-control" type="hidden"/>
        <div class="form">
            <div class="left">
                <div class="item inp">
                    <label class="form-label">Tên sản phẩm: </label>
                    <form:input path="sanPham" class="form-control" type="hidden"/>

                    <form:input path="sanPham.tenSanPham" value="${tensp}" readonly="true"/>
                </div>
                <div class="item inp">
                    <label class="form-label">Giá Bán: </label>
                    <form:input path="giaBan" cssStyle="margin-left: 50px"/>
                    <form:errors path="giaBan" cssStyle="color: crimson"/>
                </div>

                <div class="item inp">
                    <label class="form-label">Số lượng: </label>
                    <form:input path="soLuong" cssStyle="margin-left: 44px"/>
                    <form:errors path="soLuong" cssStyle="color: crimson"/>
                </div>
                <div class="item">
                    <label class="form-label">Mô tả: </label>
                    <form:textarea cols="50" rows="5" path="moTaCT"
                                   cssStyle="border: none; width: 280px;height: 100px;border-radius: 15px;margin-left: 65px;margin-top: 20px"/>
                    <form:errors path="moTaCT" cssStyle="color: crimson"/>
                </div>

                <div class="item form-check-inline">
                    <label class="form-label">Trạng Thái</label>
                    <form:radiobuttons items="${dsTrangThai}" path="trangThai" class="form-check-input"
                                       cssStyle="margin-right: 15px;margin-left: 20px;"/>
                    <form:errors path="trangThai" cssStyle="color: crimson"/>
                </div>
            </div>
            <div class="right ">
                <div class="item-right">
                    <label class="form-label">Loại giầy: </label>
                    <form:select type="text" id="searchName" path="loaiGiay">
                        <form:option value="">Chọn loại giầy</form:option>
                        <form:options items="${listLoaiGiay}" itemLabel="tenTheLoai" itemValue="id"/>
                    </form:select>
                    <span> <form:errors path="loaiGiay" cssStyle="color: crimson"/></span>
                    <a data-bs-toggle="modal" data-bs-target="#exampleModal"><i class="bi bi-plus-circle-fill"></i></a>

                </div>

                <div class="item-right">
                    <label class="form-label">Kích cỡ: </label>
                    <form:select type="text" id="searchName1" path="kichCo" cssClass=".searchName1">
                        <form:option value="">Chọn kích cỡ</form:option>
                        <form:options items="${listKichCo}" itemLabel="size" itemValue="id"/>
                    </form:select>
                    <span> <form:errors path="kichCo" cssStyle="color: crimson"/></span>
                    <a data-bs-toggle="modal" data-bs-target="#exampleModal2"><i class="bi bi-plus-circle-fill"></i></a>
                </div>
                <div class="item-right">
                    <label class="form-label">Màu sắc: </label>
                    <form:select type="text" id="searchName2" path="mauSac" cssClass=".searchName2">
                        <form:option value="">Chọn màu sắc</form:option>
                        <form:options items="${listMau}" itemLabel="tenMau" itemValue="id"/>
                    </form:select>
                    <span> <form:errors path="mauSac" cssStyle="color: crimson"/></span>
                    <a data-bs-toggle="modal" data-bs-target="#exampleModal3"><i class="bi bi-plus-circle-fill"></i></a>

                </div>
                <div class="item-right">
                    <label class="form-label">Chất liệu: </label>
                    <form:select type="text" id="searchName4" path="chatLieu">
                        <form:option value="">Chọn chất liệu</form:option>
                        <form:options items="${listChatLieu}" itemLabel="tenChatLieu" itemValue="id"/>
                    </form:select>
                    <span> <form:errors path="chatLieu" cssStyle="color: crimson"/></span>
                    <a data-bs-toggle="modal" data-bs-target="#exampleModal4"><i class="bi bi-plus-circle-fill"></i></a>
                </div>
                <div class="item-right">
                    <label class="form-label">Đế giầy: </label>
                    <form:select type="text" id="searchName3" path="deGiay" cssClass=".searchName4">
                        <form:option value="">Chọn đế giầy</form:option>
                        <form:options items="${listDeGiay}" itemLabel="loaiDe" itemValue="id"/>
                    </form:select>
                    <span> <form:errors path="deGiay" cssStyle="color: crimson"/></span>

                    <a data-bs-toggle="modal" data-bs-target="#exampleModal5"><i class="bi bi-plus-circle-fill"></i></a>
                </div>
            </div>
        </div>
        <div class="text-center" style="padding-bottom: 20px">
            <button type="submit" id="but" class="btn btn-success"
                    onclick="return confirm('Bạn có chắc muốn thực hiện ?');">
                Submit
            </button>
        </div>
    </form:form>

    <%--    modal--%>
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form:form modelAttribute="lg" method="post" action="${action4}">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">Thêm Loại Giầy</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div class="input" style="">
                            <p>Mã:</p>
                            <form:input path="ma" class="form-control"/>
                        </div>
                        <form:errors path="ma"/>
                        <div style="margin-left: 10px;color: red">${errorMa}</div>
                        <div class="input">
                            <p>Loại giày:</p>
                            <form:input path="tenTheLoai" class="form-control"/>

                        </div>
                        <form:errors path="tenTheLoai"/>
                        <div style="margin-left: 10px;color: red">${errorTen}</div>
                        <div class="mb-3 form-check-inline ">
                            <label class="form-label">Trạng Thái</label>
                            <form:radiobuttons items="${dsTrangThai}" path="trangThai" class="form-check-input"/>
                            <form:errors path="trangThai" cssStyle="color: crimson"/>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close
                        </button>
                        <button type="submit" class="btn btn-primary">
                            Submit
                        </button>
                    </div>
                </form:form>
            </div>

        </div>
    </div>
    <%--    modal2--%>
    <div class="modal fade" id="exampleModal2" tabindex="-1" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form:form modelAttribute="kichco" action="${action2}">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel2">Thêm kích cỡ</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                            aria-label="Close"></button>
                </div>
                <div class="modal-body">
                        <%--                    <form:input path="id" class="form-control" type="hidden"/>--%>
                    <div class="mb-3">
                        <label class="form-label">Mã Kích Cỡ: </label>

                        <form:input path="maKichCo" class="form-control"/>
                        <span id="maKichCoError" class="text-danger"></span>
                        <form:errors path="maKichCo" cssStyle="color: crimson"/>
                    </div>
                    <div class="mb-3 form-check-inline">
                        <label class="form-label">Giới Tính</label>
                        <form:radiobuttons items="${dsGioiTinh}" path="gioiTinh" class="form-check-input"/>
                        <form:errors path="gioiTinh" cssStyle="color: crimson"/>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Size</label>
                        <form:input path="size" class="form-control"/>
                        <form:errors path="size" cssStyle="color: crimson"/>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Loại size</label>
                        <form:input path="loaiSize" class="form-control"/>
                        <form:errors path="loaiSize" cssStyle="color: crimson"/>
                    </div>

                    <div class="mb-3 form-check-inline">
                        <label class="form-label">Trạng Thái</label>
                        <form:radiobuttons items="${dsTrangThai}" path="trangThai" class="form-check-input"/>
                        <form:errors path="trangThai" cssStyle="color: crimson"/>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close
                        </button>
                        <button type="submit" class="btn btn-primary">
                            Submit
                        </button>
                    </div>
                    </form:form>
                </div>

            </div>
        </div>
    </div>
    <%--    modal3--%>
    <div class="modal fade" id="exampleModal3" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form:form modelAttribute="ms" action="${action3}">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel3">Thêm màu sắc</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div class="mb-3">
                            <label> Mã</label>
                            <form:input class="form-control" path="ma"/>
                            <form:errors path="ma"/>
                        </div>
                        <br>
                        <div class="mb-3">
                            <label> Tên</label>
                            <form:input class="form-control" path="tenMau"/>
                            <form:errors path="tenMau"/>
                        </div>
                        <div class="mb-3 form-check-inline ">
                            <label class="form-label">Trạng Thái</label>
                            <form:radiobuttons items="${dsTrangThai}" path="trangThai" class="form-check-input"/>
                            <form:errors path="trangThai" cssStyle="color: crimson"/>
                        </div>

                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close
                        </button>
                        <button type="submit" class="btn btn-primary">
                            Submit
                        </button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>

    <div class="modal fade" id="exampleModal4" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form:form modelAttribute="vm" action="${action6}">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel4">Thêm chất liệu</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div id="ma">
                            <label>Mã</label>
                            <form:input path="maChatLieu" class="form-control"/> <br/>
                            <form:errors path="maChatLieu" cssStyle="color: red"/>
                        </div>
                        <div id="ten">
                            <label>Tên</label>
                            <form:input path="tenChatLieu" class="form-control"/> <br/>
                            <form:errors path="tenChatLieu" cssStyle="color: red"/>
                        </div>
                        <div id="tt" class="form-check-inline">
                            <label>Trạng Thái</label>
                            <form:radiobutton class="form-check-input" path="trangThai" value="1" checked="true"/>HĐ
                            <form:radiobutton class="form-check-input" path="trangThai" value="0"/>Ngưng HĐ
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close
                        </button>
                        <button type="submit" class="btn btn-primary">
                            Submit
                        </button>
                    </div>
                </form:form>
            </div>

        </div>
    </div>
    <%--    modal4--%>
    <div class="modal fade" id="exampleModal5" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form:form modelAttribute="degiay" action="${action5}">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel5">Thêm đế giầy</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                            aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <label for="inputEmail3" class="col-sm-2 col-form-label">Mã</label>
                    <div class="mb-3">
                        <form:input type="text" class="form-control" id="inputEmail3" path="ma"/>
                        <form:errors path="ma" cssStyle="color: crimson"></form:errors>
                            ${mess_Ma}
                    </div>

                    <label for="inputEmail3" class="col-sm-2 col-form-label">Loại đế</label>
                    <div class="mb-3">
                        <form:input type="text" class="form-control" id="inputEmail3" path="loaiDe"/>
                        <form:errors path="loaiDe" cssStyle="color: crimson"></form:errors>
                    </div>

                    <label for="inputEmail3" class="col-sm-2 col-form-label">Trạng thái</label>
                    <div class="mb-3 form-check-inline">
                        <form:radiobuttons items="${dsTrangThai}" path="trangThai" class="form-check-input"/>
                        <form:errors path="trangThai" cssStyle="color: crimson"></form:errors>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close
                        </button>
                        <button type="submit" class="btn btn-primary">
                            Submit
                        </button>
                    </div>
                    </form:form>
                </div>

            </div>
        </div>
    </div>
</div>
<div class="text-center" style="color: crimson">${mess}</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
        integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
        crossorigin="anonymous"></script>

<script src="../../../../../webapp/js/chi-tiet-san-pham.js"></script>
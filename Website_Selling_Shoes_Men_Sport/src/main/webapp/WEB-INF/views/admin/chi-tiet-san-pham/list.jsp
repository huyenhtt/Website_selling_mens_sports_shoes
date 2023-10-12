<%@ page pageEncoding="utf-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">

<link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet"/>
<script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>
<br>
<br>
<div class="container">
    <%--    <div class="row-cols-6">--%>
    <%--        <select type="text" id="searchName"></select>--%>
    <%--    </div>--%>
    <div class="row">
        <div class="col-6 col-md-6 col-sm-6">
            <h3>Danh sách chi tiết sản phẩm</h3>
        </div>
        <div class="col-6 col-md-6 col-sm-6">

            <form:form action="/chi-tiet-san-pham/search" modelAttribute="searchForm">
                <div class="row">
                    <div class="col-2 col-md-2 col-sm-5">
                        <button class="btn" type="submit" style="background: #0d6efd; color: whitesmoke">Search</button>
                    </div>
                    <div class="col-8 col-md-8 col-sm-7">
                        <form:input path="keyword" class="form-control" placeholder="Nhập mã hoặc loại tên sản phẩm"/>
                    </div>
                </div>
            </form:form>
        </div>
        </br>
        <br>
        <br>
        <div class="row" style="padding-bottom: 30px">
            <div class="col-2 col-md-2 col-sm-2">
                <form:form modelAttribute="lg" action="/chi-tiet-san-pham/search-by-loaigiay">
                    <label class="form-label">Loại giầy: </label>
                    <form:select type="text" id="searchName" path="idLG" onchange="submit()" cssClass="form-control">
                        <form:option value="">Tất cả</form:option>
                        <form:options items="${listLoaiGiay}" itemLabel="tenTheLoai" itemValue="id"/>
                    </form:select>

                </form:form>
            </div>

            <div class="col-2 col-md-2 col-sm-2">
                <form:form modelAttribute="searchChatLieu" action="/chi-tiet-san-pham/search-by-chatlieu">
                    <label class="form-label">Chất liệu: </label>
                    <form:select type="text" id="searchName4" path="idChatLieu" onchange="submit()"
                                 cssClass="form-control">
                        <form:option value="">Tất cả</form:option>
                        <form:options items="${listChatLieu}" itemLabel="tenChatLieu" itemValue="id"/>
                    </form:select>

                </form:form>
            </div>

            <div class="col-2 col-md-2 col-sm-2">
                <form:form action="/chi-tiet-san-pham/search-by-degiay" modelAttribute="searchDG">
                    <label class="form-label">Đế giày: </label>
                    <form:select type="text" id="searchName3" path="idDe" onchange="submit()" cssClass="form-control">
                        <form:option value="">Tất cả</form:option>
                        <form:options items="${listDeGiay}" itemLabel="loaiDe" itemValue="id"/>
                    </form:select>

                </form:form>
            </div>
            <div class="col-2 col-md-2 col-sm-2">
                <form:form action="/chi-tiet-san-pham/search-by-kichco" modelAttribute="searchKC">

                    <label class="form-label">Kích cỡ: </label>
                    <form:select type="text" id="searchName1" path="idKC" onchange="submit()" cssClass="form-control">
                        <form:option value="">Tất cả</form:option>
                        <form:options items="${listKichCo}" itemLabel="size" itemValue="id"/>
                    </form:select>

                </form:form>
            </div>
            <div class="col-2 col-md-2 col-sm-2">
                <form:form action="/chi-tiet-san-pham/search-by-mausac" modelAttribute="searchFormByMau">

                    <label class="form-label">Màu sắc:</label>
                    <form:select type="text" id="searchName2" path="idMau" onchange="submit()" cssClass="form-control">
                        <form:option value="">Tất cả</form:option>
                        <form:options items="${listMau}" itemLabel="tenMau" itemValue="id"/>
                    </form:select>

                </form:form>
            </div>
            </br>

            <div class="col-2 col-md-2 col-sm-2">
                <form:form action="/chi-tiet-san-pham/sort" modelAttribute="sortForm">
                    <label class="form-label">Sắp xếp:</label>
                    <form:select path="key" onchange="submit()" class="form-control">
                        <option value="0">---</option>
                        <form:option value="giaBan">Đơn giá</form:option>

                    </form:select>
                </form:form>
            </div>
        </div>

        <table class="table table-bordered">

            <tr class="table-danger">
                <th>STT</th>
                <th>Mã sản phẩm</th>
                <th>Tên sản phẩm</th>
                <th>Giá Bán</th>
                <th>Số lượng</th>
                <th>Trạng Thái</th>
                <th>Mô Tả Chi tiết</th>
                <th>Action</th>
            </tr>

            <tbody>
            <c:forEach items="${page.content}" var="sp" varStatus="i">
                <tr>
                    <td>${i.index+1}</td>
                    <td>${sp.sanPham.maSanPham}</td>
                    <td>${sp.sanPham.tenSanPham}</td>
                    <td><fmt:formatNumber value="${sp.giaBan}" maxFractionDigits="20" type="number"/></td>

                    <td>${sp.soLuong}</td>
                    <td>${sp.trangThai==0?"Hoạt động":"Không hoạt động"}</td>
                    <td>${sp.moTaCT}</td>
                    <td>
                        <a href="/chi-tiet-san-pham/view-update/${sp.id}" class="btn btn-warning"><i
                                class="bi bi-pencil-square"></i></a>
                        <a href="/chi-tiet-san-pham/hinh-anh/view-add/${sp.id}" class="btn btn-warning"><i
                                class="bi bi-file-earmark-image"></i></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="text-center">
            <nav aria-label="Page navigation text-center">
                <ul class="pagination justify-content-center">
                    <li class="page-item"><a class="page-link" href="/chi-tiet-san-pham/hien-thi?p=0">Previous</a></li>
                    <li class="page-item"><a class="page-link"
                                             href="/chi-tiet-san-pham/hien-thi?p=${page.number-1}"><<</a></li>
                    <li class="page-item"><a class="page-link"
                                             href="/chi-tiet-san-pham/hien-thi?p=${page.number+1}">>></a></li>
                    <li class="page-item"><a class="page-link"
                                             href="/chi-tiet-san-pham/hien-thi?p=${page.totalPages-1}">Next</a></li>
                </ul>
            </nav>
        </div>
    </div>
    <script>
        function submitForm() {
            document.getElementById('searchMauSac').submit();
        }
    </script>

</div>
<script src="../../../../../webapp/js/chi-tiet-san-pham.js"></script>

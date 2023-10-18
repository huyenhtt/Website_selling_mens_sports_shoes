<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="zxx" class="no-js">

<head>
    <%@include file="common/head.jsp" %>
</head>

<body id="category">

<%--<!-- Start Header Area -->--%>
<%@include file="common/header.jsp" %>
<%--<!-- End Header Area -->--%>

<!-- Start Banner Area -->
<section class="banner-area organic-breadcrumb">
    <div class="container">
        <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
            <div class="col-first">
                <h1>Shop Category page</h1>
                <nav class="d-flex align-items-center">
                    <a href="/user/home">Home<span class="lnr lnr-arrow-right"></span></a>
                    <a href="#">Shop<span class="lnr lnr-arrow-right"></span></a>
                    <a href="/user/category">Fashon Category</a>
                </nav>
            </div>
        </div>
    </div>
</section>
<!-- End Banner Area -->
<div class="container">
    <div class="row">
        <div class="col-xl-3 col-lg-4 col-md-5">
            <div class="sidebar-categories">

                <div class="head">Loại Giầy</div>
                <%--                <form action="/bumblebee/product_list/searchbyloaigiay">--%>
                <ul class="main-categories">
                    <li class="main-nav-list">
                        <a href="/user/category">All<span> (${soLuongSP})</span></a>
                    </li>
                    <c:forEach items="${listLoaiGiay}" var="lg">
                        <li class="main-nav-list">
                            <a href="/user/category/searchbyloaigiay?idLoaiGiayList=${lg.id}">${lg.tenTheLoai}</a>
                        </li>
                    </c:forEach>

                </ul>
                <%--                </form>--%>
            </div>
            <div class="sidebar-filter mt-50">
                <div class="top-filter-head">Lọc sản phẩm</div>
                <div class="common-filter">
                    <div class="head">Kích cỡ</div>
                    <%--                    <form action="#">--%>
                    <%--                        <ul>--%>
                    <%--                            <c:forEach items="${listKC}" var="kc">--%>
                    <%--                                <li class="filter-list"><input class="pixel-radio" type="radio" id="apple"--%>
                    <%--                                                               name="brand"> <a--%>
                    <%--                                        href="/user/category/searchbykichco?idLoaiGiayList=${lg.id}">${lg.tenTheLoai}</a>--%>
                    <%--                                </li>--%>

                    <%--                            </c:forEach>--%>
                    <%--                        </ul>--%>
                    <%--                    </form>--%>
                    <table class="table ps-table--size table-bordered">
                        <tbody class="table-bordered">
                        <c:forEach var="kc" items="${listKC}" varStatus="loop">
                            <c:if test="${loop.index % 5 == 0}">
                                <tr>
                            </c:if>
                            <td><a href="/user/category/searchbykichco/${kc.id}">${kc.size}</a></td>
                            <c:if test="${loop.index % 5 == 4 or loop.last}">
                                </tr>
                            </c:if>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="common-filter">
<%--                    <div class="head">Màu sắc</div>--%>
<%--                    <form action="#">--%>
<%--                        <ul>--%>
<%--                            <c:forEach var="ms" items="${listMS}">--%>
<%--                                <li class="filter-list">--%>
<%--                                    <a href="javascript:void(0);" onclick="handleColorSelection('${ms.id}');">--%>
<%--                                            ${ms.tenMau}--%>
<%--                                        <input class="pixel-radio" type="radio" id="${ms.id}" name="color" style="display: none;">--%>
<%--                                    </a>--%>
<%--                                    <label for="${ms.id}">${ms.tenMau}<span>(29)</span></label>--%>
<%--                                </li>--%>
<%--                            </c:forEach>--%>
<%--                        </ul>--%>
<%--                    </form>--%>

                    <div class="head">Màu sắc</div>
                    <form action="#">
                        <ul>
                            <c:forEach var="ms" items="${listMS}">
                                <li class="filter-list">
                                    <a href="/user/category/searchbymausac?idMS=${ms.id}">
                                        <input class="pixel-radio" type="radio" id="black"
                                               name="color"><label
                                            for="black">${ms.tenMau}</label></a></li>
                            </c:forEach>
                        </ul>
                    </form>
                </div>
                <div class="common-filter">
                    <div class="head">Price</div>
                    <div class="price-range-area">
                        <form method="GET" action="/user/category/searchbygiaban">
                            <form:form modelAttribute="searchFormByGiaban">
                                <form:input path="minPrice" placeholder="Từ"></form:input>
                                <span><form:input path="maxPrice" placeholder="Đến"></form:input></span>
                                <button class="ac-slider__filter ps-btn" type="submit"
                                        style="background-color: #37517E; color: whitesmoke ; margin-top: 10px">Tìm kiếm
                                </button>
                            </form:form>
                        </form>

                    </div>
                </div>
            </div>
        </div>
        <div class="col-xl-9 col-lg-8 col-md-7">
            <!-- Start Filter Bar -->
            <div class="filter-bar d-flex flex-wrap align-items-center">
                <div class="sorting mr-auto">

                    <form:form modelAttribute="sortForm" action="/user/category/sort">
                        <form:select id="mySelect" path="key" onchange="this.form.submit()">
                            <form:option value="" label="Sắp xếp theo"/>
                            <form:option value="sanPham.tenSanPham" label="Tên sản phẩm"/>
                            <form:option value="giaBan" label="Tăng dần theo giá"/>
                        </form:select>
                    </form:form>

                </div>
                <div class="pagination">
                    <a href="#" class="prev-arrow"><i class="fa fa-long-arrow-left" aria-hidden="true"></i></a>

                    <c:forEach begin="0" end="${listCTSP.totalPages - 1 >= 0 ? listCTSP.totalPages - 1 : 0}"
                               varStatus="loop">
                        <li class="page-item">
                            <a href="/user/category?page=${loop.begin + loop.count - 1}">
                                    ${loop.begin + loop.count }
                            </a>
                        </li>
                    </c:forEach>
                    <a href="#" class="next-arrow"><i class="fa fa-long-arrow-right" aria-hidden="true"></i></a>
                </div>
            </div>
            <!-- End Filter Bar -->
            <!-- Start Best Seller -->
            <section class="lattest-product-area pb-40 category-list">
                <div class="row">
                    <!-- single product -->
                    <c:forEach items="${ listCTSP.content }" var="sp">
                        <div class="col-lg-4 col-md-6">
                            <div class="single-product">
                                <img class="img-fluid" src="../../../uploads/${sp.hinhAnhs.tenanh}" alt="">
                                <div class="product-details">
                                    <h6>${sp.sanPham.tenSanPham}</h6>
                                    <div class="price">
                                        <h6>$ ${sp.giaBan}</h6>
                                        <h6 class="l-through">$210.00</h6>
                                    </div>
                                    <div class="prd-bottom">

                                        <a href="/user/cart" class="social-info">
                                            <span class="ti-bag"></span>
                                            <p class="hover-text">add to bag</p>
                                        </a>

                                        <a href="/user/product-detail/${sp.id}" class="social-info">
                                            <span class="lnr lnr-move"></span>
                                            <p class="hover-text">view more</p>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                </div>
            </section>
            <!-- End Best Seller -->
            <!-- Start Filter Bar -->
            <div class="filter-bar d-flex flex-wrap align-items-center">
                <div class="sorting mr-auto">

                    <form:form modelAttribute="sortForm" action="/user/category/sort">
                        <form:select id="mySelect" path="key" onchange="this.form.submit()">
                            <form:option value="" label="Sắp xếp theo"/>
                            <form:option value="sanPham.tenSanPham" label="Tên sản phẩm"/>
                            <form:option value="giaBan" label="Tăng dần theo giá"/>
                        </form:select>
                    </form:form>

                </div>
                <div class="pagination">
                    <a href="#" class="prev-arrow"><i class="fa fa-long-arrow-left" aria-hidden="true"></i></a>

                    <c:forEach begin="0" end="${listCTSP.totalPages - 1 >= 0 ? listCTSP.totalPages - 1 : 0}"
                               varStatus="loop">
                        <li class="page-item">
                            <a href="/user/category?page=${loop.begin + loop.count - 1}">
                                    ${loop.begin + loop.count }
                            </a>
                        </li>
                    </c:forEach>
                    <a href="#" class="next-arrow"><i class="fa fa-long-arrow-right" aria-hidden="true"></i></a>
                </div>
            </div>
            <!-- End Filter Bar -->
        </div>
    </div>
</div>

<!-- Start related-product Area -->
<section class="related-product-area section_gap">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-6 text-center">
                <div class="section-title">
                    <h1>Deals of the Week</h1>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
                        labore et dolore
                        magna aliqua.</p>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-9">
                <div class="row">
                    <c:forEach items="${listCTSP.content}" var="sp">
                        <div class="col-lg-4 col-md-4 col-sm-6 mb-20">
                            <div class="single-related-product d-flex">
                                <a href="#"><img src="../../../uploads/${sp.hinhAnhs.tenanh}" alt="" width="100"
                                                 height="100"></a>
                                <div class="desc">
                                    <a href="/user/product-detail/${sp.id}" class="title">${sp.sanPham.tenSanPham}</a>
                                    <div class="price">
                                        <h6>$ ${sp.giaBan}</h6>
                                        <h6 class="l-through">$210.00</h6>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <div class="col-lg-3">
                <div class="ctg-right">
                    <a href="#" target="_blank">
                        <img class="img-fluid d-block mx-auto" src="../../../img/category/c5.jpg" alt="">
                    </a>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- End related-product Area -->

<!-- start footer Area -->

<%@include file="common/footer.jsp" %>
<!-- End footer Area -->

<!-- Modal Quick Product View -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="container relative">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
            <div class="product-quick-view">
                <div class="row align-items-center">
                    <div class="col-lg-6">
                        <div class="quick-view-carousel">
                            <div class="item" style="background: url(../../../img/organic-food/q1.jpg);">

                            </div>
                            <div class="item" style="background: url(../../../img/organic-food/q1.jpg);">

                            </div>
                            <div class="item" style="background: url(../../../img/organic-food/q1.jpg);">

                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="quick-view-content">
                            <div class="top">
                                <h3 class="head">Mill Oil 1000W Heater, White</h3>
                                <div class="price d-flex align-items-center"><span class="lnr lnr-tag"></span> <span
                                        class="ml-10">$149.99</span></div>
                                <div class="category">Category: <span>Household</span></div>
                                <div class="available">Availibility: <span>In Stock</span></div>
                            </div>
                            <div class="middle">
                                <p class="content">Mill Oil is an innovative oil filled radiator with the most modern
                                    technology. If you are
                                    looking for something that can make your interior look awesome, and at the same time
                                    give you the pleasant
                                    warm feeling during the winter.</p>
                                <a href="#" class="view-full">View full Details <span
                                        class="lnr lnr-arrow-right"></span></a>
                            </div>
                            <div class="bottom">
                                <div class="color-picker d-flex align-items-center">Color:
                                    <span class="single-pick"></span>
                                    <span class="single-pick"></span>
                                    <span class="single-pick"></span>
                                    <span class="single-pick"></span>
                                    <span class="single-pick"></span>
                                </div>
                                <div class="quantity-container d-flex align-items-center mt-15">
                                    Quantity:
                                    <input type="text" class="quantity-amount ml-15" value="1"/>
                                    <div class="arrow-btn d-inline-flex flex-column">
                                        <button class="increase arrow" type="button" title="Increase Quantity"><span
                                                class="lnr lnr-chevron-up"></span></button>
                                        <button class="decrease arrow" type="button" title="Decrease Quantity"><span
                                                class="lnr lnr-chevron-down"></span></button>
                                    </div>

                                </div>
                                <div class="d-flex mt-20">
                                    <a href="/user/cart" class="view-btn color-2"><span>Add to Cart</span></a>
                                    <a href="#" class="like-btn"><span class="lnr lnr-layers"></span></a>
                                    <a href="#" class="like-btn"><span class="lnr lnr-heart"></span></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="common/script.jsp" %>
<%--<script>--%>
<%--    function handleColorSelection(id) {--%>
<%--        var radio = document.getElementById(id);--%>
<%--        radio.checked = true;--%>
<%--        var resultDiv = document.getElementById('result');--%>
<%--        resultDiv.textContent = 'Bạn đã chọn màu: ' + radio.id;--%>
<%--        window.location.href = '/user/category/searchbymausac?idMS=' + id;--%>
<%--    }--%>
<%--</script>--%>
</body>

</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zxx" class="no-js">

<head>
    <%@include file="common/head.jsp" %>
</head>

<body id="category">

<!-- Start Header Area -->
<%@include file="common/header.jsp" %>
<!-- End Header Area -->

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
                <div class="head">Browse Categories</div>
                <ul class="main-categories">
                    <c:forEach items="${listLG}" var="lg">
                        <li class="main-nav-list"><a href="#">Pest Control<span class="number">(24)</span></a></li>
                    </c:forEach>
                    <li class="main-nav-list"><a data-toggle="collapse" href="#officeProduct" aria-expanded="false"
                                                 aria-controls="officeProduct"><span
                            class="lnr lnr-arrow-right"></span>Office Products<span class="number">(77)</span></a>
                        <ul class="collapse" id="officeProduct" data-toggle="collapse" aria-expanded="false"
                            aria-controls="officeProduct">
                            <li class="main-nav-list child"><a href="#">Frozen Fish<span class="number">(13)</span></a>
                            </li>
                            <li class="main-nav-list child"><a href="#">Dried Fish<span class="number">(09)</span></a>
                            </li>
                            <li class="main-nav-list child"><a href="#">Fresh Fish<span class="number">(17)</span></a>
                            </li>
                            <li class="main-nav-list child"><a href="#">Meat Alternatives<span
                                    class="number">(01)</span></a></li>
                            <li class="main-nav-list child"><a href="#">Meat<span class="number">(11)</span></a></li>
                        </ul>
                    </li>

                </ul>
            </div>
            <div class="sidebar-filter mt-50">
                <div class="top-filter-head">Product Filters</div>
                <div class="common-filter">
                    <div class="head">Brands</div>
                    <form action="#">
                        <ul>
                            <li class="filter-list"><input class="pixel-radio" type="radio" id="apple"
                                                           name="brand"><label
                                    for="apple">Apple<span>(29)</span></label></li>
                            <li class="filter-list"><input class="pixel-radio" type="radio" id="asus"
                                                           name="brand"><label for="asus">Asus<span>(29)</span></label>
                            </li>
                            <li class="filter-list"><input class="pixel-radio" type="radio" id="gionee"
                                                           name="brand"><label
                                    for="gionee">Gionee<span>(19)</span></label></li>
                            <li class="filter-list"><input class="pixel-radio" type="radio" id="micromax"
                                                           name="brand"><label for="micromax">Micromax<span>(19)</span></label>
                            </li>
                            <li class="filter-list"><input class="pixel-radio" type="radio" id="samsung"
                                                           name="brand"><label
                                    for="samsung">Samsung<span>(19)</span></label></li>
                        </ul>
                    </form>
                </div>
                <div class="common-filter">
                    <div class="head">Color</div>
                    <form action="#">
                        <ul>
                            <li class="filter-list"><input class="pixel-radio" type="radio" id="black"
                                                           name="color"><label
                                    for="black">Black<span>(29)</span></label></li>
                            <li class="filter-list"><input class="pixel-radio" type="radio" id="balckleather"
                                                           name="color"><label for="balckleather">Black
                                Leather<span>(29)</span></label></li>
                            <li class="filter-list"><input class="pixel-radio" type="radio" id="blackred"
                                                           name="color"><label for="blackred">Black
                                with red<span>(19)</span></label></li>
                            <li class="filter-list"><input class="pixel-radio" type="radio" id="gold"
                                                           name="color"><label for="gold">Gold<span>(19)</span></label>
                            </li>
                            <li class="filter-list"><input class="pixel-radio" type="radio" id="spacegrey" name="color"><label
                                    for="spacegrey">Spacegrey<span>(19)</span></label></li>
                        </ul>
                    </form>
                </div>
                <div class="common-filter">
                    <div class="head">Price</div>
                    <div class="price-range-area">
                        <div id="price-range"></div>
                        <div class="value-wrapper d-flex">
                            <div class="price">Price:</div>
                            <span>$</span>
                            <div id="lower-value"></div>
                            <div class="to">to</div>
                            <span>$</span>
                            <div id="upper-value"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xl-9 col-lg-8 col-md-7">
            <!-- Start Filter Bar -->
            <div class="filter-bar d-flex flex-wrap align-items-center">
                <div class="sorting">
                    <select>
                        <option value="1">Default sorting</option>
                        <option value="1">Default sorting</option>
                        <option value="1">Default sorting</option>
                    </select>
                </div>
                <div class="sorting mr-auto">
                    <select>
                        <option value="1">Show 12</option>
                        <option value="1">Show 12</option>
                        <option value="1">Show 12</option>
                    </select>
                </div>
                <div class="pagination">
                    <a href="#" class="prev-arrow"><i class="fa fa-long-arrow-left" aria-hidden="true"></i></a>
                    <a href="#" class="active">1</a>
                    <a href="#">2</a>
                    <a href="#">3</a>
                    <a href="#" class="dot-dot"><i class="fa fa-ellipsis-h" aria-hidden="true"></i></a>
                    <a href="#">6</a>
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
                    <select>
                        <option value="1">Show 12</option>
                        <option value="1">Show 12</option>
                        <option value="1">Show 12</option>
                    </select>
                </div>
                <div class="pagination">
                    <%--                    <a href="#" class="prev-arrow"><i class="fa fa-long-arrow-left" aria-hidden="true"></i></a>--%>
                    <%--                    <a href="#" class="active">1</a>--%>
                    <%--                    <a href="#">2</a>--%>
                    <%--                    <a href="#">3</a>--%>
                    <%--                    <a href="#" class="dot-dot"><i class="fa fa-ellipsis-h" aria-hidden="true"></i></a>--%>
                    <%--                    <a href="#">6</a>--%>
                    <%--                    <a href="#" class="next-arrow"><i class="fa fa-long-arrow-right" aria-hidden="true"></i></a>--%>
<%--                    <nav aria-label="Page navigation example">--%>
                        <ul class="pagination">
                            <a href="#" class="prev-arrow"><i class="fa fa-long-arrow-left" aria-hidden="true"></i></a>
                            <c:forEach begin="0" end="${ listCTSP.totalPages -1}" varStatus="loop">
                                <li class="page-item">
                                    <a class="page-link" href="/user/category?page=${loop.begin + loop.count - 1}">
                                            ${loop.begin + loop.count }
                                    </a>
                                </li>
                            </c:forEach>
                            <a href="#" class="next-arrow"><i class="fa fa-long-arrow-right" aria-hidden="true"></i></a>
                        </ul>
<%--                    </nav>--%>
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

</body>

</html>
<%@ page pageEncoding="utf-8" %>
<section class="section dashboard">
    <div class="row">
        <div class="col-lg-12">

            <div class="card">
                <div class="card-body">
                    <h4 class="fw-semibold py-3 mb-4"> Hôm nay (
                        <script>document.write(new Date().toLocaleDateString())</script>
                        )
                    </h4>
                    <form class="row g-3">
                        <div class="col-md-3">
                            <select class="form-select" aria-label="Default select example">
                                <option selected="">Thống kê theo Ngày</option>
                                <option value="1">7 ngày trước</option>
                                <option value="2">14 ngày trước</option>
                                <option value="3">30 ngày trước</option>
                                <option value="3">60 ngày trước</option>
                                <option value="3">90 ngày trước</option>
                            </select>
                        </div>
                        <div class="col-md-3">
                            <button type="submit" class="btn btn-primary">Thống Kê</button>
                            <button type="reset" class="btn btn-secondary">Reset</button>
                        </div>
                    </form>
                </div>
                <%--               /////////////////////////// /////--%>
                <div class="card-body">
                    <%--                    <h5 class="card-title">Default Tabs</h5>--%>

                    <!-- Default Tabs -->
                    <ul class="nav nav-tabs" id="myTab" role="tablist">
                        <li class="nav-item" role="presentation">
                            <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#home"
                                    type="button" role="tab" aria-controls="home" aria-selected="true">Thống Kê theo
                                Ngày
                            </button>
                        </li>
                        <li class="nav-item" role="presentation">
                            <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile"
                                    type="button" role="tab" aria-controls="profile" aria-selected="false"
                                    tabindex="-1">Thống Kê Theo Sản Phẩm
                            </button>
                        </li>
                        <li class="nav-item" role="presentation">
                            <button class="nav-link" id="contact-tab" data-bs-toggle="tab" data-bs-target="#contact"
                                    type="button" role="tab" aria-controls="contact" aria-selected="false"
                                    tabindex="-1">Thống Kê Theo Hóa Đơn
                            </button>
                        </li>
                    </ul>
                    <div class="tab-content pt-2" id="myTabContent">
                        <div class="tab-pane fade active show" id="home" role="tabpanel" aria-labelledby="home-tab">
                            <br>
                            <section class="section dashboard">
                                <div class="row">
                                    <!-- Left side columns -->
                                    <div class="row">

                                        <!-- Sales Card -->
                                        <div class="col-xxl-3 col-md-6">
                                            <div class="card info-card sales-card">

                                                <div class="filter">
                                                    <a class="icon" href="#" data-bs-toggle="dropdown"><i
                                                            class="bi bi-three-dots"></i></a>
                                                    <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
                                                        <li class="dropdown-header text-start">
                                                            <h6>Filter</h6>
                                                        </li>

                                                        <li><a class="dropdown-item" href="#">Today</a></li>
                                                        <li><a class="dropdown-item" href="#">This Month</a></li>
                                                        <li><a class="dropdown-item" href="#">This Year</a></li>
                                                    </ul>
                                                </div>

                                                <div class="card-body">
                                                    <h5 class="card-title">Tổng Doanh Thu <span>| Today</span></h5>
                                                    <div class="d-flex align-items-center">
                                                        <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                                                            <i class="bi bi-currency-dollar"></i>
                                                        </div>
                                                        <div class="ps-3">
                                                            <h6>145</h6>
                                                            <span class="text-success small pt-1 fw-bold">12%</span>
                                                            <span
                                                                    class="text-muted small pt-2 ps-1">increase</span>

                                                        </div>
                                                    </div>
                                                </div>

                                            </div>
                                        </div><!-- End Sales Card -->

                                        <!-- Revenue Card -->
                                        <div class="col-xxl-3 col-md-6">
                                            <div class="card info-card revenue-card">

                                                <div class="filter">
                                                    <a class="icon" href="#" data-bs-toggle="dropdown"><i
                                                            class="bi bi-three-dots"></i></a>
                                                    <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
                                                        <li class="dropdown-header text-start">
                                                            <h6>Filter</h6>
                                                        </li>

                                                        <li><a class="dropdown-item" href="#">Today</a></li>
                                                        <li><a class="dropdown-item" href="#">This Month</a></li>
                                                        <li><a class="dropdown-item" href="#">This Year</a></li>
                                                    </ul>
                                                </div>

                                                <div class="card-body">
                                                    <h5 class="card-title">Tổng Khách Hàng</h5>
                                                    <div class="d-flex align-items-center">
                                                        <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                                                            <i class="bi bi-people"></i>
                                                        </div>
                                                        <div class="ps-3">
                                                            <h6>$3,264</h6>
                                                            <span class="text-success small pt-1 fw-bold">8%</span>
                                                            <span
                                                                    class="text-muted small pt-2 ps-1">increase</span>

                                                        </div>
                                                    </div>
                                                </div>

                                            </div>
                                        </div><!-- End Revenue Card -->

                                        <!-- Customers Card -->
                                        <div class="col-xxl-3 col-md-6">

                                            <div class="card info-card customers-card">

                                                <div class="filter">
                                                    <a class="icon" href="#" data-bs-toggle="dropdown"><i
                                                            class="bi bi-three-dots"></i></a>
                                                    <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
                                                        <li class="dropdown-header text-start">
                                                            <h6>Filter</h6>
                                                        </li>

                                                        <li><a class="dropdown-item" href="#">Today</a></li>
                                                        <li><a class="dropdown-item" href="#">This Month</a></li>
                                                        <li><a class="dropdown-item" href="#">This Year</a></li>
                                                    </ul>
                                                </div>

                                                <div class="card-body">
                                                    <h5 class="card-title">Sản Phẩm Đã Bán</h5>

                                                    <div class="d-flex align-items-center">
                                                        <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                                                            <i class="bi bi-cash-stack"></i>
                                                        </div>
                                                        <div class="ps-3">
                                                            <h6>1244</h6>
                                                            <span class="text-danger small pt-1 fw-bold">12%</span>
                                                            <span
                                                                    class="text-muted small pt-2 ps-1">decrease</span>

                                                        </div>
                                                    </div>

                                                </div>
                                            </div>

                                        </div><!-- End Customers Card -->

                                        <!-- Customers Card -->
                                        <div class="col-xxl-3 col-md-6">

                                            <div class="card info-card customers-card">

                                                <div class="filter">
                                                    <a class="icon" href="#" data-bs-toggle="dropdown"><i
                                                            class="bi bi-three-dots"></i></a>
                                                    <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
                                                        <li class="dropdown-header text-start">
                                                            <h6>Filter</h6>
                                                        </li>

                                                        <li><a class="dropdown-item" href="#">Today</a></li>
                                                        <li><a class="dropdown-item" href="#">This Month</a></li>
                                                        <li><a class="dropdown-item" href="#">This Year</a></li>
                                                    </ul>
                                                </div>

                                                <div class="card-body">
                                                    <h5 class="card-title">Sản Phẩm Còn Lại</h5>

                                                    <div class="d-flex align-items-center">
                                                        <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                                                            <i class="bi bi-cart"></i>
                                                        </div>
                                                        <div class="ps-3">
                                                            <h6>1244</h6>
                                                            <span class="text-danger small pt-1 fw-bold">12%</span>
                                                            <span
                                                                    class="text-muted small pt-2 ps-1">decrease</span>

                                                        </div>
                                                    </div>

                                                </div>
                                            </div>

                                        </div><!-- End Customers Card -->

                                    </div><!-- End Left side columns -->
                                </div>
                            </section>
                        </div>
                        <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                            <br>
                            <section class="section dashboard">
                                <div class="row">
                                    <!-- Left side columns -->
                                    <div class="row">

                                        <!-- Sales Card -->
                                        <div class="col-xxl-3 col-md-6">
                                            <div class="card info-card sales-card">

                                                <div class="filter">
                                                    <a class="icon" href="#" data-bs-toggle="dropdown"><i
                                                            class="bi bi-three-dots"></i></a>
                                                    <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
                                                        <li class="dropdown-header text-start">
                                                            <h6>Filter</h6>
                                                        </li>

                                                        <li><a class="dropdown-item" href="#">Today</a></li>
                                                        <li><a class="dropdown-item" href="#">This Month</a></li>
                                                        <li><a class="dropdown-item" href="#">This Year</a></li>
                                                    </ul>
                                                </div>

                                                <div class="card-body">
                                                    <h5 class="card-title">Sản Phẩm Bán Chạy</h5>
                                                    <div class="d-flex align-items-center">
                                                        <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                                                            <i class="bi bi-currency-dollar"></i>
                                                        </div>
                                                        <div class="ps-3">
                                                            <h6>145</h6>
                                                            <span class="text-success small pt-1 fw-bold">12%</span>
                                                            <span
                                                                    class="text-muted small pt-2 ps-1">increase</span>

                                                        </div>
                                                    </div>
                                                </div>

                                            </div>
                                        </div><!-- End Sales Card -->

                                        <!-- Revenue Card -->
                                        <div class="col-xxl-3 col-md-6">
                                            <div class="card info-card revenue-card">

                                                <div class="filter">
                                                    <a class="icon" href="#" data-bs-toggle="dropdown"><i
                                                            class="bi bi-three-dots"></i></a>
                                                    <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
                                                        <li class="dropdown-header text-start">
                                                            <h6>Filter</h6>
                                                        </li>

                                                        <li><a class="dropdown-item" href="#">Today</a></li>
                                                        <li><a class="dropdown-item" href="#">This Month</a></li>
                                                        <li><a class="dropdown-item" href="#">This Year</a></li>
                                                    </ul>
                                                </div>

                                                <div class="card-body">
                                                    <h5 class="card-title">Sản Phẩm Yêu Thích</h5>
                                                    <div class="d-flex align-items-center">
                                                        <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                                                            <i class='bx bx-heart'></i>
                                                        </div>
                                                        <div class="ps-3">
                                                            <h6>$3,264</h6>
                                                            <span class="text-success small pt-1 fw-bold">8%</span>
                                                            <span
                                                                    class="text-muted small pt-2 ps-1">increase</span>

                                                        </div>
                                                    </div>
                                                </div>

                                            </div>
                                        </div><!-- End Revenue Card -->

                                        <!-- Customers Card -->
                                        <div class="col-xxl-3 col-md-6">

                                            <div class="card info-card customers-card">

                                                <div class="filter">
                                                    <a class="icon" href="#" data-bs-toggle="dropdown"><i
                                                            class="bi bi-three-dots"></i></a>
                                                    <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
                                                        <li class="dropdown-header text-start">
                                                            <h6>Filter</h6>
                                                        </li>

                                                        <li><a class="dropdown-item" href="#">Today</a></li>
                                                        <li><a class="dropdown-item" href="#">This Month</a></li>
                                                        <li><a class="dropdown-item" href="#">This Year</a></li>
                                                    </ul>
                                                </div>

                                                <div class="card-body">
                                                    <h5 class="card-title">Sản Phẩm Đã Bán</h5>

                                                    <div class="d-flex align-items-center">
                                                        <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                                                            <i class="bi bi-cash-stack"></i>
                                                        </div>
                                                        <div class="ps-3">
                                                            <h6>1244</h6>
                                                            <span class="text-danger small pt-1 fw-bold">12%</span>
                                                            <span
                                                                    class="text-muted small pt-2 ps-1">decrease</span>

                                                        </div>
                                                    </div>

                                                </div>
                                            </div>

                                        </div><!-- End Customers Card -->

                                        <!-- Customers Card -->
                                        <div class="col-xxl-3 col-md-6">

                                            <div class="card info-card customers-card">

                                                <div class="filter">
                                                    <a class="icon" href="#" data-bs-toggle="dropdown"><i
                                                            class="bi bi-three-dots"></i></a>
                                                    <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
                                                        <li class="dropdown-header text-start">
                                                            <h6>Filter</h6>
                                                        </li>

                                                        <li><a class="dropdown-item" href="#">Today</a></li>
                                                        <li><a class="dropdown-item" href="#">This Month</a></li>
                                                        <li><a class="dropdown-item" href="#">This Year</a></li>
                                                    </ul>
                                                </div>

                                                <div class="card-body">
                                                    <h5 class="card-title">Sản Phẩm Còn Lại</h5>

                                                    <div class="d-flex align-items-center">
                                                        <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                                                            <i class="bi bi-cart"></i>
                                                        </div>
                                                        <div class="ps-3">
                                                            <h6>1244</h6>
                                                            <span class="text-danger small pt-1 fw-bold">12%</span>
                                                            <span
                                                                    class="text-muted small pt-2 ps-1">decrease</span>

                                                        </div>
                                                    </div>

                                                </div>
                                            </div>

                                        </div><!-- End Customers Card -->

                                    </div><!-- End Left side columns -->
                                </div>
                            </section>
                        </div>
                        <div class="tab-pane fade" id="contact" role="tabpanel" aria-labelledby="contact-tab">
                            <br>
                            <div class="row">
                                <div class="col-md-6 col-lg-3 mb-4 ">
                                    <div class="card h-100 border-success" style="border-left: 5px solid;">
                                        <div class="card-header d-flex align-items-center justify-content-between pb-0 text-uppercase text-success ">
                                            Doanh thu ngày
                                        </div>
                                        <div class="card-body fw-bold">
                                            20.000.000 <u>đ</u>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6 col-lg-3 mb-4">
                                    <div class="card h-100 border-primary" style="border-left: 5px solid">
                                        <div class="card-header d-flex align-items-center justify-content-between pb-0 text-uppercase text-primary">
                                            Tổng đơn hàng
                                        </div>
                                        <div class="card-body">
                                            <span class="fw-bold">6</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6 col-lg-3 mb-4">
                                    <div class="card h-100 border-warning" style="border-left: 5px solid">
                                        <div class="card-header d-flex align-items-center justify-content-between pb-0 text-uppercase text-warning">
                                            Đơn hoàn trả
                                        </div>
                                        <div class="card-body">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6 col-lg-3 mb-4">
                                    <div class="card h-100 border-danger" style="border-left: 5px solid">
                                        <div class="card-header d-flex align-items-center justify-content-between pb-0 text-uppercase text-danger">
                                            Đơn chờ xử lý
                                        </div>
                                        <div class="card-body">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div><!-- End Default Tabs -->

                </div>
            </div>
        </div>
    </div>
</section>

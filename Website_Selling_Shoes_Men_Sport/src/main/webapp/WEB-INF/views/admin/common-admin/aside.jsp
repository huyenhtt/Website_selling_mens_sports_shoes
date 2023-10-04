<!-- ======= Sidebar ======= -->
<%@ page pageEncoding="utf-8" %>
<aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">

        <li class="nav-item">
            <a class="nav-link " href="/admin/home">
                <i class="bi bi-grid"></i>
                <span>Dashboard</span>
            </a>
        </li><!-- End Dashboard Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" data-bs-target="#components-nav" data-bs-toggle="collapse" href="#">
                <i class="bi bi-menu-button-wide"></i><span>Quản Lý Sản Phẩm</span><i
                    class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul id="components-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                <li>
                    <a href="/admin/san-pham/hien-thi">
                        <i class="bi bi-circle"></i><span>Danh sách sản phẩm</span>
                    </a>
                </li>
                <li>
                    <a href="/admin/san-pham/view-add">
                        <i class="bi bi-circle"></i><span>Thêm mới sản phẩm</span>
                    </a>
                </li>

            </ul>
        </li>
        <li class="nav-item">
            <a class="nav-link collapsed" data-bs-target="#components-nav" data-bs-toggle="collapse" href="#">
                <i class="bi bi-menu-button-wide"></i><span>Danh mục</span><i class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul id="components-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                <li>
                    <a href="/admin/loai-giay/hien-thi">
                        <i class="bi bi-circle"></i><span>Quản Lý Loại Giầy</span>
                    </a>
                </li>
                <li>
                    <a href="/admin/de-giay/hien-de-giay">
                         <i class="bi bi-circle"></i><span>Quản Lý Đế Giày</span>
                    </a>
                </li>
                <li>
                    <a href="/admin/khuyen-mai/hien-khuyen-mai">
                         <i class="bi bi-circle"></i><span>Quản Lý Khuyến Mãi</span>
                    </a>
                </li>
                <li>
                    <a href="/admin/mau-sac/hien-mau-sac">
                         <i class="bi bi-circle"></i><span>Quản Lý Màu Sắc</span>
                    </a>
                </li>
                <li>
                    <a href="/admin/san-pham/view-add">
                        <i class="bi bi-circle"></i><span>Quản lý....</span>
                    </a>
                </li>

            </ul>
        </li>
        <!-- End Components Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" data-bs-target="#forms-nav" data-bs-toggle="collapse" href="#">
                <i class="bi bi-journal-text"></i><span>Forms</span><i class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul id="forms-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                <li>
                    <a href="#">
                        <span>Quản lý hoá đơn</span>
                    </a>
                </li>

            </ul>
        </li><!-- End Forms Nav -->

        <!-- End Icons Nav -->

        <li class="nav-heading">Pages</li>

        <li class="nav-item">
            <a class="nav-link collapsed" href="users-profile.html">
                <i class="bi bi-person"></i>
                <span>Profile</span>
            </a>
        </li><!-- End Profile Page Nav -->

    </ul>

</aside>
<!-- End Sidebar-->
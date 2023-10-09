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
                        <i class="bi bi-circle"></i><span>Danh Sách Sản Phẩm</span>
                    </a>
                </li>
                <li>
                    <a href="/admin/san-pham/view-add">
                        <i class="bi bi-circle"></i><span>Sản Phẩm</span>
                    </a>
                </li>

            </ul>
        </li>
        <li class="nav-item">
            <a class="nav-link collapsed" href="/chi-tiet-san-pham/hien-thi">
                <i class="bi bi-receipt"></i>
                <span>Quản Lý Chi Tiết Sản Phẩm</span>
            </a>
        </li><!-- End Profile Page Nav -->


        <li class="nav-item">
            <a class="nav-link collapsed" data-bs-target="#components-nav2" data-bs-toggle="collapse" href="#">
                <i class="bi bi-menu-button-wide"></i><span>Danh mục</span><i class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul id="components-nav2" class="nav-content collapse " data-bs-parent="#sidebar-nav">
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
                    <a href="/hinh-anh/hien-thi">
                        <i class="bi bi-circle"></i><span>Quản Lý Hình Ảnh</span>
                    </a>
                </li>
                <li>
                    <a href="/admin/chat-lieu/hien-chat-lieu">
                        <i class="bi bi-circle"></i><span>Quản Lý Chất Liệu</span>
                    </a>
                </li>
                <li>
                    <a href="/admin/kich-co/hien-thi">
                        <i class="bi bi-circle"></i><span>Quản Lý Kích Cỡ</span>
                    </a>
                </li>
                <li>
                    <a href="/admin/mau-sac/hien-mau-sac">
                        <i class="bi bi-circle"></i><span>Quản Lý Màu Sắc</span>
                    </a>
                </li>

            </ul>
        </li>
        <!-- End Components Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" href="/admin/hoa-don/hien-thi">
                <i class="bi bi-receipt-cutoff"></i>
                <span>Quản Lý Hoá Đơn</span>
            </a>
        </li><!-- End Profile Page Nav -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="/admin/hoa-don/hien-thi">
                <i class="bi bi-person-bounding-box"></i>
                <span>Quản Lý Người Dùng</span>
            </a>
        </li><!-- End Profile Page Nav -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="/admin/don-hang/hien-thi">
                <i class="bi bi-box-seam-fill"></i>
                <span>Quản Lý Đơn Hàng</span>
            </a>
        </li><!-- End Profile Page Nav -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="/admin/khuyen-mai/hien-khuyen-mai">
                <i class="bi bi-person"></i>
                <span>Khuyến Mãi</span>
            </a>
        </li>

        <li class="nav-item">
            <a class="nav-link collapsed" href="/thong-ke">
                <i class="bi bi-graph-up-arrow"></i>
                <span>Thống kê</span>
            </a>
        </li>

        <li class="nav-heading">Pages</li>

        <li class="nav-item">
            <a class="nav-link collapsed" href="/admin/nguoi-dung/hien-thi">
                <i class="bi bi-person"></i>
                <span>Profile</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link collapsed" href="/logout">
                <i class="bi bi-box-arrow-right"></i> <span>Logout</span>
            </a>
        </li>

    </ul>

</aside>
<!-- End Sidebar-->
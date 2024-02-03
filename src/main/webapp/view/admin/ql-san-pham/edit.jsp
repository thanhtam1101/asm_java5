<%@page pageEncoding="UTF-8" language="java"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>Sản phẩm</title>
    <meta content="" name="description">
    <meta content="" name="keywords">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

    <!-- Google Fonts -->
    <link href="https://fonts.gstatic.com" rel="preconnect">
    <link
            href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
            rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">

    <!-- Template Main CSS File -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
</head>

<body>

<!-- ======= Header ======= -->
<header id="header" class="header fixed-top d-flex align-items-center">

    <div class="d-flex align-items-center justify-content-between">
        <a href="index.html" class="logo d-flex align-items-center">
            <img src="assets/img/logo.png" alt="">
            <span class="d-none d-lg-block">THANH TUM</span>
        </a>
        <i class="bi bi-list toggle-sidebar-btn"></i>
    </div><!-- End Logo -->

    <div class="search-bar">
        <form class="search-form d-flex align-items-center" method="POST" action="#">
            <input type="text" name="query" placeholder="Search" title="Enter search keyword">
            <button type="submit" title="Search"><i class="bi bi-search"></i></button>
        </form>
    </div><!-- End Search Bar -->

</header><!-- End Header -->

<!-- ======= Sidebar ======= -->
<aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">

        <li class="nav-item">
            <a class="nav-link collapsed" href="/ban-hang/index">
                <i class="bi bi-grid"></i>
                <span>BÁN HÀNG</span>
            </a>
        </li><!-- End Dashboard Nav -->



        <li class="nav-item">
            <a class="nav-link " data-bs-target="#forms-nav" data-bs-toggle="collapse" href="chi-tiet-san-pham.html">
                <i class="bi bi-journal-text"></i><span>QUẢN LÝ SẢN PHẨM</span><i class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul id="forms-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                <li>
                    <a href="/spct/index">
                        <i class="bi bi-circle"></i><span>Chi tiết sản phẩm</span>
                    </a>
                </li>
                <li>
                    <a href="/san-pham/index">
                        <i class="bi bi-circle"></i><span>Sản phẩm</span>
                    </a>
                </li>
                <li>
                    <a href="/mau-sac/index">
                        <i class="bi bi-circle"></i><span>Màu sắc</span>
                    </a>
                </li>
                <li>
                    <a href="/kich-thuoc/index">
                        <i class="bi bi-circle"></i><span>Kích thước</span>
                    </a>
                </li>
            </ul>
        </li><!-- End Forms Nav -->

        <li class="nav-item ">
            <a class="nav-link collapsed " href="/hoa-don/index">
                <i class="bi bi-layout-text-window-reverse"></i>
                <span>HÓA ĐƠN</span>
            </a>
        </li><!-- End Dashboard Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" href="/nhan-vien/index">
                <i class="bi bi-person-lines-fill"></i>
                <span>NHÂN VIÊN</span>
            </a>
        </li><!-- End Dashboard Nav -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="/khach-hang/index">
                <i class="bi bi-people-fill"></i>
                <span>KHÁCH HÀNG</span>
            </a>
        </li><!-- End Dashboard Nav -->


        <li class="nav-heading">Pages</li>

        <li class="nav-item">
            <a class="nav-link collapsed" href="users-profile.html">
                <i class="bi bi-person"></i>
                <span>Profile</span>
            </a>
        </li><!-- End Profile Page Nav -->


        <li class="nav-item">
            <a class="nav-link collapsed" href="pages-register.html">
                <i class="bi bi-card-list"></i>
                <span>Register</span>
            </a>
        </li><!-- End Register Page Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" href="pages-login.html">
                <i class="bi bi-box-arrow-in-right"></i>
                <span>Login</span>
            </a>
        </li><!-- End Login Page Nav -->


    </ul>

</aside><!-- End Sidebar-->

<main id="main" class="main">

    <div class="pagetitle">
        <h5>UPDATE SẢN PHẨM</h5>

    </div><!-- End Page Title -->

    <section class="section">
        <div class="row">
            <div class="col-lg-8">
                <div class="card">
                    <div class="card-body  px-4">
                        <!-- General Form Elements -->
                        <sf:form method="POST" action="/san-pham/update/${data.id}" class="mt-4" modelAttribute="data">
                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">ID</label>
                                <div class="col-sm-10">
                                    <sf:input type="number" class="form-control" path="id"/>
                                    <sf:errors path="id" cssStyle="color: red"></sf:errors>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">Mã</label>
                                <div class="col-sm-10">
                                    <sf:input type="text" class="form-control" path="ma"/>
                                    <sf:errors path="ma" cssStyle="color: red"></sf:errors>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">Tên</label>
                                <div class="col-sm-10">
                                    <sf:input type="text" class="form-control" path="ten"/>
                                    <sf:errors path="ten" cssStyle="color: red"></sf:errors>
                                </div>
                            </div>
                            <fieldset class="row mb-3">
                                <legend class="col-form-label col-sm-2 pt-0">Trạng thái</legend>
                                <div class="col-sm-10">
                                    <div class="form-check">
                                        <sf:radiobutton class="form-check-input" path="trangThai" value="1"  />
                                        <label class="form-check-label" >
                                            Hoạt động
                                        </label>
                                    </div>
                                    <div class="form-check">
                                        <sf:radiobutton class="form-check-input" path="trangThai" value="0"  />
                                        <label class="form-check-label" >
                                           Ngừng hoạt động
                                        </label>
                                    </div>
                                </div>
                            </fieldset>
                            <div class="d-flex justify-content-end">
                                <button type="submit" class="btn btn-primary text-end">UPDATE</button>
                            </div>

                        </sf:form><!-- End General Form Elements -->

                    </div>
                </div>

            </div>


</main><!-- End #main -->

<

<a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i
        class="bi bi-arrow-up-short"></i></a>


<!-- Template Main JS File -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/index.js"></script>

</body>

</html>
<%@page pageEncoding="UTF-8" language="java"%>

<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>Chi tiết sản phẩm</title>
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
            <a class="nav-link collapsed" href="/hoa-don/index">
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

<%--    <div class="pagetitle">--%>
<%--        <h6>QUẢN LÝ SẢN PHẨM</h6>--%>

<%--    </div><!-- End Page Title -->--%>
    <section class="section">
        <div class="row">
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-body">
                        <!-- General Form Elements -->
                        <sf:form method="POST" action="/spct/store" modelAttribute="data" class="mt-2">
                            <div class="col-12 d-flex">
                                <div class="col-6">

                                    <div class="row mb-3">
                                        <label class="col-sm-3 col-form-label">Tên sản phẩm</label>
                                        <div class="col-sm-6">
                                            <sf:select path="idSanPham" class="form-select " aria-label="Default select example">
                                                <c:forEach var="i" items="${listSP}">
                                                    <sf:option value="${i.id}">${i.ten}</sf:option>
                                                </c:forEach>
                                            </sf:select>
                                        </div>
                                        <a class="col-3" href="/san-pham/index"><i class="bi bi-folder-plus " style="font-size: 25px;"></i></a>

                                    </div>
                                    <div class="row mb-3">
                                        <label class="col-sm-3 col-form-label">Kích thước</label>
                                        <div class="col-sm-6">
                                            <sf:select path="idKichThuoc" class="form-select " aria-label="Default select example">
                                                <c:forEach var="i" items="${listKT}">
                                                    <sf:option value="${i.id}">${i.ten}</sf:option>
                                                </c:forEach>
                                            </sf:select>
                                        </div>
                                        <a  class="col-3" href="/kich-thuoc/index"><i class="bi bi-folder-plus " style="font-size: 25px;"></i></a>

                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="row mb-3">
                                        <label class="col-sm-3 col-form-label">Màu sắc</label>
                                        <div class="col-sm-6">
                                            <sf:select path="idMauSac" class="form-select " aria-label="Default select example">
                                                <c:forEach var="i" items="${listMS}">
                                                    <sf:option value="${i.id}">${i.ten}</sf:option>
                                                </c:forEach>
                                            </sf:select>
                                        </div>
                                        <a  class="col-3" href="/mau-sac/index"><i class="bi bi-folder-plus " style="font-size: 25px;"></i></a>
                                    </div>
                                    <div class="row mb-3">
                                        <label class="col-sm-3 col-form-label">Số lượng</label>
                                        <div class="col-sm-6">
                                            <sf:input type="number" min="1" class="form-control" path="soLuong"/>
                                            <sf:errors path="soLuong" cssStyle="color: red"></sf:errors>
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <label class="col-sm-3 col-form-label">Đơn giá</label>
                                        <div class="col-sm-6">
                                            <sf:input type="number" min="1" class="form-control" path="donGia"/>
                                            <sf:errors path="donGia" cssStyle="color: red"></sf:errors>
                                        </div>
                                    </div>

                                    <div class="row ">
                                        <div class="col-sm-6">
                                            <sf:input type="hidden" class="form-control" path="trangThai" value="0"/>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="d-flex justify-content-between col-2">
                                <button type="submit" class="btn btn-primary text-end">CREATE</button>
                            </div>
                        </sf:form><!-- End General Form Elements -->
                    </div>
                </div>
            </div>

            <div class="col-lg-12">
                <div class="card">
                    <div class="card-body">
                        <table class="table table-bordered mt-3">
                            <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Mã sản phẩm</th>
                                <th scope="col">Tên sản phẩm</th>
                                <th scope="col">Số lượng</th>
                                <th scope="col">Đơn giá</th>
                                <th scope="col">Action</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="i" items="${pageData.content}" varStatus="sp">
                                <tr>
                                    <th scope="row">${i.id}</th>
                                    <td>${i.maSPCT}</td>
                                    <td>
                                        <c:forEach var="x" items="${listSP}">
                                            <c:if test="${x.id == i.idSanPham}">${x.ten}</c:if>
                                        </c:forEach>
                                    </td>
                                    <td>${i.soLuong}</td>
                                    <td>${i.donGia}</td>
                                    <td>

                                        <a href="/spct/detail/${i.id}"><i class="bi bi-eye"
                                                      style="font-size: 20px; color: rgb(46, 142, 56);"></i></a>
                                        <a href="/spct/edit/${i.id}"> <i class="bi bi-pencil-square px-2"
                                                       style="font-size: 20px; color: darkcyan;"></i></a>
                                        <a href="#" onclick="confirmDelete('${i.id}')"><i class="bi bi-trash"
                                                                                          style="font-size: 20px; color: rgb(46, 142, 56);"></i></a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <nav aria-label="Page navigation example">
                            <ul class="pagination">
                                <li class="page-item">
                                    <c:if test="${pageData.number > 0}">
                                        <a class="page-link" href="/spct/index?page=${pageData.number - 1}">Previous</a>
                                    </c:if>
                                    <c:if test="${pageData.number == 0}">
                                        <a class="page-link disabled" href="#">Previous</a>
                                    </c:if>
                                </li>
                                <li class="page-item"><a class="page-link disabled" href="#">${pageData.number+ 1}</a></li>
                                <li class="page-item">
                                    <c:if test="${pageData.number < pageData.totalPages-1}">
                                        <a class="page-link" href="/spct/index?page=${pageData.number + 1}">Next</a>
                                    </c:if>
                                    <c:if test="${pageData.number == pageData.totalPages-1}">
                                        <a class="page-link disabled" href="#">Next</a>
                                    </c:if>
                                </li>
                            </ul>
                        </nav>


                    </div>

                </div>

            </div>
        </div>
    </section>

</main><!-- End #main -->


<script>
    function confirmDelete(id) {
        if (confirm('Bạn có chắc muốn xóa không?')) {
            window.location.href = '/spct/delete/' + id;
        }
    }
</script>
<a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i
        class="bi bi-arrow-up-short"></i></a>


<!-- Template Main JS File -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/index.js"></script>

</body>

</html>
<%@page pageEncoding="UTF-8" language="java"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>Login</title>
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

<main>
    <div class="container">

        <section class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">

                        <div class="d-flex justify-content-center py-4">
                            <a href="index.html" class="logo d-flex align-items-center w-auto">
                                <img src="assets/img/logo.png" alt="">
                                <span class="d-none d-lg-block">LOGIN</span>
                            </a>
                        </div><!-- End Logo -->

                        <div class="card mb-3">

                            <div class="card-body">

                                <div class="pt-4 pb-2">
                                    <h5 class="card-title text-center pb-0 fs-4">Login to Your Account</h5>
                                    <p class="text-center small">Enter your username & password to login</p>
                                </div>

                                <form class="row g-3 needs-validation"  action="/login/admin" method="POST" >
                                    <div class="col-12">
                                        <label for="yourUsername" class="form-label">Username</label>
                                        <div class="input-group has-validation">
                                            <input type="text" name="tenDangNhap" class="form-control" id="yourUsername"  />
                                            <div class="invalid-feedback">Please enter your username.</div>
                                        </div>
                                    </div>

                                    <div class="col-12">
                                        <label class="form-label">Password</label>
                                        <input type="password" name="matKhau" class="form-control"  />
                                        <div class="invalid-feedback">Please enter your password!</div>
                                    </div>


                                    <div class="col-12">
                                        <button class="btn btn-primary w-100" type="submit">Login</button>
                                    </div>
                                </form>


                            </div>
                        </div>



                    </div>
                </div>
            </div>

        </section>

    </div>
</main><!-- End #main -->

<a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

<!-- Template Main JS File -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/index.js"></script>
</body>

</html>

// document.addEventListener("DOMContentLoaded", function () {
//     const quantityInputs = document.querySelectorAll('.quantity-input');
//     const totalAmountInput = document.getElementById('tongTien');
//
//     quantityInputs.forEach(function (input) {
//         input.addEventListener("input", function () {
//             // Cập nhật tổng tiền khi số lượng thay đổi
//             updateTotalAmount();
//
//             // Lấy thông tin sản phẩm từ data attributes
//             const productId = input.getAttribute('data-product-id');
//             const unitPrice = parseFloat(input.getAttribute('data-don-gia'));
//             const newQuantity = parseInt(input.value);
//
//             // Gọi hàm cập nhật cột thành tiền cho sản phẩm cụ thể
//             updateTotalForProduct(input, unitPrice);
//         });
//     });
//
//     // Hàm tính tổng tiền dựa trên số lượng và đơn giá của từng sản phẩm
//     function updateTotalAmount() {
//         let totalAmount = 0;
//
//         quantityInputs.forEach(function (input) {
//             const quantity = parseInt(input.value);
//             const donGia = parseFloat(input.getAttribute('data-don-gia'));
//             totalAmount += quantity * donGia;
//         });
//
//         // Cập nhật giá trị tổng tiền trên form
//         totalAmountInput.value = totalAmount.toFixed(2);
//     }
//
//     function updateTotalForProduct(input, unitPrice) {
//         // Lấy phần tử cha (tr) chứa thông tin sản phẩm
//         const productRow = input.closest('tr');
//
//         // Lấy các phần tử con chứa số lượng và cột thành tiền
//         const quantityInput = productRow.querySelector('.quantity-input');
//         const totalPriceElement = productRow.querySelector('.total-price');
//
//         // Lấy giá trị số lượng từ input
//         const newQuantity = parseInt(quantityInput.value);
//
//         // Tính toán thành tiền cho sản phẩm
//         const totalPrice = newQuantity * unitPrice;
//
//         // Cập nhật giá trị thành tiền trong cột
//         if (totalPriceElement) {
//             totalPriceElement.innerText = totalPrice.toFixed(2);
//         }
//     }
// });


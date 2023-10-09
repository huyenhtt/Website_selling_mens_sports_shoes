<%@ page pageEncoding="utf-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<br>
<section class="section">
    <div class="row">
        <div class="col-lg-12">

            <div class="card">
                <div class="card-body">

                    <div class="row">
                        <div class="col-md-4 col-sm-4 col-lg-4">
                            <h5 class="card-title">Danh sách hình ảnh</h5>
                        </div>
                    </div>

                    <table class="table table-bordered">
                        <thead class="table table-danger">
                        <tr>
                            <th>#</th>
                            <th>Mã CTSP</th>
                            <th>Tên ảnh</th>
                            <th>Đường dẫn 1</th>
                            <th>Đường dẫn 2</th>
                            <th>Đường dẫn 3</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${page.getContent()}" var="ha" varStatus="i">
                            <tr>
                                <td>${i.index+1}</td>
                                <td>${ha.ctsp.maCTSP}</td>
                                <td>${ha.tenanh}</td>
                                <td>${ha.duongdan1}</td>
                                <td>${ha.duongdan2}</td>
                                <td>${ha.duongdan3}</td>
                                <td>

                                    <a href="/hinh-anh/view-update/${ha.id}"
                                       class="btn btn-warning"><i
                                            class="bi bi-pencil-square">Sửa</i></a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <!-- End Table with stripped rows -->

                </div>
            </div>

        </div>
    </div>
</section>
<div class="text-center">
    <nav aria-label="Page navigation example" class="text-center">
        <ul class="pagination justify-content-center">
            <li class="page-item"><a class="page-link" href="/hinh-anh/hien-thi?p=0">Previous</a></li>
            <li class="page-item"><a class="page-link" href="/hinh-anh/hien-thi?p=${page.number-1}"><<</a></li>
            <li class="page-item"><a class="page-link" href="/hinh-anh/hien-thi?p=${page.number+1}">>></a></li>
            <li class="page-item"><a class="page-link" href="/hinh-anh/hien-thi?p=${page.totalPages-1}">Next</a>
            </li>
        </ul>
    </nav>
</div>


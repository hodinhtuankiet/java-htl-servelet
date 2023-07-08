<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>ADMIN</title>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <link rel="stylesheet" href="css/admin.css" />
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <!-- Font Awesome Cdn Link -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
</head>

<body style="background:url(./assets/img/hotel.jpg);background-size: cover;background-repeat: no-repeat;">
    <div class="container">
        <nav>
            <div class="navbar">
                <div class="logo">
                    <img src="./css/Rectangle58.jpg" alt="">
                    <h1>Admin</h1>
                </div>
                <ul>
                    <li><a id="active" href="list">
                            <i class="fas fa-tasks"></i>
                            <span class="nav-item">Customer</span>
                        </a>
                    </li>
                    <li><a href="account">
                            <i class="fas fa-user"></i>
                            <span class="nav-item">Account</span>
                        </a>
                    </li>
                    <li><a href="index.jsp">
                            <i class="fab fa-dochub"></i>
                            <span class="nav-item">My Website</span>
                        </a>
                    </li>
                    <li><a href="statictical.jsp">
                            <i class='bx bx-line-chart'></i>
                            <span class="nav-item">Statistical</span>
                        </a>
                    </li>
                    <li><a href="login.jsp" class="logout">
                            <i class="fas fa-sign-out-alt"></i>
                            <span class="nav-item">Logout</span>
                        </a>
                    </li>
                </ul>
            </div>
        </nav>

        <section class="main">
            <div class="main-top">
                <p>Tuan Kiet Hotel</p>
            </div>
            <div class="main-body">
                <h1>Recent Customers</h1>

                <div class="search_bar">
                    <input type="search" placeholder="Search name customer here...">
                    <select name="" id="">
                        <option>Category</option>
                        <option>Soda</option>
                        <option>Coffee</option>
                        <option>Milk tea</option>
                    </select>
                    <select class="filter">
                        <option>Filter</option>
                    </select>
                </div>

                <div class="tags_bar">
                    <div class="tag" style="color: black;font-size: 15px;">
                    	<i class='bx bx-plus-medical'></i>
                        <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add New User</a>
                    </div>
                </div>

                <div class="row">
                    <p style="color: white;font-weight: 600;">There are <span style="color: red" id="usersCount"></span> Customers</p>
                </div>

                <c:forEach var="user" items="${listUser}">
                    <div class="job_card">
                        <div class="job_details">
                        
                        <c:choose>
                 <c:when test="${user.room == 'A-1'}">
                    <div class="img">
                        <img style="width: 65px;height: 80px;margin-right:15px" src="./assets/img/portfolio/aaaa.jpg" alt="">
                    </div>
                </c:when>
                <c:when test="${user.room == 'A-2'}">
                    <div class="img">
                        <img style="width: 65px;height: 80px;margin-right:15px" src="./assets/img/portfolio/a-22.jpg" alt="">
                    </div>
                </c:when>
                <c:when test="${user.room == 'C-1'}">
                    <div class="img">
                        <img style="width: 65px;height: 80px;margin-right:15px" src="./assets/img/portfolio/c-1.jpg" alt="">
                    </div>
                </c:when>
                <c:when test="${user.room == 'C-2'}">
                    <div class="img">
                        <img style="width: 65px;height: 80px;margin-right:15px" src="./assets/img/portfolio/c-2.jpg" alt="">
                    </div>
                </c:when>
                <c:when test="${user.room == 'B-1'}">
                    <div class="img">
                        <img style="width: 65px;height: 80px;margin-right:15px" src="./assets/img/portfolio/b-1.jpg" alt="">
                    </div>
                </c:when>
                <c:when test="${user.room == 'B-2'}">
                    <div class="img">
                        <img style="width: 65px;height: 80px;margin-right:15px" src="./assets/img/portfolio/b-2.jpg" alt="">
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="img">
                        <img style="width: 65px;height: 80px;margin-right:15px" src="./assets/img/portfolio/b-1.jpg" alt="">
                    </div>
                </c:otherwise>
            </c:choose>

                            <div style="color: white;font-size: 17px;font-weight: 500">
                                <p><c:out value="STT: ${user.id}" /></p>
                                <p><c:out value="Name: ${user.name}" /></p>
                                <p><c:out value="Email: ${user.email}" /></p>
                                <p><c:out value="Address: ${user.address}" /></p>
                                <p><c:out value="Phone: ${user.phone}" /></p>
                                <p><c:out value="Room: ${user.room}" /></p>
                            </div>
                        </div>
                        <div class="job_salary">
                            <h4>{{this.price}}</h4>
                            <span>{{this.time}}</span> <br>
                            <span>{{this.email}}</span> <br> <br>
                            <a href="edit?id=<c:out value='${user.id}'/>" class="buton-edit"><i class='bx bxs-edit'></i>Update</a>
                            <a href="delete?id=<c:out value='${user.id}' />"  class="buton-delete"><i class='bx bxs-message-square-x'></i>Delete</a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </section>
    </div>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</body>

</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

<body>
    <div class="container">
        <nav>
            <div class="navbar">
                <div class="logo">
                    <img src="./css/Rectangle58.jpg" alt="">
                    <h1>Admin</h1>
                </div>
                <ul>
                    <li><a id="active" href="admin.jsp">
                            <i class="fas fa-tasks"></i>
                            <span class="nav-item">Client</span>
                        </a>
                    </li>
                    <li><a href="Account.jsp">
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
                <p>My Hotel</p>
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
                    <div class="tag">
                        <i class='bx bxs-comment-add'></i>
                        <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New User</a>
                    </div>
                </div>

                <div class="row">
                    <p style="color: white;font-weight: 600;">There are <span style="color: red" id="usersCount"></span>
                        Customers
                    </p>
                </div>

                <c:forEach var="user" items="${listUser}">
    <div class="job_card">
        <div class="job_details">
            <div class="img">
                <img style="width: 45px;height: 72px;" src="./css/user.png" alt=""> <br>
            </div>

            <tr>
                <td><c:out value="${user.id}" /></td>
                <td><c:out value="${user.name}" /></td>
                <td><c:out value="${user.email}" /></td>
                <td><c:out value="${user.address}" /></td>
                <td><c:out value="${user.phone}" /></td>
                <td><c:out value="${user.room}" /></td>
            </tr>
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

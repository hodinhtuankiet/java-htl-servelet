<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Account</title>

    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

    <link rel="stylesheet" href="css/admin_2.css" />
    <link rel="stylesheet" href="css/billboard.min.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>

    <!-- Font Awesome Cdn Link -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
</head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<body>
    <div class="container">
        <nav>
            <div class="navbar">
                <div class="logo">
                    <img src="css/Rectangle58.jpg" alt="">
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
                <p>The K&L Corner Coffee!</p>
            </div>
            <div class="main-body">
                <h1>Recent Jobs</h1>

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
                        <i class="fas fa-times"></i>
                        <span>Hot</span>
                    </div>
                    <div class="tag">
                        <i class="fas fa-times"></i>
                        <span>Coffeee</span>
                    </div>
                    <div class="tag">
                        <i class="fas fa-times"></i>
                        <span>What happen ?</span>
                    </div>
                    <div class="tag">
                        <i class="fas fa-times"></i>
                        <span>What Wrong ?</span>
                    </div>
                </div>

                <div class="row">
                    <p>There are more than <span>400</span> Jobs</p>
                    <a href="#">See all</a>
                </div>
                <div id="chart">

                </div>
            </div>
            <script src="https://d3js.org/d3.v6.min.js"></script>
            <script src="js/billboard.min.js"></script>
            <script>
                bb.generate({
                    bindto: '#chart',
                    data: {
                        x: "trucx",
                        columns: [
                            ["trucx", "1.2023", "2.2023", "3.2023", "4.2023", "5.2023", "6.2023"],
                            ["Đơn Hàng", 12, 70, 50, 60, 5, 15],
                            ["Tài Khoản", 5, 11, 22, 63, 45, 3,],
                        ]
                    }
                })
            </script>
</body>

</html>
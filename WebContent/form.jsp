<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>ADMIN</title>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <link rel="stylesheet" href="css/admin.css" />
    <!-- Font Awesome Cdn Link -->
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
</head>

<body>
    <div class="container">
        <nav>
            <div class="navbar">
                <div class="logo">
                    <img src="/img/author/Rectangle58.jpg" alt="">
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
                <h1>Edit Customers</h1>

                <div class="search_bar">
                    <input type="search" placeholder="Search name customer here...">
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
                    <form method="POST" action="/manager/{{users._id}}?_method=PUT">
                        <div class="edit">
                            <div class="row_2">
                                <label for="">User Name:</label>
                                <input value="{{users.username}}" type="text" id="username" name="username">
                            </div>
                            <div class="row_2">
                                <label for="">Email:</label>
                                <input value="{{users.email}}" type="text" id="email" name="email">
                            </div>
                            <div class="row_2">
                                <label for="">Address:</label>
                                <input value="{{users.address}}" type="text" id="address" name="address">
                            </div>

                            <div class="row_2">
                                <label for="">Payment:</label>
                                <input value="{{users.payment}}" type="text" id="payment" name="payment">
                            </div>

                            <div class="row_2">
                                <label for="">Time:</label>
                                <input value="{{users.time}}" type="text" id="time" name="time">
                            </div>
                            <div class="event">
                                <button>Update</button>
                            </div>
                        </div>
                    </form>
        </section>
    </div>
    {{!--
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> --}}

</body>

</html>
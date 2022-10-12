<%@ page import="jakarta.servlet.ServletException" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 25.09.2022
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" href="assets/css/users.css" >
    <script src="https://kit.fontawesome.com/98ec2dde3d.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<%


%>
<div class="container">

<div class="row">
    <div class="col-6">
    <form action="login" method="POST">
        <div>

            <div class="form-group">
                <%--@declare id="email"--%><label for="email"> Email:</label>
                <input placeholder="Enter email" class="form-control"  type="text" name="email" value=""/>
            </div>
            <br/>
            <div class="form-group">
                <%--@declare id="password"--%><label for="password">Password:</label>
                <input  placeholder="Enter password" class="form-control" type="password" name="password" value=""/>
            </div>
            <br/>

            <div >
                <button type="submit" class="btn btn-primary" name="login" value="">
                    <i class="fa-duotone fa-arrow-right-to-bracket"></i> LOGIN
                </button>
            </div>
        </div>

</form>
    </div>
</div>
</div>

</body>
</html>

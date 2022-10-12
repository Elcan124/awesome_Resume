<%@page import="dao.inter.UserDaoInter" %>
<%@page import="main.Context" %>
<%@page import="entity.User" %>
<%@ page import="dao.inter.SkillDaoInter" %>
<%@ page import="dao.inter.UserSkillDAOInter" %>
<%@ page import="entity.Skill" %>
<%@ page import="java.util.List" %>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="assets/css/users.css" >
    <script src="https://kit.fontawesome.com/98ec2dde3d.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://kit.fontawesome.com/98ec2dde3d.js" crossorigin="anonymous"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Resume UserDetails</title>

</head>
<body>
<%

User u = (User) request.getAttribute("user");
    SkillDaoInter skillDao = Context.skillDaoInter();

    List<Skill> skills = skillDao.getAllSkill();




%>
<div class="container">
    <form action="userdetail" method="POST">
        <input type="hidden" name="action" value="update"   />
        <div class="form-group">
        <%--@declare id="surname"--%><%--@declare id="name"--%><input type="hidden" name="id" value="<%=u.getId()%>"/>
        <label for="name"> Name:</label>
        <input type="text" class="form-control" name="name" value="<%=u.getName()%>"/>
        </div>
        <br/>
        <div class="form-group">
        <label for="surname">Surname:</label>
        <input type="text"  class="form-control" name="surname" value="<%=u.getSurname()%>"/>

            </div>
        <br/>
        <div class="form-group">
            <%--@declare id="email"--%><label for="email">Email:</label>
            <input type="text"  class="form-control" name="email" value="<%=u.getEmail()%>"/>

        </div>
        <br/>
        <div class="form-group">
            <%--@declare id="phone"--%><label for="phone">Phone Number:</label>
            <input type="text"  class="form-control" name="phone" value="<%=u.getPhone()%>"/>

        </div>
        <div class="form-group">
        <%--@declare id="profile_desc"--%><label for="profile_desc">Profile Description:</label>
        <input type="text"  class="form-control" name="profile_desc" value="<%=u.getProfile_Description()%>"/>

    </div>

<br/>
        <div class="form-group">
            <%--@declare id="adress"--%><label for="adress">Adress:</label>
            <input type="text"  class="form-control" name="adress" value="<%=u.getAdress()%>"/>

        </div>
        <br/>
        <div class="form-group">
           <%--@declare id="birthdate"--%><label for="birthdate">Birthdate:</label>
            <input type="date"  class="form-control" name="birthdate" value="<%=u.getBirthdate()%>"/>

        </div>



        <br/>
        <div>
            <div >
                <button type="submit" class="btn btn-primary" name="save" value="">
                    <i class="fa-solid fa-share-from-square"></i> SAVE
                </button>
            </div>
        </div>
    </form>


</div>
<div  class="form-group" style="margin-left: 1600px ; margin-bottom: 1000px ;    margin-top: -217px;">
    <form action="skill" method="POST">
        <input type="hidden" name="id" value="<%=u.getId()%>"   />
        <%--@declare id="skillname"--%><label for="skillName">Skills:</label>
        <select name="skilladi" class="combo">

            <option value="Select">Select....</option>
            <% for(Skill skill : skills){%>
            <option value="<%=skill.getName()%>"><%=skill.getName()%></option>
            <%
                }%>
        </select>
        <div >
            <%--@declare id="power"--%><label for="power">Power:</label>
            <select  name="guc" class="combo">
                <option value="Select">Select....</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <option value="10">10</option>
            </select>
        </div>
        <br/>
        <div style="margin-top: 10px">


            <button type="submit" class="btn btn-primary" name="add" value="">
                <i class="fa-solid fa-plus"></i> ADD Skill
            </button>


        </div>

        </form>

</div>


</body>
</html>

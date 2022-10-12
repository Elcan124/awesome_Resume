<%@page import="dao.inter.UserDaoInter" %>
<%@page import="main.Context" %>
<%@page import="entity.User" %>
<%@ page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
   <link rel="stylesheet" href="assets/css/users.css" >
    <script src="https://kit.fontawesome.com/98ec2dde3d.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
  <script type="text/javascript" src="assets/js/users.js"></script><script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
 <%
      User loggedUser    = (User) session.getAttribute("loggedInuser") ;

 %>
 Welcome,
 <%=loggedUser.getName()%>
<%


    List<User>  users =(List<User>) request.getAttribute("users");




%>

<div class="container mycontainer">
    <div class="row" >
<div class="col-4">
        <form action="users" method="GET">
            <div>
            <%--@declare id="surname"--%><%--@declare id="name"--%>
            <%--@declare id="nid"--%>
            <div class="form-group">
                <label for="name"> Name:</label>
                <input placeholder="Enter name" class="form-control"  type="text" name="name" value=""/>
            </div>
            <br/>
            <div class="form-group">
                <label for="surname">Surname:</label>
                <input  placeholder="Enter surname" class="form-control" type="text" name="surname" value=""/>
            </div>
            <br/>

            <div >
                <button type="submit" class="btn btn-primary" name="save" value="search" id="change">
                    <i class="fa-solid fa-magnifying-glass"></i> Search
                    </button>
                <button type="button" class="btn btn-primary" name="save" value="changeColor"  onclick="changeColor()">
                     Change Color

                </button>
            </div>
                </div>


        </form>
</div>

    </div>
    <div>
        <table class="table">
            <thead>
            <tr>
                <th>Name</th>
                <th>Surname</th>
                <th>Nationality</th>
                <th></th>
                <th></th>
            </tr>

            </thead>
            <tbody>

            <% for (User u : users) {%>
            <tr>
                <td><%=u.getName()%>
                </td>
                <td><%=u.getSurname()%>
                </td>
                <td><%=u.getNationalityId().getNationality() == null ? "N/A" : u.getNationalityId().getNationality()%>
                </td>
                <div>
                <td style="width: 5px">




                    <button   type="button" class="btn btn-danger"  data-toggle="modal" data-target="#exampleModal"  onclick="deleteUsersId('<%=u.getId()%>')">
                        <input id="deleteUserId" type="hidden" name="id" value="<%=u.getId()%>"   />

                        <i class="fa-solid fa-trash"></i> Delete
                    </button>


                    </td>
                <td>

                        <form action="userdetail" method="GET">
                            <input type="hidden" name="id" value="<%=u.getId()%>"   />
                            <input type="hidden" name="action" value="update"   />
                        <button  type="submit" class="btn btn-primary"  name = "action " value="update" >


                        <i class="fa-solid fa-pen-to-square"></i> Update

                        </button>
                        </form>



                </td>
</div>
            </tr>
            <%}%>

            </tbody>


        </table>

    </div>
</div>


<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Delete User</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Are you sure you want to delete the User?
            </div>
            <div class="modal-footer">
                <form  action="userdetail" method="POST">
                    <input id="formDeleteID" type="hidden" name="id"  />
                    <input type="hidden" name="action" value="delete"   />
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="submit" name = "action " value="delete" class="btn btn-danger">DELETE USER</button>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>

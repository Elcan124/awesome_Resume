package com.example.resumewebapp.controller;

import dao.inter.SkillDaoInter;
import dao.inter.UserDaoInter;
import dao.inter.UserSkillDAOInter;
import entity.Skill;
import entity.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import entity.UserSkill;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import main.Context;

/**
 * @author Asus
 */
@WebServlet(name = "UserController", urlPatterns = {"/userdetail"})
public class UserController extends HttpServlet {

private UserSkillDAOInter userSkillDao = Context.userDaoSkillInter();

private SkillDaoInter skillDao = Context.skillDaoInter();
    private UserDaoInter userDao = Context.userDaoImlInstance();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        String action = request.getParameter("action");
        if(action.equals("update")){
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phone");
        String profileDesc = request.getParameter("profile_desc");
        String adress = request.getParameter("adress");
Date birthdate = Date.valueOf(request.getParameter("birthdate"));




        User u = userDao.getById(id);

        u.setName(name);
        u.setSurname(surname);
        u.setEmail(email);
        u.setPhone(phoneNumber);
        u.setProfileDescription(profileDesc);
        u.setAddress(adress);
        u.setBirthdate(birthdate);

        userDao.updateUser(u);

       }
        else if(action.equals("delete")){
            userDao.removeUser(id);

        }else if(action.equals("add")){
            String skillName = request.getParameter("skilladi");
         int power = Integer.valueOf(request.getParameter("guc")) ;
            Skill skill = skillDao.getById(id);
            User user = userDao.getById(id);
            UserSkill userSk = new UserSkill(null , user , skill , power);
            userSkillDao.insertUserSkill(userSk);


        }

        response.sendRedirect("users");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String userIDstr = request.getParameter("id");
            if (userIDstr == null || userIDstr.trim().isEmpty()) {


                throw new IllegalArgumentException("id is not specified");
            }
            User u = null;

            Integer id = Integer.valueOf(userIDstr);
            UserDaoInter userDao = Context.userDaoImlInstance();
            u = userDao.getById(id);
            if (u == null) {
                throw new IllegalArgumentException("There is  no user with this id ");


            }
            request.setAttribute("owner" , true);
            request.setAttribute("user", u);
            request.getRequestDispatcher("userdetails.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.sendRedirect("error?msg="+ex.getMessage());
        }

    }

}



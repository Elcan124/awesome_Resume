package com.example.resumewebapp.controller;

import dao.inter.SkillDaoInter;
import dao.inter.UserDaoInter;
import dao.inter.UserSkillDAOInter;
import entity.Skill;
import entity.User;
import entity.UserSkill;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.Context;

import java.io.IOException;
import java.sql.Date;

/**
 * @author Asus
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {


    private UserDaoInter userDao = Context.userDaoImlInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            User u = null;
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            u = userDao.findByEmailandPassword(email, password);
            if (u == null) {
                throw new IllegalArgumentException("password or email is incorrect");
            }
            request.getSession().setAttribute("loggedInuser", u);
            response.sendRedirect("users");
        }catch (Exception ex){
            ex.printStackTrace();
            response.sendRedirect("error?msg="+ex.getMessage());
        }
    }

}

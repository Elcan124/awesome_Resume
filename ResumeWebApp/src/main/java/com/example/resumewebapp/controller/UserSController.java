package com.example.resumewebapp.controller;

import dao.inter.UserDaoInter;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.Context;

import java.io.IOException;
import java.util.List;

/**
 * @author Asus
 */
@WebServlet(name = "UserSController", urlPatterns = {"/users"})
public class UserSController extends HttpServlet {
private UserDaoInter user = Context.userDaoImlInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String nationalitystr = request.getParameter("nid");
        Integer nationalityID = null;
        if (nationalitystr != null && !nationalitystr.trim().isEmpty()) {
            nationalityID = Integer.valueOf(nationalitystr);
        }
        List<User> users =null;

        users = user.getAllbyNameSurnameAndNationality(name, surname, nationalityID);
   request.setAttribute("users" , users);
        request.getRequestDispatcher("users.jsp").forward(request, response);


    }
}



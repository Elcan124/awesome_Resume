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
@WebServlet(name = "SkillController", urlPatterns = {"/skill"})
public class SkillController extends HttpServlet {

private UserSkillDAOInter userSkillDao = Context.userDaoSkillInter();

private SkillDaoInter skillDao = Context.skillDaoInter();
    private UserDaoInter userDao = Context.userDaoImlInstance();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("id"));


            String skillName = request.getParameter("skilladi");
         int power = Integer.valueOf(request.getParameter("guc")) ;
            Skill skill = skillDao.getBySkillName(skillName);

            User user = userDao.getById(id);
            UserSkill userSk = new UserSkill(null , user , skill , power);
            userSkillDao.insertUserSkill(userSk);




        response.sendRedirect("userdetail?id="+id);
    }


}



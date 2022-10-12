/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;


import dao.inter.*;
import userDaoImpl.*;

public class Context {

    public static UserDaoInter userDaoImlInstance() {
        return new UserDaoImpl();
    }

    public static UserSkillDAOInter userDaoSkillInter() {
        return new UserSkillImplDAO();
    }

    public static EmploymentHistoyDaoInter employmentDAOImpl() {
        return new EmploymentHistoryDaoImpl();
    }

    public static SkillDaoInter skillDaoInter(){
        return  new SkillDaoImpl();
    }
    public static CountryDaoInter countryDaoInter(){
        return new CountryDaoImpl();
    }

}


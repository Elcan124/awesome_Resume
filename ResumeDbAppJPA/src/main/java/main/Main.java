/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import dao.inter.CountryDaoInter;
import dao.inter.SkillDaoInter;
import dao.inter.UserDaoInter;
import entity.Country;
import entity.Skill;
import entity.User;
import java.sql.Date;

import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        UserDaoInter userDao = Context.userDaoImlInstance();
userDao.removeUser(42);
      
    }
}

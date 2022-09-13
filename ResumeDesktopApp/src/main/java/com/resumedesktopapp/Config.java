/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.resumedesktopapp;

import dao.inter.UserDaoInter;
import entity.User;

/**
 *
 * @author Asus
 */
public class Config {
     public static UserDaoInter userDao = main.Context.userDaoImlInstance();
    public static User loggedInUser = userDao.getById(2)  ;
    
    
}

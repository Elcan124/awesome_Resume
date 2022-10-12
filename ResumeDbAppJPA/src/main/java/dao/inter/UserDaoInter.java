/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.inter;


import entity.Country;
import entity.Skill;
import entity.User;
import entity.UserSkill;

import java.util.List;

public interface UserDaoInter {
    public List<User> getAll();
    public List<User> getAllbyNameSurnameAndNationality(String name, String surname, Integer nationalityID);
    public boolean updateUser(User u);
    public boolean removeUser(int id);
    public User getById(int userID);

    public boolean addUser(User u);;
    public User findByEmailandPassword(String email, String password);
    public User findByEmail(String email) ;


}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.inter;
import entity.Skill;
import entity.UserSkill;

import java.util.List;

public interface UserSkillDAOInter {
    public List<UserSkill> getAllUserSkillbyID(int id);
    public Skill getSkillByID(int id);
    public boolean deleteUserSkill(int id);
     public boolean insertUserSkill(UserSkill u);
     public boolean updateUserSkill(UserSkill u);
}

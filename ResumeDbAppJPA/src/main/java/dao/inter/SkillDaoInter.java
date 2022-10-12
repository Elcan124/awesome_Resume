/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.inter;

import entity.EmploymentHistory;
import entity.Skill;

import java.util.List;

public interface SkillDaoInter {

    public List<Skill> getAllSkill();
    public boolean addSkill(Skill skill );
    public Skill getById(int userId);
    public Skill getBySkillName(String name);
    
}

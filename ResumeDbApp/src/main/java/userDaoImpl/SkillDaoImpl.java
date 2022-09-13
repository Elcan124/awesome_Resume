/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userDaoImpl;

import dao.inter.AbstractDAO;
import dao.inter.SkillDaoInter;
import entity.Skill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SkillDaoImpl extends AbstractDAO implements SkillDaoInter {

    @Override
    public List<Skill> getAllSkill() {
        List<Skill> listofSkill = new ArrayList<>();
        try ( Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select * from skill");
            ResultSet rset = stmt.getResultSet();
            while (rset.next()) {

                int id = rset.getInt("id");
                String name = rset.getString("name");

                Skill skill = new Skill(id, name);

                listofSkill.add(skill);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return listofSkill;

    }

    @Override
    public boolean addSkill(Skill skill) {
        boolean b = true;

        try ( Connection c = connect()) {

            PreparedStatement pstmt = c.prepareStatement("insert into Skill (name )  values (?)", Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, skill.getName());
            b = pstmt.execute();

            ResultSet genKeys = pstmt.getGeneratedKeys();
            if(genKeys.next()){
                
               skill.setId(genKeys.getInt(1));
               
            }

        } catch (Exception ex) {
            ex.printStackTrace();
b=false;
        }
return b;
    }
    
}

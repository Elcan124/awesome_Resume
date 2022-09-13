/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userDaoImpl;


import dao.inter.AbstractDAO;
import dao.inter.UserSkillDAOInter;
import entity.Skill;
import entity.User;
import entity.UserSkill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class UserSkillImplDAO extends AbstractDAO implements UserSkillDAOInter {
    private UserSkill getUserSkill(ResultSet rset) throws Exception{
        int id =  rset.getInt("userSkillId");
        int userID = rset.getInt("id");
        int skillID =  rset.getInt("skill_id");
        String skillname =  rset.getString("skill_name");
        int power =  rset.getInt("power");



        return new UserSkill(id,    new User(userID),new Skill(skillID , skillname) ,  power);

    }
    @Override
    public List<UserSkill> getAllUserSkillbyID(int id) {
        List<UserSkill> result = new ArrayList<>();

        try (Connection c = connect()) {

            PreparedStatement stmt = c.prepareStatement("select us.id as userSkillId , u.* , us.skill_id , s.name as skill_name , us.power from user_skill us LEFT JOIN user u on us.user_id=u.id LEFT JOIN skill s on us.skill_id = s.id where u.id =?; ");
            stmt.setInt(1 , id);
            stmt.execute();


            ResultSet rset = stmt.getResultSet();

            while (rset.next()) {
                UserSkill us =   getUserSkill(rset);

                result.add(us);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;

    }

    @Override
    public Skill getSkillByID(int id) {
        Skill result = null;

        try (Connection c = connect()) {

            Statement stmt = c.createStatement();
            stmt.execute("select * from skill where id =  " + id);


            ResultSet rset = stmt.getResultSet();

            while (rset.next()) {
                int s_id = rset.getInt("id");
                String name = rset.getString("name");
                result =  new Skill(s_id , name);


            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean deleteUserSkill(int id) {
           Connection conn;
        try {
            conn = connect();

            PreparedStatement stmt = conn.prepareStatement("DELETE FROM user_skill WHERE ID=?");
            stmt.setInt(1, id);
           
            return stmt.execute();

        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
      
    
    }

    @Override
    public boolean insertUserSkill(UserSkill u) {
         
        boolean b = true;
        try (Connection conn = connect()){
          
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO user_skill (skill_id , user_id ,power) VALUES (? , ? ,  ? ) ;");

            stmt.setInt(1, u.getSkill().getId());
            stmt.setInt(2, u.getUser().getId());
            stmt.setInt(3, u.getPower());

            b = stmt.execute();

        } catch (Exception ex) {
            System.err.println(ex);
            b = false;
        }
        return b;
    }
    }

  

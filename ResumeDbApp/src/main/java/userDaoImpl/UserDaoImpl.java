/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userDaoImpl;


import Utility.Util;
import entity.Skill;
import entity.UserSkill;
import dao.inter.AbstractDAO;
import dao.inter.UserDaoInter;
import entity.Country;
import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends AbstractDAO implements UserDaoInter {


    private User getUser(ResultSet rset) throws Exception{
        int id = rset.getInt("id");
        String name = rset.getString("name");
        String surname = rset.getString("surname");
        String email = rset.getString("email");
        String phone = rset.getString("phone");
        String address = rset.getString("address");
        String descriptionn = rset.getString("profile_Description");
        int birthplaceid = rset.getInt("birthplace_id");
        int nationalityid = rset.getInt("nationality_id");
        String nationalityStr = rset.getString("nationality");

        String birthplaceStr = rset.getString("country");
        Date birthdate = rset.getDate("birthdate");
        Country country = new Country(birthplaceid , birthplaceStr , null);
        Country nationality =  new Country(nationalityid , null , nationalityStr);
        return new User(id, name, surname, email, phone, descriptionn,address, birthdate ,country , nationality);
    }

    @Override
    public List<User> getAll() {
        List<User> result = new ArrayList<>();

        try (Connection c = connect()) {

            Statement stmt = c.createStatement();
            stmt.execute("SELECT u.*, n.name as country  , c.nationality as nationality  FROM user u   left join country n on u.birthplace_id = n.id left join country c on u.nationality_id= c.id");


            ResultSet rset = stmt.getResultSet();

            while (rset.next()) {
              User u =   getUser(rset);

                result.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateUser(User u) {
        try (Connection c = connect()) {

            PreparedStatement pstmt = c.prepareStatement("update user set name = ? , surname=? , email=? , phone = ? , profile_Description = ? , address = ? , birthdate = ? , birthplace_id=?  where id=?");
            pstmt.setString(1, u.getName());
            pstmt.setString(2, u.getSurname());
            pstmt.setString(3, u.getEmail());
            pstmt.setString(4, u.getPhone());
             pstmt.setString(5, u.getProfile_Description());
              pstmt.setString(6, u.getAdress());
               pstmt.setDate(7, u.getBirthdate());
               pstmt.setInt(8 , u.getBirthplace().getId());
               
            pstmt.setInt(9, u.getId());
            return pstmt.execute();


        } catch (Exception ex) {

            ex.printStackTrace();
            return false;

        }


    }

    @Override
    public boolean removeUser(int id) {
        try (Connection c = connect()) {

            Statement stmt = c.createStatement();
            return stmt.execute("delete from user where id = " + id);


        } catch (Exception ex) {

            ex.printStackTrace();
            return false;

        }

    }

    @Override
    public User getById(int userID) {
        User result = null;

        try (Connection c = connect()) {

            Statement stmt = c.createStatement();
            stmt.execute("SELECT u.*, n.name as country  , c.nationality as nationality  FROM user u   left join country n on u.birthplace_id = n.id left join country c on u.nationality_id= c.id where u.id = " + userID);


            ResultSet rset = stmt.getResultSet();

            while (rset.next()) {

                result = getUser(rset);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean addUser() {
        try (Connection c = connect()) {

            PreparedStatement pstmt = c.prepareStatement("insert into user (name , surname  ,email,phone) values(?,?,?,?)");
            pstmt.setString(1, Util.requireText("Enter name"));
            pstmt.setString(2, Util.requireText("Enter surname"));
            pstmt.setString(3, Util.requireText("Enter email"));
            pstmt.setString(4, Util.requireText("Enter phone number"));
            System.out.println("new User added succesfully");
            return pstmt.execute();


        } catch (Exception ex) {

            ex.printStackTrace();
            return false;

        }

    }

    @Override
    public boolean addUser(User u) {
        try (Connection c = connect()) {

            PreparedStatement pstmt = c.prepareStatement("insert into user (name , surname  ,email,phone ,profile_Description ,address , birthdate ) values(?,?,?,? ,? ,? ,?)");
            pstmt.setString(1, u.getName());
            pstmt.setString(2, u.getSurname());
            pstmt.setString(3, u.getEmail());
            pstmt.setString(4, u.getPhone());
              pstmt.setString(5, u.getProfile_Description());
               pstmt.setString(6, u.getAdress());
                pstmt.setDate(7, u.getBirthdate());
              

            return pstmt.execute();


        } catch (Exception ex) {

            ex.printStackTrace();
            return false;

        }
    }



}

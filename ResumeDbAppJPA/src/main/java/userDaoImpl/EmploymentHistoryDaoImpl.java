/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userDaoImpl;


import dao.inter.AbstractDAO;
import dao.inter.EmploymentHistoyDaoInter;
import entity.EmploymentHistory;
import entity.Skill;
import entity.User;
import entity.UserSkill;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.util.List;

public class EmploymentHistoryDaoImpl extends AbstractDAO implements EmploymentHistoyDaoInter {
    private EmploymentHistory getEmploymentHistory(ResultSet rset) throws Exception {
        String header = rset.getString("header");
        Date beginDate = rset.getDate("begin_date");
        Date endDate = rset.getDate("end_date");
        String jobDesc = rset.getString("job_description");
        int userId = rset.getInt("user_id");


        return null;

    }

    @Override
    public List<EmploymentHistory> getAllEmploymentHistorybyID(int id) {
        List<EmploymentHistory> result = new ArrayList<>();

        try (Connection c = connect()) {

            PreparedStatement stmt = c.prepareStatement("select * from  employment_history where user_id =? ");
            stmt.setInt(1, id);
            stmt.execute();


            ResultSet rset = stmt.getResultSet();

            while (rset.next()) {
                EmploymentHistory us = getEmploymentHistory(rset);

                result.add(us);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;

    }
}

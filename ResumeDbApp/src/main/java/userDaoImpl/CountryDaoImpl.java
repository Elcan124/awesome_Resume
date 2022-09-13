/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userDaoImpl;


import dao.inter.AbstractDAO;
import dao.inter.CountryDaoInter;
import entity.Country;
import entity.Skill;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountryDaoImpl extends AbstractDAO implements CountryDaoInter {
    @Override
    public List<Country> getAllContry() {
        List<Country> listofCountry = new ArrayList<>();
        try(Connection c =  connect()){
            Statement stmt = c.createStatement();
            stmt.execute("select * from country");
            ResultSet rset = stmt.getResultSet();
            while(rset.next()){

                int id =  rset.getInt("id");
                String name = rset.getString("name");
                String nationality =  rset.getString("nationality");


                Country contry =  new Country(id , name , nationality);

                listofCountry.add(contry);


            }



        }catch(Exception ex){
            ex.printStackTrace();
        }




        return listofCountry;
    }
}

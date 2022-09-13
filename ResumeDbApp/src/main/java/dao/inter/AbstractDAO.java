/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.inter;


import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class AbstractDAO {

    @SneakyThrows
    public  Connection connect() {



        String url = "jdbc:mysql://localhost:3306/resume";
        String username = "root";
        String password = "Elcan619";
        Connection c = DriverManager.getConnection(url, username, password);
        return c;

    }
}

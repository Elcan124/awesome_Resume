package util;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ControllerUtil {

    public static void errorPage(HttpServletResponse resp, Exception ex){
        try {
            ex.printStackTrace();
            resp.sendRedirect("error?msg="+ex.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
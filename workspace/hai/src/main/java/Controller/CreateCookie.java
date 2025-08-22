package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;


@WebServlet("/createcookie")

public class CreateCookie extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Nhận dữ liệu từ FORM
        String ten = request.getParameter("ten");
        String holot = request.getParameter("holot");

        // Tạo cookie
        Cookie firstName = new Cookie("ten", ten);
        Cookie lastName = new Cookie("holot", holot);

        // Set thời gian sống 1 ngày
        firstName.setMaxAge(60 * 60 * 24);
        lastName.setMaxAge(60 * 60 * 24);

        // Gửi cookie về client
        response.addCookie(firstName);
        response.addCookie(lastName);

        // Xuất ra màn hình
        PrintWriter out = response.getWriter();
        out.println("<b>First Name</b>: " + firstName.getValue()
                + " - <b>Last Name</b>: " + lastName.getValue());
    }
}
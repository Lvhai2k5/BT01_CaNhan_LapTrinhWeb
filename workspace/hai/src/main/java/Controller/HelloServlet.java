package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;


@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();

        String name = "";

        // Nhận cookie
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("username".equals(c.getName())) {
                    name = c.getValue();
                    break;
                }
            }
        }

        if (name.equals("")) {
            // Chưa đăng nhập → chuyển sang trang login
            resp.sendRedirect(req.getContextPath() + "/login");
            return; // dừng xử lý tiếp
        }

        // Nếu có cookie thì hiển thị
        printWriter.println("<h2>Xin chào, " + name + "!</h2>");
        printWriter.close();
    }
}
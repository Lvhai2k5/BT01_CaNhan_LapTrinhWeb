package Controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Hiển thị form login.html
        req.getRequestDispatcher("/WEB-INF/login.html").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        // Lấy dữ liệu từ form
        String user = req.getParameter("username");
        String pass = req.getParameter("password");

        if ("LeVuHai".equals(user) && "123456".equals(pass)) {
            // Khởi tạo cookie
            Cookie cookie = new Cookie("username", user);
            // Thiết lập thời gian tồn tại 30s
            cookie.setMaxAge(30);
            // Thêm cookie vào response
            resp.addCookie(cookie);
            // Chuyển sang trang HelloServlet
            resp.sendRedirect(req.getContextPath() + "/hello");
        } else {
            // Quay lại trang login
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }
}
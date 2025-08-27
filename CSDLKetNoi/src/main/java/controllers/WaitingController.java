package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/waiting")
public class WaitingController extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false); // Dùng false để tránh tạo session mới không cần thiết

		// Kiểm tra xem session có tồn tại và có chứa thuộc tính "username" không
		if (session != null && session.getAttribute("username") != null) {
			// Lấy đối tượng User từ session với đúng key là "username"
			User u = (User) session.getAttribute("username");

			// Dựa vào roleid để chuyển hướng
			if (u.getRoleid() == 1) {
				resp.sendRedirect(req.getContextPath() + "/csdladmin");
			} else if (u.getRoleid() == 2) {
				resp.sendRedirect(req.getContextPath() + "/csdlmanager");
			} else {
				resp.sendRedirect(req.getContextPath() + "/home");
			}
		} else {
			// Nếu không có session hoặc không có thông tin user, chuyển về trang đăng nhập
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}
}

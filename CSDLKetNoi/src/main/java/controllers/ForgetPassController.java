package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class ForgetPassController
 */
@WebServlet(urlPatterns = { "/forgetpass" })
public class ForgetPassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetPassController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String email = req.getParameter("email");
		System.out.println(email);
		if (email != null && !email.isEmpty()) {
		    try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection conn = DriverManager.getConnection(
		            "jdbc:mysql://localhost:3306/laptrinhweb", "root", "@Tuan16022005"
		        );

		        String sql = "SELECT password FROM account WHERE email = ?";
		        PreparedStatement ps = conn.prepareStatement(sql);
		        ps.setString(1, email);
		        ResultSet rs = ps.executeQuery();

		        if (rs.next()) {
		            String pass = rs.getString("password");
		            // Demo: in ra console hoặc setAttribute để hiển thị
		            System.out.println("Mật khẩu: " + pass);
		            req.setAttribute("password", pass);
		            req.getRequestDispatcher("/views/ShowPass.jsp").forward(req, resp);
		        } else {
		        	System.out.println("Email không tồn tại");
		            req.setAttribute("alert", "Email không tồn tại");
		            req.getRequestDispatcher("/views/LoginForgetPass.jsp").forward(req, resp);
		        }

		        rs.close();
		        ps.close();
		        conn.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		        req.setAttribute("alert", "Có lỗi xảy ra khi truy vấn CSDL");
		        req.getRequestDispatcher("/views/LoginForgetPass.jsp").forward(req, resp);
		    }
		}
	}

}

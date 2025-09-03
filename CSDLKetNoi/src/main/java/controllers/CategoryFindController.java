package controllers;

import dao.CategoryDao;
import dao.CategoryDaoImpl;
import category.Category;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class CategoryFindController
 */
@WebServlet("/admin/category/find")
public class CategoryFindController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            System.out.println(id);
            // Lấy dữ liệu từ DB
            CategoryDao dao = new CategoryDaoImpl();
            Category category = dao.getById(id);
            System.out.println(category);
            if (category != null) {
                req.setAttribute("category", category);
                req.getRequestDispatcher("/views/admin/editCategory.jsp").forward(req, resp);
            } else {
                req.setAttribute("alert", "Không tìm thấy danh mục với ID = " + id);
                req.getRequestDispatcher("/views/admin/edit-category.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("alert", "Có lỗi xảy ra!");
            req.getRequestDispatcher("/views/admin/edit-category.jsp").forward(req, resp);
        }
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

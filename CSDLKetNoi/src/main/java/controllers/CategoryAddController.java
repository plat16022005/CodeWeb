package controllers;

import category.Category;
import category.CategoryService;
import category.CategoryServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import util.Constant;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class CategoryAddController
 */
@WebServlet(urlPatterns = { "/admin/category/add" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50 // 50MB
)
public class CategoryAddController extends HttpServlet {
	CategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/add-category.jsp");
		dispatcher.forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		// Lấy tên danh mục
		String name = req.getParameter("name");

		// Lấy file upload (name="icon" trong form)
		Part filePart = req.getPart("icon");
		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

		// Tạo tên file mới để tránh trùng
		String ext = "";
		int idx = fileName.lastIndexOf(".");
		if (idx != -1) {
			ext = fileName.substring(idx);
		}
		String newFileName = System.currentTimeMillis() + ext;

		// Thư mục lưu
		File uploadDir = new File(Constant.DIR + "/category");
		if (!uploadDir.exists())
			uploadDir.mkdirs();

		// Ghi file ra ổ cứng
		filePart.write(uploadDir + File.separator + newFileName);

		// Tạo Category
		Category category = new Category(0, newFileName, newFileName);
		category.setname(name);
		category.setIcon("category/" + newFileName);

		// Gọi service/dao lưu vào DB
		cateService.insert(category);

		// Redirect về danh sách
		resp.sendRedirect(req.getContextPath() + "/admin/category/list");
	}
}

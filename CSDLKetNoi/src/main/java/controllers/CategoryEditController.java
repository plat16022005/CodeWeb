package controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

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
@WebServlet("/admin/category/edit")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 2,  // 2MB
    maxFileSize = 1024 * 1024 * 10,       // 10MB
    maxRequestSize = 1024 * 1024 * 50     // 50MB
)
public class CategoryEditController extends HttpServlet {
	CategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Category category = cateService.get(Integer.parseInt(id));
		req.setAttribute("category", category);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/edit-category.jsp");
		dispatcher.forward(req, resp);
	}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        // Lấy dữ liệu text
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");

        // Lấy file upload (nếu có)
        Part filePart = req.getPart("icon");

        String iconPath = null;
        if (filePart != null && filePart.getSize() > 0) {
            String fileName = Paths.get(filePart.getSubmittedFileName())
                                   .getFileName().toString();

            // Lấy đuôi file
            String ext = "";
            int idx = fileName.lastIndexOf(".");
            if (idx != -1) {
                ext = fileName.substring(idx);
            }
            String newFileName = System.currentTimeMillis() + ext;

            // Thư mục lưu
            File uploadDir = new File(Constant.DIR + "/category");
            if (!uploadDir.exists()) uploadDir.mkdirs();

            // Lưu file xuống ổ cứng
            filePart.write(uploadDir + File.separator + newFileName);

            iconPath = "category/" + newFileName;
        }

        // Tạo Category
        Category category = new Category(0, iconPath, iconPath);
        category.setid(id);
        category.setname(name);
        category.setIcon(iconPath); // Nếu null thì service/DAO nên giữ ảnh cũ

        // Gọi service update
        cateService.edit(category);

        // Redirect về list
        resp.sendRedirect(req.getContextPath() + "/admin/category/list");
    }
}

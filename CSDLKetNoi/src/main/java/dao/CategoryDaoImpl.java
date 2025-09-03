package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import category.Category;
import plat.dev.DBConnectionMySQL;

public class CategoryDaoImpl extends DBConnectionMySQL implements CategoryDao {
    private Connection conn;
    public CategoryDaoImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/laptrinhweb",
                "root",
                "@Tuan16022005"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void CategoryDao() throws Exception {
        conn = new DBConnectionMySQL().getConnection();
    }
    @Override
    public void insert(Category category) {
        String sql = "INSERT INTO category(cate_name, icons) VALUES (?, ?)";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, category.getname());
            ps.setString(2, category.getIcon());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public void edit(Category category) {
        String sql = "UPDATE category SET cate_name=?, icons=? WHERE cate_id=?";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, category.getname());
            ps.setString(2, category.getIcon());
            ps.setInt(3, category.getid());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM category WHERE cate_id=?";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public Category get(int id) {
        String sql = "SELECT * FROM category WHERE cate_id=?";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Category category = new Category(0, sql, sql);
                category.setid(rs.getInt("cate_id"));
                category.setname(rs.getString("cate_name"));
                category.setIcon(rs.getString("icons"));
                return category;
            }
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }

    @Override
    public List<Category> getAll() {
        List<Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM category";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category(0, sql, sql);
                category.setid(rs.getInt("cate_id"));
                category.setname(rs.getString("cate_name"));
                category.setIcon(rs.getString("icons"));
                categories.add(category);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return categories;
    }

    @Override
    public Category get(String name) {
        String sql = "SELECT * FROM category WHERE cate_name=?";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Category category = new Category(0, sql, sql);
                category.setid(rs.getInt("cate_id"));
                category.setname(rs.getString("cate_name"));
                category.setIcon(rs.getString("icons"));
                return category;
            }
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }

    @Override
    public List<Category> search(String keyword) {
        List<Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM category WHERE cate_name LIKE ?";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category(0, sql, sql);
                category.setid(rs.getInt("cate_id"));
                category.setname(rs.getString("cate_name"));
                category.setIcon(rs.getString("icons"));
                categories.add(category);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return categories;
    }
    public Category getById(int id) {
        String sql = "SELECT * FROM category WHERE cate_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Category cate = new Category(0, sql, sql);
                cate.setid(rs.getInt("cate_id"));
                cate.setname(rs.getString("cate_name"));
                cate.setIcon(rs.getString("icons"));
                return cate;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

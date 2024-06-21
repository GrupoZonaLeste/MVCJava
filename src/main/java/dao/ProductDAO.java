package dao;

import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

public class ProductDAO {

	public static void insert(Product product) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO projeto (titulo, dataFinal, descricao, status, id_usuario) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.createConnection();
             PreparedStatement pstm = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            pstm.setString(1, product.getTitle());
            pstm.setDate(2, new java.sql.Date(product.getEndDate().getTime())); // Convert java.util.Date to java.sql.Date
            pstm.setString(3, product.getDescription());
            pstm.setString(4, product.getStatus());
            pstm.setInt(5, product.getUserId());

            pstm.executeUpdate();

            // Retrieve the auto-generated ID
            ResultSet rs = pstm.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                product.setId(id);
            }
        }
    }

    public static Product getById(int id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM projeto WHERE idproj = ?";
        try (Connection conn = ConnectionFactory.createConnection();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setInt(1, id);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getInt("idproj"));
                    product.setTitle(rs.getString("titulo"));
                    product.setEndDate(rs.getDate("dataFinal"));
                    product.setDescription(rs.getString("descricao"));
                    product.setStatus(rs.getString("status"));
                    product.setUserId(rs.getInt("id_usuario"));
                    return product;
                }
            }
        }
        return null;
    }

    public static void deleteById(int id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM projeto WHERE idproj = ?";
        try (Connection conn = ConnectionFactory.createConnection();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setInt(1, id);
            pstm.executeUpdate();
        }
    }

    public ArrayList<Product> listByUserId(long userId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM projeto WHERE id_usuario = ?";
        ArrayList<Product> productList = new ArrayList<>();
        try (Connection conn = ConnectionFactory.createConnection();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setLong(1, userId);
            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getInt("idproj"));
                    product.setTitle(rs.getString("titulo"));
                    product.setEndDate(rs.getDate("dataFinal"));
                    product.setDescription(rs.getString("descricao"));
                    product.setStatus(rs.getString("status"));
                    product.setUserId(rs.getInt("id_usuario"));
                    productList.add(product);
                }
            }
        }
        return productList;
    }

    public static void update(Product product) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE projeto SET titulo = ?, dataFinal = ?, descricao = ?, status = ?, id_usuario = ? WHERE idproj = ?";
        try (Connection conn = ConnectionFactory.createConnection();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, product.getTitle());
            pstm.setDate(2, new java.sql.Date(product.getEndDate().getTime())); // Convert java.util.Date to java.sql.Date
            pstm.setString(3, product.getDescription());
            pstm.setString(4, product.getStatus());
            pstm.setInt(5, product.getUserId());
            pstm.setInt(6, product.getId());

            pstm.executeUpdate();
        }
    }
}
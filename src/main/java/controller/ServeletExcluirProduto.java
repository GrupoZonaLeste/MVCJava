package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.ProductDAO;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/urlExcluirProjeto")
public class ServeletExcluirProduto extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int projectId = Integer.parseInt(request.getParameter("idproj"));
        
        try {
            ProductDAO.deleteById(projectId);
            response.sendRedirect("listar.jsp"); // Redirect back to the list page
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            // Handle the error appropriately
        }
    }
}

package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;
import model.Usuario;
import dao.ProductDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/urlListarProdutos")
public class ServeletListarProdutos extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
            if (usuario != null) {
                long userId = usuario.getId();
                ProductDAO productDAO = new ProductDAO();
                ArrayList<Product> productList = productDAO.listByUserId(userId);

                // Set productList as an attribute in request
                request.setAttribute("projetos", productList);

                // Forward to JSP to display the products
                RequestDispatcher dispatcher = request.getRequestDispatcher("listar.jsp");
                dispatcher.forward(request, response);
            } else {
                response.sendRedirect("login.jsp");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); // Handle or log exception
            // Redirect to an error page or handle error response
        }
    }
}


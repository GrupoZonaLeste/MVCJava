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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/urlCriarProjeto")
public class ServletCadastrarProduto extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ServletCadastrarProduto() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        // Retrieve userId from session
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        int userId = 1;
        
        String title = request.getParameter("titulo");
        String endDateStr = request.getParameter("data_final");
        String description = request.getParameter("descricao");
        String status = request.getParameter("status");
        String mensagem = "";

        if (title.isEmpty() || endDateStr.isEmpty() || description.isEmpty() || status.isEmpty()) {
            mensagem = "Todos os campos devem ser preenchidos!";
        } else {
            try {
                // Parse endDate string to Date format
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date endDate = sdf.parse(endDateStr);

                // Create Product object with userId
                Product product = new Product(title, endDate, description, status, userId);

                // Insert Product into database
                ProductDAO.insert(product);

                mensagem = "Projeto criado com sucesso!";
            } catch (ParseException e) {
                e.printStackTrace();
                mensagem = "Erro ao converter data final!";
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                mensagem = "Erro ao criar projeto no banco de dados!";
            }
        }

        request.setAttribute("mensagem", mensagem);
        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
        dispatcher.forward(request, response);
    }
}


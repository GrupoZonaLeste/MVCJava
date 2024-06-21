package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.ProductDAO;
import model.Product;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/urlAtualizarProjeto")
public class ServeletAtualizarProduto extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idproj = Integer.parseInt(request.getParameter("idproj"));
        String titulo = request.getParameter("titulo");
        String dataFinalStr = request.getParameter("dataFinal");
        String descricao = request.getParameter("descricao");
        String status = request.getParameter("status");
        int idUsuario = Integer.parseInt(request.getParameter("id_usuario"));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dataFinal = null;
        try {
            dataFinal = sdf.parse(dataFinalStr);
        } catch (ParseException e) {
            e.printStackTrace();
            // Handle the error appropriately
        }

        Product projeto = new Product();
        projeto.setId(idproj);
        projeto.setTitle(titulo);
        projeto.setEndDate(dataFinal);
        projeto.setDescription(descricao);
        projeto.setStatus(status);
        projeto.setUserId(idUsuario);

        try {
            ProductDAO.update(projeto);
            response.sendRedirect("listar.jsp");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            // Handle the error appropriately
        }
    }
}

package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;

import java.io.IOException;
import java.sql.SQLException;

import dao.UsuarioDAO;

/**
 * Servlet implementation class ServletLogarUsuario
 */
public class ServletLogarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogarUsuario() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String mensagem = "";
		
		//DEBUG
		System.out.println("Email: "+ email);
		System.out.println("Senha: "+ senha);
		
		//Valiação de campos Vazio
		if(email.isEmpty() || senha.isEmpty()) {
			mensagem = "Todos os Campos devem ser preenchidos";
		} else {
			try {
				//Validação de autenticação
				Usuario usuario = UsuarioDAO.autenticar(email, senha);
				if(usuario != null) {
					//senão for nulo, inicia uma sessão para o usuario e redireciona para a home
					request.getSession().setAttribute("usuario", usuario);
					response.sendRedirect("home.jsp");
					return;
				} else {
					//senão estiver compatível a senha com o email
					mensagem = "Email ou Senha incorretos!";
				}
			} catch(SQLException | ClassNotFoundException e) {
				e.printStackTrace();
				mensagem = "Erro ao acessar o Banco de Dados";
			}
		}
		
		request.setAttribute("mensagem", mensagem);
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}

}

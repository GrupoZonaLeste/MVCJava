package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Persistencia;
import model.Usuario;

import java.io.IOException;
import java.sql.SQLException;

import dao.UsuarioDAO;

public class ServletCadastrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletCadastrarUsuario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append("\n Dados cadastrados com sucesso");
		//System.out.println("RECEBI A REQUISIÇÃO GET");
		response.sendRedirect("home.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		System.out.println("RECEBI A REQUISIÇÃO POST");
				
		//RECEBE OS VALORES DOS INPUTS DO HTML
		String nome = request.getParameter("nome");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String mensagem;	
		
		//DEBUG
		//System.out.println(nome + "\n" + login + "\n" + senha);
		
		//Validações
		if(nome!=null && !nome.isEmpty()) {
			Usuario user = new Usuario(nome, login, senha);
			Persistencia.lista.add(user);
			System.out.println(Persistencia.getLista());
			
			try {
				UsuarioDAO.insere(user);
				mensagem="\n Dados Cadastrados com sucesso";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				mensagem="\n Erro ao cadastrar Usuario no Banco de Dados!";
			}
			
			
			//response.sendRedirect("home.jsp");
		} else {
			mensagem="\n Dados não Cadastrados. Campos Vazios!";
		}
		request.setAttribute("mensagem", mensagem); 
		RequestDispatcher dispatcher= request.getRequestDispatcher("cadastrarUsuario.jsp"); 
		dispatcher.forward(request, response); 

		// doGet(request, response); 
		
	}

}

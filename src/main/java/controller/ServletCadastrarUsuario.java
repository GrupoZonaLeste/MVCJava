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
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String conf_senha = request.getParameter("conf_senha");
		String mensagem = "";	
		
		//DEBUG
		//System.out.println(nome + "\n" + email + "\n" + senha);
		 System.out.println("Nome: " + nome);
		    System.out.println("Email: " + email);
		    System.out.println("Senha: " + senha);
		    System.out.println("Confirma Senha: " + conf_senha);
		
		//Validações de campos vazio
		if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || conf_senha.isEmpty()) {
            mensagem = "Todos os campos devem ser preenchidos!";
            //Validações de senha e confirmar senha
        } else if (!senha.equals(conf_senha)) {
            mensagem = "As senhas não correspondem!";
        } else {
            try {
            	//Validação de email existente no Banco de Dados
            	if(UsuarioDAO.existeEmail(email)) {
            		mensagem = "Email já cadastrado! Tente Novamente com outro Email!";
            	} else {
            		Usuario user = new Usuario(nome, email, senha);
                    UsuarioDAO.insere(user);
                    mensagem = "Dados cadastrados com sucesso!";
            	}	
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                mensagem = "Erro ao cadastrar usuário no banco de dados!";
            }
        }
		request.setAttribute("mensagem", mensagem); 
		RequestDispatcher dispatcher= request.getRequestDispatcher("cadastrarUsuario.jsp"); 
		dispatcher.forward(request, response); 

		// doGet(request, response); 
		
	}

}

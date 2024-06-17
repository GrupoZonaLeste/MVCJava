package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ServletCadastrarProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServletCadastrarProduto() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("RECEBI A REQUISIÇÃO GET");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		System.out.println("RECEBI A REQUISIÇÃO POST");
		
		//RECEBE OS VALORES DOS INPUTS DO HTML
		String descricao = request.getParameter("descricao");
		String mensagem;
		int quantidade;
		double preco;
		
		if(descricao != null && !descricao.isEmpty() && request.getParameter("quantidade") != null
				&& !request.getParameter("quantidade").isEmpty() && request.getParameter("preco") != null
				&& !request.getParameter("preco").isEmpty()) {
			quantidade = Integer.parseInt(request.getParameter("quantidade"));
			
			preco = Double.parseDouble(request.getParameter("preco"));
			System.out.println("TESTE: "+descricao);
			System.out.println("TESTE: "+quantidade);
			System.out.println("TESTE: "+preco);
		
				
		boolean online = false;
		if (request.getParameter("online") != null && request.getParameter("online").equals("on")) 
			online = true;
			//DEBUG
			System.out.println("TESTE: "+online);
		
		mensagem = "Produto Cadastrado com Sucesso!";
		request.setAttribute("mensagem", mensagem);
		RequestDispatcher dispatcher = request.getRequestDispatcher("CadastrarProduto.jsp");
		} else {
			mensagem = "Os Campos obrigatórios precisam ser preenchidos";
		}
	}

}

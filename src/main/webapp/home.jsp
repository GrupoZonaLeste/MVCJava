<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.Usuario" %>
	<%@ page import="jakarta.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="home.css">
<title>Tela Principal</title>
</head>
<body>
<nav class="bNav">
		<ul>
			<li><a href="home.jsp">Criar Projeto</a></li>
			 <li><a href="listar.jsp">Meus Projetos</a></li> 
			 <li><a href="logout" style="color:#8a0000;">Sair</a></li>
		</ul>
	</nav>
	
	<main class="bMain">
	
	 <%
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            if (usuario != null) {
        %>
            <h1 style="margin-top: 2rem; text-align: center; margin-bottom: 2rem; color: white;">
            Seja Bem-vindo, <%= usuario.getNome() %>!</h1>
        <%
            } else {
                response.sendRedirect("login.jsp");
            }
        %>
	
		<form action="urlCriarProjeto" method="post" class="form_CriarProjeto" style="">
			<div>
				<h1>Criação de Projeto</h1>
			</div>
		
			<div>
				<label><strong>Título:</strong></label>
				<input type="text"name="titulo" placeholder="Digite seu título" required>
			</div>
			
			<div>
				<label><strong>Data Final:</strong></label>
				<input type="date" name="data_final" placeholder="Escolha a data final" required>
			</div>
			
			<div>
				<label><strong>Descrição:</strong></label>
				<textarea name="descricao" placeholder="Descreva o seu projeto" required></textarea>
			</div>
			
			<div>
				<label><strong>Status:</strong></label>
				<input type="text" name="status" placeholder="Digite o status do projeto" required>
			</div>
			
			<div>
				<input id="bButton" type="submit" name="criar_projeto" value="CRIAR PROJETO">
			</div>
			
			<div> <% 
			String mensagem=(String) request.getAttribute("mensagem"); 
			if(mensagem!=null) 
    		out.print(mensagem); 
			%> 
			</div> 
		</form>
	</main>
	
</body>
</html>
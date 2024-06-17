<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="UTF-8">
<title>Projeto Web</title>
</head>
<body>
	<nav class="bNav">
		<ul>
			<li><span style="color: yellow">Projeto Web</span></li>
			<li><img src="img/carteira-de-identidade.png" height="25px"></li>
			<li><a href="cadastrarUsuario.jsp" style="color: #ffffff">Cadastrar Usuario</a></li>
			<li><a href="mostrardadosUsuario.jsp" style="color: #ffffff">Mostrar Dados do Usuario</a></li>
		</ul>
	</nav>
	<main class="bMain">
		<form action="urlCadastrarUsuario" method="post" class="bForm">
			<div>
				<label><strong>Nome:</strong></label><input type="text"
					name="nome">
			</div>
			<div>
				<label><strong>Login:</strong></label><input type="text"
					name="login">
			</div>
			<div>
				<label><strong>Senha:</strong></label><input type="password"
					name="senha">
			</div>
			
			<!--  
			<label><strong>Disponível On-Line:</strong></label><input
				type="checkbox" name="online">
			<br>
			-->
			<div>
				<input id="bButton" type="submit" name="salvar"
					value="Cadastrar Usuario">
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
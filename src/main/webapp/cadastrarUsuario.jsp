<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="cadastro.css">
<meta charset="UTF-8">
<title>Projeto Web</title>
</head>
<body>
	<!-- <nav class="bNav">
		<ul>
			<li><span style="color: yellow">Projeto Web</span></li>
			<li><img src="img/carteira-de-identidade.png" height="25px"></li>
			<li><a href="cadastrarUsuario.jsp" style="color: #ffffff">Cadastrar Usuario</a></li>
			<li><a href="mostrardadosUsuario.jsp" style="color: #ffffff">Mostrar Dados do Usuario</a></li>
		</ul>
	</nav>-->
	<main class="bMain">
		<form action="urlCadastrarUsuario" method="post" class="bForm" >
			<div>
				<h1>Cadastro de Usuário</h1>
			</div>
			<div>
				<label><strong>Nome:</strong>
				</label><input type="text" name="nome" placeholder="Digite o seu nome" required>
			</div>
			<div>
				<label><strong>Email:</strong></label>
				<input type="email" name="email" placeholder="Digite o seu email" required>
			</div>
			<div>
				<label><strong>Senha:</strong>
				</label><input type="password" name="senha" placeholder="Digite a sua senha" required>
			</div>
			
			<div>
				<label><strong>Confirmar Senha:</strong>
				</label><input type="password" name="conf_senha" placeholder="Confirme a senha" required>
			</div>
			
			<!--  
			<label><strong>Disponível On-Line:</strong></label><input
				type="checkbox" name="online">
			<br>
			-->
			<div>
				<input id="bButton" type="submit" name="salvar"
					value="CADASTRAR">
			</div>
			
			<div> <% 
			String mensagem=(String) request.getAttribute("mensagem"); 
			if(mensagem!=null) 
    		out.print(mensagem); 
			%> 
			</div> 
			
			<div class="div_cadastro">
			<li class="li_cadastro"><p style="font-weight: 600;">Já tem Cadastro? Clique Abaixo:</p> <a href="login.jsp" class="btn_logar">LOGAR</a></li>
			</div>
		</form>
	</main>
</body>
</html>
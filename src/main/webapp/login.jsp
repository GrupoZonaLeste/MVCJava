
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="login.css">
<meta charset="UTF-8">
<title>ProjetoWeb</title>
</head>
<body>
	<!--<nav class="bNav">
		<ul>
			<li><span style="color: yellow">Projeto Web</span></li>
			 <li><img src="img/background.jpg" height="20px"></li>
			<li><a href="cadastrarUsuario.jsp">Cadastrar Usuario</a></li>
			 <li><a href="mostrardadosUsuario.jsp">Mostrar Dados do Usuario</a></li> 
		</ul>
	</nav>-->
	<main class="bMain">
		<form action="urlLogarUsuario" method="post" class="form_login" style="">
			<div>
				<h1>Login</h1>
			</div>
		
			<div>
				<label><strong>Email:</strong></label>
				<input type="email"name="email" placeholder="Digite seu email" required>
			</div>
			<div>
				<label><strong>Senha:</strong></label>
				<input type="password" name="senha" placeholder="Digite sua senha" required>
			</div>
			<div>
				<input id="bButton" type="submit" name="logar" value="LOGAR">
			</div>
			
			<div class="div_login">
			<li class="li_login"><p style="font-weight: 600;">Não tem um Login? Clique Abaixo:</p> <a href="cadastrarUsuario.jsp" class="btn_cadastrar">CADASTRAR</a></li>
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
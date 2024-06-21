<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">

<meta charset="UTF-8">
<title>ProjetoWeb</title>
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
		<form action="" method="post" class="bForm">
			<div>
				<label><strong>Busca por Código(id):</strong></label><input type="text"
					name="id">
			</div>
			<br>
			<div>
				<input id="bButton" type="submit" name="btbuscar"
					value="Mostrar Dados do Usuarioo">
			</div>
		</form>
	</main>
</body>
</html>
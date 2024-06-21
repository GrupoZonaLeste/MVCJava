<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Product" %>
<%@ page import="dao.ProductDAO" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="model.Usuario" %> <!-- Import the Usuario class -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Projeto</title>
</head>
<body>
<%
    int projectId = Integer.parseInt(request.getParameter("idproj"));
    Product projeto = null;
    try {
        projeto = ProductDAO.getById(projectId);
    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
        // Handle the error appropriately
    }
    if (projeto != null) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        long userId = usuario.getId();
%>		
    <form action="urlAtualizarProjeto" method="post">
        <input type="hidden" name="idproj" value="<%= projeto.getId() %>">
        <input type="hidden" name="id_usuario" value="<%= userId %>">
        Título: <input type="text" name="titulo" value="<%= projeto.getTitle() %>"><br>
        Data Final: <input type="date" name="dataFinal" value="<%= new SimpleDateFormat("yyyy-MM-dd").format(projeto.getEndDate()) %>"><br>
        Descrição: <input type="text" name="descricao" value="<%= projeto.getDescription() %>"><br>
        Status: <input type="text" name="status" value="<%= projeto.getStatus() %>"><br>
        <input type="submit" value="Atualizar Projeto">
    </form>
<%
    } else {
    	
%>
    <p>Projeto não encontrado.</p>
<%
    }
%>
</body>
</html>

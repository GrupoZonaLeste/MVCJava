<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Product" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="model.Usuario" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="listar.css">
<title>Tela Meus Projetos</title>
</head>
<body>
<nav class="bNav">
    <ul>
        <li><a href="home.jsp">Criar Projeto</a></li>
        <li><a href="listar.jsp">Meus Projetos</a></li> 
        <li><a href="logout" style="color:#8a0000;">Sair</a></li>
    </ul>
</nav>

<main class="bMain" style="margin-top: 0;">

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

<div class="div_projetos">
    <div>
        <h1>Meus Projetos</h1>
    </div>
    
    <!-- Button to list projects -->
    <form action="urlListarProdutos" method="get" class="bForm">
        <input type="submit" value="Listar Projetos">
    </form>

    <div class="lista-projetos">
        <table>
            <thead>
                <tr>
                    <th>Título</th>
                    <th>Data Final</th>
                    <th>Descrição</th>
                    <th>Status</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    ArrayList<Product> projetos = (ArrayList<Product>) request.getAttribute("projetos");
                    if (projetos != null && !projetos.isEmpty()) {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        for (Product projeto : projetos) {
                %>
                <tr>
                    <td><%= projeto.getTitle() %></td>
                    <td><%= sdf.format(projeto.getEndDate()) %></td>
                    <td><%= projeto.getDescription() %></td>
                    <td><%= projeto.getStatus() %></td>
                    <td>
                        <form action="editarProjeto.jsp" method="post" style="display:inline;">
                            <input type="hidden" name="idproj" value="<%= projeto.getId() %>">
                            <input type="submit" name="editar_projeto" value="EDITAR">
                        </form>
                        <form action="urlExcluirProjeto" method="post" style="display:inline;">
                            <input type="hidden" name="idproj" value="<%= projeto.getId() %>">
                            <input type="submit" name="excluir_projeto" value="EXCLUIR">
                        </form>
                    </td>
                </tr>
                <% 
                        }
                    } else {
                %>
                <tr>
                    <td colspan="5">Nenhum projeto encontrado.</td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</div>

</main>
</body>
</html>

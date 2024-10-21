<%-- 
    Document   : Editar
    Created on : 9 de out. de 2024, 09:33:03
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="CSS/Produto.css"/>
    </head>
    <body>
        <main>
            <article>
        <%
            
            packUser.Produto.setDescricao(request.getParameter("descricao"));
            packUser.Produto.setFabricante(request.getParameter("fabricacao"));
            packUser.Produto.setQuantidade(Integer.parseInt(request.getParameter("qtd")));
            packUser.Produto.setPreco(Float.parseFloat(request.getParameter("preco")));
            packUser.Produto.setCodigo(request.getParameter("codigo"));
            
            packUser.ProdutoDAL.alteraCadastro();
            
            if(packUser.Erro.getErro())
                out.print(packUser.Erro.getMens());
            else
                out.print("Produto Alterado");
                
            packUser.Erro.setErro(false);
        %>
            </article>
        </main>
    </body>
</html>

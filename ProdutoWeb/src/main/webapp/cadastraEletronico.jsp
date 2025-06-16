<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Cadastro de Produtos</title>
<link rel="stylesheet" href="./estilos/estiloIndex.css">
</head>
<body>

	<div class="container">
		<h2>Cadastro de Produto</h2>
		<label class="cabecalho" id="msg">
		<%
			if (request.getParameter("pmensagem") != null)
				out.write(request.getParameter("pmensagem"));
		%>
		</label>
		<form method="post" action="receberDadosEletronico.jsp">

			<div class="form-group">
				<label for="codigo">Código:</label> 
				<input type="text" id="codigo" name="codigo" required>
			</div>
			<div class="form-group">
				<label for="nome">Nome:</label> 
				<input type="text" id="nome" name="nome" required>
			</div>
			<div class="form-group">
				<label for="preco">Preço:</label> 
				<input type="number" id="preco" name="preco" required>
			</div>
			
			<div class="form-group">
				<label for="marca">Marca:</label> 
				<input type="text" id="marca" name="marca" required>
			</div>

			<div class="form-group">
				<label for="garantia">Garantia:</label> 
				<input type="number" id="garantia" name="garantia" required>
			</div>
			
			<div class="buttons">
				<button class="btn-salvar"   type="submit">Salvar</button>
				<button class="btn-cancelar" type="reset">Cancelar</button>
			</div>
		</form>
	</div>

</body>
</html>
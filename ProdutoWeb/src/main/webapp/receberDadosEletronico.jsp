<%@page import="produtojdbc.Eletronico"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
	String vCodigo   = request.getParameter("codigo");
	String vNome     = request.getParameter("nome");
	double vPreco    = Double.parseDouble(request.getParameter("preco"));
	String vMarca    = request.getParameter("marca");
	int    vGarantia = Integer.parseInt(request.getParameter("garantia"));
	
	Eletronico p = new Eletronico(vCodigo,vNome,vPreco,vMarca,vGarantia);
	
	if (p.incluirEletronico()) {
		response.sendRedirect("cadastraEletronico.jsp?pmensagem=Produto cadastrado com sucesso");
	} else {
			response.sendRedirect("cadastraEletronico.jsp?pmensagem=Problemas ao cadastrar o produto");
	}
%>
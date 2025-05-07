package produtojdbc;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		String vCodProduto, vNomeProduto;
		Double vPrecoProduto;
		/*
		vCodProduto   = JOptionPane.showInputDialog("Código");
		vNomeProduto  = JOptionPane.showInputDialog("Nome");
		vPrecoProduto = 1200.00;
		
		Produto p1 = new Produto(vCodProduto,vNomeProduto, vPrecoProduto);
		if (p1.incluirProduto()) {
			System.out.println("Produto incluído com sucesso");
			
		}
		*/
		
		// listar produtos
		
		Eletronico e = new Eletronico();
		/*
		List<Produto> listaProdutos = new ArrayList<>();
		listaProdutos = e.listarProdutos();
		if (listaProdutos != null) {
			System.out.println("Codigo" + "\t" + "Nome" + "\t" + "Preco");			
			for (Produto pr : listaProdutos) {
				System.out.println(pr.getCodProduto() + "\t" + pr.getNomeProduto() + "\t" + pr.getPrecoProduto());			
			}
		} else {
			System.out.println("Não foram localizados registros para listar");
		}
		*/
		Produto p = new Produto();
		p.setCodProduto("EL01");
		p = e.consultaProduto();
		
		if (p != null) {
			System.out.println(p.getCodProduto() + " " + p.getNomeProduto() + " " + p.getPrecoProduto());
		} else  {
			System.out.println("Produto não cadastrado");
		}
	}

}

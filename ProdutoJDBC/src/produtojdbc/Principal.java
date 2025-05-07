package produtojdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		String vCodProduto, vNomeProduto, vMarca;
		Double vPrecoProduto;
		int    vGarantiaMeses;
		Scanner sc = new Scanner(System.in);
		
		// Entrada de dados
		/*
		System.out.print("Produto : ");
		vCodProduto   =  sc.next();
		System.out.print("Nome....: ");
		vNomeProduto  =  sc.next();		
		System.out.print("Preço...: ");
		vPrecoProduto =  sc.nextDouble();
		// eletronico
		System.out.print("Marca...: ");
		vMarca = sc.next();
		System.out.print("Garantia: ");
		vGarantiaMeses = sc.nextInt();
		Eletronico e = new Eletronico(vCodProduto, vNomeProduto, vPrecoProduto, vMarca, vGarantiaMeses);
		if (e.incluirProduto()) {
			System.out.println("Produto incluído com sucesso");
			
		}
	*/
		/*
		// listar produtos
		Eletronico e1 = new Eletronico();
		List<Eletronico> lista = new ArrayList();
		lista = e1.listarProdutos();
		System.out.printf("%-6s | %-15s |%-14s| %-13s | %-13s       ",
				          "Codigo","Nome","Preço","Marca","Garantia");
		System.out.println();
	    for (Eletronico l : lista) {
	       
	        System.out.printf("%-6s | %-15s |R$ %10.2f | %-13s |",
	        		          l.getCodProduto() , 
	        		          l.getNomeProduto(), 
	        		          l.getPrecoProduto(), 
	        		          l.getMarcaEletronico());
 		    System.out.println(l.getGarantiaMeses());

	    }		
		
		Produto p = new Produto();
		var produto = "EL01";
		p = e.consultaProduto(produto);
		
		if (p != null) {
			System.out.println(p.getCodProduto() + " " + p.getNomeProduto() + " " + p.getPrecoProduto());
		} else  {
			System.out.println("Produto não cadastrado");
		}
		*/
		
		// alterar Produto
		System.out.print("Produto : ");
		vCodProduto   =  sc.next();
		System.out.print("Nome....: ");
		vNomeProduto  =  sc.next();		
		System.out.print("Preço...: ");
		vPrecoProduto =  sc.nextDouble();
		Produto p = new Produto(vCodProduto, vNomeProduto, vPrecoProduto);
		Eletronico e = new Eletronico();
		if (e.alterarProduto()) {
			System.out.println("Produto alterado com sucesso");
		}
	}

}

package cadastrodeprodutos;

public class Alimento extends Produto{
	private String dataValidAlimento;
	private String categoriaAlimento;
	
	public Alimento(String codProduto, String nomeProduto, double precoProduto, 
			        String dataValidAlimento,String categoriaAlimento) {
		super(codProduto, nomeProduto, precoProduto);
		this.dataValidAlimento = dataValidAlimento;
		this.categoriaAlimento = categoriaAlimento;
	}

	
	public void exibir_Informacoes() {
		super.exibir_Informacoes();
		System.out.println("Validade........: " + this.dataValidAlimento);
		System.out.println("Categoria.......: " + this.categoriaAlimento);
		System.out.println("---------------------------------------");
		System.out.println();
	}
	
}

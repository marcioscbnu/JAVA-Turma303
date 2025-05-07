package cadastrodeprodutos;

public class Roupa extends Produto  {
	private String tamanhoRoupa;
	private String materialRoupa;
	
	public Roupa(String codProduto, String nomeProduto, double precoProduto, 
			     String tamanhoRoupa,String materialRoupa) {
		super(codProduto, nomeProduto, precoProduto);
		this.tamanhoRoupa = tamanhoRoupa;
		this.materialRoupa = materialRoupa;
	}
	
	public void exibir_Informacoes() {
		super.exibir_Informacoes();
		System.out.println("Tamanho.........: " + this.tamanhoRoupa);
		System.out.println("Material........: " + this.materialRoupa);
	}
	
	
}

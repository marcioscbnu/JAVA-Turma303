package cadastrodeprodutos;

public class Eletronico extends Produto {
	private String marcaEletronico;
	private int    garantiaMeses;
	
	public Eletronico(String codProduto, String nomeProduto, double precoProduto, 
			          String marcaEletronico,int garantiaMeses) {
		super(codProduto, nomeProduto, precoProduto);
		this.marcaEletronico = marcaEletronico;
		this.garantiaMeses = garantiaMeses;
	}
	
	public void exibir_Informacoes() {
		super.exibir_Informacoes();
		System.out.println("Marca...........: " + this.marcaEletronico);
		System.out.println("Garantia Meses..: " + this.garantiaMeses);
		System.out.println("---------------------------------------");
		System.out.println();
	
	}

	public String getMarcaEletronico() {
		return marcaEletronico;
	}

	public int getGarantiaMeses() {
		return garantiaMeses;
	}
	
	
	
	
}

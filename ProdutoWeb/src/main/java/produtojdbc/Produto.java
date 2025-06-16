package produtojdbc;

public class Produto {
	private String codigo;
	private String nome;
	private double preco;
	
	public Produto(){
		
	}
	
	public Produto(String codigo, String nome, double preco) {
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
	}

	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public double getPreco() {
		return preco;
	}


	public void setPreco(double preco) {
		this.preco = preco;
	}


	public void exibir_informacoes() {
		System.out.println("Codigo........: " + this.codigo);
		System.out.println("Nome..........: " + this.nome);
		System.out.println("Preco.........: " + this.preco);
	}
}

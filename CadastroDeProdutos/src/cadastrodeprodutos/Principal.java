package cadastrodeprodutos;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// ArrayList's
		ArrayList<Eletronico> arrele = new ArrayList<>();
		ArrayList<Alimento>   arrali = new ArrayList<>();
		ArrayList<Roupa>      arrrou = new ArrayList<>();
		
		// Controle do Menu e opções
		int opcaoOperacao, opcaoProduto;
		
		// variaveis para produto
		String codProduto;  
		String nomeProduto; 
		double precoProduto;
		
		// variaveis para eletronico
		String marcaEletronico; 
		int    garantiaMeses;
		// variaveis para alimento
		
		// variaveis para roupa
		
		// LAÇO DE REPETIÇÃO PRINCIPAL
		do {
			// pede a operação a ser realizada
			mostraMenu();			
			System.out.print("Informe a sua opção : ");
			opcaoOperacao = sc.nextInt();
			while((opcaoOperacao < 1 || opcaoOperacao > 4) && opcaoOperacao !=9){
				// checa valor válido para a operação
				System.out.println("Operação inválida. Reinforme");
				mostraMenu();
				opcaoOperacao = sc.nextInt();
			}
			if (opcaoOperacao == 9) {
				break;				
			}
			
			// informa o tipo de produto 
			System.out.print("Informe o tipo de produto ");
			System.out.println("1-Eletrônico  2-Alimento  3-Roupa");
			opcaoProduto = sc.nextInt();
			while(opcaoProduto < 1 || opcaoProduto > 3){
				// checa valor válido para o  tipo de Produto
				System.out.println("Produto inválido. Reinforme");
				System.out.println("1-Eletrônico  2-Alimento  3-Roupa");
				opcaoProduto = sc.nextInt();
			}
			// testa opção de operação e vai para um bloco específico
			switch (opcaoOperacao) {
			case 1: { 	if (opcaoProduto == 1) { // tratar inclusao de eletronico
							//entrada de dados
							System.out.println("Codigo..: ");
							codProduto = sc.next();
							System.out.println("Nome....: ");
							nomeProduto = sc.next();
							System.out.println("Preco...: ");
							precoProduto = sc.nextDouble();
							System.out.println("Marca...: ");
							marcaEletronico = sc.next();
							System.out.println("Garantia: ");
							garantiaMeses = sc.nextInt();
							Eletronico e = new Eletronico(codProduto, nomeProduto, precoProduto, marcaEletronico, garantiaMeses);
							// adicionar no arraylist
							arrele.add(e);
							System.out.println("Inclusão efetuada com sucesso");
							break;							
						}

					}
			case 2: { 	if (opcaoProduto == 1) { // alterar eletronico
							System.out.println("Informe o código a alterar");
							codProduto = sc.next();
							
							boolean encontrado = false;
							// buscar o produto dentro do arraylist
							for (int i = 0; i < arrele.size(); i++) {
								if (arrele.get(i).getCodProduto().equals(codProduto)) {									
									encontrado = true;
									nomeProduto     = arrele.get(i).getNomeProduto();
									precoProduto    = arrele.get(i).getPrecoProduto();
									marcaEletronico = arrele.get(i).getMarcaEletronico();
									garantiaMeses   = arrele.get(i).getGarantiaMeses();
									// reentrada de dados
									System.out.println("Nome....: ");
									nomeProduto = sc.next();
									System.out.println("Preco...: ");
									precoProduto = sc.nextDouble();
									System.out.println("Marca...: ");
									marcaEletronico = sc.next();
									System.out.println("Garantia: ");
									garantiaMeses = sc.nextInt();									
									Eletronico e1 = new Eletronico(codProduto, nomeProduto, precoProduto, marcaEletronico, garantiaMeses);
									arrele.set(i, e1);
									System.out.println("Eletronico alterado com sucesso");
								}
							}
							if (!encontrado) {
								System.out.println("Infelizmente não achei o codigo " + codProduto);								
							}							
						}
						break;			
			}
			case 3: { 	System.out.println("Informe o código a excluir");
						codProduto = sc.next();	
						
						boolean encontrado = false;
						char confirmaExclusao = 'N';
						
						// buscar o produto dentro do arraylist
						for (int i = 0; i < arrele.size(); i++) {
							if (arrele.get(i).getCodProduto().equals(codProduto)) {									
								encontrado = true;
								System.out.println("Confirma a exclusao do registro?(S/N)");
								confirmaExclusao = sc.next().toUpperCase().charAt(0);
								if (confirmaExclusao == 'S') {
									arrele.remove(i);									
								}
								System.out.println("Eletronico excluido com sucesso");
							}
						}
						if (!encontrado) {
							System.out.println("Infelizmente não achei o codigo " + codProduto);								
						}
						break;
			}
			case 4: { 	if (opcaoProduto == 1) { // tratar listar eletronicos
							for (Eletronico lste : arrele) {
								lste.exibir_Informacoes();
							}
						}
						break;
			}
			
		}
			
		} while (opcaoOperacao != 9);
		
		System.out.println("Obrigado por utilizar o programa");

		sc.close();
	}

	
	public static void mostraMenu() {
		System.out.println("1 - Incluir  2 - Alterar  3 - Excluir  4 - Consultar  9 = Fim");
	}
}

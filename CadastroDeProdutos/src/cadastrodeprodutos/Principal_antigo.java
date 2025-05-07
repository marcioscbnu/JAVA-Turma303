package cadastrodeprodutos;

import java.util.ArrayList;

public class Principal_antigo {

	public static void main(String[] args) {
		Eletronico e1 = new Eletronico("El01","CD Player",120.0,"CCE", 6); 
		e1.exibir_Informacoes();
		Alimento a1 = new Alimento("Fr01", "Maça",12.50,"14/03/2025","Frutas");
		
		ArrayList<Alimento> arrAli = new ArrayList<>();
		arrAli.add(a1);
		Alimento a2 = new Alimento("Ver01", "Repolho",5.80,"17/03/2025","Verduras");
		arrAli.add(a2);
		
		for (Alimento a : arrAli) {
			a.exibir_Informacoes();
		}
	}

}

package si20122.durante.desenvolvedores;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FolhaDeProdutividade {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Desenvolvedor> desenvolvedores = getDesenvolvedores();

		for (Desenvolvedor desenvolvedor : desenvolvedores) {
			System.out.println(desenvolvedor.getNome() + " "
					+ desenvolvedor.getProdutividade());
		}
	}

	private static List<Desenvolvedor> getDesenvolvedores() {
		List<Desenvolvedor> resultado = new LinkedList<Desenvolvedor>();

		resultado.add(new Desenvolvedor("Fulano"));
		resultado.add(new Desenvolvedor("Sicrano"));

		return resultado;
	}

}

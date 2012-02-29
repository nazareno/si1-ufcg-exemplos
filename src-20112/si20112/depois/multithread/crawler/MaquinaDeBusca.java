package si20112.depois.multithread.crawler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MaquinaDeBusca {

	private Map<String, Integer> indice = new HashMap<String, Integer>();

	/**
	 * Retorna quantas ocorrências do texto foram encontradas nos documentos
	 * indexados até agora.
	 * 
	 * @param text
	 *            Texto a ser buscado.
	 * @return Quantidade de ocorrências.
	 */
	public int buscaPor(String text) {
		return indice.containsKey(text) ? indice.get(text) : 0;
	}

	public void indexa(String caminho) throws IOException {
		File atual = new File(caminho);
		indexa(atual);
	}

	private void indexa(File caminho) throws IOException {
		if (caminho.isDirectory()) {
			File[] children = caminho.listFiles();
			for (File filho : children) {
				indexa(filho);
			}
		} else {
			if (!caminho.getName().endsWith(".java")) {
				return;
			}
			BufferedReader reader = new BufferedReader(new FileReader(caminho));
			while (reader.ready()) {
				String linha = reader.readLine();
				for (String palavra : linha.split(" ")) {
					incrementaOcorrencia(palavra);
				}
			}
		}
	}

	private void incrementaOcorrencia(String palavra) {
		if (!indice.containsKey(palavra)) {
			indice.put(palavra, 1);
		} else {
			indice.put(palavra, indice.get(palavra) + 1);
		}
	}

	public int getNumeroDeDocumentosIndexados() {
		return indice.size();
	}

}

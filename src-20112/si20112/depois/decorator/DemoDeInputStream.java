package si20112.depois.decorator;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.crypto.CipherOutputStream;
import javax.crypto.NullCipher;

public class DemoDeInputStream {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.out.println("Direto: ");
			copiaComInputStream("test-resources/arquivoGrande.txt",
					"output1.txt");

			System.out.println("Com Buffer: ");
			copiaComBuffer("test-resources/arquivoGrande.txt", "output2.txt");

			System.out.println("Compactando: ");
			copiaECompacta("test-resources/arquivoGrande.txt", "output3.zip");

			System.out.println("Compactando e criptografando: ");
			copiaECompactaECriptografa("test-resources/arquivoGrande.txt",
					"output4.zip");

		} catch (IOException e) {
			System.out.println("Mundo cruel: " + e.getMessage());
			e.printStackTrace();
		}

	}

	private static void copiaECompactaECriptografa(String origem,
			String arquivoDestino) throws IOException {

		InputStream arquivo = new BufferedInputStream(new FileInputStream(
				origem));

		ZipOutputStream destino = new ZipOutputStream(
									new CipherOutputStream(
				new BufferedOutputStream(new FileOutputStream(arquivoDestino)),
				new NullCipher()));
		
		// exemplo criptografando: Cipher.getInstance("DES/CBC/PKCS5Padding");

		destino.putNextEntry(new ZipEntry(origem));

		try {
			copiaByteAByte(arquivo, destino);
		} finally {
			arquivo.close();
			destino.close();
		}
	}

	private static void copiaECompacta(String origem, String arquivoDestino)
			throws IOException {

		InputStream arquivo = new BufferedInputStream(new FileInputStream(
				origem));

		ZipOutputStream destino = new ZipOutputStream(new BufferedOutputStream(
				new FileOutputStream(arquivoDestino)));

		destino.putNextEntry(new ZipEntry(origem));

		try {
			copiaByteAByte(arquivo, destino);
		} finally {
			arquivo.close();
			destino.closeEntry();
			destino.close();
		}
	}

	private static void copiaByteAByte(InputStream arquivo, OutputStream destino)
			throws IOException {
		long antes = System.currentTimeMillis();

		int byteLido = 0;
		while ((byteLido = arquivo.read()) != -1) {
			destino.write(byteLido);
		}

		long depois = System.currentTimeMillis();
		System.out.println("Copiado. Levou " + (depois - antes));
	}

	private static void copiaComBuffer(String filePath, String arquivoDestino)
			throws IOException {

		InputStream arquivo = new BufferedInputStream(new FileInputStream(
				filePath));

		OutputStream destino = new BufferedOutputStream(new FileOutputStream(
				arquivoDestino));

		try {
			copiaByteAByte(arquivo, destino);
		} finally {
			arquivo.close();
			destino.close();
		}
	}

	private static void copiaComInputStream(String filePath,
			String arquivoDestino) throws FileNotFoundException, IOException {

		InputStream arquivo = new FileInputStream(filePath);

		OutputStream destino = new FileOutputStream(arquivoDestino);

		try {
			copiaByteAByte(arquivo, destino);
		} finally {
			arquivo.close();
			destino.close();
		}

	}

}

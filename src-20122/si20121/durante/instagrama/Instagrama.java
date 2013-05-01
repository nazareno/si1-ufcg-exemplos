package si20121.durante.instagrama;

public class Instagrama {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Imagem foto = new Foto();
		
		foto = new FotoBorrada(foto);
		foto = new FotoBorrada(foto);
		
		System.out.println(foto.getImagem());
	}

}

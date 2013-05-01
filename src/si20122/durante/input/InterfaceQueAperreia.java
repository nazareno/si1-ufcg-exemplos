package si20122.durante.input;

import java.util.Scanner;

public class InterfaceQueAperreia {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		String lido = "";

		Enchedor threadSecundaria = new Enchedor();
		
		threadSecundaria.start();

		while (!lido.equals("sai")) {
			System.out.print("Digite algo: ");
			lido = leitor.nextLine();
			System.out.println("Você digitou: " + lido);
		}

		threadSecundaria.sair();

		System.out.println(Thread.currentThread().getName()+ ": F1: Saindo.");
	}

}

class Enchedor extends Thread {

	boolean sair = false;
	
	@Override
	public void run() {
		this.encherOSacoDoUsuario();
	}

	public void sair() {
		sair = true;
		this.interrupt();
	}

	public void encherOSacoDoUsuario() {
		while (!sair) {
			System.out.println("Acordado?");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println("F2: Fui acordado!");
			}
		}

		System.out.println("Fluxo 2: Parei de encher.");
	}
}

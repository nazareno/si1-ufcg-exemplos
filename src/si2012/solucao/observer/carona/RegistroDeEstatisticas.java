package si2012.solucao.observer.carona;

public class RegistroDeEstatisticas implements CaronaListener {

	private int totalCaronasEncerradas;

	public int getCaronasEncerradas() {
		return totalCaronasEncerradas;
	}

	public void acompanharCarona(Carona carona) {
		carona.addListener(this);
	}

	@Override
	public void notificaEncerramento(Carona encerrada) {
		totalCaronasEncerradas++;
		/*
		 * guardaria estatísticas como número de solicitações, etc.
		 */
	}

}

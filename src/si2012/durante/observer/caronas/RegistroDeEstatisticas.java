package si2012.durante.observer.caronas;

public class RegistroDeEstatisticas implements InteressadoEmCarona {

	private int totalCaronasEncerradas;

	public int getCaronasEncerradas() {
		return totalCaronasEncerradas;
	}

	public void addCarona(Carona carona) {
		carona.addInteressado(this);
	}

	public void caronaEncerrada(Carona carona) {
		totalCaronasEncerradas++;
	}

}

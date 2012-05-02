package si2012.durante.observer.caronas;

public class InterfaceDeMonitoramento implements InteressadoEmCarona {

	public void monitoraCarona(Carona carona) {
		carona.addInteressado(this);
	}

	public void caronaEncerrada(Carona carona) {
		System.out.println("Carona encerrada: " + carona.toString());
	}

}

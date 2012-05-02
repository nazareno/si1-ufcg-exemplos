package si2012.solucao.observer.carona;

public class InterfaceDeMonitoramento implements CaronaListener {

	public void monitoraCarona(Carona carona) {
		carona.addListener(this);
	}

	@Override
	public void notificaEncerramento(Carona carona) {
		System.out.println("Mais uma carona encerrada.");
	}

}

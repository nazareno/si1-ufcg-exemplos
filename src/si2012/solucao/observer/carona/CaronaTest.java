package si2012.solucao.observer.carona;

import static org.junit.Assert.*;

import org.junit.Test;

public class CaronaTest {

	@Test
	public void testAvisos() throws SolicitacaoIlegalException {
		Usuario usuario1 = new Usuario("Fulano");
		Usuario usuario2 = new Usuario("Beltrano");

		RegistroDeEstatisticas registro = new RegistroDeEstatisticas();
		InterfaceDeMonitoramento monitor = new InterfaceDeMonitoramento();

		Carona carona = new Carona();

		monitor.monitoraCarona(carona);
		registro.acompanharCarona(carona);
		
		usuario1.solicitaCarona(carona);
		usuario2.solicitaCarona(carona);

		carona.confirmaCaroneiro(usuario1);
		carona.encerraCarona();

		assertEquals(1, registro.getCaronasEncerradas());
		assertEquals(1, usuario1.getCaronasAceitas());
		assertEquals(0, usuario2.getCaronasAceitas());
		assertEquals(0, usuario2.getSolicitacoesPendentes());
	}

}

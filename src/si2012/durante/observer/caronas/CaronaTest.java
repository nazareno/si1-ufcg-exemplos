package si2012.durante.observer.caronas;

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

		monitor.monitoraCarona(carona); // deve imprimir uma msg quando ela for
										// encerrada
		registro.addCarona(carona);

		
		usuario1.solicitaCarona(carona);
		usuario2.solicitaCarona(carona);

		carona.confirmaCaroneiro(usuario1);
		carona.encerraCarona();

		assertEquals(1, registro.getCaronasEncerradas());
		
		assertEquals(1, usuario1.getCaronasAceitas());
		assertEquals(0, usuario2.getCaronasAceitas());
		assertEquals(0, usuario1.getSolicitacoesPendentes());
		assertEquals(0, usuario2.getSolicitacoesPendentes());

		/*
		 * Objetivo 1: ao encerrarmos uma carona, o monitor, o registro e os
		 * usuários que solicitaram ficam sabendo.
		 * 
		 * Objetivo 2: cada confirmação gera uma mudança no estado dos usuários
		 * relevantes e do registor de estatísticas, mas não do monitor.
		 */
	}

}

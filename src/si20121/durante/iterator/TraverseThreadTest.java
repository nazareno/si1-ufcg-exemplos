package si20121.durante.iterator;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TraverseThreadTest {

	private MsgDeForum msgOriginal;
	private MsgDeForum resposta1;
	private MsgDeForum resposta2;
	private MsgDeForum treplica;
	private OutraArvoreDeMsgs thread;

	@Before
	public void setUp() throws Exception {
		thread = new OutraArvoreDeMsgs();

		msgOriginal = new MsgDeForum("Fulano", "Mensagem original.");

		thread.addMensagem(msgOriginal);

		resposta1 = new MsgDeForum("Sicrano", "A resposta.");

		msgOriginal.addResposta(resposta1);

		treplica = new MsgDeForum("Fulano", "A tréplica.");
		resposta1.addResposta(treplica);

		resposta2 = new MsgDeForum("Beltrano", "Nada a declarar.");
		msgOriginal.addResposta(resposta2);
	}

	@Test
	public void testPercorreEmProfundidade() throws Exception {
		Iterator<MsgDeForum> it = thread.iteradorEmProfundidade();
		MsgDeForum msg = it.next();
		assertEquals(msgOriginal.getTexto(), msg.getTexto());
		msg = it.next();
		assertEquals(resposta1.getTexto(), msg.getTexto());
		msg = it.next();
		assertEquals(treplica.getTexto(), msg.getTexto());
		msg = it.next();
		assertEquals(resposta2.getTexto(), msg.getTexto());
		assertFalse(it.hasNext());
	}

	@After
	public void tearDown() throws Exception {
	}

}

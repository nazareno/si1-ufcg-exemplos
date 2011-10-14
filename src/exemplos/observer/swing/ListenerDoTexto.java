package exemplos.observer.swing;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ListenerDoTexto implements FocusListener, KeyListener {

	@Override
	public void focusGained(FocusEvent arg0) {
		System.out
				.println("Controller#focusGained: foco no componente de texto.");
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		System.out
				.println("Controller#focusLost: foco saiu do componente de texto.");
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent evento) {
		System.out.println("Controller#keyTyped: " + evento.getKeyChar()
				+ " em " + evento.getWhen());
	}

}

package exemplos.mvc.vc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import exemplos.mvc.model.DadosDoNegocio;


public class Controller implements ActionListener {

	private DadosDoNegocio model;

	public Controller(DadosDoNegocio model) {
		this.model = model;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		/*
		 * O controlador que sabe o que fazer quando o usu‡rio pede algo.
		 */
		this.model.addData();
	}

}

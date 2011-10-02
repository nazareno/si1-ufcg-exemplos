package exemplos.adapter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AdapterNoSwing {
	private JFrame window;
	private CamadaLogicaDoExemploComSwing camadaLogica;

	public AdapterNoSwing() {
		camadaLogica = CamadaLogicaDoExemploComSwing.getInstance();
		
		window = new JFrame("Janela");
		window.setBounds(30, 30, 300, 300);
		JButton botao = new JButton("Exemplo");
		
		botao.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				camadaLogica.metodoDaCamadaLogica();
			}
			
		});
		
		/* QUEREMOS QUE QUANDO O BOTÌO FOR APERTADO,
		 * CHAME CAMADALOGICA#METODODACAMADALOGICA() 
		 */
		
//		botao.addActionListener(new ActionListener(){
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				camadaLogica.metodoDaCamadaLogica();
//			}
//		});
		
		window.add(botao);
		window.setVisible(true);
	}

	public static void main(String[] args) {
		new AdapterNoSwing();
	}
}
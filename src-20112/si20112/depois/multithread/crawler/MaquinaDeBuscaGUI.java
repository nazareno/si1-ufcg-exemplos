package si20112.depois.multithread.crawler;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

public class MaquinaDeBuscaGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel painelPrincipal;
	private JButton botaoStart, botaoBusca;
	private JTextPane textoDeProgresso, textoDeResultados;
	private JTextField paraBuscar;

	private MaquinaDeBusca model;
	private JPanel painelSul;
	private JPanel painelCentro;
	private JPanel painelNorte;

	private Timer timerProgressoIndexacao = new Timer();

	public MaquinaDeBuscaGUI() {
		super("Maquina de busca XPTO");

		criarComponentes();
		configuraComponentes();

		model = new MaquinaDeBusca();

		this.pack();

	}

	private void configuraAcoesDoBotaoStart() {
		this.botaoStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				criaMonitorDeProgresso();
				new Thread(new Runnable(){
					@Override
					public void run() {
						try {
							model.indexa("..");
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}).start();
			}

		});
	}

	private void criaMonitorDeProgresso() {
		timerProgressoIndexacao.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				int indexado = model.getNumeroDeDocumentosIndexados();
				textoDeProgresso.setText("Indexado até agora: \n\n\t"
						+ indexado + " palavras");
			}
		}, 0, 500);
	}

	/**
	 * 
	 */
	private void configuraAcoesDoBotaoBusca() {
		this.botaoBusca.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String textoAlvo = paraBuscar.getText();
				int ocorrencias = model.buscaPor(textoAlvo);
				textoDeResultados.setText("\n Resultado da busca por "
						+ textoAlvo + ":\n\n " + ocorrencias
						+ " ocorrências encontradas");
			}
		});
	}

	/**
	 * 
	 */
	private void configuraComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		paraBuscar.setText("Digite sua busca aqui");
		textoDeProgresso.setEditable(false);
		textoDeProgresso.setPreferredSize(new Dimension(250, 100));
		textoDeProgresso.setText("Indexação parada.");
		textoDeResultados.setEditable(false);
		textoDeResultados.setBorder(new LineBorder(Color.BLACK));
		textoDeResultados.setPreferredSize(new Dimension(400, 400));

		painelNorte.add(paraBuscar);
		painelNorte.add(botaoBusca);
		painelCentro.add(textoDeResultados);
		painelSul.add(textoDeProgresso);
		painelSul.add(botaoStart);

		painelPrincipal.add(painelNorte, BorderLayout.NORTH);
		painelPrincipal.add(painelCentro, BorderLayout.CENTER);
		painelPrincipal.add(painelSul, BorderLayout.SOUTH);

		this.setContentPane(painelPrincipal);

		configuraAcoesDoBotaoBusca();
		configuraAcoesDoBotaoStart();
	}

	/**
	 * 
	 */
	private void criarComponentes() {
		painelPrincipal = new JPanel(new BorderLayout());
		painelNorte = new JPanel(new FlowLayout());
		painelCentro = new JPanel(new FlowLayout());
		painelSul = new JPanel(new FlowLayout());

		botaoStart = new JButton("Começar indexação");
		botaoBusca = new JButton("Buscar");
		paraBuscar = new JTextField();
		textoDeProgresso = new JTextPane();
		textoDeResultados = new JTextPane();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new MaquinaDeBuscaGUI().setVisible(true);
	}

}

package si20121.depois.multithread.sincronizacao1;

import java.util.GregorianCalendar;

public class Usuario {

	private final String nome;
	private String item;
	private boolean itemDisponivel;
	private boolean emprestado;

	public Usuario(String nome) {
		this.nome = nome;
		item = null;
		emprestado = false;
		itemDisponivel = false;
	}

	public void cadastraItem(String item) {
		this.item = item;
	}

	public void setItemDisponivel() {
		if (!emprestado) {
			String mensagemParaLogar = Thread.currentThread().getName()
					+ "- Setou item Disponivel: "
					+ GregorianCalendar.getInstance().getTime().getTime();

			this.itemDisponivel = true;
			System.out.println(mensagemParaLogar);
		}
	}

	public boolean isItemDisponivel() {
		return itemDisponivel;
	}

	public void setItemIndisponivel() {
		if (!emprestado) {
			this.itemDisponivel = false;
			System.out.println(Thread.currentThread().getName()
					+ "- Setou item INdisponivel.");

		}
	}

	public boolean empresta(Usuario sicrano) {
		try {
			verificaEstadoDoSistemaDeEmail();
		} catch (EmailIndisponivelException e) {
			// trata a exceção de alguma forma 
		}
		
		if (isItemDisponivel()) {
			emprestado = true;
			return true;
		} else {
			return false;
		}
	}

	public void itemDevolvido() throws EstadoDeItemIlegalException {
		if (!emprestado || !isItemDisponivel()) {
			throw new EstadoDeItemIlegalException();
		}
		emprestado = false;
	}

	private void verificaEstadoDoSistemaDeEmail()
			throws EmailIndisponivelException {
		try {
			// e se aumentarmos aqui para 1000?
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

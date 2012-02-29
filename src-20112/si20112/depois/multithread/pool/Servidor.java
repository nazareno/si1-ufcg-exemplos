package si20112.depois.multithread.pool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Servidor {
	private FachadaDoSistema fachada = FachadaDoSistema.getInstance();

	private ExecutorService servicoDeExecucao = Executors.newCachedThreadPool();
	
	public static void main(String[] args) {

		Servidor servidor = new Servidor();

		List<Integer> requisicoes = new ArrayList<Integer>();

		for (int i = 0; i < 10; i++) {
			requisicoes.add(i);
		}

		long antes = System.currentTimeMillis();
		servidor.processa(requisicoes);
		long depois = System.currentTimeMillis();

		System.out.println("\nPROCESSADO. Demorou " + (depois - antes) + "ms");
	}

	private void processa(List<Integer> requisicoes) {
		((ThreadPoolExecutor) servicoDeExecucao).prestartAllCoreThreads();
		System.out.println("Iniciando processamento");
		List<Future<Float>> futures = new ArrayList<Future<Float>>();
		for (final Integer id : requisicoes) {
			Callable<Float> trabalho = new Callable<Float>(){
				@Override
				public Float call() {
					System.out.println("Processando R: " + id);
					fachada.alteraDadosDoUsuario();
					System.out.println("Acabou R: " + id);
					return 42f;
				}
			};
			
			futures.add(servicoDeExecucao.submit(trabalho));
		}
		
		try {
			for (Iterator iterator = futures.iterator(); iterator.hasNext();) {
				Future<Float> future = (Future<Float>) iterator.next();
				Float resultado = future.get();
				System.out.println("Resultado: " + resultado);
			}
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		} catch (ExecutionException e1) {
			e1.printStackTrace();
		}
		
		servicoDeExecucao.shutdown();
		
		try {
			servicoDeExecucao.awaitTermination(60, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

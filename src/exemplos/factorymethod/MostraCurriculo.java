package exemplos.factorymethod;

import com.sun.tools.corba.se.idl.InvalidArgument;

public class MostraCurriculo {

	/**
	 * @param args
	 * @throws InvalidArgument 
	 */
	public static void main(String[] args) throws InvalidArgument {

		Curriculo cv = new Curriculo("Nazareno",
				"Professor do DSC", "Endereço completo", "Histórico escolar",
				"Outras informações");

		System.out.println(cv.toString());
		
	}

}

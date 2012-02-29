package si20112.depois.factorymethod;

import com.sun.tools.corba.se.idl.InvalidArgument;

public class MostraCurriculo {

	/**
	 * @param args
	 * @throws InvalidArgument 
	 */
	public static void main(String[] args) throws InvalidArgument {

		Curriculo cv = new Curriculo("Nazareno",
				"Professor do DSC", "Endere�o completo", "Hist�rico escolar",
				"Outras informa��es");

		System.out.println(cv.toString());
		
	}

}

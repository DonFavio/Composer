package co.edu.unbosque.controller;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.Tulio;
import co.edu.unbosque.view.View;

public class Controller {
	
	private Tulio model;
	private View view;

	public Controller() {
		
		model = new Tulio();
		view = new View();
		funcionar();
		}
	
 	public void funcionar(){
 		int menu;
 		do {
 			menu=view.pedirMenu();
 			
 			switch (menu) {
			case 1:
				int ESTRO =view.pedirEstrofas();			
				int FRAS =view.pedirFrsese();
				model.gestionarPropiedades(ESTRO, FRAS);
				break;
			case 2:
				String Save = model.crearCancionYGuardarConParametros();
				view.escribirDato(Save);
				model.guardarCancionEnArchivo(Save);
		        break;
			case 3:
				view.escribirDato(model.seleccionarCancionYMostrar());
				break;
			case 4:
				view.escribirDato("GRACIAS POR UTILIZAR ESTE PROGRAMA");
				break;
			default:
				view.escribirDato("DIGITASTE UN NUMNERO INCORRECTO, TRATA DE NUEVO");
			break;
}
		} while (menu != 4);
	 		
}
}

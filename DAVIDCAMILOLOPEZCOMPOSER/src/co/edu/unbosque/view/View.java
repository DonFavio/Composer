package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class View {
	
	/* metodo de prueba que pide un dato por JOptionPane y retorna el String correspondiente
	 * Reemplazar por lo que se necesiten
	 */
	
	public int pedirMenu() 
	{
		return Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese cualquiera de los opciones","Song",JOptionPane.INFORMATION_MESSAGE));
	}
	public int pedirEstrofas() 
	{
		return Integer.parseInt(JOptionPane.showInputDialog(null,"COLOQUE LAS ESTROFAS QUE QUIERE QUE TENGA LA CANCION","Mero Lindo",JOptionPane.INFORMATION_MESSAGE));
	}
	public int pedirFrsese() 
	{
		return Integer.parseInt(JOptionPane.showInputDialog(null,"COLOQUE CUALQUIER NUMERO DE FRASES","Hay Morrr",JOptionPane.INFORMATION_MESSAGE));
	}
	
	
	/* metodo de prueba que imprime un dato procesado por un m�todo declarado en 
	 * Reemplazar por lo que se necesiten
	 */

	public void escribirDato(String dato) 
	{
		JOptionPane.showMessageDialog(null, dato, "Ratatata", JOptionPane.INFORMATION_MESSAGE);
	}
}

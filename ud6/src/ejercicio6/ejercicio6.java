package ejercicio6;

import javax.swing.JOptionPane;

/**
 * 
 * @author Jose Antonio Gonz�lez Alc�ntara
 * 
 * Clase de Java de la TA06-Metodos y Arrays Ejercicio 6
 *
 */
public class ejercicio6 {

	public static void main(String[] args) {
		/*Crea una aplicación que nos cuente
		  el número de cifras de un número entero
		  positivo pedido por teclado. Crea un método que realice esta acción
		  pasando un número por parámetro devolverá el número de cifras*/
		
		
		String entradaTeclado;
		int numeroValidar;
		
		do {
			
			entradaTeclado = JOptionPane.showInputDialog("Introduce el número \n"
													   + "que quieres contar las cifras"
													   + " (tiene que ser un entero positivo "
													   + "y no más de 9 cifras)");
			
		} while (!validarEnteroEntrada(entradaTeclado));
		
		numeroValidar = Integer.parseInt(entradaTeclado);
		
		JOptionPane.showMessageDialog(null, "Las cifras del número " + numeroValidar  
										+ " son " + cuentaCifras(numeroValidar));
		

	}
	
	//cuenta las cifras de un numero
	public static int cuentaCifras(int numero) {
		
		String cifras;
			
		cifras = String.valueOf(numero);
		
		return cifras.length();
	}
	
	public static boolean validarEnteroEntrada(String entradaTeclado) {

		// Si cancelamos el pane
		if (entradaTeclado != null) {
			
			if (!entradaTeclado.isEmpty()) {
				

				if(entradaTeclado.matches("[^-]\\d+") && entradaTeclado.length() <= 9) {
					
					return true;
					
				}else {
					
					JOptionPane.showMessageDialog(null, "No has introducido un número válido");
					return false;
					
				}

			}else {
				
				JOptionPane.showMessageDialog(null, "La cadena no puede estar vacia");
				return false;
				
			}

		} else {

			JOptionPane.showMessageDialog(null, "La aplicaciónn se cerrara");
			System.exit(0);
		}

		return false;

	}

}

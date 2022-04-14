package ejercicio3;

import javax.swing.JOptionPane;

/**
 * 
 * @author Jose Antonio Gonz�lez Alc�ntara
 * 
 * Clase de Java de la TA06-Metodos y Arrays Ejercicio 3
 *
 */
public class ejercicio3 {

	public static void main(String[] args) {
		/*Crea una aplicación que nos pida un 
		  número por teclado y con un método se
		  lo pasamos por parámetro para que nos 
		  indique si es o no un número primo, 
		  debe devolver true si es primo sino false.
		  Un número primo es aquel que solo puede 
		  dividirse entre 1 y si mismo. Por ejemplo:
		  25 no es primo, ya que 25 es divisible entre
		  5, sin embargo, 17  si es primo*/
		
		String entradaTeclado;
		int numeroValidar;
		
		do {
			
			entradaTeclado = JOptionPane.showInputDialog("Introduce el número \n"
													   + "que quieres validar si es primo"
													   + " (tiene que ser un entero positivo)");
			
		} while (!validarEnteroEntrada(entradaTeclado));

		numeroValidar = Integer.parseInt(entradaTeclado);
		
		if (esPrimo(numeroValidar)) {
			
			JOptionPane.showMessageDialog(null, "El número " + numeroValidar + " SI es primo");
			
		}else {
			
			JOptionPane.showMessageDialog(null, "El número " + numeroValidar + " NO es primo");
		}
		
		
		
	}
	
	/*Método que verifica si un número es primo basandose
	 en la premisa que cualquier número que se divida entre 2, 
	 entonces (numero/2) también divide entre el numero y que
	 el 2 es el único primo par.*/
	public static boolean esPrimo(int numero) {
		
		//El número uno no es primo
		if (numero == 1) {
			
			return false;
		}
		
		//El dos es el primer primo		
		if (numero == 2) {
			
			return true;
		}
		
		//Verifica si es divisible por dos
		if (numero % 2 == 0) {
			
			return false;
			
		}
			
		//Verifica recorriendo números impares hasta la raiz cuadrada del número
		for (int i = 3; i * i <= numero; i += 2) {
			
			if (numero % i == 0) {
				
				return false;
				
			}
				
		}
		
		return true;

	}
	
	public static boolean validarEnteroEntrada(String entradaTeclado) {

		// Si cancelamos el pane
		if (entradaTeclado != null) {
			
			if (!entradaTeclado.isEmpty()) {

				if(entradaTeclado.matches("-?\\d+") && !(Integer.parseInt(entradaTeclado) < 0)) {
					
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

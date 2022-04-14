package ejercicio5;

import javax.swing.JOptionPane;

/**
 * 
 * @author Jose Antonio Gonz�lez Alc�ntara
 * 
 * Clase de Java de la TA06-Metodos y Arrays Ejercicio 5
 *
 */
public class ejercicio5 {

	public static void main(String[] args) {
		/*Crea una aplicación que nos convierta
		  un número en base decimal a binario.
		  Esto lo realiza un método al que le pasaremos
		  el número como parametro, devolverá un String
		  con el número convertido a binario. Para convertir
		  un número decimal a binario, debemos dividir entre
		  2 el número y el resultado de esa división se divide
		  entre 2 de nuevo hasta que no se pueda dividir mas, 
		  el resto que obtengamos de cada división formara 
		  número binario, de abajo a arriba*/
		
		String entradaTeclado;
		int numeroDecimal;
		String binario;
		
		do {
			
			entradaTeclado = JOptionPane.showInputDialog("Introduce el número \n"
													   + "en base decimal para convertir\n"
													   + " a binario(tiene que ser un entero positivo)");
			
		} while (!validarEnteroEntrada(entradaTeclado));

		numeroDecimal = Integer.parseInt(entradaTeclado);
		
		binario = convertirDecimalABinario(numeroDecimal, "");
		
		JOptionPane.showMessageDialog(null, "El número en base decimal " + numeroDecimal + " en binario es " + binario);
	}
	
	public static String convertirDecimalABinario(int numeroDecimal, String binario) {
		
		if (numeroDecimal < 2) {
			
			binario = binario + String.valueOf(numeroDecimal);
			
		}else {

			binario = convertirDecimalABinario(numeroDecimal / 2, binario);
			binario = binario + String.valueOf(numeroDecimal % 2);
	
		}
		
		return binario;
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

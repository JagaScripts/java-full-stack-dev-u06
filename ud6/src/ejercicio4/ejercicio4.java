package ejercicio4;

import javax.swing.JOptionPane;

/**
 * 
 * @author Jose Antonio Gonz�lez Alc�ntara
 * 
 * Clase de Java de la TA06-Metodos y Arrays Ejercicio 4
 *
 */
public class ejercicio4 {

	public static void main(String[] args) {
		/*Crea una aplicación qu nos calcuale el factorial
		  de un número pedido por teclado, lo realizara
		  mediante un método al que le pasamos el nímero 
		  como parametro. Para calcular el factorial,
		  se multiplica los números anteriores hasta llegar a uno.
		  Por ejemplo, si introducimos un 5, realizara esta operación 5*4*3*2*1=120*/
		
		String entradaTeclado;
		int numero;
		int factorial;
		
		do {

			entradaTeclado = JOptionPane.showInputDialog(
					"Introduce el múmero de el \n" + "que quieres el factorial (tiene que ser un entero positivo)");

		} while (!validarNumeroNaturalEntrada(entradaTeclado));
		
		numero = Integer.parseInt(entradaTeclado);
		
		factorial = factorial(numero);
		
		if (factorial != 0) {
			
			JOptionPane.showMessageDialog(null, "El factorial de " + numero + " es " + factorial);
			
		}else {
			
			JOptionPane.showMessageDialog(null, "El factorial de " + numero + " es demasiado grande para calcular con nuestra aplicación");
						
		}
		
		

	}
	
	
	//funcion recursiva para calcular el factorial
	public static int factorial(int numero) {
		
		if (numero == 0) {
			
			return 1;
			
		}else {
			
			return numero * factorial(numero-1);
			
		}
		
		
	}
	
	public static boolean validarNumeroNaturalEntrada(String entradaTeclado) {

		// Si cancelamos el pane
		if (entradaTeclado != null) {
			
			if (!entradaTeclado.isEmpty()) {	
				

				if(entradaTeclado.matches("-?\\d+") && !(Integer.parseInt(entradaTeclado) <= 0)) {
					
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

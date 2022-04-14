package ejercicio9;

import java.util.Random;

import javax.swing.JOptionPane;

/**
 * 
 * @author Jose Antonio Gonz�lez Alc�ntara
 * 
 * Clase de Java de la TA06-Metodos y Arrays Ejercicio 9
 *
 */
public class ejercicio9 {

	public static void main(String[] args) {
		
		int array[];
		
		array = creaArray();
		

	}
	
	public static int[] creaArray() {
		
		String entradaTeclado;
		do {
			
			entradaTeclado = JOptionPane.showInputDialog("Introduce el número \n"
													   + "que quieres como valor n " + i 
													   + " (tiene que ser un entero positivo)");
			
		} while (!validarEnteroEntrada(entradaTeclado));
		
		int tamano = Integer.parseInt(entradaTeclado);
		
		int array[] = new int[tamano];
		
		return array;
		
	}
	
	public static int[] rellenarArrayAleatorios(int numBase, int numTope) {
		
		for (int i = 0; i < array.length; i++) {
			
		}
		
		Random random;
		int numeroAleatorio; 

		random = new Random();
	    numeroAleatorio = numBase + random.nextInt((numTope+1) - numBase);
		
		return null;
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

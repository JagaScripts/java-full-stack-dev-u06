package ejercicio8;

import javax.swing.JOptionPane;

/**
 * 
 * @author Jose Antonio Gonz�lez Alc�ntara
 * 
 * Clase de Java de la TA06-Metodos y Arrays Ejercicio 8
 *
 */
public class ejercicio8 {

	public static void main(String[] args) {

		int array[] = new int[10];
		
		rellenarArray(array);
		mostrarArray(array);

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
	
	public static void  rellenarArray(int[] array) {
		
		String entradaTeclado;
		
		for (int i = 0; i < array.length; i++) {
			
			do {
				
				entradaTeclado = JOptionPane.showInputDialog("Introduce el número \n"
														   + "que quieres como valor n " + i 
														   + " (tiene que ser un entero positivo)");
				
			} while (!validarEnteroEntrada(entradaTeclado));

			array[i] = Integer.parseInt(entradaTeclado);
		}
	}
	
	public static void mostrarArray(int[] array) {
		
		for (int i = 0; i < array.length; i++) {
			
			System.out.println( "El indice de la array es " + i 
					 + " y el valor de la posicion correspondiente es " + array[i]);
		}
	}
}

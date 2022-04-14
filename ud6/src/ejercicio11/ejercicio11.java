package ejercicio11;

import java.util.Random;

import javax.swing.JOptionPane;

/**
 * 
 * @author Jose Antonio Gonz�lez Alc�ntara
 * 
 * Clase de Java de la TA06-Metodos y Arrays Ejercicio 11
 *
 */
public class ejercicio11 {
	
	public static void main(String[] args) {
		
		String entradaTeclado;
		
		do {
			
			entradaTeclado = JOptionPane.showInputDialog("Introduce la cantidad de números  \n"
													   + " que quieres generar"
													   + " (tiene que ser un entero positivo)");
			
		} while (!validarEnteroEntrada(entradaTeclado));
		
		int tamano = Integer.parseInt(entradaTeclado);
		
		int array1[] = new int[tamano];
		
		rellenarArrayAleatorios(0, 9, array1);
		
		int array2[] = array1; 
		
		rellenarArrayAleatorios(0, 9, array2);
		
		int array3[] = multiplicarArrays(array1, array2);
		
		String salida = "";
		
		salida += mostrarArray(array1);
		salida += mostrarArray(array2);
		salida += mostrarArray(array3);
		
		JOptionPane.showMessageDialog(null, salida);			

	}
	
	public static int[] multiplicarArrays(int[] array1,int[] array2) {
		
		int[] arrayProducto = new int[array1.length];
		
		for (int i = 0; i < array1.length; i++) {
			
			arrayProducto[i] = array1[i] * array2[i];
		}
		
		return arrayProducto;
		
	}
	
	public static void rellenarArrayAleatorios(int numBase, int numTope, int[] array) {
		
		for (int i = 0; i < array.length; i++) {
			array[i] = generarNumeroAleatorio(numBase, numTope);
		}
				
	}
	
	public static int generarNumeroAleatorio(int numBase, int numTope){
		
		Random random;
		int numeroAleatorio; 

		random = new Random();
	    numeroAleatorio = numBase + random.nextInt((numTope+1) - numBase);
		return numeroAleatorio;
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
	
	public static String mostrarArray(int[] array) {
		

		String mensajeArray;
		
		mensajeArray = "Array de números aleatorios \n";
		
		for (int i = 0; i < array.length; i++) {
			
			mensajeArray += "El indice de la array es " + i 
					 + " y el valor de la posicion correspondiente es " + array[i] + "\n ";
			
		}
		
		return mensajeArray;
	}

}

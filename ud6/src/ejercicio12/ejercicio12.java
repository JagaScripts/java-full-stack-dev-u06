package ejercicio12;

import java.util.Random;

import javax.swing.JOptionPane;

/**
 * 
 * @author Jose Antonio Gonz�lez Alc�ntara
 * 
 * Clase de Java de la TA06-Metodos y Arrays Ejercicio 12
 *
 */
public class ejercicio12 {

	public static void main(String[] args) {
		
		String entradaTeclado;
		char digito;
		
		do {
			
			entradaTeclado = JOptionPane.showInputDialog("Introduce la cantidad de números  \n"
													   + " que quieres generar"
													   + " (tiene que ser un entero positivo)");
			
		} while (!validarEnteroEntrada(entradaTeclado));
		
		int tamano = Integer.parseInt(entradaTeclado);
		
		int array[] = new int[tamano];
		
		rellenarArrayAleatorios(1, 300, array);
		
		do {
			
			entradaTeclado = JOptionPane.showInputDialog(null,"Introduce el digito"
														+ " para mostrar los acabados en el digito");
			
		} while (!validarCaracterEntrada(entradaTeclado));
		
		digito = (char) entradaTeclado.charAt(0);
		
		int arraySeleccionada[] = seleccionarTerminacion(array, digito);
		
		mostrarArray(arraySeleccionada);		

	}
	
	public static int[] seleccionarTerminacion(int[] array, char digito) {
		
		int arraySeleccionada[];
		String numero;
		char ultimoDigito;
		int tamano = 0;
		
		for (int i = 0; i < array.length; i++) {
			
			numero = String.valueOf(array[i]);
			ultimoDigito = numero.charAt(numero.length() - 1);
		
			if (ultimoDigito == digito) {
				tamano++;
			}
		}
		
		arraySeleccionada = new int[tamano];
		
		for (int i = 0, x = 0; i < arraySeleccionada.length; i++) {
			
			numero = String.valueOf(array[i]);
			ultimoDigito = numero.charAt(numero.length() - 1);
			
			if (ultimoDigito == digito) {
				
				arraySeleccionada[x++] = array[i];
				
			}
			
		}
		
		return arraySeleccionada;
	}
	
	public static boolean validarCaracterEntrada(String entradaTeclado) {
			
		if (entradaTeclado != null) {
			
			if (entradaTeclado.length() == 1) {
				
				return true;
				
			}else {
				
				JOptionPane.showMessageDialog(null,"Porfavor introduce un solo caracter");
				return false;
						
			}
			
		}else {
			
			JOptionPane.showMessageDialog(null,"Se cerrara la aplición");
			System.exit(0);
		}
		
		return false;
		
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
	
	public static void mostrarArray(int[] array) {
		

		String mensajeArray;
		
		mensajeArray = "Array de números aleatorios \n";
		
		for (int i = 0; i < array.length; i++) {
			
			mensajeArray += "El indice de la array es " + i 
					 + " y el valor de la posicion correspondiente es " + array[i] + "\n ";
			
		}
		
		JOptionPane.showMessageDialog(null, mensajeArray);
	}
	
	
}

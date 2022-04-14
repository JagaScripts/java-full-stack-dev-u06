package ejercicio10;

import java.util.Random;

import javax.swing.JOptionPane;

/**
 * 
 * @author Jose Antonio Gonz�lez Alc�ntara
 * 
 * Clase de Java de la TA06-Metodos y Arrays Ejercicio 10
 *
 */
public class ejercicio10 {

	

	public static void main(String[] args) {
		
		final String RANGO[] = {"base","tope"};
		String entradaTeclado;
		int rangoValores[] = new int[2];

		do {

			entradaTeclado = JOptionPane.showInputDialog("Introduce la cantidad de números  \n" + " que quieres generar"
					+ " (tiene que ser un entero positivo)");

		} while (!validarEnteroEntrada(entradaTeclado));

		int tamano = Integer.parseInt(entradaTeclado);

		int array[] = new int[tamano];

		do {

			for (int i = 0; i < RANGO.length; i++) {

				do {

					entradaTeclado = JOptionPane.showInputDialog(
							"Introduce el múmero " + RANGO[i] + " para el rango (tiene que ser un entero positivo)");

				} while (!validarNumeroNaturalEntrada(entradaTeclado));

				rangoValores[i] = Integer.parseInt(entradaTeclado);

			}

		} while (!validarRangoEntrada(rangoValores));
		
		rellenarArrayAleatoriosPrimos(rangoValores[0], rangoValores[1], array);
		
		

	}
	
	public static int calcularMayorNumero(int array[]) {

		int numeromayor = 0;

		for (int i = 0; i < array.length; i++) {
			if (numeromayor < array[i]) {
				
				numeromayor = array[i];
				
			}
		}

		return numeromayor;

	}
	
	public static void rellenarArrayAleatoriosPrimos(int numBase, int numTope, int[] array) {
		
		int numeroAleatorio;
		
		for (int i = 0; i < array.length; i++) {
			
			do {
				
				numeroAleatorio = generarNumeroAleatorio(numBase, numTope);
				
			} while (!esPrimo(numeroAleatorio));
		
			array[i] = numeroAleatorio;
		}
				
		JOptionPane.showMessageDialog(null, "El numero primo mas grande de la array es " + calcularMayorNumero(array));
	
	}
	
	public static int generarNumeroAleatorio(int numBase, int numTope){
		
		Random random;
		int numeroAleatorio; 

		random = new Random();
	    numeroAleatorio = numBase + random.nextInt((numTope+1) - numBase);
		return numeroAleatorio;
		
	}
	
	public static boolean esPrimo(int numero) {

		// El número uno no es primo
		if (numero == 1) {

			return false;
		}

		// El dos es el primer primo
		if (numero == 2) {

			return true;
		}

		// Verifica si es divisible por dos
		if (numero % 2 == 0) {

			return false;

		}

		// Verifica recorriendo números impares hasta la raiz cuadrada del número
		for (int i = 3; i * i <= numero; i += 2) {

			if (numero % i == 0) {

				return false;

			}

		}

		return true;

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
	
	public static boolean validarRangoEntrada(int[] rangoValores) {

		int rango;

		rango = rangoValores[1] - rangoValores[0];

		if (rango < 0) {

			JOptionPane.showMessageDialog(null, "El rango no es válido");
			return false;
		}

		return true;
	}

}

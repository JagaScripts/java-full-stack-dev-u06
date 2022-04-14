package ejercicio2;
import java.util.Random;

import javax.swing.JOptionPane;

/**
 * 
 * @author Jose Antonio González Alcántara
 * 
 * Clase de Java de la TA06-Metodos y Arrays Ejercicio 2
 *
 */
public class ejercicio2 {

	public static void main(String[] args) {
		/*Crea una aplicación que nos genere
		  una cantidad de números enteros aleatorios
		  que nosotros le pasamos por teclado.
		  Crea un método donde pasamos como párametros
		  entre que números queremos que los genere,
		  podemos pedirlas por teclado antes de generar los números.
		  Este método devolverá un número entero aleatorio.
		  Muestra estos números por pantalla*/
		
		//pedirNumeroEntrada x
		//validarEnteroEntrada x
		//pedirNumeroEntrada
		//generarNumeroAleatorio
		//generarNumerosAleatorios
		//mostrarArrayNumeros
		
		//mostrar numeros
		final String RANGO[] = {"base","tope"};
		String entradaTeclado;
		int cantidadNumeros;
		int rangoValores[] = new int[2];
		int arrayNumeros[];
	
		
		do {
			
			entradaTeclado = JOptionPane.showInputDialog("Introduce la cantidad de múmeros \n"
													   + "que quieres generar (tiene que ser un entero positivo)");
			
		} while (!validarNumeroNaturalEntrada(entradaTeclado));
		
		cantidadNumeros = Integer.parseInt(entradaTeclado);
		
		do {
			
			for (int i = 0; i < RANGO.length; i++) {
				
				do {

					entradaTeclado = JOptionPane.showInputDialog("Introduce el múmero " + RANGO[i] 
															   + " para el rango (tiene que ser un entero positivo)");

				} while (!validarNumeroNaturalEntrada(entradaTeclado));
				
				rangoValores[i] = Integer.parseInt(entradaTeclado);
				
			}

		} while (!validarRangoEntrada(rangoValores));
		
		arrayNumeros =  generarNumerosAleatorios(cantidadNumeros, rangoValores);
		
		mostrarArrayNumeros(arrayNumeros);
		
	}
	
	//valida el rango para asegurars que el usuario introduce un rango correcto
	public static boolean validarRangoEntrada(int[] rangoValores) {
		
		int rango;
	
		rango = rangoValores[1] - rangoValores[0];
		
		if (rango < 0) {
			
			JOptionPane.showMessageDialog(null, "El rango no es válido");
			return false;
		}
		
		return true;
	}

	//valida netrada como un número natural
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
	
	//genera un numero aleatorio segun un rango
	public static int generarNumeroAleatorio(int numBase, int numTope){
		
		Random random;
		int numeroAleatorio; 

		random = new Random();
	    numeroAleatorio = numBase + random.nextInt((numTope+1) - numBase);
		return numeroAleatorio;
	}
	
	//genera numeros aleatorios dependiendo de una cantidad y un rango
	public static int[] generarNumerosAleatorios(int cantidad, int[] rango) {
		
		int numerosAleatorios[] = new int[cantidad];
		
		for (int i = 0; i < cantidad; i++) {
			
			numerosAleatorios[i] = generarNumeroAleatorio(rango[0], rango[1]);
			
		}
		
		return numerosAleatorios;
	}
	
	//muestra el indice y contenido de una array por filas 
	public static void mostrarArrayNumeros(int[] arrayNumeros) {
		
		String mensaje;
		
		mensaje =  "Estos son los números aleatroios generados\n";
		
		for (int i = 0; i < arrayNumeros.length; i++) {
			
			mensaje = mensaje +  "Número aleatorio " + (i+1) + ". " + arrayNumeros[i] + "\n";
			
		}
		
		JOptionPane.showMessageDialog(null,mensaje);
		
	}

}

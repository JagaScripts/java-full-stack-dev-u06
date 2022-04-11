package ejercicio1;

import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JOptionPane;


/**
 * 
 * @author Jose Antonio González Alcántara
 * 
 * Clase de Java de la TA06-Metodos y Arrays Ejercicio 1
 *
 */
public class ejercicio1 {

	public static void main(String[] args) {
		/*Crea una aplicaciónn que nos calcule
		  el área de un circulo, cuadrado o triangulo.
		  Pediremos que figura queremos calcular su área
		  y según lo introduccido pedirá los valores 
		  necesarios para calcular el área.
		  Crear un método por cada figura para
		  calcular cada área, este devolverá un número real.
		  Muestra el resultado por pantalla*/
		
		char opcionFigura;
		
		mostrarMenu();
		opcionFigura = validarCaracterEntrada();
		seleccionarCalculoFigura(opcionFigura);
		validarDoubleEntrada();

		
		
	}
	
	public static double validarDoubleEntrada() {
		
		String entradaTeclado;
		boolean esNumerico;
		
		do {

			

			// Si cancelamos el pane
			if (entradaTeclado != null) {

				// Como aún no hemos visto manejo de excepciones
				// Compruebo mediante el metodo matches del tipo String si lo introducido es un
				// número
				esNumerico = entradaTeclado.matches("[+-]?\\d*(\\.\\d+)?");

				if (esNumerico) {

					return true;

				} else {

					JOptionPane.showMessageDialog(null, "No has introducido un número valido");

				}

			} else {
				
				JOptionPane.showMessageDialog(null, "La aplicaciÃ³n se cerrara");
				esNumerico = false;
			}

		} while (!esNumerico && entradaTeclado != null);
		
		return entradaTeclado;
		
	}
	
	public static Double calcularAreaCirculo(String[] valores) {

		// Uso la constante PI de Math y la asigno a mi constante PI
		final double PI = Math.PI;

		// Declaramos la variable que almacena el texto introducido por el usuario y el
		// radio
		String entradaTeclado;
		double radioCirculo;
		double areaCirculo;
		boolean esNumerico;

		do {

			entradaTeclado = JOptionPane.showInputDialog(
					"Introduce el radio, el valor tienen que ser nÃºmerico," + " el separador decimal es el . (punto)");
			
			areaCirculo = 0.0;

			// Si cancelamos el pane
			if (entradaTeclado != null) {

				// Como aÃºn no hemos visto manejo de excepciones
				// Compruebo mediante el metodo matches del tipo String si lo introducido es un
				// nÃºmero
				esNumerico = entradaTeclado.matches("[+-]?\\d*(\\.\\d+)?");

				if (esNumerico) {

					// Parseamos a double el texto para que sea un double
					radioCirculo = Double.parseDouble(entradaTeclado);

					// Calculamos el area del circulo
					areaCirculo = PI * Math.pow(radioCirculo, 2);
					
					return areaCirculo;


				} else {

					JOptionPane.showMessageDialog(null, "No has introducido un número valido");

				}

			} else {

				esNumerico = false;
			}

		} while (!esNumerico && entradaTeclado != null);
		
		return areaCirculo;
	}
	
	public static String pedirFigura() {

		String entradaTeclado;
		Scanner scanner;		

		System.out.println("Elige el número de la figura que quieres calcular su area");
		scanner = new Scanner(System.in);
		entradaTeclado = scanner.nextLine();
		
		scanner.close();
		return entradaTeclado;

	}

	public static void mostrarMenu() {
		
		System.out.println("Menú de opciones para calcular areas");
		System.out.println("1. Circulo (valor por defecto)");
		System.out.println("2. Triangulo");
		System.out.println("3. Cuadrado");
		System.out.println("4. Salir de la apliación");
		
	}
	
	public static  void seleccionarCalculoFigura(char opcion) {
		
		final String CIRCULO[] = {"radio"};
		final String TRIANGULO[] = {"base","altura"};
		final String CUADRADO[] = {"lado","lado"};
		
		switch (opcion) {
		case '1':
			JOptionPane.showMessageDialog(null,"El area del circulo es " + calcularAreaCirculo(CIRCULO));
			break;
		case '2':
			JOptionPane.showMessageDialog(null,"El area del circulo es " + calcularAreaTriangulo(TRIANGULO));
			break;
		case '3':
			JOptionPane.showMessageDialog(null,"El area del circulo es " + calcularAreaCuadrado(CUADRADO));
			break;
		case '4':
			JOptionPane.showMessageDialog(null,"Se cerrara la aplición");
			break;
		default:
			System.out.println("Elige una opción válida");
			break;
		}
		
	}
	
	public static char validarCaracterEntrada() {
		
		String entradaTeclado;
		boolean esOpcionValida;			

		do {
			
			entradaTeclado = pedirFigura();
			
			esOpcionValida = (entradaTeclado.length() == 1);

			if (!esOpcionValida) {
				
				System.out.println("Porfavor introduce un solo caracter");
				
			}

		} while (!esOpcionValida);
		
		return (char) entradaTeclado.charAt(0);
		
	}
	
	public static String pedirValoresFigura(String nombreValor, int numeroalores) {

		String entradaTeclado;
		
		for (int valo = 0; valo < array.length; valo++) {
			
		}
		entradaTeclado = JOptionPane.showInputDialog(
				"Introduce " + mensaje + ", el valor tienen que ser númerico," + " el separador decimal es el . (punto)");
		
		return entradaTeclado;

	}
	
	public static void calcularAreaTriangulo(String[] valores) {
		
	}
	public static void calcularAreaCuadrado(String[] valores) {
		
	}

}

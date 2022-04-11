package ejercicio1;

import java.util.Scanner;

import javax.swing.JOptionPane;


/**
 * 
<<<<<<< HEAD
 * @author Jose Antonio González Alcántara
=======
 * @author Jose Antonio Gonz�lez Alc�ntara
>>>>>>> 205312ea58cef10a1a9314b7a468c272ad8e67ae
 * 
 * Clase de Java de la TA06-Metodos y Arrays Ejercicio 1
 *
 */
public class ejercicio1 {

	public static void main(String[] args) {
		/*Crea una aplicación que nos calcule
		  el área de un circulo, cuadrado o triangulo.
		  Pediremos que figura queremos calcular su área
		  y según lo introduccido pedirá los valores 
		  necesarios para calcular el área.
		  Crear un método por cad figura para
		  calcular cada área, este devolverá un número real.
		  Muestra el resultado por pantalla*/
		
		pedirFigura();
		
	}
	
	public static String validarEntrada(String valores) {
		
		String entradaTeclado;
		boolean esNumerico;
		
		do {

			entradaTeclado = JOptionPane.showInputDialog(
					"Introduce " + valores + ", el valor tienen que ser númerico," + " el separador decimal es el . (punto)");
			

			// Si cancelamos el pane
			if (entradaTeclado != null) {

				// Como aún no hemos visto manejo de excepciones
				// Compruebo mediante el metodo matches del tipo String si lo introducido es un
				// número
				esNumerico = entradaTeclado.matches("[+-]?\\d*(\\.\\d+)?");

				if (esNumerico) {

					return entradaTeclado;

				} else {

					JOptionPane.showMessageDialog(null, "No has introducido un número valido");

				}

			} else {
				
				JOptionPane.showMessageDialog(null, "La aplicación se cerrara");
				esNumerico = false;
			}

		} while (!esNumerico && entradaTeclado != null);
		
		return entradaTeclado;
		
	}
	
	public static Double calcularAreaCirculo() {

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
					"Introduce el radio, el valor tienen que ser númerico," + " el separador decimal es el . (punto)");
			
			areaCirculo = 0.0;

			// Si cancelamos el pane
			if (entradaTeclado != null) {

				// Como aún no hemos visto manejo de excepciones
				// Compruebo mediante el metodo matches del tipo String si lo introducido es un
				// número
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
	
	public static void pedirFigura() {

		String entradaTeclado;
		Scanner scanner;
		boolean esOpcionValida;
		char opcion;

		scanner = new Scanner(System.in);
			

		do {

			System.out.println("Menú de opciones para calcular areas");
			System.out.println("1. Circulo");
			System.out.println("2. Triangulo");
			System.out.println("3. Cuadrado");
			System.out.println("Elige el número de la figura que quieres calcular su area");
			entradaTeclado = scanner.nextLine();
			esOpcionValida = (entradaTeclado.length() == 1);

			if (esOpcionValida) {

				opcion = (char) entradaTeclado.charAt(0);

				switch (opcion) {
				case '1':
					// Mostramos resultado en pantalla
					JOptionPane.showMessageDialog(null,"El area del circulo es " + calcularAreaCirculo());
					break;
				case '2':
					JOptionPane.showMessageDialog(null,"El area del circulo es " + calcularAreaCirculo());
					break;
				case '3':
					JOptionPane.showMessageDialog(null,"El area del circulo es " + calcularAreaCirculo());
					break;
				default:
					System.out.println("Elige una opción válida");
					esOpcionValida = false;
					break;
				}

			} else {
				
				System.out.println("Porfavor introduce un solo caracter");
				esOpcionValida = false;
				
			}

		} while (!esOpcionValida);

		scanner.close();

	}

}

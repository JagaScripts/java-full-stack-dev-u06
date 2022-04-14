package ejercicio1;

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
		
		final String CIRCULO[] = {"radio"};
		final String TRIANGULO[] = {"base","altura"};
		final String CUADRADO[] = {"lado","lado"};
		final String FIGURAS[][] = {CIRCULO,TRIANGULO,CUADRADO};
		
		char opcionFigura;
		String entradaTeclado;
		String nombreValoresFigura[];
		double valoresFigura[];
		 
		do {
			
			entradaTeclado = pedirFigura();
			
		} while (!validarCaracterEntrada(entradaTeclado));
		
		opcionFigura = (char) entradaTeclado.charAt(0);
		
		nombreValoresFigura = FIGURAS[Integer.parseInt(entradaTeclado)-1];
		valoresFigura = new double[nombreValoresFigura.length];
		
		for (int i = 0; i < nombreValoresFigura.length; i++) {
			
			do {
				
				entradaTeclado = JOptionPane.showInputDialog("Introduce " + nombreValoresFigura[i] 
														   + ", el valor tienen que ser númerico," 
														   + " el separador decimal es el . (punto)");
				
			} while (!validarDoubleEntrada(entradaTeclado));
			
			// Parseamos a double el texto para que sea un double1
			valoresFigura[i] = Double.parseDouble(entradaTeclado);
			
		}
		
		//seleccionamos la figura calculamos y mostramos por pantalla		
		switch (opcionFigura) {
		case '1':
			JOptionPane.showMessageDialog(null,"El area del circulo es de " 
										+ calcularAreaCirculo(valoresFigura[0])
										+ " m^2");
			break;
		case '2':
			JOptionPane.showMessageDialog(null,"El area del triangulo es de " 
										+ calcularAreaTriangulo(valoresFigura[0],valoresFigura[1])
										+ " m^2");
			break;
		case '3':
			JOptionPane.showMessageDialog(null,"El area del cuadrado es de " 
										+ calcularAreaCuadrado(valoresFigura[0],valoresFigura[1])
										+ " m^2");
			break;
		case '4':
			JOptionPane.showMessageDialog(null,"Se cerrara la aplición");
			break;
		default:
			System.out.println("Elige una opción válida");
			break;
		}
		
		
	}
	
	//metodo que valida la entrada como double
	public static boolean validarDoubleEntrada(String entradaTeclado) {
		
		boolean esNumerico;
		
			// Si cancelamos el pane
			if (entradaTeclado != null) {

				esNumerico = entradaTeclado.matches("[+-]?\\d*(\\.\\d+)?");

				if (!esNumerico || entradaTeclado.isEmpty()) {
					
					esNumerico = false;
					JOptionPane.showMessageDialog(null, "No has introducido un número valido");

				}

			} else {
				
				esNumerico = false;
				JOptionPane.showMessageDialog(null, "La aplicaciónn se cerrara");
				System.exit(0);
			}

		
		return esNumerico;
		
	}
	//metod calcula el area del circulo
	public static Double calcularAreaCirculo(double radio) {
		
		// Calculamos el area del circulo
		return Math.PI * Math.pow(radio, 2);
					

	}
	
	//metodo que muestra el menu y reclama la entrada
	public static String pedirFigura() {

		String entradaTeclado = JOptionPane.showInputDialog(null,"Menú de opciones para calcular areas \n"
				   + "1. Circulo (valor por defecto) \n" 
				   + "2. Triangulo \n"
				   + "3. Cuadrado \n"
				   + "Para salir de la apliación cancela \n"
				   + "en las entradas de datos \n\n"
				   + "Elige el número de la figura que quieres calcular su area\n\n");
		
		return entradaTeclado;

	}
             
	//Metodo para validar la entrada
	public static boolean validarCaracterEntrada(String entradaTeclado) {
		
		boolean esOpcionValida;
			
		if (entradaTeclado != null) {
			
			if (entradaTeclado.length() == 1) {
				
				if (entradaTeclado.charAt(0) != '1' && entradaTeclado.charAt(0) != '2' && entradaTeclado.charAt(0) != '3' ) {
					
					esOpcionValida = false;
					JOptionPane.showMessageDialog(null,"Porfavor introduce caracter entre 1 y 3");
						
				} else {
					
					esOpcionValida = true;
				}

			}else {
				
				esOpcionValida = false;
				JOptionPane.showMessageDialog(null,"Porfavor introduce un solo caracter");
						
			}
			
		}else {
			
			esOpcionValida = false;
			JOptionPane.showMessageDialog(null,"Se cerrara la aplición");
			System.exit(0);
		}
		
		return esOpcionValida;
		
	}
	
	//metodo para calcular el area del triangulo
	public static double calcularAreaTriangulo(double base, double altura) {
		
		return (base * altura) / 2;
		
	}
	
	//metod calcular area del triangulo
	public static double calcularAreaCuadrado(double lado1, double lado2) {
		
		return lado1 * lado2;
		
	}

}

package ejercicio7;

import javax.swing.JOptionPane;

/**
 * 
 * @author Jose Antonio Gonz�lez Alc�ntara
 * 
 * Clase de Java de la TA06-Metodos y Arrays Ejercicio 7
 *
 */
public class ejercicio7 {

	public static void main(String[] args) {

		
		String opcionMoneda;
		String entradaTeclado;
		double cantidad;
		
		do {

			entradaTeclado = pedirMoneda();

		} while (!validarCaracterEntrada(entradaTeclado));

		opcionMoneda = entradaTeclado;
		
		
		do {
			
			entradaTeclado = JOptionPane.showInputDialog("Introduce la cantidad \n"
													   + "de euros € que quieres "
													   + " convertir "
													   + "el separador decimal es el . (punto)");
			
		} while (!validarEnteroEntrada(entradaTeclado));
		
		cantidad = Double.parseDouble(entradaTeclado);
		
		convertirEuros(cantidad, opcionMoneda);		
		
	}
	
	public static String pedirMoneda() {
		
		String entradaTeclado = JOptionPane.showInputDialog(null,"Menú de opciones para convertirmoneda \n"
				   + "1. Dolares (valor por defecto) \n" 
				   + "2. Yenes \n"
				   + "3. Libras \n"
				   + "Para salir de la apliación cancela \n"
				   + "en las entradas de datos \n\n"
				   + "Elige la moneda a la que quieras convertir\n\n");
		
		return entradaTeclado;
	}

	public static boolean validarEnteroEntrada(String entradaTeclado) {

		// Si cancelamos el pane
		if (entradaTeclado != null) {
			
			if (!entradaTeclado.isEmpty()) {
				

				if(entradaTeclado.matches("[+-]?\\d*(\\.\\d+)?")) {
					
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
	
	public static void convertirEuros(double cantidadEuros, String moneda) {
		
		
		switch (moneda.charAt(0)) {
		case '1':
			JOptionPane.showMessageDialog(null,"El valor de " + cantidadEuros + " € en dolares " 
											+ "es " + cantidadEuros * 1.28611);
			break;
		case '2':
			JOptionPane.showMessageDialog(null,"El valor de " + cantidadEuros + " € en yenes " 
											+ "es " + cantidadEuros * 129.852);
			break;
		case '3':
			JOptionPane.showMessageDialog(null,"El valor de " + cantidadEuros + " € en libras " 
											+ "es " + cantidadEuros * 0.86);
			break;
		default:
			System.out.println("Elige una opción válida");
			break;
		}
		
	}

}

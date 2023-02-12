package fes.aragon.inicio;

public class Prueba {
	private char[] columnas = { 'a', 'b', 'c', ':' };
	private int[][] tabla = { { 1, 0, 0, 0 }, { 2, 1, 1, 0 }, { 3, 2, 2, 0 }, { 4, 3, 3, 1 }, { 4, 4, 4, 0 } };
	private String token = "abbbaca:";
	private int estado = 0;
	private int columna = 0;
	private boolean correcto = true;

	public static void main(String[] args) {
		Prueba app = new Prueba();

		// Este for recorrera la palabra separando sus caracteres para evaluarlos
		for (int i = 0; i < app.token.length(); i++) {
			char simbolo = app.token.charAt(i);

			// Este while sera con el que se compararan los caracteres con el abecedario
			// aceptado
			int j = 0;
			while (j < app.columnas.length) {

				// Este if checa cuando se trata de un simbolo igual al primer caracter del
				// abecedario aceptado
				if (app.columnas[j] == simbolo) {
					app.columna = j;
					break;
				} else if (j == 0) { // Este else if sera para checar el simbolo igual al segundo o tercer caracter
										// del abecedario aceptado
					j++;
					if (app.columnas[j] == simbolo) {
						app.columna = j;
						break;
					}
					if (j != 0) {
						j++;
						if (app.columnas[j] == simbolo) {
							app.columna = j;
							break;
						}
					}

				} else if (j != 0) { // Este else if sirve para checar al caracter mayor al tercero del abecedario
										// aceptado
					j++;
					if (app.columnas[j] == simbolo) {
						app.columna = j;
						break;
					} else if (app.columnas[j] != simbolo) { // Este else if anidado sirve para los caracteres que no
																// esten dentro del abecedario aceptado
						j = 0;
						app.correcto = false;
						break;
					}
				}

			}
			
			// Este if checa si la palabra es correcta o no
			if (!app.correcto) {
				app.estado = 0;
				break;
			}
			
			// Esta asignasion es para ir moviendo el estado hasta llegar al estado final o correcto
			app.estado = app.tabla[app.estado][app.columna];

		}

		if (app.estado == 1) {
			System.out.println("Aceptada");
		} else {
			System.out.println("No aceptada");
		}
	}
}

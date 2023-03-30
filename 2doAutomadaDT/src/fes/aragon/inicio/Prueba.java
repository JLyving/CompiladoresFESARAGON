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

			for (int j = 0; j < app.columnas.length; j++) {
				app.correcto = false;
				
				if (app.columnas[j] == simbolo ) {
					app.columna = j;
					app.correcto = true;
					break;
				} 
				
			}
			
			app.estado = app.tabla[app.estado][app.columna];
			
		}
		if(app.estado == 3) {
			System.out.println("aceptada");
		} else {
			System.out.println("no aceptada");
		}
}
}

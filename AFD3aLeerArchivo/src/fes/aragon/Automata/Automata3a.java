package fes.aragon.Automata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Automata3a {
	private char[] columnas = { 'a', 'b', 'c', ':' };
	private int[][] tabla = { { 1, 0, 0, 0 }, { 2, 1, 1, 0 }, { 3, 2, 2, 0 }, { 4, 3, 3, 1 }, { 4, 4, 4, 0 } };
	private String token = null;
	private int estado = 0;
	private int columna = 0;
	private boolean correcto = true;

	public static void main(String[] args) {
		Automata3a app = new Automata3a();
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File(System.getProperty("user.dir") + "/" + "PalabrasPrueba");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] palabra = linea.split(" ");
				for (String p : palabra) {
					app.token = p;
					System.out.println(p);
				}
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
					
					if(app.correcto != true) {
						break;
					}
					
					app.estado = app.tabla[app.estado][app.columna];
					
				}
				
				if(app.estado == 1 && app.correcto == true) {
					System.out.println("aceptada " + app.token);
				} else {
					System.out.println("no aceptada " + app.token);
				}
				app.estado = 0;
				//System.out.println(linea);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		

		
}
}

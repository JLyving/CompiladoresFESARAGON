package fes.aragon.automata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class AFD {

	public void Automata(String Archivo) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			archivo = new File(System.getProperty("user.dir") + "/" + Archivo);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			int estado = 1;
			char[] l = null;
			while ((linea = br.readLine()) != null) {
				String[] palabra = linea.split(" ");
				for (String p : palabra) {
					l = p.toCharArray();
					for (int i = 0; i < l.length; i++) {
						switch (estado) {
						case 1:
							if (l[i] == 'a') {
								estado = 2;
							} else {
								break;
							}
							break;
						case 2:
							if (l[i] == 'a') {
								estado = 3;
							} else {
								break;
							}
							break;
						case 3:
							if (l[i] == 'a') {
								estado = 4;
							} else {
								break;
							}
							break;
						default:
							break;
						}

					}

				}
			}

			if (estado != 4) {
				System.out.println("No aceptada");
			} else {
				System.out.println("Aceptada");
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

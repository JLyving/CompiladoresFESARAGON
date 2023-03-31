package fes.aragon.inicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PruebaTres {
	private char[] columnas;
	private int[][] tabla;
	private int estado = 0;
	private int columna = 0;

	public static void main(String[] args) {
    	PruebaTres app = new PruebaTres();
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/config"))) {
        	String[] valores = br.readLine().split(",");
            int numColumnas = Integer.parseInt(valores[0]);
            int numEstados = Integer.parseInt(valores[1]);

            app.columnas = new char[numColumnas];
            valores = br.readLine().split(",");
            for (int i = 0; i < numColumnas; i++) {
                app.columnas[i] = valores[i].charAt(0);
            }

            app.tabla = new int[numEstados][numColumnas];
            for (int i = 0; i < numEstados; i++) {
                valores = br.readLine().split(",");
                for (int j = 0; j < numColumnas; j++) {
                    app.tabla[i][j] = Integer.parseInt(valores[j]);
                }
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        
        try {
      	  archivo = new File(System.getProperty("user.dir")+"/fuente");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                for (String token : linea.split(" ")) {
                	for (int i = 0; i < token.length(); i++) {
                        char simbolo = token.charAt(i);
                        for (int j = 0; j < app.columnas.length; j++) {
                            if (app.columnas[j] == simbolo) {
                                app.columna = j;
                                break;
                            }
                        }
                        app.estado = app.tabla[app.estado][app.columna];
                    }
                    if (app.estado == 2 || app.estado == 3) {
                        System.out.println(token + " = Aceptada");
                    } else {
                        System.out.println(token + " = No aceptada");
                    }
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {                    
                if (fr != null) {   
                    fr.close();     
                }                  
            } catch (IOException e2) { 
                e2.printStackTrace();
            }
        }
	}

}
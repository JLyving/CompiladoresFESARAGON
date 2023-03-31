package fes.aragon;

import java.io.*;

public class main {
    public static void main(String[] args) {
        File archivo = new File("sample");
        String currentline;
        try {
            FileReader fileReader = new FileReader(archivo);
            Reader lector = new BufferedReader(fileReader);
            Analizador analizador = new Analizador(lector);
            while (true){
                Tokens tokens = analizador.yylex();
                if (tokens == null ){
                    //System.out.println("Archivo Vacio");
                    return;
                }
                switch (tokens){
                    case PALABRARESERVADA:
                        //resultado += analizador.yytext() + "Reservada\n";
                        System.out.println("Reservada");
                        break;
                    case IDENTIFICADOR:
                        System.out.println("Identificador");
                        break;
                    case COMENTARIO:
                        System.out.println("Cometario");
                        break;
                    default:
                        System.out.println("No reconocido");
                        break;
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("algo");
        }
    }
}
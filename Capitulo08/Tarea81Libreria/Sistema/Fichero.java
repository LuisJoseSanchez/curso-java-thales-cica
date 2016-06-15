package Sistema;

/*********************************************
 * Jose F. Quesada                           *
 *                Curso de Programación Java *
 * Capitulo08/Fichero.java                   *
 *********************************************/

 
import java.io.*;
public class Fichero {

    private static  int MAXLINEA = 2000;

    public static void graba(FileOutputStream fos,
                 String texto) {
        if (texto.length() > MAXLINEA) {
            System.out.println(
              "#> ERROR: Excedido limite superior de línea");
            return;
        }

        byte linea[] = texto.getBytes();

        try {
            fos.write(linea);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static String leeString(FileInputStream fis,
                 String texto) {
        try {
            // Lectura de la cabecera: texto
            int d;
            for (int i = 0; i < texto.length(); i++ ) {
                if ( ((d = fis.read()) == -1) ||
                     (d != texto.charAt(i))) {
                    System.out.println("#> Error leyendo " + 
                                       texto);
                    return null;
                } 
            }

            // Lectura del dato
            byte linea[] = new byte[MAXLINEA];
            int pos;
            for (pos = 0; ; pos++) {
                if (((d = fis.read()) != -1) &&
                    (d != '\n')) {
                    linea[pos] = (byte)d;
                } else 
                    break;
            }

            // Conversi�n a String
            String strlinea = new String(linea,0,pos);
            return strlinea;
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public static int leeInt(FileInputStream fis,
                 String texto) {
        return Integer.parseInt(leeString(fis,texto));
    }

    public static double leeDouble(FileInputStream fis,
                 String texto) {
        return Double.parseDouble(leeString(fis,texto));
    }
}


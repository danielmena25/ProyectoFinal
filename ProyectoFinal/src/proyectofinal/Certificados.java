/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.io.FileNotFoundException;
import java.util.Formatter;

/**
 *
 * @author Usuario
 */
public class Certificados {

    public static void certificados(String numeroCedula, double saldoTotal) throws FileNotFoundException {
        try {
            String rutaArchivos = String.format("certificados/certificado_"
                    + numeroCedula + ".txt"); //se encarga de crear el archivo 
                                             //que pedimos
            Formatter salida = new Formatter(rutaArchivos); //crea el contenido 
                                                           //del archivo
            salida.format("Certificados de Saldos\n\nIdentificacion de los "
                    + "Clientes: %s\nSaldo disponible a la fecha: $%.2f",
                    numeroCedula, saldoTotal);
            salida.close(); // cierra el proceso de crear archivos

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1); // finaliza el programa
        }  
    }

}

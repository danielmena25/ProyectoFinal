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
class CrearCertificado {
    
    public static void registroCertificado(String numeroCedula, double saldoTotal) throws FileNotFoundException {
        try {
            String rutaArchivos = String.format("certificados/certificado_" + numeroCedula + ".txt");
            Formatter salida = new Formatter(rutaArchivos);
            salida.format("Certificados de saldos\nIdentificacion de los "
                    + "clientes:%s\nSaldo a la fecha actual:$%.2f",
                    numeroCedula, saldoTotal);
            salida.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
    
}

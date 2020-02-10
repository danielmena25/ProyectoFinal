/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Ejecutar {

    public static void main(String[] args) throws IOException {
        Scanner entrada = new Scanner(System.in);
        int option;
        boolean bandera = true;

        while (bandera == true);

        System.out.println("Option (1) Ingrese los nuevos clientes");

        System.out.println("Option (2) Realice el deposito del dinero");

        System.out.println("Option (3) Relice el retiro de dinero");

        System.out.println("Option (4) Mostrar Certificado de los Saldos de "
                + "las Cuentas");
        System.out.println("S: salir");
        option = entrada.nextInt();

        switch (option) {
            case 1:
                //llamar a los archivos para ejecutarlos
                if (option == 1) {
                    ArchivoClientes.registrosClientes();
                    break;
                }
            case 2:
                if (option == 2) {
                    Retiro.deposito();
                    break;
                }
            case 3:
                if (option == 3) {
                    Retiro.registroRetiros();
                    break;
                }
            case 4:
                if (option == 4) {
                    Retiro.certificados();
                    break;
                }
            case 5:
                if (option == 5) {
                    
                }
                break;

            case 6:
                if (option == 6) {
                    bandera = false;
                } //presenta el mensaje final

        }

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Retiro {

    public static void deposito() throws IOException {
        Scanner entrada = new Scanner(System.in);
        double saldoActual = 0;
        double saldoInicial = 1000;
        try {
            System.out.println("Ingrese el numero de cedula:");
            String numeroCedula = entrada.nextLine();
            File buscarArchivos = new File("cuentas/" + numeroCedula + ".txt"); 
               // busca el numero de cedula
            if (buscarArchivos.exists()) { // verificar que la cuenta existe en 
                //el sistema
                System.out.println("Ingrese la cantidad de dinero que desea "
                        + "depositar en su cuenta");
                double depositar = entrada.nextDouble();
                FileWriter escribirArchivo0 = new FileWriter(buscarArchivos.getAbsoluteFile(), true);
                BufferedWriter escribirArchivos = new BufferedWriter(escribirArchivo0);
                saldoActual = saldoInicial + depositar;
                // Las siguientes lineas se añadiran al archivo txt
                escribirArchivos.write("deposito|" + depositar + "\n");
                escribirArchivos.close();
            } //fin del primer if
            else {
                System.out.println("El cliente no existe en el sistema");
            } //fin del else

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

    }

    public static double acumulador(String numeroCedula) throws FileNotFoundException {
        double saldoFinal = 0;
        double saldoInicial = 1000;
        double totalSaldo = 0;
        try {
            Scanner entrada = new Scanner(new File("cuentas/" + numeroCedula + 
                    ".txt"));
            while (entrada.hasNext()) {
                String linea = entrada.nextLine();
                ArrayList<String> linea_parte = new ArrayList<>(Arrays.asList(linea.split("\\|")));
                double dinero = Double.parseDouble(linea_parte.get(1));
                if (linea_parte.get(0).equals("deposito")) {
                    saldoFinal = saldoInicial + dinero;
                } else {
                    if (linea_parte.get(0).equals("retiro")) {
                        saldoFinal = saldoFinal - dinero;
                    }
                }
            }

        } catch (Exception e) {
            System.out.printf(e.getMessage());
        }
        return saldoFinal;

    }

    public static void registroRetiros() throws FileNotFoundException, IOException {
        Scanner entrada = new Scanner(System.in);
        double saldos = 0;
        try {
            System.out.println("Ingrese su numero de cedula:");
            String numeroCedula = entrada.nextLine();
            File buscarArchivos = new File("cuentas/" + numeroCedula + ".txt");
            if (buscarArchivos.exists()) { //verificar si la cuenta del cliente 
                                          //esta existente
                System.out.println("Ingrese la cantidad de dinero que desee "
                        + "retirar de su cuenta");
                double retiro = entrada.nextDouble();
                double saldoFinal = Retiro.acumulador(numeroCedula);
                if (retiro <= saldoFinal) {
                    saldos = saldoFinal - retiro;
                    FileWritter escribirArchivo0 = new FileWritter(buscarArchivos.getAbsoluteFile(), true);
                    BufferedWriter escribirArchivos = new BuferredWritter(escribirArchivo0);
                    //lo siguiente se va a agregar al archivo que creamos txt
                    escribirArchivos.write("retiro|" + retiro + "/n");
                    escribirArchivos.close();
                } else {
                    System.out.println("Usted no contiene el dinero suficiente "
                            + "para realizar la transaccion");
                }
            } else {
                System.out.println("El cliente no existe");
            } //fin del else 
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    public static void certificados() throws FileNotFoundException {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese su numero de cedula");
        String numeroCedula = entrada.nextLine();
        double saldoTotal = Retiro.acumulador(numeroCedula);
        CrearCertificado.registroCertificado(numeroCedula, saldoTotal);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.io.BufferedWriter;

/**
 *
 * @author Usuario
 */
public class BuferredWritter extends BufferedWriter {

    private final FileWritter escribirArchivo0;

    /**
     *
     * @param escribirArchivo0
     */
    public BuferredWritter(FileWritter escribirArchivo0) {
        this.escribirArchivo0 = escribirArchivo0;
    }

}

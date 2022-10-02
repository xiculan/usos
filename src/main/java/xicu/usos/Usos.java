/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package xicu.usos;

import java.io.IOException;
import javax.swing.JFrame;

/**
 *
 * @author xicu
 */
public class Usos {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");

        JFrame crud1 = new form_crud();
        //crud1.setVisible(true);

        JFrame form1 = new form();
        form1.setVisible(true);

    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xicu.usos;

import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author xicu
 */
public class xicub {
    
    static int suma_ints(int num1,int num2){
        return num1+num2;
    }
    
    public static void MostrarResultsetConsola(ResultSet rs) {
		try {
			System.out.println("Ejecutado metodo MostrarResultsetConsola");
			StringBuilder strBuilder = new StringBuilder();
			while (rs.next()) {
				strBuilder.append(rs.getString(1)).append(" ").append(rs.getString(2));
				strBuilder.append("\n");
			}
			// textArea.setText(strBuilder.toString());
			System.out.println(strBuilder.toString());
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}
}

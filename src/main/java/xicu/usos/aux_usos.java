/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xicu.usos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;  // Import the Scanner class

/**
 *
 * @author xicu
 */
public class aux_usos {

    public static int var1 = 2;

    public static void prova() {
        System.out.println("hola");
    }

    public void check_file() {
        String filePathString = "c:\\prova\\file.txt";
        File f = new File(filePathString);
        System.out.println("comprobamos");
        System.out.println(filePathString);
        if (f.exists() && f.isFile()) {
            //do something ...
            System.out.println("es un archivo");
        }
    }

    public void filtra_copia_csv(String ruta_base, String ruta_filtro, String ruta_out, int col_base, int col_filtro, int col_copia, String separator) throws FileNotFoundException, IOException {
        //pone todos los registros de una columna del csv en un archivo, pero solo los que no son repetidos
//        String ruta_in="/home/xicu/prueba.csv";
//        String ruta_out="/home/xicu/columna_filtrada.csv";
        //Int col_copia, columna a copiar del arxiu de filtre
//       diari: s'ha de implementar 10*04/22

        //1.declaracions  i assignacions
        //2.
        File in_file = new File(ruta_base);
        File filter_file = new File(ruta_filtro);
        File out_file = new File(ruta_out);
        String csvSplitBy = separator;
        BufferedReader brFiltro = new BufferedReader(new FileReader(ruta_filtro));
        String line_base;
        String line_filtro;
        String codigo_filtro;
        FileWriter fichero = null;
        PrintWriter pw = null;
        System.out.println("metodo filtra_columna_repe");
        try {
            System.out.println("Actua metodo: filtra_csv_columna_codigos");

            fichero = new FileWriter(out_file);
            pw = new PrintWriter(fichero);

//            while ((line = br.readLine()) != null) {
            while ((line_filtro = brFiltro.readLine()) != null) {
                System.out.println(line_filtro + "***************");
                String[] reg_filtro = line_filtro.split(csvSplitBy);
                codigo_filtro = reg_filtro[col_filtro];

                BufferedReader brBase = new BufferedReader(new FileReader(in_file));

                while ((line_base = brBase.readLine()) != null) {
                    // use comma as separator

                    String[] reg_base = line_base.split(csvSplitBy);
                    System.out.println("Comparem:" + reg_base[col_base] + "," + reg_filtro[col_filtro]);

                    if (reg_base[col_base].equals(reg_filtro[col_filtro])) {

                        //String reg = line;
                        System.out.println(line_base);
                        pw.write(line_base + "\n");
                    }
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            // Cerramos el fichero tanto si la lectura ha sido correcta o no
            try {
                if (pw != null) {
                    pw.close();
                }
            } catch (Exception ex2) {
                System.out.println("Mensaje 2: " + ex2.getMessage());
            }
        }
    }//fin filtra_copia_csv
    
    public void escriu_tainfo(String text, javax.swing.JTextArea text_area){
        text_area.append(text);
        
    }

    public void filtra_csv_columna_codigos(javax.swing.JTextArea ta,String ruta_base, String ruta_filtro, String ruta_out, int col_base, int col_filtro, String separator) throws FileNotFoundException, IOException {
        //pone todos los registros de una columna del csv en un archivo, pero solo los que no son repetidos
//        String ruta_in="/home/xicu/prueba.csv";
//        String ruta_out="/home/xicu/columna_filtrada.csv";

        //1.declaracions  i assignacions
        //2.
        File in_file = new File(ruta_base);
        File filter_file = new File(ruta_filtro);
        File out_file = new File(ruta_out);
        String csvSplitBy = separator;
        int cont_filtro = 1;
        int cont_base=1;
        BufferedReader brFiltro = new BufferedReader(new FileReader(ruta_filtro));
        String line_base;
        String line_filtro;
        String codigo_filtro;
        FileWriter fichero = null;
        PrintWriter pw = null;
        System.out.println("metodo filtra_columna_repe");
        
        try {
            //System.out.println("Actua metodo: filtra_csv_columna_codigos");
            //ta.append("actua metodo:filtra_csv_columna_codigos");
            fichero = new FileWriter(out_file);
            pw = new PrintWriter(fichero);

//            while ((line = br.readLine()) != null) {
            while ((line_filtro = brFiltro.readLine()) != null) {
                ta.append("\nReg filtrados:" + cont_filtro);
                System.out.println("comparem producte: " + line_filtro + "***************\n");
                ta.append("\ncomparem producte: " + line_filtro + "***************\n");
                String[] reg_filtro = line_filtro.split(csvSplitBy);
                codigo_filtro = reg_filtro[col_filtro];

                BufferedReader brBase = new BufferedReader(new FileReader(in_file));

                while ((line_base = brBase.readLine()) != null) {
                    // use comma as separator

                    String[] reg_base = line_base.split(csvSplitBy);
                    System.out.println("Comparem cadena filtre: " + reg_filtro[col_filtro] + " amb: " + reg_base[col_base] );

                    if (reg_base[col_base].equals(reg_filtro[col_filtro])) {

                        //String reg = line;
                        System.out.println("---------------- Registre coincident: " + line_base);
                        pw.write(line_base + "\n");
                    }
                }
                cont_filtro = cont_filtro + 1;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            // Cerramos el fichero tanto si la lectura ha sido correcta o no
            try {
                if (pw != null) {
                    pw.close();
                }
            } catch (Exception ex2) {
                System.out.println("Mensaje 2: " + ex2.getMessage());
            }
        }
    }//fin filtra_csv_columna_codigos

    public void filtra_csv_columna_codigos_cara5(String ruta_base, String ruta_filtro, String ruta_out, int col_base, int col_filtro, String separator,Object sortida) throws FileNotFoundException, IOException {
        //pone todos los registros de una columna del csv en un archivo, pero solo los que no son repetidos
        //filtra el archivo csv base con el archivo csv filtro.
        //por cada fila en el archivo filtro, compara los 5 caracteres primeros de
        //la columna col_filtro y los compara con los registros del csv base
        //los dos archivos tienen que estar ordenados

        //1.declaracions  i assignacions
        //2.
        File in_file = new File(ruta_base);
        File filter_file = new File(ruta_filtro);
        File out_file = new File(ruta_out);
        String csvSplitBy = separator;
        BufferedReader brFiltro = new BufferedReader(new FileReader(ruta_filtro));
        String line_base;
        String line_filtro;
        String codigo_filtro;
        FileWriter fichero = null;
        PrintWriter pw = null;
        System.out.println("metodo filtra_columna_repe");
        try {
            System.out.println("Actua metodo: filtra_csv_columna_codigos");
               
            fichero = new FileWriter(out_file);
            pw = new PrintWriter(fichero);

//            while ((line = br.readLine()) != null) {
            while ((line_filtro = brFiltro.readLine()) != null) {
                System.out.println(line_filtro + "***************");
                String[] reg_filtro = line_filtro.split(csvSplitBy);
                codigo_filtro = reg_filtro[col_filtro];

                BufferedReader brBase = new BufferedReader(new FileReader(in_file));

                while ((line_base = brBase.readLine()) != null) {
                    // use comma as separator

                    String[] reg_base = line_base.split(csvSplitBy);
                    System.out.println("Comparem:" + reg_base[col_base] + "," + reg_filtro[col_filtro]);

//                    if (reg_base[col_base].equals(reg_filtro[col_filtro])) {
                    if (reg_base[col_base].contains(reg_filtro[col_filtro])) {
                        //String reg = line;
                        System.out.println(line_base);
                        pw.write(line_base + "\n");
                    }
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            // Cerramos el fichero tanto si la lectura ha sido correcta o no
            try {
                if (pw != null) {
                    pw.close();
                }
            } catch (Exception ex2) {
                System.out.println("Mensaje 2: " + ex2.getMessage());
            }
        }
    }//fin filtra_csv_columna_codigos
    
    

    public void filtra_csv(String ruta_base, String ruta_out, String ruta_filtre, int col_filtre_base, String separator) throws FileNotFoundException, IOException {
        /**
         * Médoto para filtrar un archivo base.csv con un archivo filtro.csv,
         * recorremos el archivo base y copiamos en el archivo out todas las
         * filas que continene la cadena que esta contenida en el archivo filtro
         */

        File in_file = new File(ruta_base);
        File out_file = new File(ruta_out);
        String cvsSplitBy = separator;
        BufferedReader br = new BufferedReader(new FileReader(in_file));
        String line;
        FileWriter fichero = null;
        PrintWriter pw = null;

        try {

            fichero = new FileWriter(out_file);
            pw = new PrintWriter(fichero);
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] reg = line.split(cvsSplitBy);
                System.out.println(reg[col_filtre_base]);
                pw.write(reg[col_filtre_base] + "\n");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            // Cerramos el fichero tanto si la lectura ha sido correcta o no
            try {
                if (pw != null) {
                    pw.close();
                }
            } catch (Exception ex2) {
                System.out.println("Mensaje 2: " + ex2.getMessage());
            }
        }
    }   //***********fi filtra_csv *********************************************

    public String busca_cadena(String ruta, String texto) throws FileNotFoundException {
        /**
         * ***********************************************************************************
         * metodo para buscar la linea de un archivo que contiene una cadena de
         * busqueda
         *
         * @param ruta
         * @param texto
         * @return.devuelve un string con la linea de texto encontrada
         * @throws FileNotFoundException
         */

        String linea;
        int numeroDeLinea = 1;
        boolean contiene = false;
        //creamos un objeto File asociado al fichero seleccionado
        //ruta=("c:\\prova\\file.txt");
        System.out.println("Ruta del archivo: " + ruta);

        File f = new File(ruta);
        Scanner entrada = new Scanner(f);
        String texto_encontrado = null;

        System.out.println("Texto a buscar: " + texto);
        while (entrada.hasNext()) { //mientras no se llegue al final del fichero
            linea = entrada.nextLine();  //se lee una línea
            if (linea.contains(texto)) {   //si la línea contiene el texto buscado se muestra por pantalla         
                System.out.println("Texto encontrado en la linea " + numeroDeLinea + ": " + linea);
                contiene = true;
                texto_encontrado = linea;
            }
            numeroDeLinea++; //se incrementa el contador de líneas
        }
        if (!contiene) { //si el archivo no contienen el texto se muestra un mensaje indicándolo
            System.out.println(texto + " no se ha encontrado en el archivo");
            texto_encontrado = "noencontrado";
        }
        entrada.close();
        return texto_encontrado;
    }

    public int SumaDos(int a, int b) {
        int resultado = a + b;
        return resultado;
    }
    
    public String BuscaEnArraylist(ArrayList<String> lista, String Cadena){
        
        for (int x = 0; x < lista.size(); x++) {
  String linea = lista.get(x);
  System.out.println(linea);
}
        
        return null;
        
    }

    public void DownloadImage(String url, String pathToSave) throws IOException {

        //creem un algoritme per detectar si l'arxiu jha existeuix
        File archivo = new File(pathToSave);
        if (!archivo.exists()) {
            try ( InputStream in = new URL(url).openStream()) {

                Files.copy(in, Paths.get(pathToSave));
            } catch (MalformedURLException e) {
                System.out.println("la url: " + url + " no es valida!");

            } catch (IOException e) {
                e.printStackTrace();
                //continue;
            }
        }
    }

    public static void filtra_columna(String ruta_in, String ruta_out, int col, String separator) throws FileNotFoundException {
        /**
         * pone todos los registros de una columna del csv en un archivo
         *
         * @param ruta_in.ruta donde se encuentra el archivo de entrada
         * @param ruta_out.ruta donde se guardara el arvhivo de salida
         * @param col.
         * @param separator
         * @throws FileNotFoundException
         */
//        String ruta_in="/home/xicu/prueba.csv";
//        String ruta_out="/home/xicu/columna_filtrada.csv";
        File inf_file = new File(ruta_in);
        File out_file = new File(ruta_out);
        String cvsSplitBy = separator;
        BufferedReader br = new BufferedReader(new FileReader(inf_file));
        String line;
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {

            fichero = new FileWriter(out_file);
            pw = new PrintWriter(fichero);
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] reg = line.split(cvsSplitBy);
                System.out.println(reg[col]);
                pw.write(reg[col] + "\n");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            // Cerramos el fichero tanto si la lectura ha sido correcta o no
            try {
                if (pw != null) {
                    pw.close();
                }
            } catch (Exception ex2) {
                System.out.println("Mensaje 2: " + ex2.getMessage());
            }
        }
    }

    public static void filtra_columna_repe(String ruta_in, String ruta_out, int col, String separator) throws FileNotFoundException {
        //pone todos los registros de una columna del csv en un archivo, pero solo los que no son repetidos
//        String ruta_in="/home/xicu/prueba.csv";
//        String ruta_out="/home/xicu/columna_filtrada.csv";
        File inf_file = new File(ruta_in);
        File out_file = new File(ruta_out);
        String cvsSplitBy = separator;
        BufferedReader br = new BufferedReader(new FileReader(inf_file));
        String line;
        FileWriter fichero = null;
        PrintWriter pw = null;

        try {

            fichero = new FileWriter(out_file);
            pw = new PrintWriter(fichero);
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] reg = line.split(cvsSplitBy);
                System.out.println(reg[col]);
                pw.write(reg[col] + "\n");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            // Cerramos el fichero tanto si la lectura ha sido correcta o no
            try {
                if (pw != null) {
                    pw.close();
                }
            } catch (Exception ex2) {
                System.out.println("Mensaje 2: " + ex2.getMessage());
            }
        }
    }

    public static void print_arraylist_console(ArrayList<String> list) {
        //public static void print_arraylist_console() {

        //create new ArrayList
        //ArrayList<String> list = new ArrayList<String>();                
        for (String s : list) {
            System.out.println(s);
        }

    }

    public ArrayList<String> busca_lineas(String ruta, String texto) throws FileNotFoundException {
//			List<Integer> lista = new ArrayList<>();
        ArrayList<String> lista_encontradas = new ArrayList<String>();

        String linea;
        int numeroDeLinea = 1;
        boolean contiene = false;
        //creamos un objeto File asociado al fichero seleccionado
        File f = new File(ruta);
        Scanner entrada = new Scanner(f);
        int i = 0;
//	        String lista = null;

        System.out.println("Texto a buscar: " + texto);
        while (entrada.hasNext()) { //mientras no se llegue al final del fichero
            linea = entrada.nextLine();  //se lee una lÃ­nea
//            if (linea.contains(texto)) {   //si la lÃ­nea contiene el texto buscado se muestra por pantalla         
              if (linea.matches(".*(?i)"+texto+".*"))  {
                System.out.println("Texto encontrado en la linea " + numeroDeLinea + ": " + linea);
                contiene = true;
//	                    texto_encontrado = linea;
                lista_encontradas.add(linea);
                //i++;
            }
            numeroDeLinea++; //se incrementa el contador de lÃ­neas
        }

        entrada.close();
        return lista_encontradas;
    }

    public String[] list_path_files(String ruta) {
        String ruta_carpeta = ruta;
        File carpeta = new File(ruta_carpeta);
        String[] listado = carpeta.list();

        return listado;
    }
}
